//首页焦点广告图切换
(function($) {
	$.fn.jfocus = function(settings) {
		var defaults = {
			time: 5000
		};
		var settings = $.extend(defaults, settings);
		return this.each(function(){
			var $this = $(this);
			var sWidth = $this.width();
			var len = $this.find("ul li").length;
			var index = 0;
			var picTimer;
			var btn = "<div class='pagination'>";
			for (var i = 0; i < len; i++) {
				btn += "<span></span>";
			}
			btn += "</div><div class='arrow pre'></div><div class='arrow next'></div>";
			$this.append(btn);
			$this.find(".pagination span").css("opacity", 0.4).mouseenter(function() {
				index = $this.find(".pagination span").index(this);
				showPics(index);
			}).eq(0).trigger("mouseenter");
			$this.find(".arrow").css("opacity", 0.0).hover(function() {
				$(this).stop(true, false).animate({
					"opacity": "0.5"
				},
				300);
			},
			function() {
				$(this).stop(true, false).animate({
					"opacity": "0"
				},
				300);
			});
			$this.find(".pre").click(function() {
				index -= 1;
				if (index == -1) {
					index = len - 1;
				}
				showPics(index);
			});
			$this.find(".next").click(function() {
				index += 1;
				if (index == len) {
					index = 0;
				}
				showPics(index);
			});
			$this.find("ul").css("width", sWidth * (len));
			$this.hover(function() {
				clearInterval(picTimer);
			},
			function() {
				picTimer = setInterval(function() {
					showPics(index);
					index++;
					if (index == len) {
						index = 0;
					}
				},
				settings.time);
			}).trigger("mouseleave");
			function showPics(index) {
				var nowLeft = -index * sWidth;
				$this.find("ul").stop(true, false).animate({
					"left": nowLeft
				},
				"normal","swing");
				$this.find(".pagination span").stop(true, false).animate({
					"opacity": "0.4"
				},
				300).eq(index).stop(true, false).animate({
					"opacity": "1"
				},
				300);
			}
		});
	}
//首页标准模块中间多图广告鼠标触及凸显
	$.fn.jfade = function(settings) {
		var defaults = {
			start_opacity: "1",
			high_opacity: "1",
			low_opacity: ".3",
			timing: "50"
		};
		var settings = $.extend(defaults, settings);
		settings.element = $(this);
		//set opacity to start
		$(settings.element).css("opacity", settings.start_opacity);
		//mouse over
		$(settings.element).hover(
		//mouse in
		function() {
			$(this).stop().animate({
				opacity: settings.low_opacity
			},"fast"); //100% opacity for hovered object

		},
		//mouse out
		function() {
			$(this).stop().animate({
				opacity: settings.start_opacity
			},"fast"); //return hovered object to start opacity

		});
		return this;
	}
})(jQuery);
	function takeCount() {
	    setTimeout("takeCount()", 1000);
	    $(".time-remain").each(function(){
	        var obj = $(this);
	        var tms = obj.attr("count_down");
	        if (tms>0) {
	            tms = parseInt(tms)-1;
                var days = Math.floor(tms / (1 * 60 * 60 * 24));
                var hours = Math.floor(tms / (1 * 60 * 60)) % 24;
                var minutes = Math.floor(tms / (1 * 60)) % 60;
                var seconds = Math.floor(tms / 1) % 60;
                
                if (days < 0) days = 0;
                if (hours < 0) hours = 0;
                if (minutes < 0) minutes = 0;
                if (seconds < 0) seconds = 0;
                obj.find("[time_id='d']").html(days);
                obj.find("[time_id='h']").html(hours);
                obj.find("[time_id='m']").html(minutes);
                obj.find("[time_id='s']").html(seconds);
                obj.attr("count_down",tms);
	        }
	    });
	}

	function ADDLI() {
		for (var i = 0; i <= numpic; i++) {
			ulcontent += '<li>' + '<a href="#">' + (i + 1) + '</a>' + '</li>';
		}
		$('#fullScreenSlides').after(ulstart + ulcontent + ulend);
	}
    //首页焦点区满屏背景广告切换
	var numpic = $('#fullScreenSlides li').size() - 1;

if(!$('#SlidesPagination li').size()){
	var ulstart = '<ul id="SlidesPagination" class="full-screen-slides-pagination">',
	ulcontent = '',
	ulend = '</ul>';
	ADDLI();
}
	var pagination = $('#SlidesPagination li');
	var paginationwidth = $('#SlidesPagination').width();
	$('#SlidesPagination').css('margin-left', (372 - paginationwidth))

	pagination.eq(0).addClass('current');

