$(function searchtext() {
    var urlParams = new URLSearchParams(window.location.search);
    var searchValue = urlParams.get('search');
    var searchInput = document.getElementById('search-input');

    searchInput.value = searchValue;
    // searchmenu(searchValue);
});
document.querySelector('.s_i_b button').addEventListener('click', function (e) {
    e.preventDefault();
    var searchInput = document.getElementById('search-input');
    var searchValue = searchInput.value;
    searchmenu(searchValue);
});


function searchmenu(searchValue) {
    var c_name = document.getElementsByClassName('cuisines');
    var r_image = document.getElementsByClassName('recipe_image');
    var r_name = document.getElementsByClassName('menu_title');
    var r_introduction = document.getElementsByClassName('recipe_introduction');
    $.ajax({
        type: "get",
        url: "/Search",
        datatype: "json",
        data: {
            type: "start",
            search: searchValue
        },
        success: function (data) {
            console.log(data.length);
            document.querySelector('.list ul').innerHTML = '';
            for (var i = 0; i < data.length; i++) {
                document.querySelector('.list ul').innerHTML += `
                    <li>
                        <a href="../../html/menu.html?id=${data[i].pk_recipe_id}">
                            <img src="../img/logo.png" alt="菜谱图片" class="recipe_image">
                            <div class="list-info">
                                <h2 class="menu_title " ></h2>&nbsp;&nbsp;&nbsp;&nbsp;<span class="cuisines" ></span>
                                <p class="recipe_introduction">
                                </p>
                            </div>
                        </a>
                    </li>
                `;
            }
            for (var i = 0; i < c_name.length; i++) {
                if (data[i] == null || data[i].cuisine_name == null) break;
                c_name[i].innerHTML = data[i].cuisine_name;
            }
            for (var i = 0; i < r_image.length; i++) {
                if (data[i] == null || data[i].recipe_image == null) break;
                r_image[i].src = data[i].recipe_image;
            }
            for (var i = 0; i < r_name.length; i++) {
                if (data[i] == null || data[i].recipe_name == null) break;
                r_name[i].innerHTML = data[i].recipe_name;
            }
            for (var i = 0; i < r_introduction.length; i++) {
                if (data[i] == null || data[i].recipe_introduction == null) break;
                r_introduction[i].innerHTML = data[i].recipe_introduction;
            }
        }
    })

}

