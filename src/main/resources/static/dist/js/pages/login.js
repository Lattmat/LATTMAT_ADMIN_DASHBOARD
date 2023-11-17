let loginBtn = document.getElementById("loginBtn");

function togglePasswordField(){

    // change field type
    let passwordField = document.getElementById("password");
    passwordField.type = passwordField.type === 'password' ? 'text': 'password';

    // change logo image
    let logoImg = document.getElementById("hiddenLogo");
    logoImg.src = passwordField.type === 'password' ?
        "/img/svg/eye-slash.svg": "/img/svg/eye.svg";
}

let isEmailBlank = true;
document.getElementById("email").addEventListener("keyup", ev => {
    isEmailBlank = document.getElementById("email").value == "";
    loginBtn.disabled = isEmailBlank || isPasswordBlank;
})

let isPasswordBlank = true;
document.getElementById("password").addEventListener("keyup", ev => {
    isPasswordBlank = document.getElementById("password").value == "";
    loginBtn.disabled = isEmailBlank || isPasswordBlank;
})