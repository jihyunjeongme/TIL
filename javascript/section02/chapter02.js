// ! 단락평가
// * 첫번째 피연산자만으로 결과값을 확인할 수 있으면 두번째 피연산자는 호출하지 않음.
// function returnFalse() {
//     console.log("False 함수");
//     return false;
// }

// function returnTrue() {
//     console.log("True 함수");
//     return true;
// }

// console.log(returnFalse() && returnTrue());

// console.log(returnTrue() && returnFalse());

// console.log(returnTrue() || returnFalse());

function returnFalse() {
    console.log("False 함수");
    return undefined;
}

function returnTrue() {
    console.log("True 함수");
    return 10;
}

console.log(returnTrue() || returnFalse());

// 단락 평가 활용 사례
// * T1 // T2 : T1이 true인 경우 T1을 사용
// * T1 && T2 : T1 && T2 모두 true인 경우 T2를 사용

function printName2(person) {
    const name = person && person.name;
    console.log(name || "person의 값이 없음");
}

printName2();
printName2({ name: "정지현" });
