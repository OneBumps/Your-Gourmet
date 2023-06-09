// 获取元素
const canvas = document.getElementById("canvas");
const block = document.getElementById("block");
const button = document.getElementById("button");
const tip = document.getElementById("tip");

// 获取画笔
const ctx = canvas.getContext("2d");
const btx = block.getContext("2d");

// 设置画布大小
canvas.width = 320;
canvas.height = 160;

// 定义变量
let isDown = false; // 是否按下鼠标或触摸
let startX = 0; // 按下时的横坐标
let distance = 0; // 滑动的距离
let x = 0; // 凹槽的横坐标
let y = 0; // 凹槽的纵坐标
let w = 40; // 凹槽的宽度
let r = w / 4; // 凹槽的半径

// 定义图片
const img = new Image();
img.src = "https://picsum.photos/320/160";
img.onload = function () {
    draw();
};

// 绘制画布
function draw() {
    // 清空画布
    ctx.clearRect(0, 0, canvas.width, canvas.height);
    btx.clearRect(0, 0, block.width, block.height);

    // 绘制背景图
    ctx.drawImage(img, 0, 0, canvas.width, canvas.height);

    // 随机生成凹槽的位置
    x = Math.floor(canvas.width / 2 + Math.random() * (canvas.width / 2 - w));
    y = Math.floor(30 + Math.random() * (canvas.height - w - 30));

    // 绘制凹槽
    drawClip(ctx, "fill");
    drawClip(btx, "clip");

    // 裁剪凹槽
    const imageData = btx.getImageData(x, y - 2 * r, w, w + 1);
    block.width = w;
    block.height = w + 1;
    btx.putImageData(imageData, 0, y - 2 * r);
}

// 绘制凹槽
function drawClip(ctx, operation) {
    ctx.beginPath();
    ctx.moveTo(x, y);
    ctx.arc(x + w / 2, y - r + 2, r, 0.72 * Math.PI, 2.26 * Math.PI);
    ctx.lineTo(x + w, y);
    ctx.arc(x + w / 2, y + w + r - 2, r, -0.26 * Math.PI, 1.26 * Math.PI);
    ctx.lineTo(x, y + w);
    ctx.lineWidth = 2;
    ctx.fillStyle = "rgba(255,255,255,0.7)";
    ctx.strokeStyle = "rgba(255,255,255,0.7)";
    ctx.stroke();
    ctx[operation]();
    ctx.globalCompositeOperation = "xor";
}

// 添加事件监听
button.addEventListener("mousedown", handleStart);
button.addEventListener("mousemove", handleMove);
button.addEventListener("mouseup", handleEnd);
button.addEventListener("mouseleave", handleEnd);

button.addEventListener("touchstart", handleStart);
button.addEventListener("touchmove", handleMove);
button.addEventListener("touchend", handleEnd);

// 处理开始滑动
function handleStart(e) {
    e.preventDefault();
    isDown = true;
    startX = e.clientX || e.touches[0].clientX;
}

// 处理滑动过程
function handleMove(e) {
    e.preventDefault();
    if (!isDown) return false;
    const moveX = e.clientX || e.touches[0].clientX;
    distance = moveX - startX;

    // 边界处理
    if (distance < 0) {
        distance = 0;
    } else if (distance > canvas.width - w) {
        distance = canvas.width - w;
    }

    // 移动滑块
    button.style.left = distance + "px";
    block.style.left = distance + "px";

    requestAnimationFrame(handleMove);
}

// 处理滑动结束
function handleEnd(e) {
    e.preventDefault();

    // 判断是否验证成功
    if (Math.abs(distance - x) < 5) {
        // 验证成功
        tip.innerHTML = "验证成功";
        button.innerHTML = "√";
        button.className = "slider-button success";
        // 移除事件监听
        button.removeEventListener("mousedown", handleStart);
        button.removeEventListener("mousemove", handleMove);
        button.removeEventListener("mouseup", handleEnd);
        button.removeEventListener("mouseleave", handleEnd);

        button.removeEventListener("touchstart", handleStart);
        button.removeEventListener("touchmove", handleMove);
        button.removeEventListener("touchend", handleEnd);

    } else {
        // 验证失败
        tip.innerHTML = "验证失败";
        button.innerHTML = "x";
        button.className = "slider-button fail";

        // 复位滑块
        setTimeout(function () {
            distance = 0;
            button.style.left = distance + "px";
            block.style.left = distance + "px";
            tip.innerHTML = "向右滑动完成验证";
            button.innerHTML = "&gt;";
            button.className = "slider-button";
        }, 1000);

        // 刷新画布
        draw();
    }
    isDown = false;
}