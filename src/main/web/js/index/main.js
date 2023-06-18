
$(function () {
    let oImgList = document.getElementById('list');
    let clonefirstImg = oImgList.firstElementChild.cloneNode();
    oImgList.appendChild(clonefirstImg);
    let index = 0;
    function handleRightBtn() {
        index++;
        oImgList.style.left = index * -985 + "px";
        oImgList.style.transition = "0.5s ease";
        if (index === 5) {
            index = 0;
            setTimeout(() => {
                oImgList.style.left = 0;
                // 取消过渡，500毫秒过后切换第一张
                oImgList.style.transition = "none";
            }, 500);
        }
        setCircles();
    }
    const circles = document.querySelectorAll(".bn1");

    // 小圆点高亮的显示
    function setCircles() {
        for (let i = 0; i < circles.length; i++) {
            // console.log(circles[i]);
            if (i === index) {
                circles[i].classList.add("active");
            } else {
                circles[i].classList.remove("active");
            }
        }
    };

    const oCircle = document.getElementById("circle-list");
    oCircle.addEventListener("mouseover", function (e) {
        // 当我点击小圆点的时候
        // console.dir(e.target)获取节点信息
        if (e.target.nodeName.toLowerCase() == "li") {
            // 当前元素的data-n对应的值和index一一对应
            const n = Number(e.target.getAttribute("data-n"));
            index = n;
            // 设置小圆点的高亮
            setCircles();
            oImgList.style.left = index * -985 + "px";
        }
    });
    let autoplay = setInterval(handleRightBtn, 2500);
    const oWrap = document.getElementById("list");
    oWrap.addEventListener("mouseenter", function () {
        clearInterval(autoplay);
    });
    oWrap.addEventListener("mouseleave", function () {
        clearInterval(autoplay);
        autoplay = setInterval(handleRightBtn, 2500);
    });
    const oWrap2 = document.getElementById("circle-list");
    oWrap2.addEventListener("mouseenter", function () {
        clearInterval(autoplay);
    });
    oWrap2.addEventListener("mouseleave", function () {

        clearInterval(autoplay);
        autoplay = setInterval(handleRightBtn, 2500);
    });
});


