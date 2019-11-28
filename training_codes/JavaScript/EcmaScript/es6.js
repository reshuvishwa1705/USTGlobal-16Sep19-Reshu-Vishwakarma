const message=new Promise(function(res,rej){
    if(30>10){
        res([{
            name:'Anuska',
            age:22
        },{
            name:'Soumen',
            age:22
        },{
            name:'Reshu',
            age:22
        }
    ])
    }
    else{
        rej('Failed')
    }
})
message.then(function(data){
    console.log('Employee Data ',data)
}).catch(function(error){
    console.log('Failure Message',error)
})
const employees=new Promise(function(res,rej){
    if(9>10){
        res([{
            name:'Anu',
            age:22
        },{
            name:'Somen',
            age:22
        },{
            name:'Rehu',
            age:22
        }
    ])
    }
    else{
        rej('Failed')
    }
})
employees.then(function(data){
    console.log('Employee Data ',data)
}).catch(function(error){
    console.log('Failure Message',error)
})
function outerFunction(counter){
    function innerFunction(){
        let count;
        count=counter+10;
        return count;
    }
    return innerFunction;
}
let innerFunc=outerFunction(10);
let counter=innerFunc();
console.log("Counter Value ",counter)