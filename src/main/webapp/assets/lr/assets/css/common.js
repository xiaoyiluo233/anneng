document.write("<script language=javascript src='/assets/js/sweetalert.min.js'></script>");
String.prototype.replaceAll = function(s1, s2) {
    return this.replace(new RegExp(s1, "gm"), s2);
};
var VALID = {
    PHONE: function (input) {
        return /^1[23456789]\d{9}$/.test(input);
    },
    TELPHONE: function (input) {
        return /^([0-9]{3,4}-)[0-9]{7,8}$/.test(input);
    },
    IS_EMPTY: function (input) {
        if (typeof input == "undefined" || input == null || input == "" || input == "undefined") {
            return true;
        } else {
            return false;
        }
    },
    NAME: function (input) {
        return /^[\u4E00-\u9FA5A-Za-z]{2,20}$/.test(input);
        //return /^[\u4E00-\u9FA5\uf900-\ufa2d·s]{2,20}$/.test(input);
    },
    BANKNO: function (input) {
        return /^[0-9]{12,25}$/.test(input);
        //return /^([1-9]{1})(\d{15}|\d{18})$/.test(input);
    },
    DATE_SHORT:function(input){
        return /^(\d{4})-(\d{2})-(\d{2})$/.test(input);
    },
    WAYBILLNUMBER: function (input) {
        return /^(([1-9]{1}|[hH][dD])([0-9]{11}|[0-9]{7}|[0-9]{13}|[0-9]{19}),{0,1}){1,10}$/.test(input);
    },
    //正整数
    INTEGER:function (input) {
        return /^[0-9]*[1-9][0-9]*$/.test(input);
    }
};

var STRHANDLE = {
    TRIM: function (str, is_global) {
        var result;
        result = str.replace(/(^\s+)|(\s+$)/g, "");
        if (is_global.toLowerCase() == "g") {
            result = result.replace(/\s/g, "");
        }
        return result;
    },
    CHANGEDOUHAO: function (str) {
        str = str.replace(/，/ig, ',');
        return str;
    },
    GETSPLITSTRING: function (str) {
        var arr = str.split(",");
        var resources = "";
        for (var i = 0; i < arr.length; i++) {
            var arr1 = arr[i].split(/\s+/);

            for (var j = 0; j < arr1.length; j++) {
                if (jQuery.trim(arr1[j]) != "") {
                    resources += jQuery.trim(arr1[j]) + ",";
                }
            }
        }
        resources = resources.substring(0, (resources.length - 1));
        return resources;
    },
    STRSPLICING: function (_str, _data) {
        if (_str == "") {
            _str = _data;
        } else {
            _str += "," + _data;
        }
        return _str;
    }
};

function clearErr() {
    $('#errMsg').html('');
}

//获取url后缀参数
function getUrlParam(name) {
    var reg = new RegExp("(^|&)" + name + "=([^&]*)(&|$)");
    var r = window.location.search.substr(1).match(reg);
    if (r != null) return decodeURIComponent(r[2]);
    return null;
}

//获取url后缀参数
function getQueryVariable(variable)
{
    var query = window.location.search.substring(1);
    var vars = query.split("&");
    for (var i=0;i<vars.length;i++) {
        var pair = vars[i].split("=");
        if(pair[0] == variable){return pair[1];}
    }
    return(false);
}

//设置缓存
function setLocalStorage(key, value) {
    var curtime = new Date().getTime(); // 获取当前时间 ，转换成JSON字符串序列
    var valueDate = JSON.stringify({
        val: value,
        timer: curtime
    });
    try {
        localStorage.setItem(key, valueDate);
    } catch (e) {
        // 兼容性写法
        if (isQuotaExceeded(e)) {
            console.log("Error: 本地存储超过限制");
            localStorage.clear();
        } else {
            console.log("Error: 保存到本地存储失败");
        }
    }
}

//判断是否超出缓存大小限制
function isQuotaExceeded(e) {
    var quotaExceeded = false;
    if (e) {
        if (e.code) {
            switch (e.code) {
                case 22:
                    quotaExceeded = true;
                    break;
                case 1014: // Firefox
                    if (e.name === 'NS_ERROR_DOM_QUOTA_REACHED') {
                        quotaExceeded = true;
                    }
                    break;
            }
        } else if (e.number === -2147024882) { // IE8
            quotaExceeded = true;
        }
    }
    return quotaExceeded;
}

