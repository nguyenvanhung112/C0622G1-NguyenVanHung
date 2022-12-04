import {Component, OnInit} from '@angular/core';
import {Garage} from "../model/garage";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Ticket} from "../model/ticket";
import {TicketService} from "../service/ticket.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {checkStartDay} from "../create/create.component";

@Component({
  selector: 'app-edit',
  templateUrl: './edit.component.html',
  styleUrls: ['./edit.component.css']
})
export class EditComponent implements OnInit {
  garageList: Garage[] = [];
  formEditTicket: FormGroup;
  message: string;
  id: number;
  ticketForm: Ticket;

  equals(o1: Garage, o2: Garage) {
    return o1.id === o2.id;
  }

  constructor(private ticketService: TicketService,
              private formBuilder: FormBuilder,
              private activatedRoute: ActivatedRoute,
              private router: Router) {
  }

  ngOnInit(): void {
    this.getGarage();
    this.editForm();
  }

  editForm() {
    this.activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get("id");
      console.log(this.id);
      this.ticketService.findById(this.id).subscribe(data => {
        this.ticketForm = data;
        this.formEditTicket = this.formBuilder.group({
          id: [this.ticketForm.id],
          price: [this.ticketForm.price,
            [Validators.required,
              Validators.pattern("^\\d+$")]],
          startPoint: [this.ticketForm.startPoint,
            [Validators.required]],
          endPoint: [this.ticketForm.endPoint,
            [Validators.required]],
          startDay: [this.ticketForm.startDay,
            [Validators.required]],
          time: [this.ticketForm.time,
            [Validators.required,
              Validators.pattern("[0-9]{2}(:)[0-9]{2}")]],
          garage: [this.ticketForm.garage,
            [Validators.required]],
          quantity: [this.ticketForm.quantity,
            [Validators.required,
              Validators.pattern("^\\d+$")]]
        },{validators: checkStartDay})
      })
    })
  }


  getGarage() {
    this.ticketService.findAllNhaXe().subscribe(data => {
      this.garageList = data;
    })
  }

  editTicket(id: number) {
    if (this.formEditTicket.valid) {
      this.ticketService.update(id, this.formEditTicket.value).subscribe(data => {
        this.router.navigateByUrl("/vexe")
      });
    }
    this.message = "Sửa thành công"
  }
}
