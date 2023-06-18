$(function searchtext(){
    var urlParams= new URLSearchParams(window.location.search);
    var searchValue=urlParams.get('search');
    var searchInput= document.getElementById('search-input');
    
    searchInput.value=searchValue;
    searchmenu();
});

function searchmenu(){
    var c_name=document.getElementsByClassName('cuisines');
    var r_image=document.getElementsByClassName('recipe_image');
    var r_name=document.getElementsByClassName('menu_title');
    var r_introduction=document.getElementsByClassName('recipe_introduction');
    $.ajax({
        type: "get",
        url:"",
        datatype: "json",
        data:{
            type:"searchmenu",
        },
       success:function(data){
        console.log(data);
            for(var i=0;i<c_name.length;i++){
                c_name[i].innerHTML=data[i][0];
            }
            for(var i=0;i<r_image.length;i++){
                r_image[i].src=data[i][1];
            }
            for(var i=0;i<r_name.length;i++){
                r_name[i].innerHTML=data[i][2];
            }
            for(var i=0;i<r_introduction.length;i++){
                r_introduction[i].innerHTML=data[i][3]
            }
       }
    })
   
}