//获得缓存数据
function getLocalStorage(key) {
    var exp = 60 * 60 * 0.5 * 1000; // 0.5Hours
    var vals = localStorage.getItem(key); // 获取本地存储的值
    if (vals) {
        var dataObj = JSON.parse(vals); // 将字符串转换成JSON对象
        var isTimed = (new Date().getTime() - dataObj.timer) > exp;
        if (isTimed) {
            console.log("存储已过期");
            localStorage.clear();
            return null;
        } else {
            var newValue = dataObj.val;
        }
        return newValue;
    } else {
        return null;
    }
}

//base64加密解密封装
function Base64() {
    _keyStr = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789+/=";
    this.encode = function (input) {
        var output = "";
        var chr1, chr2, chr3, enc1, enc2, enc3, enc4;
        var i = 0;
        input = _utf8_encode(input);
        while (i < input.length) {
            chr1 = input.charCodeAt(i++);
            chr2 = input.charCodeAt(i++);
            chr3 = input.charCodeAt(i++);
            enc1 = chr1 >> 2;
            enc2 = ((chr1 & 3) << 4) | (chr2 >> 4);
            enc3 = ((chr2 & 15) << 2) | (chr3 >> 6);
            enc4 = chr3 & 63;
            if (isNaN(chr2)) {
                enc3 = enc4 = 64;
            } else if (isNaN(chr3)) {
                enc4 = 64;
            }
            output = output +
                _keyStr.charAt(enc1) + _keyStr.charAt(enc2) +
                _keyStr.charAt(enc3) + _keyStr.charAt(enc4);
        }
        return output;
    }

    // public method for decoding
    this.decode = function (input) {
        var output = "";
        var chr1, chr2, chr3;
        var enc1, enc2, enc3, enc4;
        var i = 0;
        input = input.replace(/[^A-Za-z0-9\+\/\=]/g, "");
        while (i < input.length) {
            enc1 = _keyStr.indexOf(input.charAt(i++));
            enc2 = _keyStr.indexOf(input.charAt(i++));
            enc3 = _keyStr.indexOf(input.charAt(i++));
            enc4 = _keyStr.indexOf(input.charAt(i++));
            chr1 = (enc1 << 2) | (enc2 >> 4);
            chr2 = ((enc2 & 15) << 4) | (enc3 >> 2);
            chr3 = ((enc3 & 3) << 6) | enc4;
            output = output + String.fromCharCode(chr1);
            if (enc3 != 64) {
                output = output + String.fromCharCode(chr2);
            }
            if (enc4 != 64) {
                output = output + String.fromCharCode(chr3);
            }
        }
        output = _utf8_decode(output);
        return output;
    };

    _utf8_encode = function (string) {
        string = string.replace(/\r\n/g, "\n");
        var utftext = "";
        for (var n = 0; n < string.length; n++) {
            var c = string.charCodeAt(n);
            if (c < 128) {
                utftext += String.fromCharCode(c);
            } else if ((c > 127) && (c < 2048)) {
                utftext += String.fromCharCode((c >> 6) | 192);
                utftext += String.fromCharCode((c & 63) | 128);
            } else {
                utftext += String.fromCharCode((c >> 12) | 224);
                utftext += String.fromCharCode(((c >> 6) & 63) | 128);
                utftext += String.fromCharCode((c & 63) | 128);
            }

        }
        return utftext;
    };

    _utf8_decode = function (utftext) {
        var string = "";
        var i = 0;
        var c = c1 = c2 = 0;
        while (i < utftext.length) {
            c = utftext.charCodeAt(i);
            if (c < 128) {
                string += String.fromCharCode(c);
                i++;
            } else if ((c > 191) && (c < 224)) {
                c2 = utftext.charCodeAt(i + 1);
                string += String.fromCharCode(((c & 31) << 6) | (c2 & 63));
                i += 2;
            } else {
                c2 = utftext.charCodeAt(i + 1);
                c3 = utftext.charCodeAt(i + 2);
                string += String.fromCharCode(((c & 15) << 12) | ((c2 & 63) << 6) | (c3 & 63));
                i += 3;
            }
        }
        return string;
    }
}

