$(function() {
	$('.SearchBtn').click(function() {
		$(this).siblings('.SliderForm').toggleClass('SliderActive');
		$('.SearchName').toggleClass('IpuAct')
	})

	//  首页产品中心轮播
	jQuery(".PartnerScroll").slide({
		mainCell: ".bds .picList",
		easing: 'linear',
		autoPage: true,
		effect: "leftLoop",
		autoPlay: true,
		delayTime: 350,
		interTime: 6000,
		vis: 4
	});

	var _hri = $('.AppList').outerHeight();

	function serves_s() {
		var Timer = 0;
		var _tr = $('.AppList').length;
		if(_tr == 0) {
			return;
		}
		var _to = $('.AppList').offset().top - 350;
		if($(window).scrollTop() >= _to && $(window).scrollTop() < _to + _hri + 400) {
			$('.AppList').find("li").each(function() {
				Timer += 200;
				$(this).delay(Timer + 100).animate({
					"top": "0",
					opacity: '1'
				}, 600, 'easeOutBack');
			});
		}
	}
	$(window).scroll(serves_s);

	var _cri = $('.center').outerHeight();

	function news() {
		var Timer = 0;
		var _tr = $('.center').length;
		if(_tr == 0) {
			return;
		}
		var _to = $('.center').offset().top - 350;
		if($(window).scrollTop() >= _to && $(window).scrollTop() < _to + _cri + 400) {
			$('.center').find("li").each(function() {
				Timer += 200;
				$(this).delay(Timer + 100).animate({
					"left": "0",
					opacity: '1'
				}, 600, 'easeOutBack');
			});
		}
	}
	$(window).scroll(news);

	var _imi = $('.News').outerHeight();

	function news1() {
		var Timer = 0;
		var _tr = $('.News').length;
		if(_tr == 0) {
			return;
		}
		var _to = $('.News').offset().top - 350;
		if($(window).scrollTop() >= _to && $(window).scrollTop() < _to + _imi + 400) {
			$('.News').find("dt").children('img').each(function() {
				Timer += 200;
				$(this).delay(Timer + 100).animate({
					"width": "294px",
					"height": '294px',
					opacity: '1'
				}, 600, 'easeOutBack');
			});
		}
	}
	$(window).scroll(news1);

    function scroll() {
        if(window.pageYOffset != null) //  ie9+ 和其他浏览器
        {
            return {
                left: window.pageXOffset,
                top: window.pageYOffset
            }
        } else if(document.compatMode == "CSS1Compat") // 声明的了 DTD
        // 检测是不是怪异模式的浏览器 -- 就是没有 声明<!DOCTYPE html>
        {
            return {
                left: document.documentElement.scrollLeft,
                top: document.documentElement.scrollTop
            }
        }
        return { //  剩下的肯定是怪异模式的
            left: document.body.scrollLeft,
            top: document.body.scrollTop
        }
    }


    //  友情链接
	$('.LinkMain').click(function() {
		$(this).toggleClass('NameActive')
		$(this).siblings().slideToggle();
	})

	// 产品页面滚动
	$('.AMM').click(function(e) {
		e.preventDefault();
		$(this).parent().addClass('active').siblings().removeClass('active')
		$('html,body').animate({
			scrollTop: $('.ProcutDetail').offset().top
		}, 300);
	});
	$('.APP').click(function(e) {
		e.preventDefault();
		$(this).parent().addClass('active').siblings().removeClass('active')
		$('html,body').animate({
			scrollTop: $('.AppMain').offset().top
		}, 300);
	});

	//   问题列表
	$('.PRobelemList').on('click', '.CFList', function() {
		$(this).parent().toggleClass('active').siblings().removeClass('active');
		$(this).siblings('.CXMain').stop().slideToggle().end().parent().siblings().children('.CXMain').stop().slideUp();
	})

	//  资质荣誉点击出现蒙版
	var _ch = document.documentElement.clientHeight;
	var _cw = document.documentElement.clientWidth;
	var _ofr = ''; //记录img地址
	var _txtl = ''; //记录 内容
	var _ins = ''; //记录点击下标
	var _wi = ''; //记录当前图片的真实宽度
	var _hi = ''; //记录 盛放图片盒子的真实高度
	var _inn = $('.ACMain ul li').size() - 1; //当前页面支持最大点击数
	$('.ACMain').on('click', 'li a', function(e) {
		e.preventDefault();
		_ofr = $(this).find('img').attr('src');
		_ins = $(this).parent().index();
		_txtl = $(this).find('dd').html();
		$('.NJMed').stop().fadeIn();
		$('.NJMedPre').find('dt').children('img').attr('src', _ofr);
		_wi = $('.NJMedPre').find('dt').children('img').outerWidth();
		$('.NJMedPre').css('width', _wi + 'px')
		$('.zzpre').animate({
			left: (_cw - _wi - 240) / 2 + 'px'
		}, 300)
		$('.zznex').animate({
			right: (_cw - _wi - 240) / 2 + 'px'
		}, 300)
		$('.NJMedPre').find('dd').html(_txtl);
		_hi = $('.NJMedPre').outerHeight();
		$('.NJMedPre').animate({
			top: (_ch - _hi) / 2 + 'px',
			opacity: '1'
		}, 300)
	})

	$('.zzclo').click(function() {
		$('.NJMedPre').animate({
			top: '0',
			opacity: '0'
		}, 100, function() {
			$('.NJMedPre').find('dt').children('img').attr('src', '');
			$('.NJMedPre').find('dd').html('')
		})
		$('.NJMed').stop().fadeOut();
	})

	function _sliImg() {
		if(_ins == -1) {
			_ins = _inn
		} else if(_ins - 1 == _inn) {
			_ins = 0;
		}
		_ofr = $('.ACMain ul li').eq(_ins).find('img').attr('src');
		_txtl = $('.ACMain ul li').eq(_ins).find('dd').html();
		$('.NJMedPre').find('dt').children('img').attr('src', _ofr);
		$('.NJMedPre').find('dd').html(_txtl);
		_wi = $('.NJMedPre').find('dt').children('img').outerWidth();
		$('.NJMedPre').css('width', _wi + 'px');
		_hi = $('.NJMedPre').outerHeight();
		$('.zzpre').animate({
			left: (_cw - _wi - 240) / 2 + 'px'
		}, 100)
		$('.zznex').animate({
			right: (_cw - _wi - 240) / 2 + 'px'
		}, 100)
		$('.NJMedPre').animate({
			top: (_ch - _hi) / 2 + 'px',
			opacity: '1'
		}, 100)
	}

	$('.zzpre').click(function() {
		_ins--;
		_sliImg();
	})
	$('.zznex').click(function() {
		_ins++
		_sliImg();
	})

	//  点击出现二维码
	$('.WXCon').click(function(e) {
		e.preventDefault();
		$(this).children('.ewmcon').stop().slideToggle();
	})

})

