function first(callback){
    setTimeout(function(){
        console.log('First Function Executed');
        callback();
    },0)
    }
    function second(){
        console.log('Second Function Executed');
    }
    first(second);
    