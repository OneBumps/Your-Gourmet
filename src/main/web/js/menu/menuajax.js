let searchParams = new URLSearchParams(window.location.search);
$.ajax({
    type: "GET",
    url: "/recipe",
    dataType: "json",
    data: {
        type: "getMenuMessage",
        id: searchParams.get('id')
    },
    success: function (event) {
        if (event != "null") {
            console.log(event)
            console.log(event.recipeIntroduction)
            $("#description").html(event.recipeIntroduction);
            $("#publishTime").html(event.recipePublishTime);
            $("#hot").html(event.recipeLike - event.recipeDislike);
            $("#author").html(event.userId);
            $("#dish_name").html(event.recipeName);

            // var steps = event.steps;
            // //使用each()函数遍历数组
            // $.each(steps, function (index, element) {

            //     var html = '<li><h4>步骤${element.stepNumber}</h4><div><img src="../img/icon/menupage/dishexm.png" alt=""><span id="step${element.stepNumber}">${element.stepDescription}</span></div></li>'
            //     $("#steps").append(html);
            //     // // 根据元素中的步骤编号，找到对应的span标签
            //     // var span =$("#step"+element.stepNumber);
            //     // // 将span标签的内容修改为元素中的步骤描述
            //     // span.text(element.stepDescription);
            // });
            //步骤
            for (var i = 0; i < event.steps.length; i++) {
                var stepNumber = event.steps[i].stepNumber;
                var stepDescription = event.steps[i].stepDescription;
            
                $("#step" + stepNumber).text(stepDescription);
                $("h4:nth-child(" + (i+1) + ")").html("步骤" + stepNumber);
            }

            //菜品用料
            var ingredients = "";
            for (var i = 0; i < event.ingredient.length; i++) {
                ingredients += event.ingredient[i].ingredient_name + "：" + event.ingredient[i].ingredient_amount + "<br>";
            }

            $("#materials").html(ingredients);
        }
    }
});

// $.getJSON("../../../../test/", {type: "getMenuMessage", userId: ""}, function (event) {
//     if (event == true) {
//         // 使用html()方法修改网页元素的内容
//         $("#dish_name").html(event.recipeName);
//         $("#materials").html(event.recipeMaterial);

//         var steps = event.steps;
//         // 使用each()方法遍历数组
//         $.each(steps,function(index,element){
//             // 使用模板字符串拼接HTML代码
//             var html = `<li>
//                             <span id="step${element.stepNumber}">${element.stepDescription}</span>
//                         </li>`;
//             // 将HTML代码追加到ul元素中
//             $("#steps").append(html);
//         });
//     }
// });