import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class HolidayBonusTestSTUDENT {
	private double[][] dataSet1 = {{1,2,3},{4,5},{6,7,8}};
	@BeforeEach
	void setUp() throws Exception {
	}

	@AfterEach
	void tearDown() throws Exception {
	}

	@Test
	void test() {
		try{
			double[] result = HolidayBonus.calculateHolidayBonus(dataSet1,5000,1000,2000);
			assertEquals(15000.0,result[2],.001);
			}
			catch (Exception e) {
				fail("This should not have caused an Exception");
			} 
	}

}
