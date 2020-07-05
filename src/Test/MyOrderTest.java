package Test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import dao.MyOrderDao;
import model.Rental;

public class MyOrderTest {
	private MyOrderDao dao=new MyOrderDao();
	String brand;
	@Test
	public void testqueryMyOrder() {
		 List<Rental> queryMyOrder= dao.queryMyOrder(brand);
		 assertEquals(4,queryMyOrder.size());
	}
}
