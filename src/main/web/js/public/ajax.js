var httpRequest = null; //定义XMLHttpRequest对象
//创建XMLHttpRequest对象
function createXHR() {
    var httpRequest = new XMLHttpRequest();
    if (!httpRequest) {
        console.log("创建httpRequest失败");
    }
}


/**
 * 使用XMLHttpRequest发送客户端的请求
 * @param {String} url 设置要连接的URL，建立到服务器的连接并执行
 * @param params 从Web表单中获取需要发送的数据集合
 * @param method 设置请求的类型，GET或POST，默认为POST
 * @param {Function} handler 指定的响应函数（服务器在完成后要运行的回调函数）
 */
function sendRequest(url, params, method = "POST", handler) {
    createXHR();
    if (!httpRequest) return false;
    httpRequest.onreadystatechange = handler;
    if (method === "GET") {
        httpRequest.open(method, url + '?' + params, true);
        httpRequest.send(null);
    }
    if (method === "POST") {
        httpRequest.open(method, url, true);
        httpRequest.setRequestHeader("Content-type",
            "application/x-www-form-urlencoded");
        httpRequest.send(params);
    }
}