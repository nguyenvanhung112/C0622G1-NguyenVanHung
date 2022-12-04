import {Component, OnInit} from '@angular/core';
import {Ticket} from "../model/ticket";
import {Garage} from "../model/garage";
import {TicketService} from "../service/ticket.service";
import {Router} from "@angular/router";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-list',
  templateUrl: './list.component.html',
  styleUrls: ['./list.component.css']
})
export class ListComponent implements OnInit {
  ticketList: Ticket[] = [];
  ticketOrder: Ticket;
  message: string;
  deleteTicket: Ticket;
  p: string | number;
  formSearch: FormGroup;
  firstDaySearch = "";
  secondDaySearch = "";

  constructor(private ticketService: TicketService,
              private formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.ticketService.findAll().subscribe(data => {
      this.ticketList = data
    })

    this.formSearch = this.formBuilder.group(
      {
        endPoint: [""],
        startPoint: [""],
        firstDay: [""],
        secondDay: [""]
      }
    )
  }

  resetSearch() {
    this.ngOnInit()
  }

  search(startPoint: string, endPoint: string, firstDay: string, secondDay: string) {
    this.p = 1;
    this.setDay(firstDay, secondDay);
    this.ticketService.search(startPoint, endPoint, this.firstDaySearch, this.secondDaySearch).subscribe(
      data => {
        this.ticketList = data;
      })
  }

  infoOrderTicket(id: number) {
    this.ticketService.findById(id).subscribe(data => {
      this.ticketOrder = data;
    })
  }

  orderTicket(id: number) {
    if (this.ticketOrder.quantity == 0) {
      this.message = "Đã hết vé"
    } else {
      this.ticketService.order(id, this.ticketOrder).subscribe(data => {
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
    this.p = 1;
    this.ticketService.delete(id).subscribe(data => {
      this.ngOnInit()
      this.message = "Xóa vé thành công"
    })
  }

  private setDay(firstDay: string, secondDay: string) {

    if (firstDay == "") {
      this.firstDaySearch = "0001-01-01";
    }
    if (secondDay == "") {
      this.secondDaySearch = "9999-12-31";
    }
  }
}
