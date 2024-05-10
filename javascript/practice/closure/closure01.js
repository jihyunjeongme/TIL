// const x = 1;

// function outerFunc() {
//     const x = 10;

//     function innerFunc() {
//         console.log(x);
//     }
//     innerFunc();
// }

// outerFunc();

const x = 1;

function foo() {
    const x = 10;
    bar();
}

function bar() {
    console.log(x);
}

foo();
bar();