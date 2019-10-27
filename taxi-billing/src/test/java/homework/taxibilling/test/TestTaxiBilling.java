package homework.taxibilling.test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import homework.taxibilling.po.Taxi;
import homework.taxibilling.service.impl.TaxiBilling;
import static homework.taxibilling.contants.TaxiRegionTypeEnum.*;

import org.junit.Assert;
import org.junit.Test;

/*
 * 注：可以在homework.taxibilling.dao.SimulateDao类中，更改计费规则数据(白天夜晚时间、距离、单价等)
 * 
 * 另外：只要存在 提供当前车“实时计费行驶距离”的服务接口，我另起一个线程便可以在任意时间点，输出车行驶过程中的实时费用
 */
public class TestTaxiBilling {

	@Test
	public void testInnerRingAndDaylight_case1() {	//夜晚，内环测试
		
		/* case 1:
		 * 计费路程为0
		 */
		Taxi taxi = new Taxi(INNER_RING);
		TaxiBilling tb = new TaxiBilling(taxi);
		double fee = tb.billing(taxi, 0);
		System.out.println(fee);
		Assert.assertEquals(0.0d, fee, 0.0d);
		
	}
	
	@Test
	public void testInnerRingAndNight_case2() {	//白天，内环测试
		
		/* case 1:
		 * 计费路程为0
		 */
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		
		Taxi taxi = new Taxi(INNER_RING);
		TaxiBilling tb = new TaxiBilling(taxi);
		try {
			tb.setNowTime(df.parse("12:00"));	//为测试白天夜晚切换，特意开放的设置通道函数
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double fee = tb.billing(taxi, 0);
		System.out.println(fee);
		Assert.assertEquals(0.0d, fee, 0.0d);
		
	}


	@Test
	public void testInnerRingAndDaylight_case3() {	//夜晚，内环测试
		
		/* case 3:
		 * 计费路程大于0，小于或等于起步距离
		 */
		Taxi taxi = new Taxi(INNER_RING);
		TaxiBilling tb = new TaxiBilling(taxi);
		double fee = tb.billing(taxi, 1.5);
		System.out.println(fee);
		Assert.assertEquals(18.0d, fee, 0.0d);
		
	}
	
	@Test
	public void testInnerRingAndNight_case4() {	//白天，内环测试
		
		/* case 4:
		 * 计费路程大于0，小于或等于起步距离
		 */
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		
		Taxi taxi = new Taxi(INNER_RING);
		TaxiBilling tb = new TaxiBilling(taxi);
		try {
			tb.setNowTime(df.parse("12:00"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double fee = tb.billing(taxi, 1.5);
		System.out.println(fee);
		Assert.assertEquals(14.0d, fee, 0.0d);
		
	}
	
	@Test
	public void testAbnormal_case5() {	//白天，内环测试
		
		/* case 5:
		 * 计费路程小于0
		 */
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		
		Taxi taxi = new Taxi(INNER_RING);
		TaxiBilling tb = new TaxiBilling(taxi);
		try {
			tb.setNowTime(df.parse("12:00"));
		} catch (ParseException e) {
			e.printStackTrace();
		}
		double fee = tb.billing(taxi, -1);
		System.out.println(fee);
		Assert.fail();
		
	}
	
	@Test
	public void testAbnormal_case6() {	//夜晚，内环测试
		
		/* case 6:
		 * 传入taxi为空
		 */
		SimpleDateFormat df = new SimpleDateFormat("HH:mm");
		
		Taxi taxi = new Taxi(INNER_RING);
		TaxiBilling tb = new TaxiBilling(taxi);
		double fee = tb.billing(null, 3);
		System.out.println(fee);
		Assert.fail();
		
	}
	
	/*
	 * 测试外环、以及超出起步价等场景只需修改参数即可
	 */
}
