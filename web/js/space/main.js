/**
 * 用于space页面的js
 * 依赖于/js/util/ajax.js
 */

document.write("<script src='/js/util/ajax.js'></script>");

function getPage_Summary() {
    sendRequest("/space/summary", "", "POST", function () {
        if (httpRequest.readyState === 4) {
            if (httpRequest.status === 200) {
                document.getElementById("content").innerHTML = httpRequest.responseText;
            }
        }
    });
}

document.getElementById("nav-summary").addEventListener("click", getPage_Summary);
document.getElementById("nav-menu")
document.getElementById("nav-data")