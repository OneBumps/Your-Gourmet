$(function(){
    var menu_arr = 
    ['蛋花丝瓜汤', '混沌', '海蜇汤菜', '三色鲜贝', '夹馅黄瓜', 
    '萝卜丝糕', '熘黄瓜', '榴莲鱼丁', '香菇烧茭白', '纯菜汤'];
    var menu_id=[1,2,3,4,5,6,7,8,9,10];
    var name_arr=document.getElementsByClassName('menu_name');
    var id_arr=document.getElementsByClassName('menu-id');
    for(var i=0;i<name_arr.length;i++){
        name_arr[i].innerHTML=menu_arr[i];
    }
    for(var i=0;i<name_arr.length;i++){
        id_arr[i].href="html/menu.html?id="+menu_id[i];
    }
})