package chap04._0205;

public class BookTest {
	public static void main(String[] args) {

		Manager manager = new Manager();

		manager.insert("21424", "Java Pro", "김하나", "Jaen.kr", 15000, "Java 기본문법");

		manager.insert("35355", "분석설계", "소나무", "Jaen.kr", 30000, "SW 모델링");

		manager.insert("35535", "Java World", "편집부", "Java.com", 2018, 2, 7000, "첫 걸음");


		manager.update("21424", "Java Pro", "BJ_Hong", "Jaen.kr", 19900, "Java 기본문법");

		manager.update("35535", "Java World", "BJ_Hong", "motoman.co.kr", 2020, 2, 39800, "첫 걸음" );

		manager.delete( "Java Pro",1);

		manager.list(1);

		manager.list(2);

	}

}