$(function(){
	setTimeout("takeCount()", 1000);
    //首页Tab标签卡滑门切换
    $(".tabs-nav > li > h3").bind('mouseover', (function(e) {
    	if (e.target == this) {
    		var tabs = $(this).parent().parent().children("li");
    		var panels = $(this).parent().parent().parent().children(".tabs-panel");
    		var index = $.inArray(this, $(this).parent().parent().find("h3"));
    		if (panels.eq(index)[0]) {
    			tabs.removeClass("tabs-selected").eq(index).addClass("tabs-selected");
    			panels.addClass("tabs-hide").eq(index).removeClass("tabs-hide");
    		}
    	}
    }));

    // 图文组合 tab切换
    $(".floor-right-top-tabs-nav > ul > li > span").bind("mouseover", (function(e) {
    	if (e.target == this) {
    		var tabs = $(this).parent().parent().find("li");
    		var panels = $(this).parent().parent().parent().parent().children(".tabs-panel");
    		var index = $.inArray(this, $(this).parent().parent().parent().find("span"));
    		if (panels.eq(index)[0]) {
    			tabs.removeClass("tabs-selected").eq(index).addClass("tabs-selected");
    			panels.addClass("tabs-hide").eq(index).removeClass("tabs-hide");
    		}
    	}
    }));

    // 图文组合三 tab切换
    $(".floor-pic-font-group-title-3 .floor-right-top-tabs-nav > ul > li > span").bind("mouseover", (function(e) {
    	if (e.target == this) {
    		var tabs = $(this).parent().parent().find("li");
    		var panels = $(this).parent().parent().parent().parent().parent().find(".tabs-panel");
    		var index = $.inArray(this, $(this).parent().parent().find("span"));
    		if (panels.eq(index)[0]) {
    			tabs.removeClass("tabs-selected").eq(index).addClass("tabs-selected");
    			panels.addClass("tabs-hide").eq(index).removeClass("tabs-hide");
    		}
    	}
    }));
	$('.middle-goods-list > ul > li').jfade({
		start_opacity: "1",
		high_opacity: "1",
		low_opacity: "0.8",
		timing: "0"
	});
	//品牌的闪动效果
	$('.floor_bottom_brand > a > img').jfade({
		start_opacity: "1",
		high_opacity: "1",
		low_opacity: "0.85",
		timing: "0"
	});
	//每日上新的闪动效果
	$('#updateday > a > img').jfade({
		start_opacity: "1",
		high_opacity: "1",
		low_opacity: "0.85",
		timing: "0"
	});
	//最新热卖的闪动效果
	$('#ad_part01> a > img').jfade({
		start_opacity: "1",
		high_opacity: "1",
		low_opacity: "0.85",
		timing: "0"
	});
	//热门品牌的闪动效果
	$('#hotbrand> a > img').jfade({
		start_opacity: "1",
		high_opacity: "1",
		low_opacity: "0.85",
		timing: "0"
	});
	$(".jfocus-trigeminy").jfocus();
	$(".right-side-focus").jfocus();
	$(".tuan").jfocus({time:8000});
	$("#saleDiscount").jfocus({time:8000});
})

//楼层内的品牌切换
	$('.tabs-brand').each(function(){
		var num =0;
		var llishu=$(this).find(".brand-list").first().children().length;
		var liwidth=$(this).find(".brand-list").children().width();
		var shu = Math.floor($(this).width()/liwidth);
		var boxwidth=llishu*liwidth;
		var shuliang=llishu-shu;
		$(this).find('.brand-right').click(function(){
			$(this).parents(".brand-con").find(".brand-list").css('width',boxwidth+'px');
			num++;
			if (num>shuliang) {
				num=shuliang;
			}
			var move=-liwidth*num;
			$(this).closest($(this).parents(".brand")).find(".brand-list").stop().animate({'left':move+'px'},500);
		})
		$(this).find('.brand-left').click(function(){
			$(this).parents(".brand-con").find(".brand-list").css('width',''+boxwidth+'px');
			num--;
			if (num<0) {
				num=0;
			}
			var move=-liwidth*num;
			$(this).closest($(this).parents(".brand")).find(".brand-list").stop().animate({'left':move+'px'},500);
		})
		
	})	

	// 轮播广告
	$('.tabs-ads').each(function(){
		var num =0;
		var llishu=$(this).find(".ad-three-list").first().children().length;
		var liwidth=$(this).find(".ad-three-list").children().width();
		var shu = Math.floor($(this).width()/liwidth);
		var boxwidth=llishu*(liwidth+9);
		var shuliang=(llishu/3)-(shu/3);
		$(this).find(".brand-right").click(function(){
			$(this).parents(".ads-con").find(".ad-three-list").css("width",boxwidth+"px");
			num++;
			if (num>shuliang) {
				num=shuliang;
			}
			var move=-(liwidth*3+30*1)*num;
			$(this).closest($(this).parents(".ads")).find(".ad-three-list").stop().animate({"left":move+"px"},500);
		})
		$(this).find(".brand-left").click(function(){
			$(this).parents(".ads-con").find(".ad-three-list").css("width",""+boxwidth+"px");
			num--;
			if (num<0) {
				num=0;
			}
			var move=-(liwidth*3+30*1)*num;
			$(this).closest($(this).parents(".ads")).find(".ad-three-list").stop().animate({"left":move+"px"},500);
		})
		
	})	

function Move(btn1,btn2,box,btnparent,shu){
	var llishu=$(box).first().children().length;
	var liwidth=$(box).children().width();
	var boxwidth=llishu*liwidth;
	var shuliang=llishu-shu;
	$(box).css('width',''+boxwidth+'px');
	var num=0;
	$(btn1).click(function(){
		num++;
		if (num>shuliang) {
			num=shuliang;
		}
		var move=-liwidth*num;
		$(this).closest(btnparent).find(box).stop().animate({'left':''+move+'px'},500);
	});
	$(btn2).click(function(){
		num--;
		if (num<0) {
			num=0;
		}
		var move=liwidth*num;
		$(this).closest(btnparent).find(box).stop().animate({'left':''+-move+'px'},500);
	})
}
