package homework.taxibilling.service.impl;

import static homework.taxibilling.exceptions.TaxiBillingException.*;
import static homework.taxibilling.contants.TaxiRegionTypeEnum.*;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import homework.taxibilling.dao.SimulateDao;
import homework.taxibilling.po.FeeRule;
import homework.taxibilling.po.Taxi;
import homework.taxibilling.service.Billing;
import homework.taxibilling.util.TimeOperatUtil;


public class TaxiBilling implements Billing {
	
	
	private Date nowTime ;
	
	private Logger logger = LoggerFactory.getLogger(this.getClass());
	//模拟去数据库读计费规则
	private SimulateDao dao = new SimulateDao();
	private Taxi taxi;
		
	public Date getNowTime() {
		return nowTime;
	}
	//该方法用于测试白天黑夜用
	public void setNowTime(Date nowTime) {
		this.nowTime = nowTime;
	}

	public TaxiBilling(Taxi taxi) {
		this.taxi = taxi;
		init();
	}

	/**
	 * 计费算法
	 * 		入参：出租车实例、行驶总距离
	 * 		出参：计费结果
	 */
	public double billing(Taxi taxi,double totalDistance) {
//		logger.info("---------------------------------------开始计费-----------------------------");
		System.out.println("---------------------------------------开始计费-----------------------------");
		/*
		 * 异常检查
		 */
		if(null == taxi){
			throw TAXI_ISNULL_ERROR;
		}
		if(0.0d > totalDistance){
			throw FEEDISTANCE_ISNEGATIVE_ERROR;
		}
		if(0.0d == totalDistance){
			return 0.0d;
		}
		//判断计费开始时间
		boolean isDaylight ;
		if(null==nowTime){
			isDaylight = TimeOperatUtil.isBelong(); 
		}
		else {
			isDaylight = TimeOperatUtil.isBelong(nowTime); 
		}
//		logger.info("---------------------------------------开始计费时间是否在白天： "+isDaylight);
		System.out.println("---------------------------------------开始计费时间是否在白天： "+isDaylight);
		//如果是白天
		if(isDaylight){
			//白天上车
			return billingInDaylight(taxi,totalDistance);
		}
		else {
			//夜间上车
			return billingInNight(taxi,totalDistance);
		}
		
	}

	private double billingInDaylight(Taxi taxi,double totalDistance){
		FeeRule rule = taxi.getRule();
		if(null == rule){
			throw FEERULE_ISNULL_ERROR;
		}
		//计费总路程
		int billingDistance = (int) Math.ceil(totalDistance);
		//taxi是内环出租车
		if(INNER_RING.equals(taxi.getRegion())){
			
			// 起步价到终点
			if(rule.getInitialMaxDistanceDaylight() >= billingDistance){
				return rule.getInitialPriceDaylight();
			}
			//起步价距离至临界距离之间 到终点
			else if ( (rule.getInitialMaxDistanceDaylight() < billingDistance) && (rule.getCriticalDistance() >= billingDistance) ) {
				// 超出起步距离的费用
				double exceedInitialFee = rule.getUnitPriceDaylight() * (billingDistance - rule.getInitialMaxDistanceDaylight());
				System.out.println("超出起步距离的费用: "+exceedInitialFee);
				//返回起步距离费用+超出费用
				return rule.getInitialPriceDaylight()+exceedInitialFee;
			}
			//超出临界距离 才到终点
			else {
				//超出部分：起步距离至临界距离之间 的费用
				double exceedBetweenInitialAndCriticalFee = rule.getUnitPriceDaylight() * (rule.getCriticalDistance()-rule.getInitialMaxDistanceDaylight());
				System.out.println("超出起步距离的费用: "+exceedBetweenInitialAndCriticalFee);
				//超出部分：超出临界距离 的费用
				double exceedCriticalFee = rule.getUnitPriceCriticalDaylight() * (billingDistance - rule.getCriticalDistance());
				System.out.println("超出临界距离 的费用: "+exceedCriticalFee);
				//返回各部分之和
				return rule.getInitialPriceDaylight()+exceedBetweenInitialAndCriticalFee+exceedCriticalFee;
			}
		}
		//外环出租车
		else {
			
			// 起步价到终点
			if (rule.getInitialMaxDistanceDaylight() >= billingDistance) {
				return rule.getInitialPriceDaylight();
			}
			//外环的出租车10公里之外的价格与10公里之内相同 
			else{
				// 超出起步距离的费用
				double exceedInitialFee = rule.getUnitPriceDaylight() * (billingDistance - rule.getInitialMaxDistanceDaylight());
				System.out.println("超出起步距离的费用: "+exceedInitialFee);
				//返回起步距离费用+超出费用
				return rule.getInitialPriceDaylight()+exceedInitialFee;
			}
		}
	}
	
