package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import vo.UserVO;

public class UserDAO {
//	회원 탈퇴한 상태
	public static final int DELETED_USER_CODE = -1;
//	회원탈퇴를 복구한 또는 일반 상태
	public static final int RESTORED_USER_CODE = 0;

//	아이디 만들기를 시도 했을 경우
//	아이디가 이미 존재하는 상태
	public static final int DUPLICATED_ID_CODE = 1;
//	아이디를 만들수 있는 상태
	public static final int ENABLED_ID_CODE = 2;

	public Connection connection;
	public PreparedStatement preparedStatement;
	public ResultSet resultSet;

	/**
	 * 
	 * @param userId
	 * @return
	 * 	RESTORED_USER_CODE = 0;<br>
		DELETED_USER_CODE = 1;<br>
		DUPLICATED_ID_CODE = 2;<br>
		ENABLED_ID_CODE = 3;<br>
	 */
	
	
	
//	아이디 중복검사	
//	회원상태를 확인 후 아이디 중복검사를 진행한다.
	public int checkId(String userId) {
		String query = "select userStatus from tbl_user where userId = ?";
		
//		보통 boolean으로 리턴하여 아이디 중복검사를 하지만,
//		아이디를 3개까지 만들수 있는 점을 고려하여
//		상태를 상수(code)로 세분화하여 관리한다
		int code = 0;
		
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
//			executeQuery는 SELECT 문일때만 사용
			resultSet = preparedStatement.executeQuery();
			
//			중복인지 확인 (결과테이블 행)
			if(resultSet.next()) {
//				가독성
				code = DUPLICATED_ID_CODE;
//				그 중복된 회원이 탈퇴한 회원인지 확인 (결과테이블 열)
				if(resultSet.getInt(1) == DELETED_USER_CODE) {
//					가독성
					code = DELETED_USER_CODE;
				}
			}else {
//				다 아니라면 사용가능한 상태번호로 바꿔준다
				code = ENABLED_ID_CODE;
			}

		} catch (SQLException e) {
			System.out.println("checkId()에서 쿼리문 오류");
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}

		return code;
	}
	
	
	

//	회원가입
//	알고리즘 : 회원가입 성공시 boolean리턴	
	public boolean insert(UserVO userVO) {

		//	"더 이상 입력된 폰번호로 아이디를 만들 수 없다"
		if(!check(userVO.getUserPhoneNumber())) { return false; }	
		//회원가입을 실패했다면 이미 가입된 정보가 나와야한다 : findUsersByUserPhoneNumber()
		
		
		String query = "insert into tbl_user "
				+ "(userId, userPassword, userName, userAge, userPhoneNumber, userBirth) " + "values(?, ?, ?, ?, ?, ?)";

		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userVO.getUserId());
			preparedStatement.setString(2, userVO.getUserPassword());
			preparedStatement.setString(3, userVO.getUserName());
			preparedStatement.setInt(4, userVO.getUserAge());
			preparedStatement.setString(5, userVO.getUserPhoneNumber());
			preparedStatement.setString(6, userVO.getUserBirth());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println(e);
			System.out.println("insert()에서 쿼리문 오류");

		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return true;
	}

//	로그인
	public int login(String userId, String userPassword) {
		String query = "select userNumber, userStatus from tbl_user where userId = ? and userPassword =?";

		int userNumber = 0;

		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userId);
			preparedStatement.setString(2, userPassword);
			resultSet = preparedStatement.executeQuery();
			
//			로그인 시 탈퇴한 회원처리
			if (resultSet.next()) {
//				조회한 userNumber를 담아준다
				userNumber = resultSet.getInt("userNumber");
//				만약 조회한 userNumber가 탈퇴한 회원이라면
				if(resultSet.getInt(2) == DELETED_USER_CODE) {
					userNumber = DELETED_USER_CODE;
				}
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("login() 쿼리문 오류");
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return userNumber;
	}

	
	
	
