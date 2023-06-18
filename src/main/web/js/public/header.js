// 获取用户信息
$(function () {
    let loginbox = document.getElementById('login_r');
    let userbox = document.getElementById('user');
    // 获取用户信息
    function PopulateUserInfo(data) {
        if (data == undefined) {
            userbox.classList.add("user");
            loginbox.classList.remove("login_r");
        } else {
            const { userName, userAvatar = "avatar/default.jpg" } = data;
            userbox.classList.remove("user");
            loginbox.classList.add("login_r");
            document.querySelector("#user a>span").innerHTML = userName;
            document.querySelector("#user a>img").src = `/img/profile/${userAvatar}`;
        }
    }
    $.ajax({
        type: "POST",
        url: "/GetInfo",
        datatype: "json",
        data: {
            type: "getUserInfo"
        },
        success: PopulateUserInfo
    });
});




const script = document.createElement('script');
script.src = "../js/public/util/colorful-tracker.js";
// 加载完成后再调用
script.onload = function () {
    getColorfulTracker(".navitems ul", ["#ff8c00", "#7a6ada", "#b1191a", "#6ada84", "#6a95da", "#1564AF"], 0, 20);
};
document.body.appendChild(script);