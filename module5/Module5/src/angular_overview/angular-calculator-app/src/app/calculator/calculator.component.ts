import {Component, OnInit} from '@angular/core';

@Component({
  selector: 'app-calculator',
  templateUrl: './calculator.component.html',
  styleUrls: ['./calculator.component.css']
})
export class CalculatorComponent implements OnInit {

  result: (number | string);
  numberA: number;
  numberB: number;

  constructor() {
  }

  ngOnInit(): void {
  }

  calculator(operator: string) {
    switch (operator) {
      case '+':
        this.result = this.numberA + this.numberB;
        break;
      case '-':
        this.result = this.numberA - this.numberB;
        break;
      case '*':
        this.result = this.numberA * this.numberB;
        break;
      case '%':
        if (this.numberA == 0) {
          this.result = "Error";
          break
        }
        this.result = this.numberA / this.numberB;
        break;
    }
  }
}
