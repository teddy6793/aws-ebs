function submitSignUp(){
    const email = document.getElementById("email-sign-up").value
    const firstname = document.getElementById("firstname-sign-up").value
    const lastname = document.getElementById("lastname-sign-up").value
    const job = document.getElementById("job-sign-up").value
    const phone = document.getElementById("phone-sign-up").value
    const password = document.getElementById("password-sign-up").value
    const passwordConfirm = document.getElementById("password-sign-up-confirm").value

    if(email == null || email == ""){
        alert("Email không được để trống")
    }else{
        if(firstname == null || firstname == ""){
            alert("Họ tên không được để trống")
        }else{
            if(lastname == null || lastname == ""){
                alert("Họ tên không được để trống")
            }else {
                if(job == null || job == ""){
                    alert("Công việc không được để trống")
                }else{
                    if(phone == null || phone == ""){
                        alert("Số điện thoại không được để trống")
                    }else{
                        if(password == null || password == ""){
                            alert("Mật khẩu không được để trống")
                        }else{
                            if(passwordConfirm == null || passwordConfirm == ""){
                                alert("Mật khẩu xác thực không được để trống")
                            }else{
                                if(password == passwordConfirm){
                                    document.getElementById("form-sign-up").submit();
                                }else{
                                    document.getElementById("message").innerHTML = "Mật khẩu xác thực không đúng";
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}