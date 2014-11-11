/**
 * 
 */
package com.demo.testapp.app;

/**
 * @author yangsatiago
 *
 */
public class Constant {

	public static final String ROOT_URL = "http://17huaitao.com/";
	public static final String IM_ROOT_URL = "http://im.17huaitao.com/";
	public static final String IM_ROOT_HOST = "im.17huaitao.com";
	public static final String IM_ROOT_URL_NOLINE = "http://im.17huaitao.com";
	//
	// int
	public static final int MIN_PWD_LENGTH = 6;
	public static final int MAX_PWD_LENGTH = 20;
	public static final int SEND_CODE_LAST_TIME = 30;// TODO release to 30
	public static final int MIN_NAME_LENGTH = 2;
	public static final int MAX_NAME_LENGTH = 20;

	// String
	public static final String GENDER_MALE = "1";
	public static final String GENDER_FEMALE = "0";

	// REQUEST_CODE
	public static final int REQUEST_SELECT_CITY = 100;
	public static final int REQUEST_UPLOC_SERVICE = 101;
	public static final int REQUEST_SELECT_LATLNG = 102;
	public static final int REQUEST_SELECT_ADDRESS = 103;
	// KEY
	public static final String KEY_CITY_NAME = "key_city_name";
	public static final String KEY_CITY_PINYIN = "key_city_pinyin";
	public static final String KEY_CITY_ID = "key_city_id";
	public static final String KEY_PROVINCE_ID = "key_province_id";

	public static final String KEY_STR_LATLNG = "key_str_latlng";
	public static final String KEY_STR_ADDRESS = "key_str_address";

	public static final long TIME_SPAN_UP_LOC = 10 * 60 * 1000;// 10分钟
	// public static final long TIME_SPAN_UP_LOC = 20 * 1000;// FOR TEST
	public static final int DIS_SEARCH_DEFAULT = 2000;// 默认搜索距离

	// for http logic
	public static final int RET_SUCCESS = 0;
	public static final int NUM_ONE_PAGE_DEFAULT = 12;// 默认请求页项目数目
	public static final int NUM_ONE_PAGE_DEFAULT_MAX = 100;// 默认请求页项目数目,较大值

	// for date time
	public static final String DATE_FORMAT = "yyyy-MM-dd";

	// for sort rule choice
	public static final String SORT_FRIEND_DEFAULT = "0";
	public static final String SORT_FRIEND_BY_RANK = "1";
	public static final String SORT_FRIEND_BY_NAME = "2";

	// for list info
	public static final String DISTANCE_SEARCH_DEFAULT = "2000";
	// for list goods
	public static final String SORT_PRICE_TYPE_ASC_DEFAULT = "1";
	public static final String SORT_PRICE_TYPE_DESC = "0";

	// for order
	public static final int STATUS_NO_PAY = 0;
	public static final int STATUS_PART_PAY = 1;
	public static final int STATUS_FULL_PAY = 2;

	// for map
	public static final String DISTANCE_LOC_SEARCH_DEFAULT = "500";
	public static final long TIME_SPAN_LOC_SEARCH_DEFAULT = 3 * 60 * 1000;// 3分钟

	// loc for用户选择
	public static final String CITY_NAME_DEFAULT = "淮安";
	public static final String CITY_ID_DEFAULT = "18";
	public static final String PROVINCE_NAME_DEFAULT = "江苏";// 暂时无用
	// loc for LBS定位
	public static final String CITY_LOC_DEFAULT = "淮安";
	public static final String PROVINCE_LOC_DEFAULT = "江苏";
	public static final String LAT_DEFAULT = "33.584995";
	public static final String LNG_DEFAULT = "119.051048";

}
