package app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Stream;

public class StreamCreationTest {

	public static void main(String[] args) {
		// #1 Array
		{
			String[] strArray = {"A", "B", "C"};
			
			//Stream<String> stream = Arrays.stream(strArray); 	// by Arrays.stream()
			Stream<String> stream = Stream.of(strArray);		// by Stream.of()
			print(stream);
		}
		
		// #2 Collection
		{
			List<String> list = Arrays.asList("D", "E", "F");
			
			Stream<String> stream = list.stream();
			print(stream);
		}
		
		// #3 Stream.generate() with functional interface
		{
			Stream<Integer> stream = Stream.generate(() -> { return new Random().nextInt(10); }).limit(5);
			print(stream);
		}
		
		// #4  Stream.iterate() with functional interface
		{
			Stream<Integer> stream = Stream.iterate(1, n -> n + 2).limit(10);
			print(stream);
		}
	}

	public static void print(Stream<?> stream) {
		// Stream forEach with functional interface consumer
		stream.forEach( a -> System.out.print(a + " "));
		System.out.println();
	}
}
