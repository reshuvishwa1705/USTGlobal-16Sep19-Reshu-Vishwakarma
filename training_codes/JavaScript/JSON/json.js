const person={
    name:'sundari',
    age:22,
    color:{
        city:'bijawar',
        state:'Madhya Pradesh',
        pincode:8798798
    },
    hobbies:['coding','bird watching','singing']
}
console.log('JavaScript Person Object',person)
const jsonObject=JSON.stringify(person)
console.log('JSON Person Object',jsonObject)
const javaScriptPersonObject=JSON.parse(jsonObject)
console.log('JavaScript Person Object After Parse',javaScriptPersonObject)
localStorage.setItem('email','billgates@gmail.com ')
let emailId=localStorage.getItem('email')
console.log("Email ID = ",emailId)
localStorage.clear()
let e=localStorage.getItem('email')
console.log('Item is ',e)