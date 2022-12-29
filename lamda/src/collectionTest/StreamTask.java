package collectionTest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.IntStream;

public class StreamTask {

	public static void main(String[] args) {
//      1~10까지 ArrayList에 담고 출력
		ArrayList<Integer> data = new ArrayList<>();
		IntStream.rangeClosed(1, 10).forEach(v->data.add(v));
		data.forEach(result -> System.out.println(result));
		
//      1~100까지 중 홀수만 ArrayList에 담고 출력
		ArrayList<Integer> num = new ArrayList<>();
		IntStream.rangeClosed(1, 100).filter(v->v%2==1).forEach(v->num.add(v));
//     IntStream.range(1, 51).map(v -> v * 2 - 1).forEach(datas::add);
		num.forEach(v->System.out.println(v));
		
//      ABCDEF를 각 문자별로 출력
		String str = "ABCDEF";
		str.chars().forEach(v->System.out.print((char)v));

		
//      A~F까지 ArrayList에 담고 출력 65~71
		ArrayList<Character> word = new ArrayList<>();
		IntStream.rangeClosed(65, 71).forEach(v->word.add((char)v));
		System.out.println(word);
//		IntStream.범위.반복문(람다식)
//								     	   (람다식 : ArrayList에 추가하기)
		
//      A~F까지 중 D제외하고 ArrayList에 담고 출력  / map쓰기
		ArrayList<Character> alphabet = new ArrayList<>();
		System.out.println("======================");
//		IntStream.rangeClosed(66, 70).map(v-> v > 68 ? v : v-1).forEach(v->alphabet.add((char)v));
		IntStream.rangeClosed('A', 'F').filter(v-> v != 68).forEach(v->alphabet.add((char)v));
//     IntStream.rangeClosed('A', 'E').map(v -> v > 67 ? v + 1 : v).forEach(v -> datas.add((char)v));
		System.out.println(alphabet);
		
//      5개의 문자열을 입력받은 후 모두 소문자로 변경(String.toLowerCase())
		ArrayList<String> changeWord = new ArrayList<>(Arrays.asList("HAPPY","SAD","UPSET","GOOD","BAD"));
		changeWord.stream().map(String::toLowerCase).forEach(System.out::println);
		
//      Apple, banana, Melon 중 첫번째 문자가 대문자인 문자열 출력 filter검사
		ArrayList<String> voca = new ArrayList<>(Arrays.asList("Apple","banana", "Melon"));
		voca.stream().filter(fruit -> fruit.charAt(0) >= 'A').filter(fruit -> fruit.charAt(0) <= 'Z').forEach(System.out::println);
//		voca.stream().filter(fruit -> fruit.charAt(0) >= 'A'&& fruit.charAt(0) <= 'Z').forEach(System.out::println); 도 가능

		
//      한글을 정수로 변경
		String number = "공일이삼사오육칠팔구";
		String hanguel = "육칠삼오";
		number.chars().map(hanguel::indexOf).forEach(System.out::print);
		number.chars().map(v->hanguel.indexOf(v)).forEach(System.out::println);

		
//      정수를 한글로 변경
	      String count = "1024";
	      count.chars().map(c -> c - 48).forEach(c -> System.out.print(number.charAt(c)));

		
	}

}
