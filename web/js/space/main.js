//jQuery - 点击鼠标后二级导航栏切换颜色和位置
$(".subnav-list a").click(function () {
    // 获取当前点击的a标签所在的li的索引
    var index = $(this).parent().index();
    // 根据索引计算nav-tracker的偏移量
    var offset = index * 105;
    $("#nav-tracker").css("left", offset + 20 + "px");
    // 设置nav-tracker的背景颜色为当前点击的a标签的颜色
    var color = $(this).css("color");
    $("#nav-tracker").css("background-color", color);
    //设置全局背景色为当前点击的a标签的颜色
    $("body").css("background-color", color);
});
$("")