function changeImgs(){
	alert("hello");
	var img1 = document.getElementById("img1");
	var imgSrc = "../../img/icon/menupage/viewing.png";
	if(img1.src == imgSrc){
		img1.src = "../../img/icon/menupage/viewing(1).png";
	}
	else{
		img1.src = imgSrc;
	}
}