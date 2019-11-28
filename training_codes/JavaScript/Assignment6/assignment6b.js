function valid(){
    let userName= document.getElementById('username').value
    let pwd=document.getElementById('password').value
   
    let login=document.getElementById('sub')
    if(userName.length<7 && pwd.length<5){
        login.disabled=true;
}
else{
    login.disabled=false;
}
}