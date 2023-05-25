// 设置菜单项显隐性
// 点按编辑按钮的效果
document.getElementsByClassName("edit-manage")[0].addEventListener("click", function () {
    if (this.innerHTML == "编辑") {
        this.innerHTML = "取消收藏";
        this.nextElementSibling.style.display = "block";
    } else {
        this.innerHTML = "编辑";
        this.nextElementSibling.style.display = "none";
        console.log(this.nextElementSibling.style.display = "none");
    }
});
// 全选/反选
document.getElementsByClassName("select-all-manage")[0].addEventListener("click", function () {
    var selects = $(".list-box a");
    if (this.innerHTML == "全选") {
        selects.addClass("selected-item");
        this.innerHTML = "取消全选";
    } else {
        selects.removeClass("selected-item");
        this.innerHTML = "全选";
    }
});