/**
 * 拥有彩色变换的nav和tracker
 * @param {String} clickItems 点击项(使用CSS选择器)
 * @param {String} trackerItem tracker项(使用CSS选择器)
 * @param {String[]} colors 导航栏颜色数组，之后会通过colors的length判断导航栏条目数量
 * @param pageIndex 目前导航条所在的索引
 * @param leftOffset 左偏移量设置
 * @param changeBg 是否改变背景色
 * @param {String[]} boxes 区块内容的名称数组(使用CSS选择器)
 * @author OneBumps
 */
const getColorfulTracker = function (clickItems, trackerItem, colors, pageIndex = 0, leftOffset = 0, changeBg = false, changeBlock = []) {
    // 初始化变量
    let index = pageIndex;
    const trackerElement = document.querySelector(trackerItem);
    const clickElements = document.querySelectorAll(clickItems);
    const liElements = document.querySelector(clickItems).parentElement.parentElement.children;
    // 工作函数
    function changeBk() {
        for (let i = 0; i < changeBlock.length; i++) {
            document.querySelector(changeBlock[i]).style.display = "none";
        }
        document.querySelector(changeBlock[index]).style.display = "block";
    }
    function toggleStatus(nowIndex, nowColor) {
        // 设置偏移
        trackerElement.style.left = leftOffset + nowIndex * (+clickElements[0].parentElement.offsetWidth) + "px";
        // 设置变色
        trackerElement.style.backgroundColor = nowColor;
        // 设置点击项变色
        for (let i = 0; i < liElements.length; i++) {
            liElements[i].children[0].style.color = "#000";
        }
        liElements[nowIndex].children[0].style.color = nowColor;
    }
    function clickNav() {
        // 更新索引为当前点击的标签所在的li的索引
        index = Array.from(liElements).indexOf(this.parentElement);
        toggleStatus(index, colors[index]);
        // 设置全局的背景色
        if (changeBg) {
            document.body.style.backgroundColor = colors[index];
        }
        // 设置区块内容
        if (changeBlock.length > 0) changeBk();
    }
    function enterNav() {
        let tempIndex = Array.from(liElements).indexOf(this.parentElement);
        toggleStatus(tempIndex, colors[tempIndex]);
    }
    function leaveNav() {
        toggleStatus(index, colors[index]);
    }
    // 设置事件
    clickElements.forEach(function (element) {
        element.addEventListener("click", clickNav);
        element.addEventListener("mouseenter", enterNav);
    });
    clickElements[0].parentElement.parentElement.addEventListener("mouseleave", leaveNav);
    // 初始化界面
    toggleStatus(index, colors[index]);
    // 设置全局的背景色
    if (changeBg) {
        document.body.style.backgroundColor = colors[index];
    }
    // 设置区块内容
    if (changeBlock.length > 0) changeBk();
};