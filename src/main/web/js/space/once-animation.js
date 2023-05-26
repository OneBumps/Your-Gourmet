/**
 * 使用LocalStorage实现页面只加载一次动画
 * 1. 判断是否是第一次加载
 * 2. 如果是第一次加载，显示动画
 * 3. 如果不是第一次加载，直接显示页面
 */
(function () {
    let oStorage = window.localStorage;
    let isFirstAnimation = oStorage.getItem('isFirstAnimation');
    if (isFirstAnimation == null) {
        oStorage.setItem('isFirstAnimation', 'false');
        document.getElementsByClassName("wrapper")[0].classList.add("wrapperAnimation");
    }
})();