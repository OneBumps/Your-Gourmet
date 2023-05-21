var httpRequest = null; //定义XMLHttpRequest对象
//创建XMLHttpRequest对象
function createXHR() {
    var httpRequest = new XMLHttpRequest();
    if (!httpRequest) {
        console.log("创建httpRequest失败");
    }
}


//发送客户端的请求，该方法有4个参数，
//参数url设置要连接的URL，建立到服务器的连接并执行
//参数params为从Web表单中获取需要发送的数据集合
//参数method取值为POST或GET
//参数handler为指定的响应函数（服务器在完成后要运行的回调函数）
function sendRequest(url, params, method, handler) {
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