// Named function

function add(num1,num2){
    console.log('Sum=',num1-num2);
}
add(20,10);
var sub= function(num1,num2){
    return num1-num2;
}
var s=sub(90,2);
console.log(sub(56,9));
console.log('subtraction= ',s);
(function(nm1,nm2){
    console.log(nm1+nm2);
})(30,40);
