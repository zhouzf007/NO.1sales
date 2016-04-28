package com.dianba.userdomain.constant;

/**
 * 常量存储类
 */
public final class Const {

	public static final int DISPLAY_STYLE_NORMAL = 0;
	public static final int DISPLAY_STYLE_MINI = 1;
	
	public static final int PAGE_NO = 1;
	
	public static final String PAGE_SIZE = "20";
	
	public static final String STATUS = "status";
	public static final String SUCCESS = "success";
	public static final String FAILURE = "failure";
	public static final String ERROR_MESSAGE = "errorMessage";
	
	
	public static final String UNKOWN_EXCEPTION = "unknown exception";
	public static final String GET_EXCEPTION = "query exception,please try again";
	public static final String CREATE_EXCEPTION = "create exception,please try again";
	public static final String UPDATE_EXCEPTION = "update exception,please try again";
	public static final String DELETE_EXCEPTION = "delete exception,please try again";
	
	/**
	 * 普通用户
	 */
	public static final String USER_TYPE_WMUSER = "user";

	/**
	 * 快递员
	 */
	public static final String USER_TYPE_COURIERUSER = "courier";

	/**
	 * 商家
	 */
	public static final String USER_TYPE_MERCHANTUSER = "merchant";
	/**
	 * 管理员
	 */
	public static final String USER_TYPE_MANAGEUSER = "manage";
	
	/**
	 * token
	 */
	public static final String TOKEN_PARAM = "accessToken";

	/**
	 * 登录Token
	 */
	public static final String LOGIN_TOKEN_PARAM = "loginToken";
	
	/**
	 * 手机唯一标识Token
	 */
	public static final String IDENTITY_TOKEN_PARAM = "idEntityToken";
	
	/**
	 * 登录名称(cookie)
	 */
	public static final String LOGIN_PARAM = "_name";
	
	/**
	 * API接口参数登录帐户名称
	 */
	public static final String API_LOGIN_NAME = "loginName";
	
	/**
	 * 默认Cookies的maxAge
	 */
	public static final int DEFAULT_COOKIE_MAXAGE = 12*60*60;
	
	/**
	 * hex次数
	 */
	public static final int HEX_SIZE = 1024;
	
	/**
	 * 默认验证码参数名称
	 */
	public static final String CAPTCHA_PARAM = "captcha";
	
	/**
	 * 允许错误次数
	 */
	public static final int CORRECTNUMBER = 3;
	
	/**
	 * 默认在session中存储的登录错误次数的名称
	 */
	public static final String CAPTCHA_ERROR_NUM_NAME = "incorrectNumber";
	
	/**
	 * 计算地理位置差距，0.001=100米
	 */
	public static final double  PRECISION = 0.01;

	/* 缓存KEY 普通用户位置 */
	public static final String LOCATION_USER = "LocationUser_"; 
	/* 缓存KEY 快递员位置 */
	public static final String LOCATION_COURIER = "LocationCourier_";
	
	/* 蹭饭扫描公里数,  0.2 = 20公里 = 20000米*/
	public static final double CENGRICE_SCAN_RANGE = 0.2;
	
	/* 缓存KEY 热销菜品*/
	public static final String HOTSELLING_USER = "HotSellingUser_";
	/* 缓存KEY 商家类别 */
	public static final String CATEGORY = "Category_";

	
	
	
	
	
	
	
	/* 系统用户头像默认图片 - 男 */
    public static final String DEFAULT_IMG_M = "http://oss.0085.com/weixin/vulgartycoon.png";
    /* 系统用户头像默认图片 - 女 */
    public static final String DEFAULT_IMG_F = "http://oss.0085.com/weixin/beauty.png";
    
    public static final String PAYTYPE_WEIXINPAY= "weixinpay";//微信支付
    public static final String PAYTYPE_balance= "balance";//余额支付
    public static final String PAYTYPE_merchantpay= "merchantpay";//商家会员卡支付
    public static final String PAYTYPE_WFTPAY= "wft_pay";//威付通支付
    
}