// 1. Date 객체를 생성하는 방법
let date1 = new Date();
// console.log(date1);

let date2 = new Date("1999-12-31");
// console.log(date2);

let date3 = new Date("2000/11/11/10:11:11");
// console.log(date3);

let date4 = new Date(2020, 1, 7, 23, 59, 59);
// console.log(date4);

// 2. 타임 스탬프
// 특정 시간이 "1970.01.01 00시 00분 00초"로 부터 몇 ms가 지났는지를 의미하는 숫자값
let ts1 = date1.getTime();
// console.log(ts1);

let date5 = new Date(ts1);
// console.log(date1, date5);

// 3. 시간 요소들을 추출하는 방법
let year = date1.getFullYear();
let month = date1.getMonth() + 1; // JS에선 1월 0으로 표시되기 때문에 +1을 해줘야 함.
let date = date1.getDate();

let hour = date1.getHours();
let minute = date1.getMinutes();
let seconds = date1.getSeconds();

// console.log(year, month, date, hour, minute, seconds);

// 4. 시간 수정하기
date1.setFullYear(2023);
date1.setMonth(2); // 실제론 3월
date1.setDate(3);
date1.setHours(23);
date1.setMinutes(59);
date1.setSeconds(59);

// console.log(date1);

// 5. 시간을 여러 포맷으로 출력하기
console.log(date1.toDateString());
console.log(date1.toLocaleString());
