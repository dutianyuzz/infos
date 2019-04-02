$(function() {
	// 动态改变导航菜单下拉列表宽度
	var h1 = $('.dropdown_1').height(); //高度
	var w1 = $('.dropdown_1').width(); //宽度
	$('.dropdown-content_1').width(w1 + "px"); //改变下拉菜单宽度

	var h2 = $('.dropdown_2').height();
	var w2 = $('.dropdown_2').width();
	$('.dropdown-content_2').width(w2 + "px");

	var h3 = $('.dropdown_3').height();
	var w3 = $('.dropdown_3').width();
	$('.dropdown-content_3').width(w3 + "px");

	var h4 = $('.dropdown_4').height();
	var w4 = $('.dropdown_4').width();
	$('.dropdown-content_4').width(w4 + "px");

	var h5 = $('.dropdown_5').height();
	var w5 = $('.dropdown_5').width();
	$('.dropdown-content_5').width(w5 + "px");
});