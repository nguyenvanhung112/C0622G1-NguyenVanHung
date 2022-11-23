import {Component, Input, OnInit} from '@angular/core';

@Component({
  selector: 'app-process-bar',
  templateUrl: './process-bar.component.html',
  styleUrls: ['./process-bar.component.css']
})
export class ProcessBarComponent implements OnInit {
  @Input() backgroundColor = '#D9D9D9';
  @Input() progressColor = '#4CAF50';
  @Input() progress = 0;
  constructor() { }

  ngOnInit(): void {
    this.loading();
  }

  loading() {
    let interval = setInterval(() => {
      this.progress = +this.progress + 5;
      if (this.progress == 100) {
        clearInterval(interval);
      }
    }, 1000);
  }
}
