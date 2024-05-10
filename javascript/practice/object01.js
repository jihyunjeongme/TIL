var person = {
    name : 'Lee',
    sayHello: function () {
        console.log(`Hello! My name is ${this.name}.`);
    }
};

// console.log(typeof person);
// console.log(person);

var circle = {
    radius: 5,

    getDiameter: function(){
        return 2 * this.radius;
    }
};

// console.log(circle.getDiameter());

var person = {
    name: 'Lee'
};

// console.log(person.name);
// console.log(person['name']);

person.age = 20;

console.log(person);

delete person.age;
console.log(person);