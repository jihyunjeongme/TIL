// 5가지 요소 순회 및 탐색 메서드
// 1. forEach
// 모든 요소를 순회하면서, 각각의 요소에 특정 동작을 수행시키는 메서드
let arr1 = [1, 2, 3];

arr1.forEach(function (item, idx, arr) {
    // console.log(idx, item * 2);
});

let doubledArr = [];

arr1.forEach((item) => {
    doubledArr.push(item * 2);
});

// console.log(doubledArr);

// 2. includes
// 배열에 특정 요소가 있는지 확인하는 메서드
let arr2 = [1, 2, 3];
let isInclude = arr2.includes(2);
// console.log(isInclude);

// 3. indexOf
// 특정 요소의 인덱스(위치)를 찾아서 반환하는 메서드
let arr3 = [1, 2, 3];
let index = arr3.indexOf(2);
// console.log(index);

// 4. findIndex
// 모든 요소를 순회하면서, 콜백함수를 만족하는
// 특정 요소의 인덱스(위치)를 반환하는 메서드
// let arr4 = [1, 2, 3];
// const findedIndex = arr4.findIndex((item) => {
//     if (item === 2) return true;
// });

// console.log(findedIndex);

// 화살표 함수를 좀 더 간단하게 사용하는 법
let arr4 = [1, 2, 3];
const findedIndex = arr4.findIndex((item) => item === 2);

// console.log(findedIndex);

const findedIndex2 = arr4.findIndex((item) => item === 999);

// 만족하지 않으면 -1을 반환
// console.log(findedIndex2);

// findIndex가 필요한 이유
// indexof는 얕은 비교를 하기 때문에 복합한 object의 위치를 찾아서 반환하기 어렵다.
let objectArr = [
    {
        name: "정지현",
    },
    {
        name: "홍길동",
    },
];

// -1이 반환됨
// console.log(objectArr.indexOf({ name: "정지현" }));

// 0이 반환됨
// console.log(objectArr.findIndex((item) => item.name === "정지현"));

// 5. find
// 모든 요소를 순회하면서 콜백함수를 만족하는요소를 찾는데, 요소를 그대로 반환
let arr5 = [{ name: "정지현" }, { name: "홍길동" }];

const finded = arr5.find((item) => item.name === "정지현");

console.log(finded);
