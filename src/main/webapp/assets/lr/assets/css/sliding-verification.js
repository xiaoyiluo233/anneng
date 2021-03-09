(function(global, factory) {
	typeof exports === 'object' && typeof module !== 'undefined' ? module.exports = factory() :
		typeof define === 'function' && define.amd ? define(factory) :
		(global = global || self, global.SlidingVerification = factory());
}(this, (function() {
	'use strict';

//	function request(url) {
//		return fetch(url).then(function(response) {
//			return response.json();
//		});
//	}

	function createElement(tagName, className, options) {
		var elm = document.createElement(tagName);
		if(className) {
			elm.className = className;
		}
		if(options) {
			var keys = Object.keys(options);
			for(var i = 0; i < keys.length; i++) {
				var keyName = keys[i];
				elm[keyName] = options[keyName];
			}
		}
		return elm;
	}
	//# sourceMappingURL=util.js.map

	var refreshIcon = "\n  <svg viewBox=\"0 0 1024 1024\">\n    <path d=\"M871.808175 149.84203a510.825102 510.825102 0 1 0 136.220027 488.348798h-136.220027a383.459377 383.459377 0 1 1-360.983073-510.144002 378.010576 378.010576 0 0 1 272.440055 110.338222l-204.330041 204.330041H1021.650205V0z\" fill=\"#FFFFFF\" />\n  </svg>\n";
	var arrowIcon = "\n  <svg viewBox=\"0 0 1414 1024\" width=\"18\" height=\"13\">\n    <path d=\"M0 1024l384-512-384-512h326.4l384 512-384 512H0z\" />\n    <path d=\"M704 1024l384-512-384-512h326.4l384 512-384 512H704z\" />\n  </svg>\n";
	//# sourceMappingURL=icon.js.map

	var SlidingVerification = /** @class */ (function() {
		function SlidingVerification(id, options) {
			var _this = this;
			if(options === void 0) {
				options = {};
			}
			/**
			 * 是否可以滑动
			 */
			this.isMove = false;
			/**
			 * 滑块 x 轴距离
			 */
			this.offsetLeft = 0;
			/**
			 * 滑块宽度
			 */
			this.offsetWidth = 0;
			this.maxWidth = 0;
			this.getCheckNumber = function() {
				var block = _this.block;
				var bgImg = _this.imgBg;
				if(block && bgImg) {
					return block.offsetLeft / bgImg.offsetWidth;
				}
				return 0;
			};
			this.host = options.host;
			this.width = options.width || 300;
			this.height = options.height || 150;
			this.onVerification = options.onVerification || function() {};
			if(!id) {
				console.error('Error: id 参数是必传参数！');
				return;
			}
			this.warpper = document.getElementById(id);
			if(!this.warpper) {
				console.error('Error: id 参数是必传参数！');
				return;
			}
			if(!options.host) {
				console.error('Error: host 参数是必传参数！');
				return;
			}
			this.warpper.style.width = this.width + "px";
			this.warpper.style.height = this.height + "px";
			this.warpper.className = 'ane-verifica';
			this.createBgImage();
			this.getCuid();
		}
		SlidingVerification.prototype.createBgImage = function() {
			var _this = this;
			var imgBox = createElement('div', 'ane-verifica-images');
			this.warpper.appendChild(imgBox);
			this.refresh = createElement('div', 'ane-verifica-refresh');
			this.refresh.innerHTML = refreshIcon;
			this.refresh.onclick = function() {
				return _this.refreshHandle();
			};
			imgBox.appendChild(this.refresh);
			this.imgBlock = createElement('img', 'ane-verifica-block');
			imgBox.appendChild(this.imgBlock);
			this.imgBg = createElement('img', 'ane-verifica-bg');
			imgBox.appendChild(this.imgBg);
			this.mask = createElement('div', 'ane-verifica-mask');
			// mask.className = 'ane-verifica-mask ane-verifica-faild';
			imgBox.appendChild(this.mask);
			this.message = createElement('span');
			this.mask.appendChild(this.message);
			// 滑块按钮
			this.track = createElement('div', 'ane-verifica-bar');
			this.changeTrack('none');
			this.warpper.appendChild(this.track);
			this.msgTips = createElement('div', 'ane-verifica-bar-tips');
			this.track.appendChild(this.msgTips);
			this.statusBlock = createElement('div', 'ane-verifica-bar-status');
			this.track.appendChild(this.statusBlock);
			this.block = createElement('button', 'ane-verifica-bar-slider');
			this.block.innerHTML = arrowIcon;
			this.block.onmousedown = this.handleMouseDown.bind(this);
			this.track.appendChild(this.block);
		};
		SlidingVerification.prototype.removeEvent = function() {
			document.removeEventListener('mousemove', this.handleMouseMove, false);
			document.removeEventListener('mouseup', this.handleMouseUp, false);
		};
		SlidingVerification.prototype.handleMouseDown = function(e) {
			this.isMove = true;
			this.startX = e.clientX;
			this.offsetLeft = this.block.offsetLeft;
			this.offsetWidth = this.block.offsetWidth;
			this.maxWidth = this.track.offsetWidth - this.offsetWidth;
			document.addEventListener('mousemove', this.handleMouseMove.bind(this));
			document.addEventListener('mouseup', this.handleMouseUp.bind(this));
		};
		SlidingVerification.prototype.handleMouseMove = function(e) {
			if(!this.isMove || !this.block) {
				return;
			}
			var move = this.offsetLeft + (e.clientX - this.startX);
			if(move < 0) {
				move = 0;
			}
			if(move > this.maxWidth) {
				move = this.maxWidth;
			}
			var trackWidth = this.track.offsetWidth;
			var trackMove = move;
			var width = (trackMove + this.block.offsetWidth);
			if(width > trackWidth) {
				trackMove = trackWidth - this.block.offsetWidth;
			}
			this.imgBlock.style.left = trackMove + "px";
			this.block.style.left = move + "px";
			this.statusBlock.style.width = move + "px";
			this.statusBlock.style.backgroundColor = '#ffe2c1';
			this.changeTrack('moving');
		};
		SlidingVerification.prototype.handleMouseUp = function() {
			if(!this.isMove) {
				return;
			}
			this.isMove = false;
			this.offsetLeft = this.block.offsetLeft;
			this.changeTrack('verifying');
			this.removeEvent();
			this.verifcheck();
		};
		SlidingVerification.prototype.refreshHandle = function() {
			this.getCuid();
		};
		/**
		 * 重置滑动
		 */
		SlidingVerification.prototype.reset = function() {
			this.changeTrack('none');
			this.imgBlock.style.left = "0px";
			this.block.style.left = "0px";
			this.statusBlock.style.width = "0px";
			this.showtips('向右滑动滑块填充拼图!', 'none');
			this.onVerification(false);
		};
		SlidingVerification.prototype.changeTrack = function(type) {
			if(type) {
				this.track.className = "ane-verifica-bar ane-verifica-bar-" + type;
			}
		};
		SlidingVerification.prototype.showtips = function(message, type) {
			if(message) {
				this.msgTips.innerText = message;
				this.changeTrack(type);
			}
		};
		SlidingVerification.prototype.loading = function(spin) {
			if(this.refresh) {
				this.refresh.className = spin ? 'ane-verifica-refresh ane-verifica-spin' : 'ane-verifica-refresh';
			}
		};
		/**
		 * API 验证
		 */
		SlidingVerification.prototype.verifcheck = function() {
			var _this = this;
			$.ajax({
				type: "GET",
				url: this.host + "/verifcheck?id=" + this.uid + "&x=" + this.getCheckNumber() + "&_" + (new Date()).getTime(),
				success: function(result) {
					if(result.code !== 1) {
						_this.showtips('验证失败!', 'fail');
					} else if(result.data) {
						if(result.data.status) {
							_this.showtips('验证成功!', 'success');
							_this.onVerification(true);
						} else {
							_this.showtips('验证失败!', 'fail');
							_this.count = _this.count - 1;
							var count_1 = _this.count;
							if(_this.timer) {
								clearTimeout(_this.timer);
							}
							_this.timer = setTimeout(function() {
								count_1 < 1 ? _this.refreshHandle() : _this.reset();
							}, 1000);
						}
					}
				},
				error: function(error) {
					console.error('Error:', error.message || '');
				}
			});
		};
		/**
		 * 获取 cuid
		 */
		SlidingVerification.prototype.getCuid = function() {
			var _this = this;
			this.loading(true);
			this.sendMessage('正在加载中...', 'refresh');			
			$.ajax({
				type: "GET",
				url: this.host + "/cuid",
				success: function(data) {
					if(data.code === 1 && data && data.data && data.data.uid) {
						_this.uid = data.data.uid;
						_this.loginver();
					} else {
						_this.sendMessage(data.message || '获取 cuid 失败!');
					}
					_this.loading();
					_this.reset();
				},
				error: function(error) {
					console.error('Error:', error.message || '');
				}
			});
		};
		/**
		 * 验证 cuid 是否正确
		 */
		SlidingVerification.prototype.loginver = function() {
			var _this = this;			
			$.ajax({
				type: "GET",
				url: this.host + "/loginver?id=" + this.uid,
				success: function(data) {
					if(data.code !== 1) {
						_this.sendMessage(data.message || '验证 loginver 失败!');
					} else if(data.data && data.data.number) {
						_this.count = data.data.number;
						_this.showImages();
					}
				},
				error: function(error) {
					console.error('Error:', error.message || '');
				}
			});

		};
		/**
		 * 展示滑块以及滑块图片
		 */
		SlidingVerification.prototype.showImages = function() {
			var time = new Date().getTime();
			if(this.imgBg) {
				this.imgBg.src = this.host + "/getimage?id=" + this.uid + "&type=2&t=" + time;
			}
			if(this.imgBlock) {
				this.imgBlock.src = this.host + "/getimage?id=" + this.uid + "&type=1&t=" + time;
			}
			this.sendMessage('', 'refresh');
		};
		/**
		 * 显示错误信息
		 */
		SlidingVerification.prototype.sendMessage = function(msg, type) {
			if(msg === void 0) {
				msg = '';
			}
			if(this.message) {
				this.message.innerText = msg;
			}
			if(type === 'refresh' && this.mask) {
				this.mask.className = msg ? 'ane-verifica-mask ane-verifica-refreshing' : 'ane-verifica-mask';
			}
		};
		return SlidingVerification;
	}());

	return SlidingVerification;

})));