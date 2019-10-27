package homework.taxibilling.exceptions;

public class TaxiBillingException extends RuntimeException{


	private static final long serialVersionUID = 1L;
	
	/**
	 * 出租车内外环属性未指定
	 */
	public static final TaxiBillingException TAXI_REGION_VALUE_ERROR = new TaxiBillingException(10000001, "出租车内外环属性未指定");
	
	/**
	 * 出租车未初始化
	 */
	public static final TaxiBillingException TAXI_ISNULL_ERROR = new TaxiBillingException(10000002, "出租车未初始化");
	
	/**
	 * 计费规则初始化失败
	 */
	public static final TaxiBillingException FEERULE_ISNULL_ERROR = new TaxiBillingException(10000003, "计费规则初始化失败");	
	
	/**
	 * 计费路程总长为负数
	 */
	public static final TaxiBillingException FEEDISTANCE_ISNEGATIVE_ERROR = new TaxiBillingException(10000004, "计费路程总长为负数");	
	
	/**
	 * 临界距离不大于起步距离
	 */
	public static final TaxiBillingException CRITICALE_DISTANCE_ERROR = new TaxiBillingException(10000005, "临界距离不大于起步距离");
	/**
	 * 计费规则值存在负数
	 */
	public static final TaxiBillingException FEERULE_VALUE_ISNEGATIVE_ERROR = new TaxiBillingException(10000006, "计费规则值存在负数");
	
	
	/**
	 * 异常信息
	 */
	protected String msg;
	/**
	 * 具体异常码
	 */
	protected int code;
	
	public TaxiBillingException(int code, String msgFormat, Object... args) {
		super(String.format(msgFormat, args));
		this.code = code;
		this.msg = String.format(msgFormat, args);
	}

	public TaxiBillingException() {
		super();
	}

	public String getMsg() {
		return msg;
	}

	public int getCode() {
		return code;
	}

	/**
	 * 实例化异常
	 * 
	 * @param msgFormat
	 * @param args
	 * @return
	 */
	public TaxiBillingException newInstance(String msgFormat, Object... args) {
		return new TaxiBillingException(this.code, msgFormat, args);
	}

	public TaxiBillingException(String message, Throwable cause) {
		super(message, cause);
	}

	public TaxiBillingException(Throwable cause) {
		super(cause);
	}

	public TaxiBillingException(String message) {
		super(message);
	}
	
}
