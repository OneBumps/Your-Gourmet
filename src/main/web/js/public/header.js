const script = document.createElement('script');
script.src = "../js/public/util/colorful-tracker.js";
// 加载完成后再调用
script.onload = function () {
    getColorfulTracker(".navitems a", "#public_nav-tracker", ["#ff8c00", "#7a6ada", "#b1191a", "#6ada84", "#6a95da", "#1564AF"], 0, 20);
};
document.body.appendChild(script);