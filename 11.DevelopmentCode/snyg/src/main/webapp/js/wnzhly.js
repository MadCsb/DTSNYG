// JavaScript Document

$(document).ready(function(e) {
    /*============= 首页大图滚动 ==============*/
	jQuery(".homeTopSlideBox").slide({mainCell:".bd ul",effect:"fold",autoPlay:true,delayTime:1000});
	/*============= 首页优惠专区 ==============*/
	jQuery(".favourablePicScroll").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"leftLoop",autoPlay:true,vis:4,trigger:"click"});
	$(".favourableWrap .prev2").click(function(e){
		$(".favourablePicScroll .hd .prev").click();
	});
	$(".favourableWrap .next2").click(function(e){
		$(".favourablePicScroll .hd .next").click();
	});
	/*============= 返回页面顶部 ==============*/
	$(".backTop").click(function(){
		$('body,html').animate({scrollTop:0},1000);
		return false;
	});
	$(window).scroll(function(e){
		var screenHeight = $(document.body).outerHeight(true);
//		var backTop_top = $(".backTop").offset().top;
//		var bottom_top = $('.footerWrap').offset().top;
		if(window.pageYOffset){
			y = window.pageYOffset;
			if(y > (screenHeight * 2 / 3)){
				$(".backTop").show();
			}else{
				$(".backTop").hide();
			}
//			if(y > (bottom_top - 650)){
//				$(".backTop").css({"position": "absolute", "bottom": 290});
//			}else{
//				$(".backTop").css({"position": "fixed", "bottom": 70});
//			}
		}
	});
	/*============= 华山揽胜景点 ==============*/
	$(".hslsScenicSpotsList > li").hover(function(e){
		$(this).find("i").animate({"width": 60}, 500);
	}, function(e){
		$(this).find("i").animate({"width": 40}, 500);
	});
	/*============= 华山揽胜文化 ==============*/
	$(".hslsCultureList > li").hover(function(e){
		if(!$(this).hasClass("active")){
			$(this).find(".hover").stop(true, true).fadeIn("normal");
		}
	}, function(e){
		if(!$(this).hasClass("active")){
			$(this).find(".hover").stop(true, true).fadeOut("normal");
		}
	});
	/*============= 畅游渭南主题线路 ==============*/
	$(".cywnSubjectLineList li").hover(function(e){
		$(this).find(".hover").stop(true, true).fadeToggle("slow");
		$(this).find(".normal").stop(true, true).fadeToggle("slow");
	});
	/*============= 畅游渭南旅游资源 ==============*/
	$(".cywnTouristResourcesRight > div").hover(function(e){
		$(this).find(".hover").stop(true, true).fadeToggle("slow");
	});
	/*============= 走进渭南首页 ==============*/
	$(".zjwnLinkList > li").hover(function(e){
		$(this).find(".hover").stop(true, true).fadeToggle("slow");
	});
	/*============= 区县划分商家切换 ==============*/
	jQuery(".qxhfNameScroll").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"left",autoPlay:false,vis:6,trigger:"click"});
	$(".qxhfTopInfo .prev2").click(function(e){
		$(".qxhfNameScroll .hd .prev").click();
	});
	$(".qxhfTopInfo .next2").click(function(e){
		$(".qxhfNameScroll .hd .next").click();
	});
	$(".qxhfBusinessLink li .icon").hover(function(e){
		$(this).find(".hover").stop(true, true).fadeToggle("slow");
	});
	var itemIndex = $(".qxhfNameScroll .bd ul .active").index();
	var itemNum = $(".qxhfNameScroll .bd ul li").length;
	if (itemIndex > 5 && itemIndex <= itemNum - 2) {
		for(var i = 0; i < itemIndex - 5; i++){
			$(".qxhfTopInfo .next2").click();
		}
	} else if (itemIndex > itemNum - 2) {
		for(var i = 0; i < itemNum - 6; i++){
			$(".qxhfTopInfo .next2").click();
		}
	}
	/*============= 区县划分商家景区 ==============*/
	$(".qxhfBusinessJqBox").hover(function(e){
		$(this).find("p").stop(true, false).animate({"bottom": 0}, 500);
	},function(e){
		$(this).find("p").stop(true, false).animate({"bottom": -130}, 500);
	});
	/*============= 自助旅游交通 ==============*/
	$(".zzlyTrafficIcon li").hover(function(e){
		if(!$(this).hasClass("current")){
			$(this).find(".hover").stop(true, true).fadeToggle("slow");
		}
	});
	/*============= 自助旅游活动 ==============*/
	$(".zzlyActivityWrap .prev2").click(function(e){
		$(".zzlyActivityScroll .hd .prev").click();
	});
	$(".zzlyActivityWrap .next2").click(function(e){
		$(".zzlyActivityScroll .hd .next").click();
	});
	/*============= 春夏秋冬切换 ==============*/
	function fourSeasonsStyle(fourSeasonsName){
		switch (fourSeasonsName) {
			case "spring":
				$(".zzlySeason").css({"background-position": "0px 0px"});
				break;
			case "summer":
				$(".zzlySeason").css({"background-position": "0px -103px"});
				break;
			case "autumn":
				$(".zzlySeason").css({"background-position": "0px -208px"});
				break;
			case "winter":
				$(".zzlySeason").css({"background-position": "0px -312px"});
				break;
			default:
				break;
		}
	}
	var date = new Date;
	var month = date.getMonth()+1;
	if(2 <= month && 5 > month) {
		fourSeasonsStyle("spring");
	}else if(5 <= month && 8 > month) {
		fourSeasonsStyle("summer");
	}else if(8 <= month && 11 > month) {
		fourSeasonsStyle("autumn");
	}else {
		fourSeasonsStyle("winter");
	}
	$('.zzlySeason .spring').click(function(e){
		fourSeasonsStyle("spring");
	});
	$('.zzlySeason .summer').click(function(e){
		fourSeasonsStyle("summer");
	});
	$('.zzlySeason .autumn').click(function(e){
		fourSeasonsStyle("autumn");
	});
	$('.zzlySeason .winter').click(function(e){
		fourSeasonsStyle("winter");
	});
	/*============= 旅游服务商家 ==============*/
	$(".lyfwBusinessList li").eq(6).css({"border": 0});
	$(".lyfwBusinessList li").hover(function(e){
		$(this).find(".hover").stop(true, true).fadeToggle("normal");
	});
	/*============= 商家详情 ==============*/
	jQuery(".businessDetailSlideBox").slide({mainCell: ".bd ul", effect:"fold", autoPlay:false, delayTime:1000, trigger:"click"});
	var contentHeight = $(".sjxqBottomBusinessDetail .content").height();
	if(contentHeight < 235){
		$(".sjxqBottomBusinessDetail .showAll").hide();
	}
	$(".sjxqBottomBusinessDetail .showAll").click(function(e){
		if($(this).hasClass("close")){
			$(this).removeClass("close").addClass("open");
			$(".sjxqBottomBusinessDetail .contentBox").animate({"height": contentHeight + 40}, 500);
		}else {
			$(this).removeClass("open").addClass("close");
			$(".sjxqBottomBusinessDetail .contentBox").animate({"height": 235}, 500);
		}
	});
	$(".sjxqBottomBtn .text").click(function(e){
		$(this).addClass("active").siblings(".text").removeClass("active");
		if($(this).index() == 0){
			$(".sjxqBottomleft .sjxqContent").eq(0).show().siblings(".sjxqContent").hide();
			$(".sjxqBottomleft .bottomLine").show();
		}else if($(this).index() == 2){
			$(".sjxqBottomleft .sjxqContent").eq(1).show().siblings(".sjxqContent").hide();
			$(".sjxqBottomleft .bottomLine").show();
		}else if($(this).index() == 4){
			$(".sjxqBottomleft .sjxqContent").eq(2).show().siblings(".sjxqContent").hide();
			$(".sjxqBottomleft .bottomLine").hide();
		}else if($(this).index() == 6){
			$(".sjxqBottomleft .sjxqContent").eq(3).show().siblings(".sjxqContent").hide();
			$(".sjxqBottomleft .bottomLine").hide();
		}
	});
	/*============= 画说渭南 ==============*/
	$(".wntsClassify .item").hover(function(e){
		if(!$(this).hasClass("current")) {
			$(this).css({"background-position": "-297px 0px"});
		}
	}, function(e){
		if(!$(this).hasClass("current")) {
			$(this).css({"background-position": "0px 0px"});
		}
	});
	/*============= 影视渭南 ==============*/
	$(".yswnListWrap").each(function(e){
        var num = $(this).find(".hslsTravelNotesList li").length;
		var remainder = num % 4;
		var consult = parseInt(num / 4);
		switch(remainder)
		{
			case 1:
				var num = $(this).find(".hslsTravelNotesList li").eq(consult * 4).css({"margin-left": 381});
			break;
			case 2:
				var num = $(this).find(".hslsTravelNotesList li").eq(consult * 4).css({"margin-left": 255});
			break;
			case 3:
				var num = $(this).find(".hslsTravelNotesList li").eq(consult * 4).css({"margin-left": 125});
			break;
			default:
			break;
		}
    });
	/*============= 活动详情 ==============*/
	$(".hdxqAtlas").hide();
	/*============= 景点详情 ==============*/
	jQuery(".jdxqPicScroll").slide({titCell:".hd ul",mainCell:".bd ul",autoPage:true,effect:"leftLoop",autoPlay:true,scroll:4,vis:4,trigger:"click", delayTime:1000});
	var jdxqPicScrollNum1 = $(".jdxqPicScroll .bd ul li").length;
	var jdxqPicScrollNum2 = $(".jdxqPicScroll .bd ul").find(".clone").length;
	var jdxqPicScrollNum = jdxqPicScrollNum1 - jdxqPicScrollNum2;
	var jdxqPicScrollFocus = parseInt(jdxqPicScrollNum / 4);
	if(jdxqPicScrollNum % 4 == 0) {
		$(".jdxqPicScroll .hd").css({"width": jdxqPicScrollFocus * 27});
	}else {
		$(".jdxqPicScroll .hd").css({"width": (jdxqPicScrollFocus + 1) * 27});
	}
	$(".jdxqAtlas").hide();
	$(".jdxqTopWrap .ssjq").css({"margin-left": -($(".jdxqTopWrap .ssjq").width() + 26)/2});
	/*============= 地图弹层 ==============*/
	var marskHeight = $(".marsk").height();
	var mapWrapHeight = $(".mapWrap").height();
	$(".mapWrap").css({"margin-top": (marskHeight - mapWrapHeight) / 2});
	
	$('.marskToggle').click(function(e){
		$('html').css({"overflow": "hidden"});
		$('.wraper').css({"margin-right": "17px"});
		$('.marsk').show();
	});
	$('.marsk').find('.close').click(function(e){
		$('html').css({"overflow": "auto"});
		$('.wraper').css({"margin-right": 0});
		$('.marsk').hide();
		jwplayer("yswnVideo").pause(true);
	});
	/*============= 交通方式 ==============*/
	$("#feiji li").eq(0).css({"border": 0});
	$("#huoche li").eq(0).css({"border": 0});
	/*============= 付文本样式过滤 ==============*/
	$('.styleFilter').each(function(e){
		$(this).find('div, p, span, label, i, img').attr("style", "");
		$(this).find('a').each(function(){
			$(this).after($(this).html());
			$(this).remove();
		});
	});
	/*============= 分享 ==============*/
	$(".commonShare").hover(function(e){
		$(".bdsharebuttonbox").animate({"left": -88, "width": 95}, 300);
	},function(e){
		$(".bdsharebuttonbox").animate({"left": 10, "width": 0}, 300);
	});
	
	$(".homeFavorableList li").hover(function(e) {
        $(this).find(".normal, .hover").stop(true, false).fadeToggle("slow");
		$(this).find(".buyNow").stop(true, false).fadeToggle("slow");
    });
	
	$(".fourItemList li, .twoItemList li").hover(function(e) {
        $(this).find("h1").stop(true, false).fadeToggle("fast");
    });
	
	$(".virtualTravel").hover(function(e) {
        $(this).find(".hover").stop(true, false).fadeToggle("slow");
    });
	
	$(".recommendActivityList li").hover(function(e) {
		$(this).find("h1").stop(true, false).animate({"top": 70}, 500);
		$(this).find(".date").stop(true, false).animate({"top": 130}, 500);
		$(this).find(".tel").stop(true, false).animate({"top": 155}, 500);
		$(this).find(".maskLayer").stop(true, true).fadeOut(500);
    }, function(e){
		$(this).find("h1").stop(true, false).animate({"top": 60}, 500);
		$(this).find(".date").stop(true, false).animate({"top": 120}, 500);
		$(this).find(".tel").stop(true, false).animate({"top": 250}, 500);
		$(this).find(".maskLayer").stop(true, true).fadeIn(500);
	});
	
	function slideBox() {
		var slideBoxWidth = $(".slideBox").width();
		var slideBoxHeight = slideBoxWidth * 0.27;
		$(".slideBox").css({"height": slideBoxHeight});
		$(".slideBox .bd ul, .slideBox .bd ul li").css({"width": slideBoxWidth, "height": slideBoxHeight});
	}
	//slideBox();
	
	$(window).resize(function(e) {
		//slideBox();
	});
});