var CACHE_KEY = {
    USER_TOKEN: 'userToken',
    SEND_USER: 'sendUser',
    SEND_SSQX: 'sendSsqx',
    SEND_PHONE: 'sendPhone',
    SEND_ADDRESS: 'sendAddress',
    ARRIVE_USER: 'arriveUser',
    ARRIVE_SSQX: 'arriveSsqx',
    ARRIVE_PHONE: 'arrivePhone',
    ARRIVE_ADDRESS: 'arriveAddress',
    ORDER_INFO: 'orderInfo',
    ORDER_NETWORK: 'orderNetwork',
    TIMESTAMP: 'timestamp',
    WAYBILL_HUAKUAI:'waybillHuakuai'
};

/**
 * @param {string} funcName 回调函数名称，如果为空不需要回调
 * @param {string} server constants中的server
 * @param {string} api constants中的api
 * @param {Object} params 请求参数
 * @param {boolean} isToken 请求是否需要token
 * @param {boolean} isAsync 是否异步
 * @param {boolean} isLoading 是否需要loading效果
 */
function gw_ajax(funcName, server, api, params, isToken, isAsync, isLoading) {
    if (isLoading) {
        //加载loading
        $('.loader').show();
        $('#preloader').show();
    }
    var userToken;
    if (isToken) {
        userToken = getLocalStorage(CACHE_KEY.USER_TOKEN);
        if (VALID.IS_EMPTY(userToken)) {
            localStorage.clear();
            window.location.href = '/login.html';
            return;
        }
    }
    var result;
    $.ajax({
        type: "POST",
        async: isAsync,
        contentType: "application/x-www-form-urlencoded;charset=UTF-8",
        url: server + api,
        dataType: "json",
        data: params,
        beforeSend: function (XMLHttpRequest) {
            if (isToken) {
                XMLHttpRequest.setRequestHeader(CACHE_KEY.USER_TOKEN, userToken);
            }
        },
        error: function (e) {
            $('.loader').hide(350);
            $('#preloader').hide(350);
            console.log("请求异常：" + e.status, e.responseText);
            swal({
                title: "系统异常",
                text: "请联系官方客服！",
                type: "error"
            });
            if (!isAsync) {
                result = {success: false};
            }
        },
        success: function (data) {
            result = data;
            if (data.errorCode == 401) {
                //鉴权失败
                swal({
                    title: "登陆状态异常",
                    text: "请重新登陆！",
                    type: "error"
                }, function (isConfirm) {
                    if (isConfirm) {
                        localStorage.clear();
                        window.location.href = '/login.html';
                        return;
                    }
                });
                return;
            } else {
                if (funcName) {
                    eval(funcName + "(" + JSON.stringify(data) + ");");
                }
            }
            if (isLoading) {
                //关闭loading
                $('.loader').delay(350).fadeOut(0);
                $('#preloader')
                    .delay(550)
                    .slideUp(0);
            }
        }
    });
    if (!isAsync) {
        return result;
    }
}
function initUserHeadImg() {
    gw_ajax('initUserHeadImg_fc',GW_SERVER,USER_API.INIT_USER_INFO,"",true,true,true);
}
function initUserHeadImg_fc(result) {
    if(result.success){
        var data = result.data;
        $(".userName").html(data.name);
        if(!VALID.IS_EMPTY(data.headImgUrl)){
            $("[name='headImg']").attr("src",data.headImgUrl);
        }else{
            $("[name='headImg']").attr("src","assets/img/pho.jpg");
        }

    }
}
function exitLogin() {
    swal({
            title: "确定退出登录？",
            type: "warning",
            showCancelButton: true,
            confirmButtonClass: "btn-warning",
            confirmButtonText: "确认",
            cancelButtonText: "取消",
            closeOnConfirm: true,
            showLoaderOnConfirm: true
        },
        function () {
            localStorage.clear();
            window.location.href="login.html";
        });
}

