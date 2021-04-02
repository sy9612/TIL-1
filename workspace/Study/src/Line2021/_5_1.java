package Line2021;

import java.util.ArrayList;

public class _5_1 {
	public static void main(String[] args) {
		String program = "bank";
		String[] flag_rules = {"-send STRING", "-a ALIAS -amount", "-amount NUMBERS"};
		String commads[] = {"bank -send abc -amount 500 200 -a 400", "bank -send abc -a hey"};

		solution(program, flag_rules, commads);
	}
	static class Type {
		String flag;
		String argument;

		Type(String flag, String argument) {
			this.flag = flag;
			this.argument = argument;
		}
	}
    public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
      boolean[] answer = new boolean[commands.length];

		ArrayList<Type> flags = new ArrayList<>();

		//flag 관리
		for (int i = 0; i < flag_rules.length; i++) {
			String[] buf = flag_rules[i].split(" ");
			flags.add(new Type(buf[0], buf[1]));
		}

		
		
		for (int i = 0; i < commands.length; i++) {
			String[] command = commands[i].split(" ");

			if (!command[0].equals(program)) {
				answer[i] = false;
				continue;
			}

			boolean ans = false;

			// flage_name flag_arguments_type 형식 (j, j+1)
			// flag_arguments_type: 3개, NULL, NUMBER, STRING
			for (int j = 1; j < command.length; j++) {
				// 처음 시작이 flag가 아니라면 flag가 나올 때 까지 continue;
				if (command[j].charAt(0) != '-') {
					continue;
				}

				// 처음 시작이 flag 라면
				for (int flag = 0; flag < flags.size(); flag++) {
					ans = true;
					// 같은 flag라면
					if (command[j].equals(flags.get(flag).flag)) {

						// NULL이면 바로 다음 명령어가 들어오는 지 check
						if (j + 1 < command.length && flags.get(flag).argument.equals("NULL")) {
							if (command[j + 1].charAt(0) == '-')
								break;
							else {
								ans = false;
								break;
							}
						}

						int cnt = 0;
						while (j + 1 < command.length && command[j + 1].charAt(0) != '-') {
							// 다음 명령어로 이동
							j++;

							
							// flag 구분
							switch (flags.get(flag).argument) {

							// String일 때
							case "STRING":
                                // 이후 명령어가 2개 이상이 들어오면 실패
								if(cnt!= 0) {
									ans = false;
									break;
								}
								// 숫자로 바꿀 수 있으면 명령어 실패
								try {
									cnt++;
									int number = Integer.parseInt(command[j]);
									ans = false;
								} catch (NumberFormatException e) {
									ans = true;
								}
								break;

						
								
							// Number 일 떄
							case "NUMBER":
                                    // 이후 명령어가 2개 이상이 들어오면 실패
								if(cnt!= 0) {
									ans = false;
									break;
								}
								// 숫자로 바꾸지 못하면 명령어 실패
								try {
									cnt++;
									int number = Integer.parseInt(command[j]);
								} catch (NumberFormatException e) {
									ans = false;
								}

								break;

							

							}// end switch

						} // while 다음 명렁어가 flag일 때 종료

						break; // 같은 flag를 찾았으므로 그 이후 flag는 NOT COUNT
					} // 같은 flag를 찾은 for 종료

				} // flag 명령 종료

				// 이미 명렁어 실행이 불가능 함
				if (!ans)
					break;

			} // 첫 번째 command
			answer[i] = ans; // 답

		}

		return answer;
    }
}
