var arrayFibonacci;
var count = 0;
var number1 = 0;
var number2 = 1;
var fibonacci;
var n = 20;
for (var i = 0; i < n; i++) {
    fibonacci = number1 + number2;
    number1 = number2;
    number2 = fibonacci;
    arrayFibonacci.push(fibonacci);
}
for (var i = 0; i < arrayFibonacci.length; i++) {
    count += arrayFibonacci[i];
}
console.log(arrayFibonacci);
