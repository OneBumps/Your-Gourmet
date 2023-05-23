// 设置基准浮标和颜色
var index = 0;
var colors = ["#ff8c00", "#7a6ada"];
var box_name = ["#collection", "#my-menu"];
var color = colors[0];

// 点击二级导航栏切换
function toggleAnimation(now_index, now_color) {
    //设置偏移
    $(".nav-tracker").css("left", now_index * 100 + "px");
    // 设置nav-tracker的背景颜色为当前点击的a标签的颜色
    $(".nav-tracker").css("background-color", now_color);
    // 设置a标签变色
    $(".sub-nav a").css("color", now_color);
    $($(".sub-nav a").parent()[now_index]).siblings().children().css("color", "#000");
}

// 区块内容改变
function changeBlock(now_index) {
    if (now_index != undefined) {
        for (var i = 0; i < box_name.length; i++) {
            $(box_name[i]).css("display", "none");
        }
        $(box_name[now_index]).css("display", "block");
    }
    //重置选项栏样式
    
}

$(".sub-nav a").click(function () {
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

$(".sub-nav a").hover(
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

$(document).ready(function () {
    // 设置切换动画
    toggleAnimation(index, color);
    // 设置全局的背景色
    $("body").css("background-color", color);
    // 区块内容改变
    changeBlock();
}
);