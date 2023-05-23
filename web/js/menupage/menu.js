function changeImgs(){
    var image = [
        "../../img/icon/menupage/viewing(1).png",
        "../../img/icon/menupage/thumb(1).png",
        "../../img/icon/menupage/collect(1).png",
        "../../img/icon/menupage/remark(1).png"
    ]

    var img1 = document.getElementById("img1");
    var img2 = document.getElementById("img2");
    var img3 = document.getElementById("img3");
    var img4 = document.getElementById("img4");

    img1.src = image[0];
    img2.src = image[1];
    img3.src = image[2];
    img4.src = image[3];
}
alert("nihao ");