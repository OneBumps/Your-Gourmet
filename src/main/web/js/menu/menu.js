function changeImgs() {
	alert("hello");
	var img1 = document.getElementById("img1");
	var imgSrc = "../../img/icon/menupage/viewing.png";
	if (img1.src == imgSrc) {
		img1.src = "../../img/icon/menupage/viewing(1).png";
	}
	else {
		img1.src = imgSrc;
	}
}

//1创建变量存放对象
var xmlHttpRequest;
//浏览器兼容创建对象
function createXMLHttpRequest() {
	if (window.ActiveXObject()) {
		xmlHttpRequest = new ActiveXObject("Microsoft.XMLHTTP");
	} else if (window.ActiveXObject) {
		xmlHttpRequest = new XMLHttpRequest();
	}
}
function get() {
	var xhr = new XMLHttpRequest();
	xhr.open("GET",'url',true);
	xhr.responseType = 'blob';
	xhr.onload = function(event) {
		if(this.status ===200) {
			var url = window.URL.createObjectURL(this.response);
			var img = new Image();
			img.src = url;
			
		}
	};
}
// //2与服务器建立连接,创建HTTP请求
// function getData() {
// 	var xhr = new XMLHttpRequest();
// 	if (xhr != null) {
// 		xhr.open("POST", URL, true);
// 		xhr.responseType = 'blob';
// 		//HTTP请求状态变化处理
// 		xhr.onreadystatechange = httpStateChange;
// 		xhr.send();
// 	}
// }
// //3设置响应HTTP请求状态变化的函数
// function httpStateChange() {
// 	//判断异步调用是否成功,若成功开始局部更新数据
// 	if (xmlHttpRequest.readyState == 4) {
// 		if (xmlHttpRequest.status == 200) {
// 			//获取节点以更新数据
// 			node.innerText = xmlHttpRequest.responseType + ": " + xmlHttpRequest.responseText;//更新数据
// 		} else {//如果异步调用未成功,弹出警告框,并显示出错信息
// 			alert("error:HTTP状态码为:" + xmlHttpRequest.status + ",HTTP状态信息为:" + xmlHttpRequest.statusText);
// 		}
// 	}
// }

// //设置句柄
// xmlHttpRequest.setRequestHeader("Content-type", "application/x-www-form-urlencoded");

