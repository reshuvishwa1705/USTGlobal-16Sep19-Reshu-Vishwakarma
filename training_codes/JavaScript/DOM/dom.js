let h1ele=document.getElementById('demo');
console.log('Element =',h1ele);
console.log('Element Text = ',h1ele.textContent)
h1ele.textContent='Good Evening';
console.log('Element Text = ',h1ele.textContent)
console.log("--------------------------------------------")
let buttonElement=document.createElement('button')
buttonElement.textContent='Click Me!!!!'
console.log('Button Element ',buttonElement);
document.body.appendChild(buttonElement);
let ulEle=document.createElement('ul');
let li1Ele=document.createElement('li');
let li2Ele=document.createElement('li');
let li3Ele=document.createElement('li');
li1Ele.textContent='Java'
li2Ele.textContent='SQL'
li3Ele.textContent='JavaScript'

ulEle.appendChild(li1Ele)
ulEle.appendChild(li2Ele)
ulEle.appendChild(li3Ele)
document.body.appendChild(ulEle);
h1ele.style.color='red'
h1ele.style.fontSize='100px';
h1ele.style.fontFamily='Lucida Calligraphy'
function showMessage(){
    alert('Hi Hello Welcome!!!!!!!!!');
}
function changeColor(){
    let pEle=document.getElementById('mover');
    pEle.style.color='green';
}
function removeColor(){
    let pEle=document.getElementById('mover')
    pEle.style.color='black'
}
function printHello(){
    console.log('Hello')
   let userName= document.getElementById('username').value
   document.getElementById('showusername').textContent=userName
}
let name='xyz'
let age=22
let phoneno=48979837984
console.log('Name is '+name+' Age is '+age+' PhoneNo is '+phoneno)
console.log(`Name is ${name} Age is ${age} PhoneNo is ${phoneno}`)