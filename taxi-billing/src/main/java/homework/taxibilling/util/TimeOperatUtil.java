package homework.taxibilling.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import static homework.taxibilling.contants.TaxiBillRuleConstants.*;

public class TimeOperatUtil {
	
	public static boolean isBelong(Date nowTime){

	    SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
	    Date now =null;
	    Date beginTime = null;
	    Date endTime = null;
	    try {
	        now = df.parse(df.format(nowTime));
	        beginTime = df.parse(DAYLIGHT_BEGIN_TIME);
	        endTime = df.parse(DAYLIGHT_END_TIME);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    Boolean flag = belongCalendar(now, beginTime, endTime);
	    return flag;
	}
	public static boolean isBelong(){

	    SimpleDateFormat df = new SimpleDateFormat("HH:mm");//设置日期格式
	    Date now =null;
	    Date beginTime = null;
	    Date endTime = null;
	    try {
	        now = df.parse(df.format(new Date()));
	        beginTime = df.parse(DAYLIGHT_BEGIN_TIME);
	        endTime = df.parse(DAYLIGHT_END_TIME);
	    } catch (Exception e) {
	        e.printStackTrace();
	    }

	    Boolean flag = belongCalendar(now, beginTime, endTime);
	    return flag;
	}

	/**
     * 判断时间是否在时间段内
     * @param nowTime
     * @param beginTime
     * @param endTime
     * @return
     */
    public static boolean belongCalendar(Date nowTime, Date beginTime, Date endTime) {
        Calendar date = Calendar.getInstance();
        date.setTime(nowTime);

        Calendar begin = Calendar.getInstance();
        begin.setTime(beginTime);

        Calendar end = Calendar.getInstance();
        end.setTime(endTime);

        if (date.after(begin) && date.before(end)) {
            return true;
        } else {
            return false;
        }
    }
}
