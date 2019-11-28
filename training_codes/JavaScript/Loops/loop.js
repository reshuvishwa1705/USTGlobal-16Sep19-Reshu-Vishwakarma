var brands=['kingfisher','bisleri','aqua','kinley'];
//for of loop
console.log('****************for of loop****************');
for(var ele of brands){
    console.log('Value',ele);
    
}
//for in loop
console.log('****************for in loop*****************');
for(var index in brands){
    console.log(brands[index]);
}
var person={
    name:'ABC',
    age:22,
    color:'white'
}
console.log('****************for in loop*****************');
for(var key in person){
    console.log(person[key]);
}
console.log('*****************for each method***************');
brands.forEach(function(value,index){
    console.log('Brands=',value);
});
console.log('----------------*******Empty Element*******----------------');
var n=[10,34,,67,,78,99];
console.log('*******************for loop************************');
for(var i=0;i<n.length;i++){
    console.log("Value=",n[i]);
}
console.log('********************for of  loop*******************');
for(var val of n){
    console.log('Value',val);
}
console.log('********************for in loop********************');
for(var i in n){
    console.log('Value',i);
}
console.log('----------------*******array[value]*******----------------');
console.log('********************for in loop********************');
for(var i in n){
    if(i==1){
        n[i]=90;
    }
    console.log('Value',n[i]);
}
