package chap04;

/**
 * 
 * @author multicampus
 *
 */
/** 개인정보클래스 */
public class Profile {
		/** 이름 */
		String name;
		/** 번호 */
		int no;
		/** 성별 */
		boolean gender;
		/** 나이 */
		int age;
		
		public void setData(Profile p) {
			
		}
		
		//생성자
		//객체의 초기화
		public Profile(){
			this("",0,false,0);
			this.toString();
			this.setData(this);
			System.out.println("Profile ");
			//자동으로 실행
		};
		
		public Profile(String string, int i, boolean b, int j) {
			
		}

		public String toString() {
			return name + ", " + no +", " + gender+ ", "+age;
		}
		


}
