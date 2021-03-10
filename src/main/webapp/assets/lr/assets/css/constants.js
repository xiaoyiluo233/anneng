var GW_SERVER = '/gw/api';//官网服务地址
//测试
//var VALID_IMG_SERVER = 'http://122.144.220.210:50120/password/api';
//生产
var VALID_IMG_SERVER = 'http://103.6.223.125:8055/password/api';

var PROVINCE_API = '/chinaRegion/queryPro';
var CITY_API = '/chinaRegion/queryCity';
var DISTRICT_API = '/chinaRegion/queryDistrict';
var IMGCODE_API = '/valid/img';

var USER_API = {
    LOGIN_PWD: '/user/pwdlogin',
    LOGIN_SMS: '/user/smslogin',
    LOGIN_SMS_SENDSMS: '/user/smslogin/sendSms',
    REGISTER: '/user/register',
    REGISTER_SENDSMS: '/user/register/sendSms',
    FORGOTPWD: '/user/forgotPwd',
    FORGOTPWD_SENDSMS: '/user/forgotPwd/sendSms',
    PLENISHPWD: '/user/plenishPwd',
    INIT_USER_INFO: '/userInfo/initUserInfo',
    QUERY_SEND_ORDER: '/order/querySendOrderForMobile',
    QUERY_RECEIPT_ORDER: '/order/searchOrderByPhone',
    MODIFY_MEMBER: '/userInfo/modifyMember',
    USER_HEAD_IMG_UPLOAD: '/userInfo/userHeadImgUpload',
    CHECK_OLD_PWD: '/userInfo/checkOldPwd',
    MODIFY_PASSWORD: '/userInfo/modifyPassword',
    INIT_BANK_PAGE_SELECT: '/userInfo/initBankInfoPageSelect',
    INIT_BANK_BY_ID: '/userInfo/initBankInfoById',
    MODIFY_BANK_INFO: '/userInfo/modifyBankInfo',
    INIT_USER_BANK_INFO: '/userInfo/initUserBankInfo',
    STOP_USE_BANK_CARD: '/userInfo/stopUseBankCard',
    QUERY_SENDER_BY_ID: '/sendInfo/querySendInfoById',
    QUERY_COLLECTER_BY_ID: '/collectInfo/queryCollectInfoById',
    ADD_SENDER_INFO: '/sendInfo/addSendInfo',
    CHECK_SENDER_INFO: '/sendInfo/checkSendInfo',
    ADD_COLLECTER_INFO: '/collectInfo/addCollectInfo',
    CHECK_COLLECTER_INFO: '/collectInfo/checkCollectInfo',
    QUERY_SEND_LIST: '/sendInfo/querySendInfoList',
    QUERY_COLLECT_LIST: '/collectInfo/queryCollectInfoList',
    DEL_SEND_BY_ID: '/sendInfo/delSendInfoById',
    DEL_COLLECT_BY_ID: '/collectInfo/delCollectInfoById'

};

var DYNAMIC_API = {
    ANEDYNAMIC: '/dynamic/anedynamic/selectPage',
    ACTIVITY: '/dynamic/activity/selectPage',
    NOTICE: '/dynamic/notice/selectPage',
    MEDIA: '/dynamic/media/selectPage',
    SOCIAL: '/dynamic/social/selectPage'
};

var HELP_API = {
    NEW_CS: '/help/addComplaints',
    SELECT_CS: '/help/queryComplaintsByCondition'
};

var JOIN_API = {
    BIGCUSTOMER_ADD: '/join/bigcustomer/addBigcustomer',
    OVERVIEW_SELECT: '/join/case/selectPage',
    CUSTOMER_ADD: '/join/customer/addCustomer',
    OPENAREA_PROVINCE: '/join/openarea/getOpenareaProvince',
    OPENAREA_CITY: '/join/openarea/getOpenareaCity',
    OPENAREA_COUNTY: '/join/openarea/getOpenareaCounty',
    OPENAREA_SELECTLIST: '/join/openarea/selectList',
    OPENAREA_SELECTDATALIST: '/join/openarea/selectDataList',
    PROVINCEALLCOUNT_GET: '/join/openarea/queryProvinceAllCount',
    OVERVIEW_SELECTTEXT: '/join/overview/selectByMenuID'
};

var SELF_API = {
    SENDFLOW_GET: '/selfStandard/getSendFlow',
    STANDARD_QUERY: '/selfStandard/querySendStandard',
    FREIGHTTIMES_QUERY: '/freightTimes/queryFreightTimes',
    NETWORKCOUNT_QUERY: '/selfNetWork/queryNetWorkCount',
    NETWORKPRIOVINCE_GET: '/selfNetWork/getNetWorkProvince',
    NETWORKCITY_GET: '/selfNetWork/getNetWorkCity',
    DISTRICT_GET: '/selfNetWork/getNetWorkDistrict',
    PROVINCEALLCOUNT_GET: '/selfNetWork/queryProvinceAllCount',
    NETWORK_QUERYBYCONDITION: '/selfNetWork/selectPageByCondition',
    NETWORK_QUERYBYAREA: '/selfNetWork/selectNetWorkByArea',
    NETWORK_QUERYBYSITEID: '/selfNetWork/queryNetWorkBySiteId',
    ORDER_ADD: '/order/addOrder',
    ORDER_CHECK_GIS: '/order/checkGis',
    ORDERDETAILS_SELECT: '/order/selectOrderDetails',
    WAYBILL_SELECT: '/order/searchWayBillByNo',
    WAYBILLORDER_SELECTPAGE: '/order/selectWaybillOrderPage',
    PROMPT_QUERY: '/selfPrompt/queryEnablePrompt',
    ORDER_UPDATE: '/order/updateOrder',
    QUERY_ORDER_BY_ID: '/order/queryOrderById',
    SEARCH_ORDER_PHONEEND: '/order/checkOrderPhoneEnd',
    QUERY_REMINDER: '/order/queryReminder'
};

var CACHE_KEY = {
    USER_TOKEN: 'userToken',
    USER_OBJECT: 'user'
};

var USER_KEY = {
    USER_ID: 'userId',
    USER_PHONE: 'userPhone'
};
var MONITOR = {
    PC: '/aneMonitor/aneMonitorPC',
};


