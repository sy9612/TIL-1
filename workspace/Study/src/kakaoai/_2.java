package kakaoai;

import java.io.*;
import java.math.*;
import java.security.*;
import java.text.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.function.*;
import java.util.regex.*;
import java.util.stream.*;
import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

class Result {

	/*
	 * Complete the 'solution' function below.
	 *
	 * The function is expected to return a STRING_ARRAY. The function accepts
	 * following parameters: 1. 2D_STRING_ARRAY items 2. INTEGER orderBy 3. INTEGER
	 * orderDirection 4. INTEGER pageSize 5. INTEGER pageNumber
	 */

	// orderBy = 정렬할 아이템 열 (0, 1, 2)
	// Direciton : 0 = 오름차순, 1 = 내림차순
	// pageSize: 아이템
	// pageNumber: 페이지번호
	public static List<String> solution(List<List<String>> items, int orderBy, int orderDirection, int pageSize,
			int pageNumber) {

		List<String> result = new LinkedList<>();

		// List를 정렬해야 하므로 Collections를 이용했다.
		/**
		 * 단순한 구현 문제인가?
		 */
		Collections.sort(items, new Comparator<List<String>>() {

			@Override
			public int compare(List<String> o1, List<String> o2) {
				// TODO Auto-generated method stub

				// 동일한 코드에 대해서 합칠 수 있는 방안은?
				// 정렬에 대해서 알아가자. 정렬이란?
				
				if (orderDirection == 0) {
					// 문자열 비교
					if (orderBy == 0)
						return o1.get(orderBy).compareTo(o2.get(orderBy));
					//숫자 비교
					else {
						return Integer.parseInt(o1.get(orderBy)) - Integer.parseInt(o2.get(orderBy));
					}
				} else {
					if (orderBy == 0)
						return o2.get(orderBy).compareTo(o1.get(orderBy));
					else

						return Integer.parseInt(o2.get(orderBy)) - Integer.parseInt(o1.get(orderBy));

				}

			}

		});

		// pageSize가 더 크면 index outbound 에러가 발생할 수 있다.
		int min = Math.min(pageSize * (pageNumber + 1), items.size());
		for (int i = pageSize * pageNumber; i < min; i++) {
			result.add(items.get(i).get(0));
		}

		return result;

	}

}

public class _2 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int itemsRows = Integer.parseInt(bufferedReader.readLine().trim());
		int itemsColumns = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<String>> items = new ArrayList<>();

		IntStream.range(0, itemsRows).forEach(i -> {
			try {
				items.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		int orderBy = Integer.parseInt(bufferedReader.readLine().trim());

		int orderDirection = Integer.parseInt(bufferedReader.readLine().trim());

		int pageSize = Integer.parseInt(bufferedReader.readLine().trim());

		int pageNumber = Integer.parseInt(bufferedReader.readLine().trim());

		List<String> result = Result.solution(items, orderBy, orderDirection, pageSize, pageNumber);

		bufferedReader.close();
	}
}
