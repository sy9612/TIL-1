package hw_03_0401;

public class Test {
	public static void main(String[] args) {
		ProductDAO dao = new ProductDAO();
		dao.insertProduct(0001, "LG전자TV 75UK", 1969990);
		dao.insertProduct(0002, "삼성전자TV UN43", 377300);
		dao.insertProduct(1000, "삼성전자 갤럭시북이온 노트북", 1599000);
		dao.insertProduct(2000, "LG전자 그램15 노트북", 1498980);
		dao.insertProduct(3000, "레노버 아이디어패드 노트북", 489000);

		dao.allViewProduct();
		dao.ViewProduct("노트북");
		dao.updateProduct(0001, "LG", 1000);
		
		dao.allViewProduct();
		
		dao.deleteProduct(0002);
		
		dao.allViewProduct();
	}
}
