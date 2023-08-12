const wapper = document.querySelector('.wapper');

const loginLink = document.querySelector('.login-link');

const registerLink = document.querySelector('.register-link');

const btnPopup = document.querySelector('.btnLogin-popup');

const modal = document.querySelector('.modal-edit');

const icon_close =document.querySelector('.icon-close');

registerLink.addEventListener('click', () => {
    wapper.classList.add('active');
});

loginLink.addEventListener('click', () => {
    wapper.classList.remove('active');
});

btnPopup.addEventListener('click', () => {
    modal.classList.add('open');
});

icon_close.addEventListener('click', () => {
    modal.classList.remove('open');
});

function signup() {

    if (!checkPassword()) {
        throw new Error("Mat khau khong dung");
    };

    var registerApi = 'http://localhost:8080/register';

    var fullName = document.getElementById("fullName").value;
    var username = document.getElementById("username").value;
    var password = document.getElementById("password").value;
    var phoneNumber = document.getElementById("phoneNumber").value;
    var dateOfBirth = document.getElementById("dateOfBirth").value;
    var sex = document.getElementById("sex").value;


    var userData = {
        fullName: fullName,
        username: username,
        password: password,
        phoneNumber: phoneNumber,
        dateOfBirth: dateOfBirth,
        sex: sex
    };
    console.log(userData);


    fetch(registerApi, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
        },
        body: JSON.stringify(userData)
    })
        .then((response) => {
            if (response.status == 200) {
                alert("Bạn đã đăng ký thành công tài khoản thành công!");
                // window.location.href = "login";
            }
            else {
                alert("Tên người dùng đã tồn tại");
            }
        })
        .catch((error) => {
            alert("Lỗi trong quá trình chạy!");
        });
}

function checkPassword() {

    var password = document.getElementById("password").value;
    var confimPassword = document.getElementById("confimPassword").value;

    if (password !== confimPassword) {
        alert("Mật khẩu không khớp vui lòng nhập lại!");
        return false;
    }

    return true;

}