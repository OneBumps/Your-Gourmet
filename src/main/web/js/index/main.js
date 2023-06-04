
var bn1=document.getElementById("bn1");
bn1.addEventListener(onmousemove,check(),false);
function check(){
    var pic=document.getElementById("list");
    pic.style.left='400px';
    
}
var video = document.getElementById('#qqq');
//console.log(video); //通过打印拿到所有的属性和方法
video[0]['disablePictureInPicture'] = true; //