function carousel() {
	var timer = 0;
	var cur = 0; //当前显示的图片下标
	var number = $(".banner ul li").size() - 1; //最大下标
	//下一个
	function slideNext() {
		if(cur < number) {
			$(".banner ul li").eq(cur).css({
				'z-index': 10
			}).stop().fadeOut();
			$(".banner ul li").eq(cur + 1).css({
				'z-index': 20
			}).stop().fadeIn();
			$(".indicator a").removeClass().eq(cur + 1).addClass("cur");
			cur++;
		} else {
			$(".banner ul li").eq(number).css({
				'z-index': 10
			}).stop().fadeOut();
			$(".banner ul li").eq(0).css({
				'z-index': 20
			}).stop().fadeIn();
			$(".indicator a").removeClass().eq(0).addClass("cur");
			cur = 0;
		}
	}
	//上一个
	function slidePrev() {
		if(cur > 0) {
			$(".banner ul li").eq(cur).css({
				'z-index': 10
			}).stop().fadeOut();
			$(".banner ul li").eq(cur - 1).css({
				'z-index': 20
			}).stop().fadeIn();
			$(".indicator a").removeClass().eq(cur - 1).addClass("cur");
			cur--;
		} else {
			$(".banner ul li").eq(cur).css({
				'z-index': 10
			}).stop().fadeOut();
			$(".banner ul li").eq(number).css({
				'z-index': 20
			}).stop().fadeIn();
			$(".indicator a").removeClass().eq(number).addClass("cur");
			cur = number;
		}
	}
	//绑定定时器
	timer = setInterval(slideNext, 5000);
	//当鼠标移入banner区域时，停止自动运行
	$(".banner").mouseover(function() {
		clearInterval(timer);
	});
	$(".banner").mouseout(function() {
		timer = setInterval(slideNext, 5000);
	});
	//左右箭头
	$(".banner .next").click(function() {
		slideNext();
	});
	$(".banner .prev").click(function() {
		slidePrev();
	});
	//小圆点指示器
	$(".indicator a").mouseover(function() {
		var now = $(this).index(); //获得鼠标移入的小圆点的下标
		$(".indicator a").removeClass();
		$(this).addClass("cur");
		$(".banner ul li").eq(cur).css({
			'z-index': 10
		}).stop().fadeOut();
		$(".banner ul li").eq(now).css({
			'z-index': 20
		}).stop().fadeIn();
		cur = now;
	});
}
carousel();

/************************************************************************************************************************************/