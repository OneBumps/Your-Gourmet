// 设置基准浮标和颜色
var index = 0;
var colors = ["#ff8c00", "#7a6ada"];
var color = colors[0];

// 点击二级导航栏切换
function toggleAnimation(now_index, now_color) {
    //设置偏移
    $("#nav-tracker").css("left", now_index * 105 + 20 + "px");
    // 设置nav-tracker的背景颜色为当前点击的a标签的颜色
    $("#nav-tracker").css("background-color", now_color);
}

// 区块内容改变
function changeBlock(index) {
    switch (index) {
        case 0:
            $("#collection").css("display", "block");
            $("#mymenu").css("display", "none");
            break;
        case 1:
            $("#collection").css("display", "none");
            $("#mymenu").css("display", "block");
            break;
    }
}
$(".subnav-list a").click(function () {
    // 更新索引为当前点击的a标签所在的li的索引
    index = $(this).parent().index();
    // 更新当前点击的a标签所在的li的颜色
    color = colors[index];
    // 设置切换动画
    toggleAnimation(index, color);
    // 设置全局的背景色
    $("body").css("background-color", color);
    // 区块内容改变
    changeBlock(index);
});

$(".subnav-list a").hover(function () {
    // 获取当前点击的a标签所在的li的索引
    var hover_index = $(this).parent().index();
    // 获取当前点击的a标签所在的li的颜色
    var hover_color = colors[hover_index];
    // 设置切换动画
    toggleAnimation(hover_index, hover_color);
});

// 鼠标离开便恢复原样
$(".subnav-list a").mouseleave(function () {
    toggleAnimation(index, color);
});

// wrapper动画设置
$(document).ready(function () {
    // slide up from the bottom when the page is ready
    $("#wrapper").animate({ top: 0 }, "slow");
    $("#wrapper").css("position", "absolute");
    $("#mymenu").css("display", "none");
});