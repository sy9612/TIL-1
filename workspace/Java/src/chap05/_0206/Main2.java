package chap05._0206;

public class Main2 {
	public static void main(String[] args) {
		Superman s = new Superman();
		toEat(s);
	}
	static void toEat(IEat e) {
		//형변환
		
		if(e instanceof Superman) {
			
			ILove l = (ILove)e;
		}
		
	}
	
}
