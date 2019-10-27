package homework.taxibilling.po;

import java.io.Serializable;

/**
 * 计费规则类
 * @author jsy
 * 
 */

public class FeeRule implements Serializable {

	private static final long serialVersionUID = 1L;

	// 白天起步价
	private double initialPriceDaylight;
	
	// 夜间起步价
	private double initialPriceNight;
	
	// 白天起步价最大距离
	private int initialMaxDistanceDaylight;
	
	// 夜间起步价最大距离
	private int initialMaxDistanceNight;
	
	// 白天超出起步价距离，每公里价格
	private double unitPriceDaylight;
	
	// 夜间超出起步价距离，每公里价格
	private double unitPriceNight;
	
	// 公里临界值：超出后里程单价可能发生变动
	private int criticalDistance;
	
	// 白天超临界值后单价
	private double unitPriceCriticalDaylight;
	
	// 夜间超临界值后单价
	private double unitPriceCriticalNight;

	public double getInitialPriceDaylight() {
		return initialPriceDaylight;
	}

	public void setInitialPriceDaylight(double initialPriceDaylight) {
		this.initialPriceDaylight = initialPriceDaylight;
	}

	public double getInitialPriceNight() {
		return initialPriceNight;
	}

	public void setInitialPriceNight(double initialPriceNight) {
		this.initialPriceNight = initialPriceNight;
	}

	public int getInitialMaxDistanceDaylight() {
		return initialMaxDistanceDaylight;
	}

	public void setInitialMaxDistanceDaylight(int initialMaxDistanceDaylight) {
		this.initialMaxDistanceDaylight = initialMaxDistanceDaylight;
	}

	public int getInitialMaxDistanceNight() {
		return initialMaxDistanceNight;
	}

	public void setInitialMaxDistanceNight(int initialMaxDistanceNight) {
		this.initialMaxDistanceNight = initialMaxDistanceNight;
	}

	public double getUnitPriceDaylight() {
		return unitPriceDaylight;
	}

	public void setUnitPriceDaylight(double unitPriceDaylight) {
		this.unitPriceDaylight = unitPriceDaylight;
	}

	public double getUnitPriceNight() {
		return unitPriceNight;
	}

	public void setUnitPriceNight(double unitPriceNight) {
		this.unitPriceNight = unitPriceNight;
	}

	public int getCriticalDistance() {
		return criticalDistance;
	}

	public void setCriticalDistance(int criticalDistance) {
		this.criticalDistance = criticalDistance;
	}

	public double getUnitPriceCriticalDaylight() {
		return unitPriceCriticalDaylight;
	}

	public void setUnitPriceCriticalDaylight(double unitPriceCriticalDaylight) {
		this.unitPriceCriticalDaylight = unitPriceCriticalDaylight;
	}

	public double getUnitPriceCriticalNight() {
		return unitPriceCriticalNight;
	}

	public void setUnitPriceCriticalNight(double unitPriceCriticalNight) {
		this.unitPriceCriticalNight = unitPriceCriticalNight;
	}

	@Override
	public String toString() {
		return "FeeRule [initialPriceDaylight=" + initialPriceDaylight
				+ ", initialPriceNight=" + initialPriceNight
				+ ", initialMaxDistanceDaylight=" + initialMaxDistanceDaylight
				+ ", initialMaxDistanceNight=" + initialMaxDistanceNight
				+ ", unitPriceDaylight=" + unitPriceDaylight
				+ ", unitPriceNight=" + unitPriceNight + ", criticalDistance="
				+ criticalDistance + ", unitPriceCriticalDaylight="
				+ unitPriceCriticalDaylight + ", unitPriceCriticalNight="
				+ unitPriceCriticalNight + "]";
	}

	
}
