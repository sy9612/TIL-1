package sw_expert._0129;
import java.util.Scanner;
import java.util.Stack;

class 쇠막대기_자르기
{
	public static void main(String args[]) throws Exception
	{
		
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int result = 0;
			
			String stick = sc.next();
			Stack<Character> stack = new Stack<>();
			
			int laser_arr[] = new int[stick.length()];
			int top = -1;
		
			for(int i=0; i<stick.length(); i++) {
				if(stick.charAt(i) == '(') {
					if(i<stick.length()-1 && stick.charAt(i+1) == ')')
					{
						//레이저
//						int[] arr = new int[laser.size()];
						
						for(int j=0; j<top+1; j++)
							laser_arr[j]++;
/*						for(int j=arr.length-1; j>=0; j--){
							arr[j] = (laser.pop()+1);
						}
						for(int j=0; j<arr.length;j++) {
							laser.push(arr[j]);
						}*/
						
						i++;
					}
					else
					{
						top++;
						stack.push('(');
					}
				}
				else if(stick.charAt(i) == ')') {
					if(!stack.isEmpty() && stack.pop() == '(') {
						int buf = laser_arr[top];
						laser_arr[top]=0;
						top--;
//
						result += (buf+1);
					}
					else {
						break;
					}
				}
			}
			
			System.out.println("#"+test_case+" "+ result);		
		}
	}
}