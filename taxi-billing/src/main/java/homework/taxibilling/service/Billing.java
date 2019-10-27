package homework.taxibilling.service;

import homework.taxibilling.po.Taxi;


public interface Billing {
	
	double billing(Taxi taxi,double totalDistance);

}
