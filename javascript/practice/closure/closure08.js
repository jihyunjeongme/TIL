// function Person(name, age){
//     this.name = name;
//     let _age = age;

//     this.sayHi = function () {
//         console.log(`Hi! My name is ${this.name}. I am ${_age}.`);
//     };
// }

// const me = new Person('Lee', 20);
// me.sayHi();

// console.log(me.name);
// console.log(me._age);

// function Person(name, age){
//     this.name = name;
//     let _age = age;
// }

// Person.prototype.sayHi = function () {
//     console.log(`Hi! My name is ${this.name}. I am ${_age}.`);
// };


const Person = (function () {
    let _age = 0;

    function Person(name, age){
        this.name = name;
        _age = age;
    }

    Person.prototype.sayHi = function () {
        console.log(`Hi My name is ${this.name}. I am ${_age}.`);
    };

    return Person;
}());

const me = new Person('Lee', 20);
// me.sayHi();

// console.log(me.name);
// console.log(me._age);

me.sayHi();

const you = new Person('Kim', 30);
you.sayHi();

me.sayHi();
