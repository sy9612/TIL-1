package Line2021;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class _5 {
	public static void main(String[] args) {
		String program = "line";
		String[] flag_rules = {"-s STRING", "-num NUMBER", "-e NULL", "-n ALIAS -num"};
		String commads[] = {"line -n HI"};

		solution(program, flag_rules, commads);
	}

	// 관리를 용이하게 하기 위해 flag_rules을 class로 지정
	static class Type {
		String flag;
		String argument;
		String alias;

		Type(String flag, String argument, String alias) {
			this.flag = flag;
			this.argument = argument;
			this.alias = alias;
		}
		
	}

	public static boolean[] solution(String program, String[] flag_rules, String[] commands) {
		boolean[] answer = new boolean[commands.length];

		ArrayList<Type> flags = new ArrayList<>();

		/*
		 * buf[0] = flag
		 * buf[1] = flag_argument
		 * =====
		 * buf[0] = Alias flag
		 * buf[1] = ALIAS
		 * buf[2] = flag
		 */
		for (int i = 0; i < flag_rules.length; i++) {
			String[] buf = flag_rules[i].split(" ");
			
			// 두 번째 인자가 ALIAS면 약어 지정
			if(buf[1].equals("ALIAS")) {
				boolean contain = false;
				
				for (int j = 0; j < flags.size(); j++) {
					
					//명령어 관리 list에 flag가 존재한다면
					if(flags.get(j).flag.equals(buf[2])) {
						Type retype = new Type(flags.get(j).flag, flags.get(j).argument, buf[0]);
						flags.set(j, retype); //타입 재지정
						contain = true;
						break;
					}
				}
				
				// 약어가 먼저 지정되면 type 미지정으로 flags에 삽입
				if(!contain) {
					flags.add(new Type(buf[2], "NOTHING", buf[0]));
				}
				
			}//약어지정
				
			else {
				boolean contain = false;
				for (int j = 0; j < flags.size(); j++) {
					//약어가 먼저 저장됐을 때
					if(flags.get(j).flag.equals(buf[0])) {
						Type retype = new Type(flags.get(j).flag, buf[1], flags.get(j).alias);
						flags.set(j, retype); //타입 재지정
						contain = true;
						break;
					}
				}
				
				// 약어가 없다면 NOTHING
				if(!contain) 
					flags.add(new Type(buf[0], buf[1], "NOTHING"));
			}//flag지정
		}//관리 list 생성 종료

		for (int i = 0; i < commands.length; i++) {
			String[] command = commands[i].split(" ");
			
			// 동시에 입력되는 지를 check
			// ArrayList이므로 순서가 바뀌지 않는다.
			boolean[] same_input = new boolean[flags.size()];
			
			if (!command[0].equals(program)) {
				answer[i] = false;
				continue;
			} //명령어가 program이랑 다르면 다음 command로

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
					// 같은 flag 또는 Alias라면
					if (command[j].equals(flags.get(flag).flag) || command[j].equals(flags.get(flag).alias)) {
						//이미 한 번 들어온 명령어라면 실패
						if(same_input[flag]) {
							ans = false;
							break;
						}
						ans = true;
						
						//들어온 명령어임을 check
						same_input[flag] = true;
						
						// NULL이면 바로 다음 명령어가 들어오는 지 check
						if (flags.get(flag).argument.equals("NULL")) {
							if(j + 1 >= command.length ) {
								ans = true;
								break;
							}
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

							case "STRINGS":
								// 숫자로 바꾸지 못하면 명령어 실패
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

							case "NUMBERS":

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
						
						//명령어 뒤에 아무런 argument도 없다면
						if(cnt == 0)
							ans = false;
						
						break; // 같은 flag를 찾았으므로 그 이후 flag는 NOT COUNT
					} // 같은 flag를 찾은 for 종료

				} // flag 명령 종료

				// 이미 명렁어 실행이 불가능 함
				if (!ans)
					break;

			} // 첫 번째 command
			answer[i] = ans; // 답

		}

		System.out.println(Arrays.toString(answer));
		return answer;
	}
}
