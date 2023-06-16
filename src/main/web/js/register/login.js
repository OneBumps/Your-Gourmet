
function submitForm(event) {
    event.preventDefault(); // 阻止表单提交的默认行为
   
    var username = document.getElementById("user_name").value;
    var password = document.getElementById("user_password").value;
  
    // 检查用户名和密码是否为空
    if (username === "") {
      showErrorMessage("用户名不能为空!");
      return;
    }
    if (password === "") {
      showErrorMessage("密码不能为空!");
      return;
    }

    
    $.ajax({
      type: "post",
    
      url: "http://localhost/YourGourmet/login",
      datatype: "json",
      data: {
        type: "login",
        username: username ,
        password: password
      },
      success: function(res){
        console.log(res);
        if(res.code===200){
          alert("登录成功！");
        }else {
            showErrorMessage("用户名或密码不正确!");
        }
      } 
    });
    // if (username === "username" && password === "password") {
    //     // 登录成功
    //     alert("登录成功！");
    //   } else {
    //     showErrorMessage("用户名或密码不正确!");
    //   }
    // }
    // if (event) {
    //     // 登录成功
    //     alert("登录成功！");
    //   } else {
    //     showErrorMessage("用户名或密码不正确!");
    //   }
}
    function showErrorMessage(message) {
      var errorMessage = document.getElementById("errorMessage");
      errorMessage.textContent = message;
}
    
   
    
    
    
    
    