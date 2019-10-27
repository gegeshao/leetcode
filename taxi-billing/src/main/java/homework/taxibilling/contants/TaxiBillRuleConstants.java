package homework.taxibilling.contants;

public final class TaxiBillRuleConstants {
	// 白天起步价
	public final static double INITIAL_PRICE_DAYLIGHT = 14.0d;
	// 夜间起步价
	public final static double INITIAL_PRICE_NIGHT = 18.0d;
	// 白天起步价最大距离
	public final static int INITIAL_MAX_DISTANCE_DAYLIGHT = 3;
	// 夜间起步价最大距离
	public final static int INITIAL_MAX_DISTANCE_NIGHT = 3;
	// 白天超出起步价距离，每小时价格
	public final static double UNIT_PRICE_DAYLIGHT = 2.5d;
	// 夜间超出起步价距离，每小时价格
	public final static double UNIT_PRICE_NIGHT = 3d;
	// 公里临界值：超出后里程单价可能发生变动
	public final static int CRITICAL_DISTANCE = 10;
	// 内环：白天超临界值后单价
	public final static double INNER_UNIT_PRICE_CRITICAL_DAYLIGHT = 3.5d;
	// 内环：夜间超临界值后单价
	public final static double INNER_UNIT_PRICE_CRITICAL_NIGHT = 4.7d;
	// 内环：白天超临界值后单价
	public final static double OUTTER_UNIT_PRICE_CRITICAL_DAYLIGHT = 2.5d;
	// 内环：夜间超临界值后单价
	public final static double OUTTER_UNIT_PRICE_CRITICAL_NIGHT = 3d;

	
	// string表示：白天
	public final static String DAYLIGHT = "DAYLIGHT";

	// string表示：夜晚
	public final static String NIGHT = "NIGHT";

	// string表示白天开始时间：含06:00
	public final static String DAYLIGHT_BEGIN_TIME = "05:59";

	// string表示白天结束时间：不含23:00(boolean java.util.Calendar.before(Object when): This method is equivalent to:compareTo(when) < 0)
	public final static String DAYLIGHT_END_TIME = "23:00";
}
