// 设置基准浮标和颜色
var index = 0;
var colors = ["#ff8c00", "#7a6ada", "#b1191a", "#6ada84", "#6a95da", "#1564AF"];
var box_name = ["#collection", "#my-menu"];
var color = colors[0];

function toggleAnimation(now_index, now_color) {
    //设置偏移
    $("#public_nav-tracker").css("left", now_index * 150 + 20 + "px");
    // 设置nav-tracker的背景颜色为当前点击的a标签的颜色
    $("#public_nav-tracker").css("background-color", now_color);
    // 设置a标签变色
    $(".navitems a").css("color", now_color);
    $($(".navitems a").parent()[now_index]).siblings().children().css("color", "#000");
}

$(".navitems li a").click(function () {
    // 更新索引为当前点击的a标签所在的li的索引
    index = $(this).parent().index();
    // 更新当前点击的a标签所在的li的颜色
    color = colors[index];
    // 设置切换动画
    toggleAnimation(index, color);
});

$(".navitems li a").hover(
    function () {
        // 获取当前点击的a标签所在的li的索引
        var hover_index = $(this).parent().index();
        // 获取当前点击的a标签所在的li的颜色
        var hover_color = colors[hover_index];
        // 设置切换动画
        toggleAnimation(hover_index, hover_color);
    },
    function () {
        toggleAnimation(index, color);
    });

$(".navitems li a").mouseleave(function () {
    toggleAnimation(index, color);
});

$(document).ready(function () {
    // 设置切换动画
    toggleAnimation(index, color);
}
);