/**
 *鍥炲埌椤堕儴js
 * @authors Your Name (you@example.org)
 * @date    2015-02-09 15:31:22
 * @version $Id$
 */
window.onload = function () {
	var obtn = document.getElementById('btn');
	//鑾峰彇鐣岄潰鍙鍖哄煙楂樺害
	var cHeight = document.documentElement.clientHeight || document.body.clientHeight;
	var timer = null;
	var isTop = true;
	//婊氬姩鏉℃粴鍔ㄦ椂鍋滄
	window.onscroll = function() {
		var osTop = document.documentElement.scrollTop || document.body.scrollTop;
		if(osTop >= cHeight) {
			obtn.style.display = 'block';
		}else {
			obtn.style.display = 'none';
		}
		if(!isTop) {
			clearInterval(timer);
		}
		isTop = false;
	}
	obtn.onclick = function() {
		//璁剧疆瀹氭椂鍣�
		timer = setInterval(function() {
			//鑾峰彇婊氬姩鏉¤窛绂婚《閮ㄩ珮搴�
			var osTop = document.documentElement.scrollTop || document.body.scrollTop;
			var ispeed = Math.floor(-osTop / 6);
			document.documentElement.scrollTop = document.body.scrollTop = osTop + ispeed;
			isTop = true;
			if (osTop == 0) {
				clearInterval(timer);
			}
		},30)
	}
}