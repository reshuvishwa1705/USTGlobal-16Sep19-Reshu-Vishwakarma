function valid(){
    
    let pwd=document.getElementById('password')
    if(document.getElementById('checkbox').checked){
        pwd.type="text";
    }
    else{
        pwd.type="password"
    }
}
