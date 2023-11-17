let loginBtn = document.getElementById("loginBtn");

let pwdWarningTxt = document.getElementById("passwordWarningText");

let charLengthWarn = document.getElementById("charLengthWarn");
let capitalLetterWarn = document.getElementById("capitalLetterWarn");
let numberWarn = document.getElementById("numberWarn");
let specialLetterWarn = document.getElementById("specialLetterWarn");

function togglePasswordField(){

    // change field type
    toggleFieldType("newPassword")

    // change logo image
    toggleLogo("hiddenLogo");
}
function toggleRetypePasswordField(){

    // change field type
    toggleFieldType("retypePassword")

    // change logo image
    toggleLogo("retypeHiddenLogo")
}

function toggleFieldType(id){
    let passwordField = document.getElementById(id);
    passwordField.type = passwordField.type === 'password' ? 'text': 'password';
}

function toggleLogo(id){
    let logoImg = document.getElementById(id);
    logoImg.src = logoImg.type === 'password' ?
        "/img/svg/eye-slash.svg": "/img/svg/eye.svg";
}

let newPassword = '';
let retypePassword = '';
document.getElementById("newPassword").addEventListener("keyup", ev => {
    newPassword = document.getElementById("newPassword").value;
    loginBtn.disabled = (newPassword == '') || newPassword != retypePassword;
})

document.getElementById("retypePassword").addEventListener("keyup", ev => {
    retypePassword = document.getElementById("retypePassword").value;
    loginBtn.disabled = (newPassword == '') || newPassword != retypePassword;
})

function resetStyle(field) {
    field.style.color = "black";
    field.style.fontWeight = "normal";
}

$('#loginForm').submit(function(e) {
    e.preventDefault();

    resetStyle(charLengthWarn);
    resetStyle(capitalLetterWarn);
    resetStyle(numberWarn);
    resetStyle(specialLetterWarn);

    let isValid = true;
    let password = document.getElementById("newPassword").value;

    if(password.length < 8){
        isValid = false;
        charLengthWarn.style.color = "red";
        charLengthWarn.style.fontWeight = "bold";
    }
    if(!containsUppercase(password)){
        isValid = false;
        capitalLetterWarn.style.color = "red";
        capitalLetterWarn.style.fontWeight = "bold";
    }
    if(!hasNumber(password)){
        isValid = false
        numberWarn.style.color = "red";
        numberWarn.style.fontWeight = "bold";
    }
    if(!containsSpecialChar(password)){
        isValid = false;
        specialLetterWarn.style.color = "red";
        specialLetterWarn.style.fontWeight = "bold";
    }

    if(isValid){
        this.submit();
    } else {
        pwdWarningTxt.hidden = false
    }
});

function containsUppercase(str) {
    return /[A-Z]/.test(str);
}

function hasNumber(str) {
    return /\d/.test(str);
}

function containsSpecialChar(str){
    return /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/.test(str);
}