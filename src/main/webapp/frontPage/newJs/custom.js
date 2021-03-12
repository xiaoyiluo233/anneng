(function($) {
	"use strict"; // Start of use strict

	// Preloader Start
	$(window).load(function() {
		$('.loader').fadeOut();
		$('#preloader')
			.delay(350)
			.slideUp('slow');
		$('body')
			.delay(350)
	});
	// Preloader End

	// Dropdown Menu Script Start

	$('#mainNav ul.navbar-nav li.dropdown').hover(function() {
		$(this).find('.dropdown-menu').stop(true, true).delay(200).fadeIn(500);
	}, function() {
		$(this).find('.dropdown-menu').stop(true, true).delay(200).fadeOut(500);
	});
	// Dropdown Menu Script End

	$(window).scroll(function() {
		var scroll = $(window).scrollTop();
		if(scroll >= 62) {
			$("#mainNav").addClass("new-menu");
		} else {
			$("#mainNav").removeClass("new-menu");
		}

	});

	// mobile Menu area
	$('nav.mobile_menu').meanmenu({
		meanScreenWidth: '991'
	});
	$('nav.mean-nav li > a:first-child').on('click', function() {
		$('a.meanmenu-reveal').click();
	});

	//--------- Initialize WOW JS
	new WOW().init();

	// --------Scroll To Top---------

	$(window).scroll(function() {
		if($(this).scrollTop() > 200) {
			$('#scroll').fadeIn();
		} else {
			$('#scroll').fadeOut();
		}
	});
	$('#scroll').click(function() {
		$("html, body").animate({
			scrollTop: 0
		}, 600);
		return false;
	});

	// ----------------- AOS Animation
	if($("[data-aos]").length) {
		AOS.init({
			duration: 1000,
			mirror: true,
		});
	}

	var $layer_2 = $(".layer-2"),
		$container = $("body"),
		container_w = $container.width(),
		container_h = $container.height();

	//------页码
	var methods = {
		pageInit: function(options) {
			/**
			 * [opts this plug propertys]
			 * @type {Obeject}
			 */
			var opts = $.extend({}, $.fn.zPager.defaults, options);
			return $(this).each(function(k, v) {
				var _v = $(v);
				_v.data("options", opts);
				methods.pageData(_v, opts.current);
			})
		},
		pageData: function(_v, _current) {
			var opts = _v.data("options");
			var t = opts.totalData,
				p = opts.pageData,
				ajaxOpts = null;
			if(opts.ajaxSetData && (typeof(opts.ajaxSetData) === 'boolean')) {
				if(opts.url !== '' && typeof(opts.url) === 'string') {
					ajaxOpts = methods.ajaxData(opts.url, _current);
					t = opts.totalData = ajaxOpts.total;
					// if(ajaxOpts.rows.length>0){
					var ishasDataRender = (opts.dataRender && typeof(opts.dataRender) === 'function');
					ishasDataRender ? opts.dataRender(ajaxOpts.rows) : methods.dataRender(_v, ajaxOpts.rows);
					// }
				} else {
					$.pageError(2);
				}
			}
			if(t % p === 0) {
				opts.pageCount = parseInt(t / p);
			} else {
				opts.pageCount = parseInt(t / p) + 1;
			}
			if(opts.pageCount > 0) {
				_v.data("options", opts);
				methods.pageRender(_v, _current);
			}
		},
		dataRender: function(_v, _data) {

			var opts = _v.data("options");
			var cells = '';
			for(var i = 0; i < _data.length; i++) {
				cells += '<div class="cc_cells"><a href=""><span>' + _data[i].id + '-' + Math.random() + '</span>';
				cells += '<span>' + _data[i].title + '</span>';
				cells += '<span>' + _data[i].starttime + '</span>';
				cells += '<span>' + _data[i].endtime + '</span>';
				cells += '</a></div>';
			}
			if(opts.htmlBox === '' || (typeof(opts.htmlBox) !== 'Obeject')) {
				var abx = _v.prev();
				if(!abx.hasClass('pagerHtmlWrap')) {
					var d = '<div class="pagerHtmlWrap"></div>';
					_v.before(d);
				}
				_v.prev().html(cells);
			} else {
				opts.htmlBox.html(cells);
			}
		},
		pageRender: function(_v, _current) {
			// 页码操作
			currentPage(_current);

			/**
			 * [o this plug propertys]
			 * @type {Obeject}
			 */
			var o = _v.data("options");
			var _page = o.pageCount;

			var _middle = parseInt(o.pageStep / 2);
			var _tep = _middle - 2;
			var _html = '';
			if(_page > o.pageStep && _current <= _page) {
				_html += methods.setPrevNext(o, 'prev');
				if(_current <= _middle) {
					_html += methods.forEach(1, o.pageStep, _current, o.active);
					_html += methods.elliPsis();
					_html += methods.forEach(_page * _tep, _page - (-1), _current, o.active);
				} else if(_current > _middle && _current < (_page - _tep)) {
					_html += methods.pageBtn(1);
					_html += methods.elliPsis();
					_html += methods.forEach(_current - _tep, _current - (-_tep) - (-1), _current, o.active);
					_html += methods.elliPsis();
					_html += methods.forEach(_page * _tep, _page - (-1), _current, o.active);
				} else if(_current >= (_page - _tep)) {
					_html += methods.pageBtn(1);
					_html += methods.elliPsis();
					_html += methods.forEach(_page - 2 * _tep - 1, _page - (-1), _current, o.active);
				}
				_html += methods.setPrevNext(o, 'next');
			} else if(_page <= o.pageStep) {
				if(_page > o.minPage) {
					_html += methods.setPrevNext(o, 'prev');
				}
				_html += methods.forEach(1, _page - (-1), _current, o.active);
				if(_page > o.minPage) {
					_html += methods.setPrevNext(o, 'next');
				}
			}
			_v.html(_html);
			methods.bindEvent(_v);
		},
		bindEvent: function(_v) {
			/**
			 * [o this plug propertys]
			 * @type {Obeject}
			 */
			var o = _v.data("options");
			var _a = _v.find("a");
			$.each(_a, function(index, item) {
				var _this = $(this);
				_this.on("click", function() {
					if(_this.attr("disabled")) {
						return false;
					}
					var _p = _this.attr("page-id");
					o.current = _p;
					_v.data("options", o);
					// methods.options.current = _p;
					methods.pageData(_v, _p);
				})
			})
		},
		forEach: function(_start, length, _current, curclass) {
			/**
			 * [s page elements]
			 * @type {String}
			 */
			var s = '';
			for(var i = _start; i < length; i++) {
				if(i === parseInt(_current)) {
					s += methods.pageCurrent(i, curclass);
				} else {
					s += methods.pageBtn(i);
				}
			}
			return s;
		},
		pageCurrent: function(_id, _class) {
			/**
			 * [class current page element calss]
			 * @type {String}
			 */
			return '<span class="' + _class + '" page-id="' + _id + '">' + _id + '</span>';
		},
		elliPsis: function() {
			/**
			 * [class ellipses...]
			 * @type {String}
			 */
			return '<span class="els">...</span>';
		},
		pageBtn: function(_id) {
			/**
			 * [id page id]
			 * @type {String}
			 */
			return '<a page-id="' + _id + '">' + _id + '</a>';
		},
		addBtn: function(_property, _page, _count) {
			/**
			 * [disabled is it can click button]
			 * @type {Boolean}
			 */
			var disabled = '';
			if(_count) {
				disabled = (_page === 0 || _page === _count - (-1)) ? 'disabled="true"' : '';
			}
			return '<a class="' + _property + '" page-id="' + _page + '" ' + disabled + '></a>';
		},
		setPrevNext: function(_o, _type) {
			/**
			 * [s string create prev or next buttons elements]
			 * @type {String}
			 */
			var s = '';

			function prev() {
				if(_o.btnShow) {
					s += methods.addBtn(_o.firstBtn, 1);
				}
				if(_o.btnBool) {
					s += methods.addBtn(_o.prevBtn, _o.current - 1, _o.pageCount);
				}
				return s;
			}

			function next() {
				if(_o.btnBool) {
					s += methods.addBtn(_o.nextBtn, _o.current - (-1), _o.pageCount);
				}
				if(_o.btnShow) {
					s += methods.addBtn(_o.lastBtn, _o.pageCount);
				}
				return s;
			}
			return _type === 'prev' ? prev() : next();
		},
		ajaxData: function(_url, _current) {
			/**
			 * [ajax get data and pagenumber]
			 * @param  {Object} ){ var parms [ajax url,current page number]
			 * @return {[type]}            [obj total rows]
			 */

			var _total = $.fn.zPager.defaults.totalData;
			var _pageSize = $.fn.zPager.defaults.pageData;
			var _params = $.fn.zPager.defaults.params;
			var isToken = $.fn.zPager.defaults.isToken;
			return(function() {
				var parms = {
					'total': _total,
					'rows': []
				};
				var param = {
					"page": _current,
					"rows": _pageSize
				};
				if(_params) {
					if(typeof Object.assign != 'function') {
						Object.assign = function(target) {
							'use strict';
							if(target == null) {
								throw new TypeError('Cannot convert undefined or null to object');
							}

							target = Object(target);
							for(var index = 1; index < arguments.length; index++) {
								var source = arguments[index];
								if(source != null) {
									for(var key in source) {
										if(Object.prototype.hasOwnProperty.call(source, key)) {
											target[key] = source[key];
										}
									}
								}
							}
							return target;
						};
					}
					param = Object.assign({}, _params, param);
				}
				$('.loader').show();
				$('#preloader').show();
				$.ajax({
					url: _url,
					type: 'get',
					data: param,
					dataType: 'json',
					cache: false,
					async: false,
					success: function(data) {
						if(data.total && (data.total !== 0)) {
							parms['total'] = data.total;
							parms['rows'] = data.rows;
							$.fn.zPager.defaults.total = data.total;
						} else {
							if(data.errorCode == 401) {
								swal({
									title: "登陆状态异常",
									text: "请重新登陆！",
									type: "error"
								}, function(isConfirm) {
									if(isConfirm) {
										localStorage.clear();
										window.location.href = '/login.html';
									}
								});
							}
							$.pageError(3);
						}
						$('.loader').delay(350).fadeOut(0);
						$('#preloader')
							.delay(550)
							.slideUp(0);
					},
					beforeSend: function(XMLHttpRequest) {
						if(isToken) {
							XMLHttpRequest.setRequestHeader(CACHE_KEY.USER_TOKEN, getLocalStorage(CACHE_KEY.USER_TOKEN));
						}
					},
					error: function(XMLHttpRequest, textStatus, errorThrown) {
						swal({
							title: "系统异常",
							text: "请联系官方客服！",
							type: "error"
						});
						var msg = '';
						switch(XMLHttpRequest.readyState) {
							case 0:
								msg = '（未初始化）还没有调用send()方法';
								break;
							case 1:
								msg = '（载入）已调用send()方法，正在发送请求';
								break;
							case 2:
								msg = '（载入完成）send()方法执行完成，已经接收到全部响应内容';
								break;
							case 3:
								msg = '（交互）正在解析响应内容';
								break;
							case 4:
								msg = '（完成）响应内容解析完成，可以在客户端调用了';
								break;
						}
						console.log(textStatus + '：' + XMLHttpRequest.readyState + '-' + msg);
						$('.loader').hide(350);
						$('#preloader').hide(350);
					}
				})
				return parms;
			})();
		}
	}

	$.extend({
		pageError: function(type) {
			/**
			 * [switch error type]
			 * @param  {[type]} type [no this function]
			 * @return {[type]}      [ajax error]
			 */
			switch(type) {
				case 1:
					//console.log('method'+method+'dose not exist on jQuery.zPager');
					break;
				case 2:
					//console.log('no ajax');
					break;
				case 3:
					//console.log('no data');
					break;
				default:
					//console.log('default error');
			}
		}
	})

	$.fn.extend({
		zPager: function(method) {
			/**
			 * [if has this method]
			 * @param  {[type]} methods[method] [apply this method]
			 * @return {[type]}                 [return property]
			 */
			if(methods[method]) {
				return methods[method].apply(this, Array.prototype.slice.call(arguments, 1));
			} else if(typeof method === 'object' || !method) {
				return methods.pageInit.apply(this, arguments);
			} else {
				$.pageError(1);
			}
		}
	})

	$.fn.zPager.defaults = {
		totalData: 10, //数据总条数
		pageData: 5, //每页数据条数
		pageCount: 0, //总页数
		current: 1, //当前页码数
		pageStep: 8, //当前可见最多页码个数
		minPage: 5, //最小页码数，页码小于此数值则不显示上下分页按钮
		active: 'current', //当前页码样式
		prevBtn: 'pg-prev', //上一页按钮
		nextBtn: 'pg-next', //下一页按钮
		btnBool: true, //是否显示上一页下一页
		firstBtn: 'pg-first', //第一页按钮
		lastBtn: 'pg-last', //最后一页按钮
		btnShow: true, //是否显示第一页和最后一页按钮
		params: {},
		disabled: true, //按钮失效样式
		ajaxSetData: true, //是否使用ajax获取数据 此属性为真时需要url和htmlBox不为空
		url: '', //ajax路由
		htmlBox: '', //ajax数据写入容器
		isToken: false,
		total: 0
	}
	//判断是否是ie且给出ie版本号
	function IEVersion() {
		var userAgent = navigator.userAgent; //取得浏览器的userAgent字符串
		var isIE = userAgent.indexOf("compatible") > -1 && userAgent.indexOf("MSIE") > -1; //判断是否IE<11浏览器
		var isEdge = userAgent.indexOf("Edge") > -1 && !isIE; //判断是否IE的Edge浏览器
		var isIE11 = userAgent.indexOf('Trident') > -1 && userAgent.indexOf("rv:11.0") > -1;
		if(isIE) {
			var reIE = new RegExp("MSIE (\\d+\\.\\d+);");
			reIE.test(userAgent);
			var fIEVersion = parseFloat(RegExp["$1"]);
			if(fIEVersion == 7) {
				return 7;
			} else if(fIEVersion == 8) {
				return 8;
			} else if(fIEVersion == 9) {
				return 9;
			} else if(fIEVersion == 10) {
				return 10;
			} else {
				return 6; //IE版本<=7
			}
		} else if(isEdge) {
			return 'edge'; //edge
		} else if(isIE11) {
			return 11; //IE11
		} else {
			return -1; //不是ie浏览器
		}

	}
	var isIE = IEVersion();
	
	if(isIE == "6" || isIE == "7" || isIE == "8" || isIE == "9") {
		 var newUrl = location.protocol + '//' + location.host + '/browser.html';
     
		window.location =newUrl;
	}

})(jQuery); // End of use strict