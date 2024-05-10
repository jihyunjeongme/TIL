let days = ['mon','tue','wed'];

days.push('thu');
days.unshift('sun');
// console.log(days);

// for (let i=0; i<days.length; i++){
//     console.log(days[i]);
// }

for (let x of days) {
    console.log(x);
}