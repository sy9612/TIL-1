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

public class _1 {
	public static void main(String[] args) throws IOException {
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

		int arrRows = Integer.parseInt(bufferedReader.readLine().trim());
		int arrColumns = Integer.parseInt(bufferedReader.readLine().trim());

		List<List<String>> arr = new ArrayList<>();

		IntStream.range(0, arrRows).forEach(i -> {
			try {
				arr.add(Stream.of(bufferedReader.readLine().replaceAll("\\s+$", "").split(" ")).collect(toList()));
			} catch (IOException ex) {
				throw new RuntimeException(ex);
			}
		});

		List<String> result = solution(arr);

		bufferedReader.close();
	}

	public static List<String> solution(List<List<String>> arr) {
		// Write your code here

		int min = 0;

		// HashMap에 대한 정의를 알아가자
		// HashMap이란? Hash란? -> 해시로 인해 변형된 값을 key값으로 사용
		HashMap<String, Integer> hm = new HashMap<>();
	

		for (int i = 0; i < arr.size(); i++) {

			// 누가 누구에게 줬는지 체크
			// ArrayList.get의 시간복잡도 -> O(1)
			String from = arr.get(i).get(0);
			String to = arr.get(i).get(1);
			String point = arr.get(i).get(2);

			// key 값이 있는 지 확인하지 않아도 put으로 변경할 수 있다.
			// 하지만 처음 값이 없으면, hm.get(from)을 하지 못하기 때문에 contain으로 존재하는 지 확인했다.
			/**
			 * 시간복잡도는?
			 * 존재하는 지 검색 O(1)
			 * 추가하는 것 O(1)
			 * Why? HashMap의 key는 Hash로 접근하므로
			 */

			 /*
			 더 나은 방향? TreeMap의 사용
			 TreeMap의 comparator를 지정하면 treemap에 넣으면서 자동으로 가장 작은 숫자를 가져올 수 있음 -> 근데 get에 logn, contian에 logn, next에 logn
			 */
			
			if (!hm.containsKey(from)) {
				hm.put(from, -Integer.parseInt(point));
			} else if (hm.containsKey(from)) {
				hm.replace(from, hm.get(from) - Integer.parseInt(point));
			}

			if (!hm.containsKey(to)) {
				hm.put(to, Integer.parseInt(point));
			} else if (hm.containsKey(to)) {
				hm.replace(to, hm.get(to) + Integer.parseInt(point));
			}

		}

		// 가장 작은 값을 찾기 위해
		// 정렬을 이용해서 최소값 찾기?
		for (String key : hm.keySet()) {
			int pt = hm.get(key); // O(n)
			if (min > pt) {
				min = pt;
			}
		}

		// 링크드리스트에 대해서 알아가자
		List<String> result = new LinkedList<>();
		if (min == 0) {
			result.add("None");
		} else {
			for (String key : hm.keySet()) {
				if (min == hm.get(key)) {
					result.add(key);
				}
			}

		}
		
		// 어떻게 정렬이 가능한가?
		/**
		 * Tim 정렬 O(n), O(nlogn)
		 * Tim 정렬이란: 삽입 정렬 + 머지 정렬
		 * - 머지 정렬보다 작은 추가 메모리 사용
		 * - 삽입 정렬: 인접한 메모리와의 비교를 반복하여 참조 지역성의 원리를 잘 만족함 -> 작은 덩어리로 잘라 각각의 덩어리에 삽입 정렬한 뒤 병합
		 * 
		 * 참조 지역성의 원리로 인해 Tim 사용
		 */
		Collections.sort(result);
		
		return result;
	}
}

