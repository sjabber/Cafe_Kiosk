package DB;


/**
 * 
 * @author seunghwan
 버튼 누를시 저장하는 정보의 형태
 이름 가격 수량 만 저장
 
 
 */
public class Product {

	private String prod_name;
	private int prod_price;

	public Product(String prod_name, int prod_price) {
		super();
		this.prod_name = prod_name;
		this.prod_price = prod_price;
	}

	public String getProd_name() {
		return prod_name;
	}

	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}

	public int getProd_price() {
		return prod_price;
	}

	public void setProd_price(int prod_price) {
		this.prod_price = prod_price;
	}
	
	
	
}

