// 显示用户信息(立即执行)
(function () {
  localStorage.setItem("userId", "e5114cee020e11eebd064ccc6a7eb102");
  localStorage.setItem("userName", "孤影メ残刀");
  function PopulateUserInfo(data) {
    const { userName, userPhone, userGender = '未知', userGroup, userEmail = '未知', userIntroduction = '你还没有介绍你自己呢', userAvatar = "avatar/default.jpg" } = data;
    document.querySelector(".base-info table tbody").innerHTML = `
    <tr></tr>
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
    document.querySelector(".show-avatar").src = `http://localhost/YourGourmet/img/profile/${userAvatar}`;
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
      if (checkPassword == true) {
        document.querySelector(".password .err").innerHTML = "修改成功，请重新登录";
        setTimeout(() => {
          location.reload();
        }, 3000);
      } else {
        document.querySelector(".password .err").innerHTML = "修改失败，请检查原密码是否正确";
      }
    }
  });
});

// 修改头像
//显示上传的头像
document.querySelector("input[name='avatar']").onchange = function () {
  document.querySelector(".show-avatar").src = window.URL.createObjectURL(this.files[0]);
};
//上传头像
document.querySelector(".avatar button").addEventListener("click", function () {
  let avatar = document.querySelector("input[name='avatar']").files[0];
  let err = document.querySelector(".avatar .err");
  if (avatar == undefined) {
    err.innerHTML = "请选择图片";
    return;
  }
  let userId = localStorage.getItem("userId");
  let changeAvatar = document.querySelector("form[name='changeAvatar']");
  let formData = new FormData(changeAvatar);
  formData.append("type", "updateAvatar");
  formData.append("userId", userId);
  $.ajax({
    type: "POST",
    url: "http://localhost/YourGourmet/Upload",
    data: formData,
    //关闭 Jquery 对 formData 的默认处理
    processData: false,
    contentType: false,
    success: function (st) {
      if (st == "true") {
        err.innerHTML = "上传成功,即将刷新页面";
        setTimeout(() => {
          location.reload();
        }, 3000);
      } else {
        err.innerHTML = "上传失败,请重试";
      }
    }
  });
});



// 获取定位
// 自动定位 - 使用百度地图API
document.querySelector("input[name='autoLocation']").addEventListener("change", getGeolocation);
function getGeolocation() {
  if (this.checked == false) return;
  let geolocation = new BMap.Geolocation();
  geolocation.getCurrentPosition(function (r) {
    if (this.getStatus() == BMAP_STATUS_SUCCESS) {
      // 获取城市名称
      let province = r.address.province;// 省
      let cityName = r.address.city;// 市
      localStorage.setItem("province", province);
      localStorage.setItem("city", cityName);
      document.querySelector("span#province").innerHTML = localStorage.getItem("province");
      document.querySelector("span#city").innerHTML = localStorage.getItem("city");
    }
  }, { enableHighAccuracy: true })//高精度方式
}
// 手动定位 - 使用ajax获取地址
(function () {
  let chooseProvince = document.querySelector("#choose-province");
  let chooseCity = document.querySelector("#choose-city");
  // 获取省份列表
  $.ajax({
    url: "/YourGourmet/GetInfo",
    type: "GET",
    dataType: "json",
    data: {
      type: "getProvinceList"
    },
    success: function (data) {
      if(data == "false"){
        chooseProvince.innerHTML = "<option value='0'>加载失败，请重试</option>";
        return;
      }
      // 添加省份选项
      chooseProvince.innerHTML = "<option value='0'>请选择省份</option>";
      data.forEach(function (item) {
        const { id, provinceName } = item;
        chooseProvince.innerHTML += `<option value='${id}' data-value='${provinceName}'>${provinceName}</option>`;
      }
      );
      // 添加城市列表
      chooseProvince.addEventListener("change", function () {
        let provinceId = this.value;
        $.ajax({
          url: "/YourGourmet/GetInfo",
          type: "GET",
          dataType: "json",
          data: {
            type: "getCityList",
            provinceId: provinceId
          },
          success: function (data) {
            if (data == "false") {
              chooseCity.innerHTML = "<option value='0'>加载失败，请重新选择省份</option>";
              return;
            }
            chooseCity.innerHTML = "<option value='0'>请选择城市</option>";
            data.forEach(function (item) {
              chooseCity.innerHTML += `<option value='${item}'>${item}</option>`;
            }
            );
            // 显示更改按钮
            let changeButton = document.querySelector("#ConfirmChange");
            changeButton.style.display = "inline-block";
            changeButton.addEventListener("click", function () {
              localStorage.setItem("province", chooseProvince.options[chooseProvince.selectedIndex].getAttribute("data-value"));
              localStorage.setItem("city", chooseCity.options[chooseCity.selectedIndex].value);
              document.querySelector("span#province").innerHTML = localStorage.getItem("province");
              document.querySelector("span#city").innerHTML = localStorage.getItem("city");
            });
          },
          error: function () {
            chooseCity.innerHTML = "<option value='0'>服务器错误</option>";
          }
        });
      });
    },
    error: function () {
      chooseProvince.innerHTML = "<option value='0'>服务器错误</option>";
    }
  });
})();



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
  let res = prompt("确定要删除账户吗？你将失去所有收藏的菜谱，并且我们会将你的数据抹除\n请输入你的密码以确认删除");
  if (res != null) {
    $.ajax({
      type: "POST",
      userId: localStorage.getItem("userId"),
      url: "http://localhost/YourGourmet/Delete",
      data: {
        type: "deleteUser",
        userId: localStorage.getItem("userId"),
        userPassword: res
      },
      success: function (data) {
        if (data == true) {
          window.open(location, '_self').close();
        } else {
          alert("删除失败,密码错误,请重试！！");
        }
      }
    });
  }
});