function gw_upload_ajax(funcName, server, api, data, isToken, isAsync, isLoading) {
    if (isLoading) {
        //加载loading
        $('.loader').show();
        $('#preloader').show();
    }

    var userToken;
    if (isToken) {
        userToken = getLocalStorage(CACHE_KEY.USER_TOKEN);
        if (VALID.IS_EMPTY(userToken)) {
            localStorage.clear();
            window.location.href = '/login.html';
        }
    }
    var result;
    $.ajax({
        type: "POST",
        async: isAsync,
        url: server + api,
        dataType: "json",
        data: data,
        contentType: false,
        processData: false,
        beforeSend: function (XMLHttpRequest) {
            if (isToken) {
                XMLHttpRequest.setRequestHeader(CACHE_KEY.USER_TOKEN, userToken);
            }
        },
        error: function (e) {
            $('.loader').hide(350);
            $('#preloader').hide(350);
            console.log("请求异常：" + e.status, e.responseText);
            swal({
                title: "系统异常",
                text: "请联系官方客服！",
                type: "error"
            });
            if (!isAsync) {
                result = {success: false};
            }
        },
        success: function (data) {
            result = data;
            if (data.errorCode == 401) {
                //鉴权失败
                swal({
                    title: "登陆状态异常",
                    text: "请重新登陆！",
                    type: "error"
                }, function (isConfirm) {
                    if (isConfirm) {
                        localStorage.clear();
                        window.location.href = '/login.html';
                    }
                });
            } else {
                if (funcName) {
                    eval(funcName + "(" + JSON.stringify(data) + ");");
                }
            }
            if (isLoading) {
                //关闭loading
                $('.loader').delay(350).fadeOut(0);
                $('#preloader')
                    .delay(550)
                    .slideUp(0);
            }
        }
    });
    if (!isAsync) {
        return result;
    }

}
function dateFormat(fmt, date) {
    var ret;
    var opt = {
        "y+": date.getFullYear().toString(),        // 年
        "M+": (date.getMonth() + 1).toString(),     // 月
        "d+": date.getDate().toString(),            // 日
        "h+": date.getHours().toString(),           // 时
        "m+": date.getMinutes().toString(),         // 分
        "s+": date.getSeconds().toString()          // 秒
        // 有其他格式化字符需求可以继续添加，必须转化成字符串
    };
    for (var k in opt) {
        ret = new RegExp("(" + k + ")").exec(fmt);
        if (ret) {
            fmt = fmt.replace(ret[1], (ret[1].length == 1) ? (opt[k]) : (opt[k].padStart(ret[1].length, "0")))
        }
    }
    return fmt;
}

/*input只可输入数字且保留且保留两位小数*/
function clearNoNum(obj){
    obj.value = obj.value.replace(/[^\d.]/g,"");  //清除“数字”和“.”以外的字符
    obj.value = obj.value.replace(/\.{2,}/g,"."); //只保留第一个. 清除多余的
    obj.value = obj.value.replace(".","$#$").replace(/\./g,"").replace("$#$",".");
    obj.value = obj.value.replace(/^(\-)*(\d+)\.(\d\d).*$/,'$1$2.$3');//只能输入两个小数(.(\d\d)种有几个\d就代表只能几位小数)
    if(obj.value.indexOf(".")< 0 && obj.value !=""){//以上已经过滤，此处控制的是如果没有小数点，首位不能为类似于 01、02的金额
        obj.value= parseFloat(obj.value);
    }
}

//1代表本窗口打开，2代表新窗口打开
function toPageMenuName(_url, _type, _menuName, type2) {
    $.ajax({
        url:GW_SERVER+MONITOR.PC,
        type:'post',
        data:{
            'menuName':_menuName,
            'type': type2
        },
        error:function(){
            console.log('调用用户行为接口异常');
            if (_type == 1) {
                window.location.href = _url;
            } else if (_type == 2) {
                window.open(_url);
            }
            return;
        },
        success:function(){
            if (_type == 1) {
                window.location.href = _url;
            } else if (_type == 2) {
                window.open(_url);
            }
            return;
        }
    });

}

function toPageMenuId(_url, _type, _menuId, type2) {
    $.ajax({
        url:GW_SERVER+MONITOR.PC,
        type:'post',
        data:{
            'menuId':_menuId,
            'type': type2
        },
        error:function(){
            console.log('调用用户行为接口异常');
            if (_type == 1) {
                window.location.href = _url;
            } else if (_type == 2) {
                window.open(_url);
            }
            return;
        },
        success:function(){
            if (_type == 1) {
                window.location.href = _url;
            } else if (_type == 2) {
                window.open(_url);
            }
            return;
        }
    });

}

function toPageMenuNameone(_url, _type, _menuName, type2) {
    $.ajax({
        url:GW_SERVER+MONITOR.PC,
        type:'post',
        data:{
            'menuName':_menuName,
            'type': type2
        },
        error:function(){
            console.log('调用用户行为接口异常');
            return;
        },
        success:function(){
            return;
        }
    });

}
