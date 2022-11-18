let count: number = 0;

let number1: number = 0;
let number2: number = 1;
let fibonacci: number;

let n: number = 20;

let arrayFibonacci: number[] = [];

for (let i = 0; i < n; i++) {
    fibonacci = number1 + number2;
    arrayFibonacci.push(fibonacci);
    number1 = number2;
    number2 = fibonacci;
}

for (let i = 0; i < arrayFibonacci.length; i++) {
    count += arrayFibonacci[i];
}

console.log(arrayFibonacci);
console.log(count);