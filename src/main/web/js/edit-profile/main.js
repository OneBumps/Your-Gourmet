// 电梯导航(立即执行)

// 显示用户信息(立即执行)
(function () {
  localStorage.setItem("userId", "e5114a96020e11eebd064ccc6a7eb102");
  localStorage.setItem("userName", "小明");
  function PopulateUserInfo(data) {
    const { userName, userPhone, userGender = '未知', userGroup, userEmail = '未知', userIntroduction = '你还没有介绍你自己呢' } = data;
    document.querySelector(".base-info table tbody").innerHTML = `
    <tr>
    <td>${userName}</td>
    <td>${userPhone}</td>
    <td>${userGender}</td>
    <td>${userGroup}</td>
    <td>${userEmail}</td>
  </tr>
    `;
    document.querySelector(".base-info #introduction").innerHTML = `
      个人简介如下：<br>
      <textarea readonly>${userIntroduction}</textarea>
    `;
  }
  $.ajax({
    type: "POST",
    url: "http://localhost/YourGourmet/GetInfo",
    datatype: "json",
    data: {
      type: "getUserInfo",
      userId: localStorage.getItem("userId")
    },
    success: PopulateUserInfo
  });
})();

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

// 修改用户信息
document.querySelector("form[name='changeInfo'] button").addEventListener('click', function () {
  // e.preventDefault();
  let userName = document.querySelector("form[name='changeInfo'] input[name='userName']").value;
  let userNameErr = document.querySelector("form[name='changeInfo'] input[name='userName']+.err ");
  let userPhone = document.querySelector("form[name='changeInfo'] input[name='userPhone']").value;
  let userPhoneErr = document.querySelector("form[name='changeInfo'] input[name='userPhone']+.err");
  let userEmail = document.querySelector("form[name='changeInfo'] input[name='userEmail']").value;
  let userEmailErr = document.querySelector("form[name='changeInfo'] input[name='userEmail']+.err");
  let userGender = document.querySelector("form[name='changeInfo'] input[name='userGender']:checked").value;
  let userIntroduction = document.querySelector("form[name='changeInfo'] textarea[name='userIntroduction']").value;
  let userIntroErr = document.querySelector("form[name='changeInfo'] textarea[name='userIntroduction']+.err");
  let flag = true;
  if (userName.trim() == "") {
    userNameErr.innerText = "昵称不能为空";
    return;
  }
  if (userName.trim().length > 30) {
    document.querySelector("form[name='changeInfo'] .err").innerText = "昵称长度不能超过30个字符";
    return;
  }
  if (userName.trim() === localStorage.getItem("userName")) {
    userNameErr.innerText = "昵称不能与原昵称相同";
    return;
  }
  userNameErr.innerText = "";
  if (userPhone.trim() == "") {
    userPhoneErr.innerText = "手机号不能为空";
    return;
  }
  if (userPhone.trim().length != 11) {
    userPhoneErr.innerText = "手机号长度不正确";
    return;
  }
  //验证手机格式为数字
  if (!/^\d+$/.test(userPhone.trim())) {
    userPhoneErr.innerText = "手机号格式不正确";
    return;
  }
  userPhoneErr.innerText = "";
  if (userEmail.trim() != '' && !/^[^\s@]+@[^\s@]+\.[^\s@]+$/.test(userEmail.trim())) {
    userEmailErr.innerText = "邮箱格式不正确";
    return;
  }
  userEmailErr.innerText = "";
  if (userIntroduction.trim().length > 500) {
    userIntroErr.innerText = "个人简介长度不能超过500个字符";
    return;
  }
  userIntroErr.innerText = "";
  document.querySelector("form[name='changeInfo'] input[type='hidden']").value = localStorage.getItem("userId");
  document.querySelector("form[name='changeInfo']").submit();
});

// 删除账户
document.querySelector("div[data-title='delete'] button").addEventListener('click', function () {
  let res = confirm("确定要删除账户吗？你将失去所有收藏的菜谱，并且我们会将你的数据抹除");
  if(res == true){
    $.ajax({
      type: "POST",
      userId: localStorage.getItem("userId"),
      url: "http://localhost/YourGourmet/Verify",
      data: {
        type: "deleteUser",
        userId: localStorage.getItem("userId")
      },
      success: function (data) {
        if (data == true) {
          window.close();
        } else {
          alert("删除失败,服务器响应出错");
        }
      }
    });
  }
});