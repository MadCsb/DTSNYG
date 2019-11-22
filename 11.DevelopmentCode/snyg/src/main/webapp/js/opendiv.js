	//城市选择
	$(".logo strong").mouseenter(function(){
		$(".logo dl").toggle();
	});
	$(".logo strong").mouseout(function(){
		setTimeout($(".logo dl").toggle(), 200);
	});
	$(".logo dl").mouseenter(function(){
		$(".logo dl").show();
	});
	$(".logo dl").mouseleave(function(){
		$(".logo dl").hide();
	});