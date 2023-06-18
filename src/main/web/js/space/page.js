// 彩色导航栏
getColorfulTracker(".sub-nav ul", ["#ff8c00", "#7a6ada"], 0, 0, true, ["#collection", "#my-menu"]);
getColorfulTracker(".navitems ul", ["#ff8c00", "#7a6ada", "#b1191a", "#6ada84", "#6a95da", "#1564AF"], 0, 20);

// 获取用户信息
(function () {
  function PopulateUserInfo(data) {
    const { userName, userAvatar = "avatar/default.jpg" } = data;
    document.querySelector("#username").innerHTML = userName;
    document.querySelector(".avatar img").src = `/img/profile/${userAvatar}`;
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
})();


// 获取位置信息
(function() {
  let loc = document.querySelector("#location");
  if(localStorage.getItem('province') && localStorage.getItem('city')){
    loc.innerHTML = localStorage.getItem('province') + ' ' + localStorage.getItem('city');
  }else{
    loc.innerHTML = '未知';
  }
})();

// 发布菜谱
document.querySelector("#releaseMenu").addEventListener("click", function () {
  window.location.href = "../../html/release-menu.html";
});