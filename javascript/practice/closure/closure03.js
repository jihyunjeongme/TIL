// let num = 0;

// const increase = function () {
//     return ++num;
// };

// console.log(increase());
// console.log(increase());
// console.log(increase());

// const increase = function () {
//     let num = 0;

//     return ++num;
// };

// console.log(increase());
// console.log(increase());
// console.log(increase());

const increase = (function () {
    let num = 0;

    return function () {
        return ++num;
    };

}());

console.log(increase());
console.log(increase());
console.log(increase());