function add10(num) {
  const promise = new Promise((resolve, reject) => {
    // 비동기 작업 실행하는 함수
    // executor

    setTimeout(() => {
      // true인 경우
      // const num = 10;
      // false인 경우
      // const num = null;

      if (typeof num === "number") {
        resolve(num + 10);
      } else {
        reject("num이 숫자가 아닙니다");
      }
    }, 2000);
  });

  return promise;
}

const p = add10(0);

// ! callback 지옥의 빠질수 있음.
// p.then((result) => {
//   console.log(result);

//   const newP = add10(result);
//   newP.then((result) => {
//     console.log(result);
//   });
// });

// ! 따라서 다른 방법으로
// p.then((result) => {
//   console.log(result);

//   const newP = add10(result);

//   return newP;
// }).then((result) => {
//   console.log(result);
// });

// * 위에 방법을 좀 더 간결하게 p를 넣지말고 바로 함수 호출
add10(0)
  .then((result) => {
    console.log(result);
    return add10(result);
  })
  .then((result) => {
    console.log(result);
    return add10(undefined);
  })
  .then((result) => {
    console.log(result);
  })
  .catch((error) => {
    console.log(error);
  });

// then 메서드
// -> 그 후에
// promise.then((value) => {
//   console.log(value);
// });

// then에다가 catch를 이어서 사용할 수 있음. promise.then은 promise를 반환하기 때문
// promise chaining
// promise
//   .then((value) => {
//     console.log(value);
//   })
//   .catch((error) => {
//     console.log(error);
//   });

// promise.catch((error) => {
//   console.log(error);
// });
