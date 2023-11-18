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
    if(parent.classList.contains("error")){
        parent.classList.remove("error")
    }

    if(isStrongPassword){
        parent.classList.add("success");
        pwdWarningTxt.hidden = true;
    }else{
        parent.classList.add("error");
        pwdWarningTxt.hidden = false;
    }

})

document.getElementById("retypePassword").addEventListener("keyup", ev => {

    let parent = ev.target.parentElement.parentElement;

    if(parent.classList.contains("success")){
        parent.classList.remove("success")
    }
    if(parent.classList.contains("error")){
        parent.classList.remove("error")
    }

    newPassword = document.getElementById("newPassword").value;
    retypePassword = document.getElementById("retypePassword").value;

    loginBtn.disabled = (newPassword == '') || (newPassword != retypePassword) || !isStrongPassword;

    if(newPassword != retypePassword){
        document.getElementById("passwordNotMatchText").hidden = false;
        parent.classList.add("error");
    }else{
        document.getElementById("passwordNotMatchText").hidden = true;
        parent.classList.add("success");
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


    charLengthWarn.style.fontWeight = "bold";
    capitalLetterWarn.style.fontWeight = "bold";
    numberWarn.style.fontWeight = "bold";
    specialLetterWarn.style.fontWeight = "bold";

    let password = document.getElementById("newPassword").value;

    if(password.length < 8){
        isStrongPassword = false;
        charLengthWarn.style.color = "var(--danger)";
    }else{
        charLengthWarn.style.color = "var(--success)";
    }

    if(!containsUppercase(password)){
        isStrongPassword = false;
        capitalLetterWarn.style.color = "var(--danger)";
    }else{
        capitalLetterWarn.style.color = "var(--success)";
    }
    if(!hasNumber(password)){
        isStrongPassword = false
        numberWarn.style.color = "var(--danger)";
    }else{
        numberWarn.style.color = "var(--success)";
    }

    if(!containsSpecialChar(password)){
        isStrongPassword = false;
        specialLetterWarn.style.color = "var(--danger)";
    }else{
        specialLetterWarn.style.color = "var(--success)";
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