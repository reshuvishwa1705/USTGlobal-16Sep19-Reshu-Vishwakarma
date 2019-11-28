console.log('Window object',window);
console.log('This Keyword',this);
console.log(this===window);
// window.alert('Welcome to JavaScript Class');
// alert('Welcome UST Global and Test Yantra');
// let confirmDelete=confirm('Are you sure you want to delete');
// console.log('Confirm Delete',confirmDelete);
// let val=prompt('What is your name','Soumen');
// console.log('User Name',val)
const person={
    firstName:'Alia',
    age:26,
    lastName:'Bhatt',
    getName:function(){
        console.log('This keyword ',this)
        return this.firstName+' '+this.lastName
    }
}
let fullName=person.getName();
console.log("FullName is "+fullName);