package homework.taxibilling.dao;

import homework.taxibilling.po.FeeRule;
import static homework.taxibilling.contants.TaxiBillRuleConstants.*;

public class SimulateDao {

	/*
	 * 模拟从数据库中查询并返回feeRule实例，入参为：
	 * 		1--代表内环  
	 * 		2--代表外环
	 */
	
	public FeeRule getContentFromDatabase(int regionType){
		FeeRule rule = new FeeRule();
		//模拟从database获取到配置数据
		//模拟taxi是内环
		if(1==regionType){			
			rule.setCriticalDistance(CRITICAL_DISTANCE);
			rule.setInitialMaxDistanceDaylight(INITIAL_MAX_DISTANCE_DAYLIGHT);
			rule.setInitialMaxDistanceNight(INITIAL_MAX_DISTANCE_NIGHT);
			rule.setInitialPriceDaylight(INITIAL_PRICE_DAYLIGHT);
			rule.setInitialPriceNight(INITIAL_PRICE_NIGHT);
			rule.setUnitPriceCriticalDaylight(INNER_UNIT_PRICE_CRITICAL_DAYLIGHT);
			rule.setUnitPriceCriticalNight(INNER_UNIT_PRICE_CRITICAL_NIGHT);
			rule.setUnitPriceDaylight(UNIT_PRICE_DAYLIGHT);
			rule.setUnitPriceNight(UNIT_PRICE_NIGHT);			
			
			return rule;
		}
		
		//模拟从database获取到配置数据
		//模拟taxi是外环
		if(2==regionType){			
			rule.setCriticalDistance(CRITICAL_DISTANCE);
			rule.setInitialMaxDistanceDaylight(INITIAL_MAX_DISTANCE_DAYLIGHT);
			rule.setInitialMaxDistanceNight(INITIAL_MAX_DISTANCE_NIGHT);
			rule.setInitialPriceDaylight(INITIAL_PRICE_DAYLIGHT);
			rule.setInitialPriceNight(INITIAL_PRICE_NIGHT);
			rule.setUnitPriceCriticalDaylight(OUTTER_UNIT_PRICE_CRITICAL_DAYLIGHT);
			rule.setUnitPriceCriticalNight(OUTTER_UNIT_PRICE_CRITICAL_NIGHT);
			rule.setUnitPriceDaylight(UNIT_PRICE_DAYLIGHT);
			rule.setUnitPriceNight(UNIT_PRICE_NIGHT);			
			
			return rule;
		}
		
		return null;
	}
}
