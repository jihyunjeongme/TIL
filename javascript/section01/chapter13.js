// 콜백함수(callback Function)
// -> 자신이 아닌 다른 함수에, 인수로써 전달된 함수를 의미함

function main(value) {
    // console.log(value);
    // console.log(1);
    // console.log(2);

    value();
    // console.log('end');
}

// function sub() {
//     console.log('I am sub');
// }

// main(1);
// main(sub);

// main(function sub() {
//     console.log('I am sub');
// });

// main(function () {
//     console.log('I am sub');
// });

main(() => {
    // console.log('I am sub');
});

// 2. 콜백함수의 활용
// -> wㅜㅇ복 코드를 제거하고 간결하게 작성 가능
// function repeat(count) {
//     for (let idx = 0; idx <= count; idx++) {
//         console.log(idx);
//     }
// }

// repeat(5);

// function repeatDouble(count) {
//     for (let idx = 0; idx <= count; idx++) {
//         console.log(idx * 2);
//     }
// }

// repeatDouble(5);

function repeat(count, callback) {
    for (let idx = 1; idx <= count; idx++) {
        callback(idx);
    }
}

repeat(5, (idx) => {
    console.log(idx);
});

repeat(5, (idx) => {
    console.log(idx * 2);
});

repeat(5, (idx) => {
    console.log(idx * 3);
});
