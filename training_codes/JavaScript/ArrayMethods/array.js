const hobbies=['sketching','playing games','listening song','drawing','coding'];
console.log(typeof hobbies)
var a=Array.isArray(hobbies);
console.log(a);
console.log(hobbies.includes("playing games"));
console.log(hobbies.includes('singing',2));
console.log(hobbies.push('singing'));
console.log(hobbies.pop());
//Numismatics- it is hobby to collect coins and notes
console.log(hobbies.unshift('a','Numismatics'));
console.log(hobbies.shift());
console.log('After using unshift',hobbies);
console.log(hobbies.splice(2,0,'pubg','watching movie'));
console.log(hobbies.splice(3,2,'PUBG Playing'));
console.log('After using splice',hobbies)
console.log(hobbies.slice(2,5));
console.log('Index of coding is',hobbies.indexOf('coding',2));
console.log(hobbies.join('-'));
const num=[10,30,50,40];
const num2=num.map(function(value){
    return value+5;
});
console.log("After map method",num2);
const num3= num.map(val=>val+6);
console.log('After map arrow function', num3);
const num4=num.filter(function(val){
if(val>25)
return true;
else
return false;
});
console.log("After using filter method",num4);
const num5=num.filter(val=>val>35);
console.log('After using fat arrow function with filter',num5);
