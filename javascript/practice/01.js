function User(name, age){
    this.name = name;
    this.age = age;
    this.sayName = function() {
        console.log(this.name);
    }
}

let user1 = new User('Mike',30);
let user2 = new User('Jane',22);
let user3 = new User('Tom',17);

let user5 = new User('Han', 40);

user5.sayName;
