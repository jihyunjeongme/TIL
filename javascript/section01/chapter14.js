// 스코프
// -> 변수나 함수에 접근하거나 호출할 수 있는 범위를 말함
// -> 전역(전체 영역) 스코프: 전체 영역에서 접근 가능
// -> 지역 스코프: 특정 영역에서만 접근 가능

let a = 1; // wㅓㄴ역 스코프

function funcA() {
    let b = 2; // 지연 스코프
    console.log(a);
    function funcB() {}
}

funcA();
// console.log(b);

if (true) {
    let c = 1;
}

// console.log(c);

for (let i = 0; i < 10; i++) {
    let d = 1;
}

// console.log(d);

funcB();