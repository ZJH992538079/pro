
$(function() {
	/* 使主要内容区高度充满整个容器 */
	(function() {
		var
			// 待设置高度的元素
			mybody = $("#mybody"),
			// 其他元素的高度
			otherHeight = 50,
			// body内容的高度
			bodyHeight = document.body.scrollHeight;
		
		// 屏幕可见区域高度 - 其他元素的高度
		mybody.css("height", $(window).height() - otherHeight + "px");
		window.onresize = function() {
			mybody.css("height", $(window).height() - otherHeight + "px");
		}
	})();

});
