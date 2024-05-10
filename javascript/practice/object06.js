// const person = new Object();

// person.name = 'Lee';
// person.sayHello = function() {
//     console.log('Hi! My name is ' + this.name);
// };

// console.log(person);
// person.sayHello();


function sum() {
    let res = 0;
    for (let i = 0; i < arguments.length; i++){
        res += arguments[i];
    
    }
    return res;
}

console.log(sum());
console.log(sum(1,2));
console.log(sum(1,2,3));