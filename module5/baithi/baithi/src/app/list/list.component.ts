import {Component, OnInit} from '@angular/core';
import {TicketService} from "../vexe.service";
import {Ticket} from "../model/ticket";
import {Garage} from "../model/garage";
import {FormGroup} from "@angular/forms";
import {Router} from "@angular/router";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {

  ticketList: Ticket[] = [];
  garageList: Garage[] = [];
  endPoint = "";
  startPoint = "";
  searchGarage = "";
  firstDay = "";
  secondDay = "";
  ticketForm: Ticket;
  message: string;
  deleteTicket: Ticket;
  p: string | number;

  constructor(private ticketService: TicketService,
              private router: Router) {
  }

  ngOnInit(): void {
    this.ticketService.findAll().subscribe(data => {
      this.ticketList = data
    })
    this.ticketService.findAllNhaXe().subscribe(data => {
      this.garageList = data
    });
  }

  resetSearch() {
    this.ngOnInit()
  }

  findDiemDenDiemDi() {
    this.p = 1;
    this.ticketService.search(this.endPoint, this.startPoint, this.searchGarage).subscribe(
      data => {
        if (this.firstDay !== "" && this.secondDay !== "") {
          this.ticketList = data.filter(value => {
            const format = new Date(value.startDay);
            let firstDay1 = new Date(this.firstDay);
            let secondDay1 = new Date(this.secondDay);
            if (format >= firstDay1 && format <= secondDay1) {
              return data;
            }
          })
        } else {
          this.ticketList = data;
        }
      })
  }

  infoDatVe(id: number) {
    this.ticketService.findById(id).subscribe(data => {
      this.ticketForm = data;
    })
  }

  orderTicket(id: number) {
    if (this.ticketForm.quantity == 0) {
      this.message = "Đã hết vé"
    } else {
      this.ticketForm.quantity = this.ticketForm.quantity - 1;
      this.ticketService.update(id, this.ticketForm).subscribe(data => {
        this.ngOnInit();
        this.message = "Đặt vé xe thành công!";
      })
    }
  }

  infoDelete(id: number) {
    this.ticketService.findById(id).subscribe(data => {
      this.deleteTicket = data;
    })
  }

  removeTicket(id: number) {
    this.ticketService.delete(id).subscribe(data => {
      this.message = "Xóa vé thành công"
    })

  }
}
