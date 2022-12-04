import { Component, OnInit } from '@angular/core';
import {Garage} from "../model/garage";
import {AbstractControl, FormBuilder, FormGroup, ValidationErrors, ValidatorFn, Validators} from "@angular/forms";
import {TicketService} from "../service/ticket.service";
import {Router} from "@angular/router";



export const checkStartDay: ValidatorFn = (control: AbstractControl): ValidationErrors | null => {
  const startDay = new Date(control.get("startDay").value).getTime();
  console.log(startDay)
  const dateNow = new Date().getTime();
  console.log(dateNow)
  if (startDay - dateNow < 24 * 60 * 60 * 1000) {
    return {"checkStartDay": true};
  } else {
    return null;
  }
}
@Component({
  selector: 'app-create',
  templateUrl: './create.component.html',
  styleUrls: ['./create.component.css']
})
export class CreateComponent implements OnInit {
  garageList: Garage[] = [];
  formTicket: FormGroup;
  message: string;
  constructor(private ticketService: TicketService,
              private formBuilder: FormBuilder,
              private router: Router) { }

  ngOnInit(): void {
    this.ticketService.findAllNhaXe().subscribe(data => {
      this.garageList = data
    });
    this.formTicket = this.formBuilder.group({
      price: ["",
        [Validators.required,
          Validators.pattern("^\\d+$")]],
      startPoint: ["",
        [Validators.required]],
      endPoint: ["",
        [Validators.required]],
      startDay: ["",
        [Validators.required]],
      time: ["",
        [Validators.required,
          Validators.pattern("[0-9]{2}(:)[0-9]{2}")]],
      garage: ["",
        [Validators.required]],
      quantity: ["",
        [Validators.required,
          Validators.pattern("^\\d+$")]]
    },{validators: checkStartDay})
  }
  addTicket() {
    if (this.formTicket.valid) {
      this.ticketService.save(this.formTicket.value).subscribe(data => {
        this.router.navigateByUrl("/vexe")
      });
    }
    this.message = "Thêm mới thất bại"
  }
}
