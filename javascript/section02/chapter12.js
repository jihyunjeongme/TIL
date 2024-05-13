// function add(a, b, callback) {
//     setTimeout(() => {
//         const sum = a + b;
//         callback(sum);
//     }, 3000);
// }

// add(1, 2, (value) => {
//     console.log(value);
// });

// 음식을 주문하는 상황
function orderFood(callback) {
  setTimeout(() => {
    const food = "떡볶이";
    callback(food);
  }, 3000);
}

function cooldownFood(food, callback) {
  setTimeout(() => {
    const cooldownedFood = `식은 ${food}`;
    callback(cooldownedFood);
  }, 2000);
}

function freezeFood(food, callback) {
  setTimeout(() => {
    const freezedFood = `냉동된 ${food}`;
    callback(freezedFood);
  }, 1500);
}

// 인덴트가 깊어지게 됨 callback을 자꾸 사용할 수록, 이걸 콜백 지옥이라고 함. 이걸 피하기 위해 promise를 사용함.
orderFood((food) => {
  console.log(food);

  cooldownFood(food, (cooldownedFood) => {
    console.log(cooldownedFood);

    freezeFood(cooldownedFood, (freezeFood) => {
      console.log(freezeFood);
    });
  });
});
