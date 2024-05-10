// let x = 1, y =2;

// const obj = { x, y};
// console.log(obj);

const obj = {
    name: 'Lee',
    sayHi() {
        console.log('Hi! ' + this.name);
    }
};

obj.sayHi();