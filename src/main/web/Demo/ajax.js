$.ajax({
  type: "POST",//请求方式，选择POST或者GET
  url: "http://localhost/YourGourmet/GetInfo",//请求路径，你们不用管
  datatype: "json",//返回的类型，这里我用的是json，用来处理长表单，也可以不设置
  data: {
    type: "getUserInfo",//这里必须要有，用来判断是哪个请求，根据你要做什么来填写
    userId: "111"  // aa: bb   aa是你要传的参数名，bb是你要传的参数值
  },
  success: PopulateUserInfo,  // 在服务器处理完成请求后，可以调用的函数，这里我用来处理返回的数据，可以是匿名函数
  //失败时：
  error : err //这里的err是一个函数，用来处理失败时的情况,一般服务器有问题才会调用，你们不用管
});
/**请在备注里写你们的需要的值，用来处理返回的数据
 * 格式为
 *         参数名(类型) : 参数值
 * 比如：
 *         userId(string) : 111
 *         userName(string) : "张三"
 *         userAge(int) : 18
*/
//例子：请求用户信息
$.ajax({
  type: "Get",//请求方式，选择POST或者GET

  url: "http://localhost/YourGourmet/GetInfo",//请求路径，你们不用管
  datatype: "json",//返回的类型，这里我用的是json，用来处理长表单，也可以不设置
  data: {
    type: "getUserInfo",//这里必须要有，用来判断是哪个请求，根据你要做什么来填写
    userId: "222"  // aa: bb   aa是你要传的参数名，bb是你要传的参数值
  },
  success: 成功函数, // 请求成功可以调用的函数，这里我用来处理返回的数据，可以是匿名函数
});

//例子：修改密码
$.ajax({
  type: "POST",//请求方式，选择POST或者GET
  url: "http://localhost/YourGourmet/Verify",//请求路径，不用管
  data: {
    type: "updatePassword",//这里必须要有，用来判断是哪个请求，根据你要做什么来填写
    userId: "333",  // aa: bb   aa是你要传的参数名，bb是你要传的参数值
    oldPassword: "123456",
    newPassword: "234567"
  },
  success: function(flag){// 请求成功可以调用的函数，这里我用匿名函数来处理返回的数据
    if(flag == true) console.log("成功修改");
    else console.log("修改失败");
  }
});
// 如果是json对象
//flag.参数名
//a.innerHTML = flag.参数名;