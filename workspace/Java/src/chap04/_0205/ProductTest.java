package chap04._0205;

public class ProductTest {
	public static void main(String[] args) {

		hw_Manager manager = new hw_Manager();
		
		manager.insert(2132, "롤러블티비", 30000000, 10, 100, 0);
		manager.insert(1530, "LG티비", 1000000, 150, 90, 1);
		manager.insert(45211, "삼성티비", 5000100, 130, 150, 1);
		manager.insert(1156, "티비종륲1", 13010100, 1, 800, 0);
		
		manager.insert(475, "냉장고", 200, 900, 50);
		manager.insert(115, "삼성냉장고", 15000000, 1000, 100);
		manager.insert(041, "신기한냉장고", 701000, 1, 600000);

		manager.list(1);

		manager.list(2);
	}
}
