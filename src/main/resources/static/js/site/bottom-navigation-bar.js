$(function() {
	//搜索框
	$('.SearchBtn').click(function() {
		$(this).siblings('.SliderForm').toggleClass('SliderActive');
		$('.SearchName').toggleClass('IpuAct')
	})
	
	//  友情链接
	$('.LinkMain').click(function() {
		$(this).toggleClass('NameActive')
		$(this).siblings().slideToggle();
	})

	//  点击出现二维码
	$('.WXCon').click(function(e) {
		e.preventDefault();
		$(this).children('.ewmcon').stop().slideToggle();
	})

})