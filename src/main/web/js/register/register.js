function check_password(){
    var password=document.getElementById("password").value;
    var repassword=document.getElementById("repassword").value;
    if(password==repassword){
        document.getElementById("error").innerHTML="<font color='green'>两次密码输入一致</font>";
        document.getElementById("submit").disabled=false;

    }else{
        document.getElementById("error").innerHTML="<font color='red'>两次输入密码不一致!</font>";
	    document.getElementById("submit").disabled = true; 


    }

}

function check_password_l(){
    var password_l=document.getElementById("password").value;
    if( password_l.length<6 || password_l.length>14){
       
        document.getElementById("error_p").innerHTML="<font color='red'>请输入6到14位的密码！</font>";
	    document.getElementById("submit").disabled = true; 
    }
}