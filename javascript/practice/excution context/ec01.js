// const x = 1;
// const y = 2;

// function foo(a){
//     const x = 10;
//     const y = 20;

//     console.log(a + x + y);
// }

// foo(100);

// console.log(x+y);

// const x = 1;

// function foo() {
//     const y = 2;

//     function bar () {
//         const z = 3;
//         console.log(x + y + z);
//     }
//     bar();
// }

// foo();

var x = 1;
const y = 2;

function foo(a){
    var x = 3;
    const y = 4;

    function bar(b){
        const z = 5;
        console.log(a + b + x + y + z);
    }
    bar(10);
}
foo(2);