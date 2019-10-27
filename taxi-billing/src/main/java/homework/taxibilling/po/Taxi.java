package homework.taxibilling.po;

import homework.taxibilling.contants.TaxiRegionTypeEnum;
import java.io.Serializable;

/**
 * 出租车类
 * @author jsy
 *
 */
public class Taxi implements Serializable{

	private static final long serialVersionUID = 1L;

	//持有计费规则类实例，在TaxiBilling.init()方法中设置具体对象
	private FeeRule rule;
	//归属：外环、内环
	private TaxiRegionTypeEnum region;

	public Taxi(TaxiRegionTypeEnum region) {
		this.region = region;
	}

	public TaxiRegionTypeEnum getRegion() {
		return region;
	}

	public FeeRule getRule() {
		return rule;
	}

	public void setRule(FeeRule rule) {
		this.rule = rule;
	}

	@Override
	public String toString() {
		return "Taxi [rule=" + rule + ", region=" + region + "]";
	}
	
}
