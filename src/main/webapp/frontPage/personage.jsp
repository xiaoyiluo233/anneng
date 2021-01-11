<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
	<head>
		<meta charset="utf-8" />
		<title>安能无限可能</title>
		<link rel="icon" href="../img/luoxiaoimg/favicon.png" type="image/png" sizes="16*16" />
		<link rel="stylesheet" type="text/css" href="../css/luoxiao/default/easyui.css" />
		<link rel="stylesheet" href="../css/luoxiao/luoxcss/luox.css" />
		<link rel="stylesheet" type="text/css" href="../css/luoxiao/default/icon.css" />
		<link rel="stylesheet" type="text/css" href="../ui/easyui/themes/default/easyui.css">
		<link rel="stylesheet" type="text/css" href="../ui/easyui/themes/icon.css">
		<link href="http://cdn.bootcss.com/bootstrap/3.3.6/css/bootstrap.css" rel="stylesheet" type="text/css" />
		<link href="../css/luoxiao/city-picker.css" rel="stylesheet" type="text/css" />
	</head>
	<style>
		
	</style>
	<script type="text/javascript" src="../js/luoxiaojs/luoxjs/jquery-3.4.1.min.js"></script>
	<script type="text/javascript" src="../js/luoxiaojs/luoxjs/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="../ui/easyui/jquery-1.7.2.min.js"></script>
	<script type="text/javascript" src="../ui/easyui/jquery.easyui.min.js"></script>
	<script src="../js/luoxiaojs/luoxjs/jquery.js"></script>
	<script src="../js/luoxiaojs/luoxjs/bootstrap.js"></script>
	<script src="../js/luoxiaojs/luoxjs/city-picker.data.js"></script>
	<script src="../js/luoxiaojs/luoxjs/city-picker.js"></script>
	<script src="../js/luoxiaojs/luoxjs/main.js"></script>
	
	<body style="background-color: #dfe0e1;">
		<div id="backcolor"></div>
		<div id="black"></div>
		<center>
			<!--
				右上角头像g
			-->
			<div id="head">
				<img id="log" src="../img/luoxiaoimg/luoxImg/logowhite.png" />
				<div id="hean-message">
					<h5>本间芽衣子 </h5>
					<img src="../img/luoxiaoimg/luoxImg/huhu.gif">
				</div>
			</div>
			<!--
				中间一块整体
			-->
			<div id="center">
				<div id="function">
					<div id="head_portrait">
						<img id="touxk" src="../img/luoxiaoimg/luoxImg/imgBg.png" />
						<img id="head_portraits" src="../img/luoxiaoimg/luoxImg/huhu.gif" />
						<h2>本间芽衣子</h2>
					</div>
					<div id="icon">
						<a class="branch">
							<img src="../img/luoxiaoimg/luoxImg/chachao.png" />
							<h5>我要查件</h5>
						</a>
						<a class="branch">
							<img src="../img/luoxiaoimg/luoxImg/xiangzi.png" />
							<h5>我要寄件 </h5>
						</a>
						<a id="myjijian" class="branch">
							<img src="../img/luoxiaoimg/luoxImg/jijian.png" />
							<h5>我的寄件 </h5>
						</a>
						<a class="branch">
							<img src="../img/luoxiaoimg/luoxImg/shoujian.png" />
							<h5>我的收件 </h5>
						</a>
						<a class="branch">
							<img src="../img/luoxiaoimg/luoxImg/dizhi.png" />
							<h5>地址薄 </h5>
						</a>
						<a id="myziliao" class="branch">
							<img src="../img/luoxiaoimg/luoxImg/touxiang.png" />
							<h5>我的资料 </h5>
						</a>
						<a class="branch">
							<img src="../img/luoxiaoimg/luoxImg/yinghangka.png" />
							<h5>我的银行卡 </h5>
						</a>
						<a class="branch">
							<img src="../img/luoxiaoimg/luoxImg/mima.png" />
							<h5>修改密码 </h5>
						</a>
					</div>
				</div>
				<!--
					我的寄件	
				-->
				<div  id="kong">
					<span style="font-size: 12px;float: left;margin: 20px;color: #666666;">单号/姓名/地址/关键字</span>
					<span style="font-size: 12px;float: left;margin-top: 20px; margin-left:90px;color: #666666;"> 时间范围</span>
					<div style="float: left; width: 540px;height:56px;"></div>
					<input type="text" style="border: none;width: 200px; height: 50px;float: left; margin-left: -140px; font-size: 16px;
					color: #666666; " value="请输入" />
					<input type="date" value="请选择开始时间" style="border: none;float: left;width: 200px; height: 50px;margin-left: 10px;">
					<input type="date" value="请选择开始时间" style="border: none;float: left;width: 200px; height: 50px;margin-left: 10px;">
					<input type="button" value="查询" style="border: none; color: white; width:125px ; height:50px ;float: left;margin-left: 10px;background-color: #f18700;"/>
					
					<div id="dingdan" style="background-color: #ffffff; width: 800px; height: 160px; margin: 20px;">
					<div style="width: 760px; height: 40px; margin: 20px; border: solid 1px #cccccc;border-top: none; border-left: none; border-right: none;">
						<img src="../img/luoxiaoimg/luoxImg/dingdan.png" style="width: 20px;height: 20px;float: left;" />
						<span style="float: left;"> 订单号: </span>
						</div>
						<div style=" float: left;margin-left: 20px;">
							<img src="../img/luoxiaoimg/luoxImg/ji.png" />
							<span style="font-size: 20px;font-weight: bold;"> 长沙市 刘佳佳</span>
							<br />
							<span >下单时间</span>
						</div>
						<div style=" float: left;margin-left: 250px;">
							<img src="../img/luoxiaoimg/luoxImg/pai.png"/>
							<span style="font-size: 20px;font-weight: bold;"> 长沙市 李湘</span>
							 	
						</div>
						<div style=" float: left;margin: 20px;">
							<span style="color: #f18700;">订单状态：已撤销</span>							 	
						</div>
					</div>
					
					
					
				</div>
				<!--
					我的资料	
				-->
				<div id="message" style="display: none;">
					<div id="userimg">
						<img src="../img/luoxiaoimg/luoxImg/huhu.gif" />
						<div id="data">
							<span style="margin-left: -170px;">会员账号:</span>
							<h3>17773792708 </h3>
							<span class="tishi">用户登录和验证身份，同时也是您个人信息的一部分</span>
						</div>
						<button id="updatemessage"> 修改头像 <button>
					</div>
					<div class="update">
						<img src="../img/luoxiaoimg/luoxImg/user-1.jpg" />
						<h3>姓名 <br/><span class="name">罗啸</span></h3>
						<button  id="name"  class="updatemessages">修改</button>
					</div>
					<div class="update">
						<img src="../img/luoxiaoimg/luoxImg/user-2.jpg" />
						<h3>企业名称  <br/><span class="name1">呱呱集团</span></h3>
						<button id="qiyename" class="updatemessages"> 修改 </button>
					</div>
					<div class="update">
						<img src="../img/luoxiaoimg/luoxImg/user-3.jpg" />
						<h3>性别  <br/><span class="name2">女</span></h3>
						<button id="xingbieanniu" class="updatemessages"> 更换   </button>
					</div>
					<div class="update">
						<img src="../img/luoxiaoimg/luoxImg/user-4.jpg" />
						<h3>生日  <br/><span class="name3"></span></h3>
						<button id="bosdata" class="updatemessages">重新定义</button>
					</div>
					<div class="update">
						<img src="../img/luoxiaoimg/luoxImg/user-5.jpg" />
						<h3>电话 <br/><span>17773792708</span> </h3>

					</div>
					<div class="update">
						<img src="../img/luoxiaoimg/luoxImg/user-6.jpg" />
						<h3>详细地址  <br/><span class="name4">湖南长沙香樟路110号</span></h3>
						<button id="dizhianniu" class="updatemessages"> 修改 </button>
					</div>
				</div>
				
				<span class="tail1">Copyright © 2015-2025 上海安能聚创供应链管理有限公司. All rights reserved. 沪ICP备16019765号-3</span>

				<img style="margin-right: 70px;" src="../img/luoxiaoimg/luoxImg/foot-01.png" />

				<span class="tail2"><img src="../img/luoxiaoimg/luoxImg/foot-02.png"/>沪公网安备 31011802001067号</span>
				<span class="tail3"><img src="../img/luoxiaoimg/luoxImg/foot-03.png"/ >上海工商</span>

			</div>
		</center>
		<!--修改姓名-->
		<div id="namewin" style="width: 500px; height: 236px; position:fixed; top: 360px;left: 650px; display:none;">
			<div style="height: 55px;background-color: white; margin-top: 2px;">
				<center></center>
				<h4 style="float: left;margin-left: 215px; margin-top: 16px; color: #f5911e;">修改姓名</h4>
			</div>
			<div style="height: 112px;width: 499px;  background-color: white;border: solid 1px black;border-left: none;border-right: none; ">
				<div id="xx" style="width:180px;height:180px;">
					<input id="updatename" style="height: 50px; width: 369px; text-align:center; margin-left: 60px;margin-top: 30px; background-color: #f7f7f7;border: none;" type="text" />
				</div>
			</div>
			<div id="" style="height: 68px;">
				<button id="namequeren"onclick="changess()" style="height: 65px; color: #f18700; width: 249px;background-color: #fffcf7;float: left;border: none;" >确认修改</button>
				<button id="namequxiao" style="height: 65px; width: 249px; background-color: white;float: r;border: none;">取消</button>
			</div>
		</div>		
    	<!--
    		修改企业名
    	-->
    	<div id="qiyewin" style="width: 500px; height: 236px; position:fixed; top: 360px;left: 650px; display:none;">
			<div style="height: 55px;background-color: white; margin-top: 2px;">
				<center></center>
				<h4 style="float: left;margin-left: 215px; margin-top: 16px; color: #f5911e;">修改企业名</h4>
			</div>
			<div style="height: 112px;width: 499px;  background-color: white;border: solid 1px black;border-left: none;border-right: none; ">
				<div id="xx" style="width:180px;height:180px;">
					<input id="updateqiye" style="height: 50px; width: 369px; text-align:center; margin-left: 60px;margin-top: 30px; background-color: #f7f7f7;border: none;" type="text" />
				</div>
			</div>
			<div id="" style="height: 68px;">
				<button id="qiyequeren" onclick="changess1()" style="height: 65px; color: #f18700; width: 249px;background-color: #fffcf7;float: left;border: none;" >确认修改</button>
				<button id="qiyequxiao" style="height: 65px; width: 249px; background-color: white;float: r;border: none;">取消</button>
			</div>
		</div>		
		
		<!--修改性别-->
    	<div id="windata3" style="width: 500px; height: 236px; position:fixed; top: 360px;left: 650px; display:none;">
			<div style="height: 55px;background-color: white; margin-top: 2px;">
				<center></center>
				<h4 style="float: left;margin-left: 215px; margin-top: 16px; color: #f5911e;">修改性别</h4>
			</div>
			<div style="height: 112px;width: 499px;  background-color: white;border: solid 1px black;border-left: none;border-right: none; ">
			<!---->
			<button id="boy" style="width: 159px ;height: 78px; border: solid 1px #e8e8e8; margin-left: 40px; background-color: white;">
    			<img src="../img/luoxiaoimg/luoxImg/boy.png" />
    		</button>
    		<button id="girl" style="width: 159px ;height: 78px;  border: solid 1px #e8e8e8; margin-left: 100px; background-color: white;margin: 15px; " >
    			<img src="../img/luoxiaoimg/luoxImg/girl.png" />
    		</button>
    		<!---->
			</div>
			<div id="rilianniu3" style="height: 68px;">
				<button id="riliqueren3" onclick="changess()" style="height: 65px; color: #f18700; width: 249px;background-color: #fffcf7;float: left;border: none;">确认修改</button>
				<button id="riliquxiao3" style="height: 65px; width: 249px; background-color: white;float: r;border: none;">取消</button>
			</div>
		</div>		
		
		<!-- 日历  -->
		<div id="datawin" style="width: 500px; height: 236px; position:fixed; top: 360px;left: 650px; display:none;">
			<div style="height: 55px;background-color: white; margin-top: 2px;">
				<center></center>
				<h4 style="float: left;margin-left: 215px; margin-top: 16px; color: #f5911e;">修改生日</h4>
			</div>
			<div style="height: 112px;width: 499px;  background-color: white;border: solid 1px black;border-left: none;border-right: none; ">
				<div id="xx" style="width:180px;height:180px;">
					<input id="rili" style="height: 50px; width: 369px; text-align:center; margin-left: 60px;margin-top: 30px; background-color: #f7f7f7;border: none;" type="date" />
				</div>
			</div>
			<div id="rilianniu" style="height: 68px;">
				<button id="riliqueren" onclick="changess()" style="height: 65px; color: #f18700; width: 249px;background-color: #fffcf7;float: left;border: none;">确认修改</button>
				<button id="riliquxiao" style="height: 65px; width: 249px; background-color: white;float: r;border: none;">取消</button>
			</div>
		</div>		
	
	<!--
		修改地址
	-->
	<div id="dizhiwin" style="width: 500px; height: 236px; position:fixed; top: 360px;left: 650px; display:none;">
			<div style="height: 55px;background-color: white; margin-top: 2px;">
				<center></center>
				<h4 style="float: left;margin-left: 215px; margin-top: 16px; color: #f5911e;">修改地址</h4>
			</div>
			<div style="height: 112px;width: 499px;  background-color: white;border: solid 1px black;border-left: none;border-right: none; ">
				<div class="container" style="margin: 35px;margin-left: 80px; ">
					<div class="docs-methods">
						<form class="form-inline">
							<div id="distpicker">
								<div class="form-group">
									<div style="position: relative;">
										<input style="width: 200px;" id="city-picker3" class="form-control" readonly type="text" value="江苏省/常州市/溧阳市" data-toggle="city-picker">
									</div>
								</div>
								<div class="form-group">
									<button class="btn btn-warning" id="reset" type="button">重置</button>
									<button class="btn btn-danger" id="destroy" type="button">确定</button>
								</div>
							</div>
						</form>
					</div>
				</div>
			</div>
			<div id="rilianniu4" style="height: 68px;">
				<button id="riliqueren4" style="height: 65px; color: #f18700; width: 249px;background-color: #fffcf7;float: left;border: none;">确认修改</button>
				<button id="riliquxiao4" style="height: 65px; width: 249px; background-color: white;float: r;border: none;">取消</button>
			</div>
		</div>
	</body>
	<script type="text/javascript">
		function changess(){
			/*alert($(".name").text());
			alert($("#updatename").val());*/
			$("#namewin").css("display", "none");
			$("#backcolor").css("display", "none");
		}
		
		function changess1(){
			/*alert($(".name1").text());
			alert($("#rili2").val());*/
			$("#qiyewin").css("display", "none");
			$("#backcolor").css("display", "none");
		}
		/*我的资料*/
		$("#myziliao").on("click",function(){
			//显示指定的div
			$("#message").show();
			$("#kong").hide();
		});
		/*我的寄件*/
		$("#myjijian").on("click",function(){
			//显示指定的div
			$("#kong").show();

			$("#message").hide();
		});
		
		//设置头像样式
		$("#head_portraits").css({
			"width": "100px",
			"height": "100px",
			"border-radius": "50px",
			"cursor": "pointer"
		})
		//设置小头像
		$("#hean-message>img").css({
			"width": "35px",
			"height": "35px",
			"border-radius": "17.5px",
			"cursor": "pointer",

		})
		//修改头像
		$("#userimg>img").css({
			"width": "80px",
			"height": "80px",
			"border-radius": "40px",
			"cursor": "pointer"
		})
		//修改头像按钮
		$("#updatemessage").css({
			"border-radius": "20px",
			"cursor": "pointer"
		})
		//修改按钮
		$(".updatemessages").css({
			"border-radius": "20px",
			"cursor": "pointer"
		})
		//功能选择按钮
		$(".branch").css({
			"border-radius": "10px",
			"cursor": "pointer",
		})
		
		
		
		/*点击按钮变色其他不变*/
		$(function(){
        $(".branch").on("click",function(){
            $(".branch").eq($(this).index()).attr("style","background-color:#f18700","color:#ffffff").siblings().removeAttr("style");
            
        });
    	})
		
		//按钮放上去效果
		$(".updatemessages").mouseover(function() {
			$(this).css({
				"background-color": "#f18700",
				"color": "#ffffff"
			});
		});
		//按钮放移开效果
		$(".updatemessages").mouseout(function() {
			$(this).css({
				"background-color": "#ffffff",
				"color": "black"
			});
		});
		

		
		
		
		/*修改姓名*/
		$("#namewin").css({
			"border-radius": "5px",
			"cursor": "pointer"
		})
		//按钮放上去效果
		$("#namequeren").mouseover(function() {
			$(this).css({
				"background-color": "#f18700",
				"color": "white"
			});
		});
		//按钮移开效果
		$("#namequeren").mouseout(function() {
			$(this).css({
				"background-color": "#fffcf7",
				"color": "#f18700"
			});
		});
		//按钮放上去效果
		$("#namequxiao").mouseover(function() {
			$(this).css({
				"background-color": "#f18700",
				"color": "white"
			});
		});
		//按钮移开效果
		$("#namequxiao").mouseout(function() {
			$(this).css({
				"background-color": "white",
				"color": "black"
			});
		});
		//按钮按下显示
		$("#name").mousedown(function() {
		$("#upadtename").val($(".name").text());
			$("#namewin").show();
			$("#backcolor").slideToggle();
		});
		//日历取消按钮
		$("#namequxiao").click(function() {
			$("#namewin").css("display", "none");
			$("#backcolor").css("display", "none");
		});
		
		/*
		 * 修改企业
		 */
		$("#qiyewin").css({
			"border-radius": "5px",
			"cursor": "pointer"
		})
		//按钮放上去效果
		$("#qiyequeren").mouseover(function() {
			$(this).css({
				"background-color": "#f18700",
				"color": "white"
			});
		});
		//按钮移开效果
		$("#qiyequeren").mouseout(function() {
			$(this).css({
				"background-color": "#fffcf7",
				"color": "#f18700"
			});
		});

		$("#qiyequxiao").mouseover(function() {
			$(this).css({
				"background-color": "#f18700",
				"color": "white"
			});
		});
		$("#qiyequxiao").mouseout(function() {
			$(this).css({
				"background-color": "white",
				"color": "black"
			});
		});
		$("#qiyename").mousedown(function() {
			
			$("#qiyewin").show();
			$("#backcolor").slideToggle();
		});
		/*企业取消按钮*/
		$("#qiyequxiao").click(function() {
			$("#qiyewin").css("display", "none");
			$("#backcolor").css("display", "none");
		});
		
		
		/*修改性别*/
		$("#windata3").css({
			"border-radius": "5px",
			"cursor": "pointer"
		})
		//按钮放上去效果
		$("#riliqueren3").mouseover(function() {
			$(this).css({
				"background-color": "#f18700",
				"color": "white"
			});
		});
		//按钮移开效果
		$("#riliqueren3").mouseout(function() {
			$(this).css({
				"background-color": "#fffcf7",
				"color": "#f18700"
			});
		});

		$("#riliquxiao3").mouseover(function() {
			$(this).css({
				"background-color": "#f18700",
				"color": "white"
			});
		});
		$("#riliquxiao3").mouseout(function() {
			$(this).css({
				"background-color": "white",
				"color": "black"
			});
		});
		$("#xingbieanniu").mousedown(function() {
			$("#windata3").slideToggle();
			$("#backcolor").slideToggle();
		});
		/*日历取消按钮*/
		$("#riliquxiao3").click(function() {
			$("#windata3").css("display", "none");
			$("#backcolor").css("display", "none");
		});
		
		
		//修改生日
		$("#datawin").css({
			"border-radius": "5px",
			"cursor": "pointer"
		})
		//按钮放上去效果
		$("#riliqueren").mouseover(function() {
			$(this).css({
				"background-color": "#f18700",
				"color": "white"
			});
		});
		//按钮移开效果
		$("#riliqueren").mouseout(function() {
			$(this).css({
				"background-color": "#fffcf7",
				"color": "#f18700"
			});
		});
		//按钮放上去效果
		$("#riliquxiao").mouseover(function() {
			$(this).css({
				"background-color": "#f18700",
				"color": "white"
			});
		});
		//按钮移开效果
		$("#riliquxiao").mouseout(function() {
			$(this).css({
				"background-color": "white",
				"color": "black"
			});
		});
		/*选择日历*/
		$("#bosdata").mousedown(function() {
			$("#datawin").slideToggle();
			$("#backcolor").slideToggle();
		});
		/*日历取消按钮*/
		$("#riliquxiao").click(function() {
			$("#datawin").css("display", "none");
			$("#backcolor").css("display", "none");
		});
		
		
		/*修改地址*/
		$("#windata4").css({
			"border-radius": "5px",
			"cursor": "pointer"
		})
		//按钮放上去效果
		$("#riliqueren4").mouseover(function() {
			$(this).css({
				"background-color": "#f18700",
				"color": "white"
			});
		});
		//按钮移开效果
		$("#riliqueren4").mouseout(function() {
			$(this).css({
				"background-color": "#fffcf7",
				"color": "#f18700"
			});
		});

		$("#riliquxiao4").mouseover(function() {
			$(this).css({
				"background-color": "#f18700",
				"color": "white"
			});
		});
		$("#riliquxiao4").mouseout(function() {
			$(this).css({
				"background-color": "white",
				"color": "black"
			});
		});
		$("#dizhianniu").mousedown(function() {
			$("#dizhiwin").show();
			$("#backcolor").slideToggle();
		});
		/*日历取消按钮*/
		$("#riliquxiao4").click(function() {
			$("#dizhiwin").css("display", "none");
			$("#backcolor").css("display", "none");
		});
	</script>

</html>