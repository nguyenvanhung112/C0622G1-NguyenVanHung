import {Component, OnInit} from '@angular/core';
import {TicketService} from "../vexe.service";
import {Garage} from "../model/garage";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";

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
              private router: Router) {
  }

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
      starDay: ["",
        [Validators.required]],
      time: ["",
        [Validators.required,
          Validators.pattern("[0-9]{2}(:)[0-9]{2}")]],
      garage: ["",
        [Validators.required]],
      quantity: ["",
        [Validators.required,
          Validators.pattern("^\\d+$")]]
    })

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
