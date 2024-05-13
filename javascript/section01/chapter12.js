// 함수 표현식
// -> 호이스팅에 대상이 되지 않음.

function funcA() {
    console.log('funcA');
}

let varA = funcA;
// console.log(varA);
// varA();

let varB = function funcB() {
    // console.log('funcB');
};
// varB();

// 2. 화살표 함수
// let varC = function () {
//     return 1;
// }

// let varC = () => {
//     return 1;
// };

// console.log(varC());

// let varC = () => 1;
// console.log(varC());

// let varD = (value) => value + 1;
// console.log(varD(2));

let varE = (value) => {
    console.log(value);
    return value + 1;
};
console.log(varE(3));