//	아이디 찾기
//	중복확인 -> userVO객체로 저장(set) -> ArrayList에 담아 한꺼번에 return
	public ArrayList<UserVO> findId(String userPhoneNumber) {

		String query = "select userNumber, userId, userPhoneNumber from tbl_user where userPhoneNumber = ?";
		
//		아이디를 찾았을 때 리턴할 회원정보
		ArrayList<UserVO> users = new ArrayList<UserVO>();

		try {
			connection = DBConnecter.getConnection();
//			작성한 쿼리 전달
			preparedStatement = connection.prepareStatement(query);
//			?(1번째 물음표) 채우기
			preparedStatement.setString(1, userPhoneNumber);
//			쿼리실행 : 해당 행(한 줄)만 가져온다.
			resultSet = preparedStatement.executeQuery();

//			결과테이블 1행 접근
			while (resultSet.next()) {
				UserVO userVO = new UserVO();
				
//				결과테이블의 1열에 접근하여 UserNumber를 가져오고, 가져온 값을 userVO 객체에 저장
				userVO.setUserNumber(resultSet.getInt(1));	//컬럼1열
				userVO.setUserId(resultSet.getString(2));
				userVO.setUserPhoneNumber(resultSet.getString(3));
				
//				저장한 userVO 객체 값들을 ArrayList에 저장
				users.add(userVO);
			}

		} catch (SQLException e) {
			System.out.println("findId() 쿼리문 오류");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return users;
	}

//	회원 정보 전체 수정
	public void update(UserVO userVO) {
		String query = "update tbl_user " + "set userName=?, userPassword=?, userPhoneNumber=?, userAge=?, userBirth=? "
				+ "WHERE userNumber = ?";

		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);

//			userVO에 저장되어있는 값을 불러와서 ? 에 set
			preparedStatement.setString(1, userVO.getUserName());
			preparedStatement.setString(2, userVO.getUserPassword());
			preparedStatement.setString(3, userVO.getUserPhoneNumber());
			preparedStatement.setInt(4, userVO.getUserAge());
			preparedStatement.setString(5, userVO.getUserBirth());
			preparedStatement.setInt(6, userVO.getUserNumber());
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("update() 쿼리 오류");
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

//	회원 전체 정보 조회
	public UserVO selectUser(int userNumber) {	//
		String query = "select userNumber, userId, userPassword, userName, userAge, userPhoneNumber, userStatus, userBirth from tbl_user "
				+ "where userNumber=?";

		int i = 0;
		UserVO userVO = new UserVO();
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setInt(1, userNumber);
			resultSet = preparedStatement.executeQuery();

//			정보가 있다면 : 회원가입하지 않은 사이트에서 정보조회를 할 수도 있기 때문
			if (resultSet.next()) {
//				++i : 값을 따로 저장하지 않는다.
				userVO.setUserNumber(resultSet.getInt(++i));					// i =1
				userVO.setUserId((resultSet.getString(++i)));						// i =2
				userVO.setUserPassword(resultSet.getString(++i));			// i =3 ...
				userVO.setUserName(resultSet.getString(++i));
				userVO.setUserAge(resultSet.getInt(++i));
				userVO.setUserPhoneNumber(resultSet.getString(++i));
				userVO.setUserStatus(resultSet.getInt(++i));
				userVO.setUserBirth(resultSet.getString(++i));
			}
		} catch (SQLException e) {
			System.out.println("updateUser() 쿼리문 오류");
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		return userVO;
	}

//	회원탈퇴
//	회원정보 삭제는 하지않고(일정기간 개인정보 수집) 상태 업데이트만 해준다.
	public void delete(int userNumber) {
//	회원 정보 전체를 받아서 삭제해줄 것이기 때문에 userNumber를 받아온다.
		String query = "update tbl_user set userStatus=? where userNumber= ?";

		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
//			상태 업데이트
			preparedStatement.setInt(1, DELETED_USER_CODE);
			preparedStatement.setInt(2, userNumber);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("delete() 쿼리문 오류");
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

	
	
	
//	회원탈퇴 복구
//	회원번호 받아 상태 업데이트
	public void restore(int userNumber) {
		String query = "update tbl_user set userStatus=? where userNumber = ?";

		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);

			preparedStatement.setInt(1, RESTORED_USER_CODE);
			preparedStatement.setInt(2, userNumber);
			preparedStatement.executeUpdate();

		} catch (SQLException e) {
			System.out.println("restore() 쿼리문 오류");
			e.printStackTrace();
		} finally {
			try {
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
	}

//	휴대폰번호 중복확인 (번호당 3개의 아이디 생성가능)
	private boolean check(String userPhoneNumber) {	
//		가입정보 입력 후 "가입하기"를 누르면, 다음페이지로 "탈퇴한 회원입니다" 등의 정보&선택창이 나온다.
//		회원가입 메소드에서 check()를 써줘야하므로 private로 해준다.
		boolean check = false;
		String query = "select count(userPhoneNumber) result from tbl_user where userPhoneNumber = ?";

		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userPhoneNumber);
			resultSet = preparedStatement.executeQuery();

			if (resultSet.next()) { 
//				아이디를 만들 수 있는 상태는 일치하는 PhoneNumber가 3개 미만일 때
				check = resultSet.getInt("result") < 3;
			}

		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("login() 쿼리문 오류");
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}

		return check;
	}
	
//	회원가입 실패시 보여줄 정보
//	핸드폰번호로 가입한 전체 회원 정보 조회
//	폰번호 입력받기 -> 일치하는 데이터 찾기 ->  결과테이블(get)을 userVO에 저장(set) -> ArrayList로 반환
	public ArrayList<UserVO> findUsersByUserPhoneNumber(String userPhoneNumber) {
		String query = "select userNumber, userId, userName, userAge, userPhoneNumber, userBirth, userStatus from tbl_user "
				+ "where userPhoneNumber = ?";
		ArrayList<UserVO> users = new ArrayList<UserVO>();
		try {
			connection = DBConnecter.getConnection();
			preparedStatement = connection.prepareStatement(query);
			preparedStatement.setString(1, userPhoneNumber);
			resultSet = preparedStatement.executeQuery();
			
			while (resultSet.next()) {
				UserVO userVO = new UserVO();
				userVO.setUserNumber(resultSet.getInt(1));
				userVO.setUserId(resultSet.getString(2));
				userVO.setUserName(resultSet.getString(3));
				userVO.setUserAge(resultSet.getInt(4));
				userVO.setUserPhoneNumber(resultSet.getString(5));
				userVO.setUserBirth(resultSet.getString(6));
				userVO.setUserStatus(resultSet.getInt(7));
				users.add(userVO);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (resultSet != null) {
					resultSet.close();
				}
				if (preparedStatement != null) {
					preparedStatement.close();
				}
				if (connection != null) {
					connection.close();
				}
			} catch (SQLException e) {
				throw new RuntimeException(e.getMessage());
			}
		}
		
		return users;
	}
}

