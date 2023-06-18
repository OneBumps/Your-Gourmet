let searchParams = new URLSearchParams(window.location.search);
$.ajax({
    type: "GET",
    url: "/recipe",
    datatype: "json",
    data: {
        type: "getMenuMessage",
        id: searchParams.get('id')
    },
    success: function (event) {
        if (event == true) {
            var dish_name = document.getElementById("dish_name");
            var ingredients = document.getElementById("materials");
            dish_name.innerHTML = event.name;
            ingredients.innerHTML = event.materials;

            // var dish_name = $("#dish_name");
            // var materials = $("#materials");
            // dish_name.html(event.name);
            // materials.html(event.materials);

            //定义基础的步骤span个数
            var basic_count = 4;
            //获取步骤数组中有几个数据（对应有几个span步骤）
            var counts = event.steps.length;

            if (counts == basic_count) {
                //为span元素设置返回数据数组的相应数据
                $("span").each(function (index) {
                    $(this).html(event.steps[index]);
                });
            } else {
                //增加span元素
                for (var i = 0; i < counts - basic_count; i++) {
                    var newElement = "<li><h4>步骤四</h4> <div><img src=\"../img/icon/menupage/dishexm.png\" alt=\"\"><span>步骤四内容</span></div></li>";
                    $("#steps").append(newElement);
                }

                //为span元素设置返回数据数组的相应数据
                $("span").each(function (index) {
                    $(this).html(event.steps[index]);
                });
            }
        }
    }
});
/**
 * 菜名：name(string)=""
 * 菜品用料：materials(string)=""
*/