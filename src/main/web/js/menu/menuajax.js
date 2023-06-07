$.ajax({
    type: "POST",
    url: "",
    datatype: "json",
    data: {
        type: "getMenuMessage",
        userId: ""
    },
    success: function (event) {
        if (event == true) {
            var dish_name = document.getElementById("dishname");
            var ingredients = document.getElementById("materials");
            dish_name.innerHTML = event.name;
            ingredients.innerHTML = event.materials;

            //遍历服务器返回的数据数组
            $.each(event, function (index, value) {
                /**
                 * //根据索引找到对应的span元素，用步骤内容替换它的内容
                $("ul.steps li:eq(" + index + ") span").html(value.content);
                //根据索引找到对应的电话号码span元素，用电话号码替换它的内容
                $("ul.steps li:eq(" + index + ") span.phone").html(value.phone);
                 */

                for(var i = 0; index < 6; i++){
                    $("li.steps > span").text(index);
                }
            });
        }
    }
});
/**
 * 菜名：name(string)=""
 * 菜品用料：materials(string)=""
 * 
*/