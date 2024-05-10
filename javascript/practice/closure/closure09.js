// var funcs = [];

// for (var i = 0; i < 3; i++) {
//     funcs[i] = function () { return i; };
// }

// for (var j = 0; j < funcs.length; j++){
//     console.log(funcs[j]());
// }


// const funcs = [];

// for (let i = 0; i < 3; i++) {
//     funcs[i] = function () { return i; };
// }

// for (let j = 0; j < funcs.length; j++){
//     console.log(funcs[j]());
// }

const funcs = Array.from(new Array(3), (_, i) => () => i);

funcs.forEach(f => console.log(f()));