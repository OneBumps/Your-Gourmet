// 电梯导航(立即执行)

// 显示用户信息
localStorage.setItem("userName", "张三");
let userName = localStorage.getItem("userName");
document.querySelector(".base-info #username").innerHTML = userName;
$.ajax({
  type: "POST",
  url: "http://localhost/YourGourmet/Verify",
  datatype: "json",
  data: {
    type: "getUserInfo",
    userId: localStorage.getItem("userId")
  },
  success: function (data) {
    console.log(data);
  }
});

// 修改密码
document.querySelector(".password button").addEventListener('click', function () {
  let oldPassword = document.querySelector(".password input[name='oldPassword']").value;
  let newPassword = document.querySelector(".password input[name='newPassword']").value;
  let verify = document.querySelector(".password input[name='verify']").value;
  if (oldPassword == "" || newPassword == "" || verify == "") {
    document.querySelector(".password .err").innerHTML = "输入框不能为空";
    return;
  }
  if (newPassword != verify) {
    document.querySelector(".password .err").innerHTML = "两次密码不一致";
    return;
  }
  if (oldPassword == newPassword) {
    document.querySelector(".password .err").innerHTML = "新旧密码不能相同";
    return;
  }
  if (newPassword.length < 6 || verify.length > 14) {
    document.querySelector(".password .err").innerHTML = "密码长度应在6-14位之间";
    return;
  }
  //获取userId
  let userId = localStorage.getItem("userId");

  // 发送AJAX请求
  $.ajax({
    type: "POST",
    url: "http://localhost/YourGourmet/Verify",
    data: {
      type: "updatePassword",
      userId: userId,
      oldPassword: oldPassword,
      newPassword: newPassword
    },
    success: function (checkPassword) {
      console.log(checkPassword);
      if (checkPassword == true) {
        document.querySelector(".password .err").innerHTML = "修改成功";
        setTimeout(() => {
          location.reload();
        }, 3000);
      } else {
        document.querySelector(".password .err").innerHTML = "修改失败，请检查原密码是否正确";
      }
    }
  });
});

