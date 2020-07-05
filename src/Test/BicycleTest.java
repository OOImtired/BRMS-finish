package Test;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import dao.BicycleDao;
import model.Bicycle;

public class BicycleTest {
	private BicycleDao dao=new BicycleDao();
	String brand;
	@Test
	public void testqueryBicycle() {
		List<Bicycle> queryBicycle=dao.queryBicycle(brand);
		assertEquals(2,queryBicycle.size());
	}
}
