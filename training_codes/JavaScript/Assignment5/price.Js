const items=[{
    name:'Kajal',
    id:1,
    price:1000
},{
    name:' Ear Ring',
    id:2,
    price:5000
},{
    name:'Trimmer',
    id:3,
    price:3000
},{
    name:'Beardo',
    id:4,
    price:170
}];

 const items1=items.map(function(val,i){
    
    return val.name,val.id,val.price+500;
    
});
const items2=items.filter(function(v){
if(v.price>1000)
return true;
else
return false;
});
console.log(items1);
console.log(items2);
const i1=items.map(function(val){
    val.price=val.price+300;
    return val.price;
});
console.log(i1);
const i2=items.filter((v)=>v.price>1000)
console.log(i2)