	private double billingInNight(Taxi taxi,double totalDistance){
		FeeRule rule = taxi.getRule();
		if(null == rule){
			throw FEERULE_ISNULL_ERROR;
		}
		//计费总路程
		int billingDistance = (int) Math.ceil(totalDistance);
		// taxi是内环出租车
		if (INNER_RING.equals(taxi.getRegion())) {

			// 起步价到终点
			if(rule.getInitialMaxDistanceNight() >= billingDistance){
				return rule.getInitialPriceNight();
			}
			//起步价距离至临界距离之间 到终点
			else if ( (rule.getInitialMaxDistanceNight() < billingDistance) && (rule.getCriticalDistance() >= billingDistance) ) {
				// 超出起步距离的费用
				double exceedInitialFee = rule.getUnitPriceNight() * (billingDistance - rule.getInitialMaxDistanceNight());
				System.out.println("超出起步距离的费用: "+exceedInitialFee);
				//返回起步距离费用+超出费用
				return rule.getInitialPriceNight()+exceedInitialFee;
			}
			//超出临界距离 才到终点
			else {
				//超出部分：起步距离至临界距离之间 的费用
				double exceedBetweenInitialAndCriticalFee = rule.getUnitPriceNight() * (rule.getCriticalDistance()-rule.getInitialMaxDistanceNight());
				System.out.println("超出起步距离的费用: "+exceedBetweenInitialAndCriticalFee);
				//超出部分：超出临界距离 的费用
				double exceedCriticalFee = rule.getUnitPriceCriticalNight() * (billingDistance - rule.getCriticalDistance());
				System.out.println("超出临界距离 的费用: "+exceedCriticalFee);
				//返回各部分之和
				return rule.getInitialPriceNight()+exceedBetweenInitialAndCriticalFee+exceedCriticalFee;
			}
		}
		// 外环出租车
		else {

			// 起步价到终点
			if (rule.getInitialMaxDistanceNight() >= billingDistance) {
				return rule.getInitialPriceNight();
			}
			// 外环的出租车10公里之外的价格与10公里之内相同
			else {
				// 超出起步距离的费用
				double exceedInitialFee = rule.getUnitPriceNight() * (billingDistance - rule.getInitialMaxDistanceNight());
				System.out.println("超出起步距离的费用: "+exceedInitialFee);
				// 返回起步距离费用+超出费用
				return rule.getInitialPriceNight() + exceedInitialFee;
			}
		}
	}
	
	/*
	 * taxi和rule的初始化
	 */
	private void init() {
		/*
		 * 异常检查
		 */
		if(null == taxi){
			throw TAXI_ISNULL_ERROR;
		}
		if (null == taxi.getRegion()) {
			throw TAXI_REGION_VALUE_ERROR;
		}
		
//		logger.info("----------------------------根据taxi内外环属性，初始化计费规则------------------------");
		System.out.println("----------------------------根据taxi内外环属性: "+taxi.getRegion().getDesc() +"，初始化计费规则------------------------");
		FeeRule rules = new FeeRule();
		rules = dao.getContentFromDatabase(taxi.getRegion().getValue());
		checkRules(rules);
//		logger.info("----------------------------计费规则为： "+rules);
		System.out.println("----------------------------计费规则为： "+rules);
		if (null == rules) {
			throw FEERULE_ISNULL_ERROR;
		}
		taxi.setRule(rules);
	}
	
	private void checkRules(FeeRule rule){
		/*
		 *	数据异常检查 
		 */
		
		if((rule.getCriticalDistance() <= rule.getInitialMaxDistanceDaylight()) ||(rule.getCriticalDistance() <= rule.getInitialMaxDistanceNight()) ){
			throw CRITICALE_DISTANCE_ERROR;
		}
		
		if( (rule.getCriticalDistance() < 0) ||
		(rule.getInitialMaxDistanceDaylight() < 0) ||
		(rule.getInitialMaxDistanceNight() < 0) ||
		(rule.getInitialPriceDaylight() < 0.0d) ||
		(rule.getInitialPriceNight() < 0.0d) ||
		(rule.getUnitPriceCriticalDaylight() < 0.0d) ||
		(rule.getUnitPriceCriticalNight() < 0.0d)||
		(rule.getUnitPriceDaylight() < 0.0d) ||
		(rule.getUnitPriceNight()<0.0d) ){
			throw FEERULE_VALUE_ISNEGATIVE_ERROR;
		}
	}

}
