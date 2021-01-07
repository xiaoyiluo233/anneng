(function($) {
    var fg_bgNum = 1;

    function replaceBgImg() {
        if (fg_bgNum == 1) {
            $("body").css("background-image", "url(img/LFimg/133692c5-4058-415c-b6c0-bf0f1e05ad7d.jpg)");
            $("#replaceBgImg li:eq(0)").css("background-color", "rgba(256,256,256,.2)");
            $("#replaceBgImg li:eq(1)").css("background-color", "white");
            fg_bgNum++;
        } else {
            $("body").css("background-image", "url(img/LFimg/184871cf-4292-4cc5-8058-829ba5ab1e98.jpg)");
            $("#replaceBgImg li:eq(1)").css("background-color", "rgba(256,256,256,.2)");
            $("#replaceBgImg li:eq(0)").css("background-color", "white");
            fg_bgNum = 1;
        }
    }

    var fg_BgImg;
    $("#replaceBgImg li:eq(0)").click(function () {
        fg_bgNum = 2;
        clearTimeout(fg_BgImg);
        replaceBgImg();
        fg_BgImg = setInterval(replaceBgImg, 10000);
    });
    $("#replaceBgImg li:eq(1)").click(function () {
        fg_bgNum = 1;
        clearTimeout(fg_BgImg);
        replaceBgImg();
        fg_BgImg = setInterval(replaceBgImg, 10000);
    });


    var fg_sectionNum = 0;

    var fg_sectionImg;

    function sectionSelect(index, bool) {
        $(".section-imgList dl").removeClass("fadeUpIn");
        if (index >= 2) {

            $(".section-imgList dl:eq(0)").css("display", "none");
            $(".section-imgList dl:eq(4)").css("display", "block");
        } else {
            $(".section-imgList dl:eq(4)").css("display", "none");
            $(".section-imgList dl:eq(0)").css("display", "block");
        }
        $(".section-content").css("display", "none");
        $(".section-content:eq(" + index + ")").css("display", "block");
        $(".section-imgList dl div").css("display", "none");
        $(".section-imgList dl:eq(" + index + ") div").css("display", "block");
        $(".section-imgList dl").css("background-color", "white");
        $(".section-imgList dl:eq(" + index + ")").css("background-color", "#F18700");
        $(".section-imgList dl dd").removeClass("white");
        $(".section-imgList dl:eq(" + index + ") dd").addClass("white");
        $(".section-img").css("display", "none");
        $(".section-img:eq(" + index + ")").css("display", "block");
        if (index >= 4) {
            fg_sectionNum = 0;
        } else {
            fg_sectionNum = index + 1;
        }
        // 运行特效
        $(".section-content:eq(" + index + ")").effect("drop", {}, 1000, sectionBack(index));
        if (bool) {
            clearInterval(fg_sectionImg);
            fg_sectionImg = setInterval(function () {
                sectionSelect(fg_sectionNum, false);
            }, 5000);
        }
    }

    $(".section-imgList dl").click(function () {
        var index = $(this).index();
        sectionSelect(index, true);
    });
    $(".leftJian").click(function () {
        var num = parseInt(fg_sectionNum);
        if (num == 1) {
            num = 4;
        } else if (num == 0) {
            num = 3;
        } else {
            num = num - 2;
        }
        sectionSelect(num, true);
    });
    $(".rightJian").click(function () {
        var num = parseInt(fg_sectionNum);
        sectionSelect(num, true);
    });
    $("#newsTitle li").click(function () {
        var index = $(this).index();
        $("#newsTitle>li>img").css("display", "none");
        $("#newsTitle li:eq(" + index + ") img").css("display", "block");
        $("#newsTitle>li>p").css("color", "rgb(119, 124, 135)");
        $("#newsTitle li:eq(" + index + ") p").css("color", "#f18700");
        $(".newsLists").css("display", "none");
        $(".newsLists:eq(" + index + ")").css("display", "block");

    });
    $("#newsTitle li").click(function () {
        var index = $(this).index();
    });
    $(function () {
        $(".opacityDiv").css("display", "block");
        setTimeout(function () {
            $(".opacityDiv").css("height", "0px");
            $(".opacityDiv").css("animation", "opacityDiv 1s");
            $(".opacityDiv").css("-webkit-animation", "opacityDiv 1s");
        }, 800);
        fg_BgImg = setInterval(replaceBgImg, 10000);
        sectionSelect(fg_sectionNum, false);
        fg_sectionImg = setInterval(function () {
            sectionSelect(fg_sectionNum, false);
        }, 5000);
    });

// 回调函数
    function sectionBack(index) {
        $(".section-content:eq(" + index + ")").removeAttr("style").hide().fadeIn();
        $("#section-img").removeAttr("style").hide().fadeIn();
    };
    var sectionImgList_bool = 0;
    var AN_Number_bool = false
    $(document).ready(function(){//在文档加载完毕后执行
        $(window).scroll(function(){//开始监听滚动条
            //获取当前滚动条高度
            var top = $(document).scrollTop();
            if (top > 200) {
                $("#head_tou").css("opacity",1);
                $(".arrow-right-up").css("display", "block");
            } else {
                $("#head_tou").css("opacity",0.1);
                $(".arrow-right-up").css("display", "none");
            }
            if (top > 400) {
                $(".section-subheading:eq(0)").addClass("fadeUpInH3");
            }
            if (top > 600 && sectionImgList_bool == 0) {
                $(".section-imgList dl:eq(0)").addClass("fadeUpIn");
                $(".section-imgList dl:eq(0)").css("bottom", "0px");
                setTimeout(function () {
                    $(".section-imgList dl:eq(1)").addClass("fadeUpIn");
                    $(".section-imgList dl:eq(1)").css("bottom", "0px");
                }, 200);
                setTimeout(function () {
                    $(".section-imgList dl:eq(2)").addClass("fadeUpIn");
                    $(".section-imgList dl:eq(2)").css("bottom", "0px");
                }, 400);
                setTimeout(function () {
                    $(".section-imgList dl:eq(3)").addClass("fadeUpIn");
                    $(".section-imgList dl:eq(3)").css("bottom", "0px");
                }, 600);
                setTimeout(function () {
                    $(".section-imgList dl:eq(4)").addClass("fadeUpIn");
                    $(".section-imgList dl:eq(4)").css("bottom", "0px");
                    sectionImgList_bool = 1;
                }, 800);
            }
            if (top > 900) {
                $(".section-subheading:eq(1)").addClass("fadeUpInH3");
                $(".activityList").addClass("activityList-anima");
            }
            if (top > 1700) {
                $(".section-subheading:eq(2)").addClass("fadeUpInH3");
                $(".newsLists").addClass("newsLists-anima");
            }
            if (top > 2820 && AN_Number_bool == false) {
                $(".section-subheading:eq(3)").addClass("fadeUpInH3");
                $(".AN_Number01").numScroll();
                $(".AN_Number02").numScroll();
                $(".AN_Number03").numScroll();
                $(".AN_Number04").numScroll();
                $(".AN_Number05").numScroll();
                AN_Number_bool = true;
            }
        });
    });
})(jQuery);