let loginBtn = document.getElementById("loginBtn");

let pwdWarningTxt = document.getElementById("passwordWarningText");

let charLengthWarn = document.getElementById("charLengthWarn");
let capitalLetterWarn = document.getElementById("capitalLetterWarn");
let numberWarn = document.getElementById("numberWarn");
let specialLetterWarn = document.getElementById("specialLetterWarn");

function togglePasswordField(){

    let passwordField = document.getElementById('newPassword');
    passwordField.type = passwordField.type === 'password' ? 'text': 'password';

    let logoImg = document.getElementById('hiddenLogo');
    logoImg.src = passwordField.type === 'password' ?
        "/img/svg/eye-slash.svg": "/img/svg/eye.svg";
}
function toggleRetypePasswordField(){

    let passwordField = document.getElementById('retypePassword');
    passwordField.type = passwordField.type === 'password' ? 'text': 'password';

    let logoImg = document.getElementById('retypeHiddenLogo');
    logoImg.src = passwordField.type === 'password' ?
        "/img/svg/eye-slash.svg": "/img/svg/eye.svg";
}

let isStrongPassword = false;
let newPassword = '';
let retypePassword = '';

document.getElementById("newPassword").addEventListener("keyup", ev => {
    newPassword = document.getElementById("newPassword").value;
    loginBtn.disabled = (newPassword == '') || newPassword != retypePassword || !isStrongPassword;

    checkIfValidPassword();
    let parent = ev.target.parentElement.parentElement;
    if(parent.classList.contains("success")){
        parent.classList.remove("success")
    }

    if(isStrongPassword){
        parent.classList.add("success");
        pwdWarningTxt.hidden = true;
    }else{
        pwdWarningTxt.hidden = false;
    }

})

document.getElementById("retypePassword").addEventListener("keyup", ev => {
    newPassword = document.getElementById("newPassword").value;
    retypePassword = document.getElementById("retypePassword").value;

    console.log(isStrongPassword)
    loginBtn.disabled = (newPassword == '') || (newPassword != retypePassword) || !isStrongPassword;

    if(newPassword != retypePassword){
        document.getElementById("passwordNotMatchText").hidden = false;
    }else{
        document.getElementById("passwordNotMatchText").hidden = true;
    }

})

function resetStyle(field) {
    field.style.color = "black";
    field.style.fontWeight = "normal";
}

$('#loginForm').submit(function(e) {
    e.preventDefault();

    let isValid = checkIfValidPassword();

    if(isValid){
        this.submit();
    } else {
        pwdWarningTxt.hidden = false
    }
});

function checkIfValidPassword() {

    isStrongPassword = true;

    resetStyle(charLengthWarn);
    resetStyle(capitalLetterWarn);
    resetStyle(numberWarn);
    resetStyle(specialLetterWarn);

    let password = document.getElementById("newPassword").value;

    if(password.length < 8){
        isStrongPassword = false;
        charLengthWarn.style.color = "red";
        charLengthWarn.style.fontWeight = "bold";
    }
    if(!containsUppercase(password)){
        isStrongPassword = false;
        capitalLetterWarn.style.color = "red";
        capitalLetterWarn.style.fontWeight = "bold";
    }
    if(!hasNumber(password)){
        isStrongPassword = false
        numberWarn.style.color = "red";
        numberWarn.style.fontWeight = "bold";
    }
    if(!containsSpecialChar(password)){
        isStrongPassword = false;
        specialLetterWarn.style.color = "red";
        specialLetterWarn.style.fontWeight = "bold";
    }

    return isStrongPassword;
}

function containsUppercase(str) {
    return /[A-Z]/.test(str);
}

function hasNumber(str) {
    return /\d/.test(str);
}

function containsSpecialChar(str){
    return /[!@#$%^&*()_+\-=\[\]{};':"\\|,.<>\/?]+/.test(str);
}