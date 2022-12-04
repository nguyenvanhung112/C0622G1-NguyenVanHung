import {Component, OnInit} from '@angular/core';
import {CustomerServiceService} from "../../service/customer-service.service";
import {Customer} from "../../model/customer";
import {Route, Router} from "@angular/router";
import {CustomerType} from "../../model/customer-type";

@Component({
  selector: 'app-list-customer',
  templateUrl: './list-customer.component.html',
  styleUrls: ['./list-customer.component.css']
})
export class ListCustomerComponent implements OnInit {
  customers: Customer[] = [];
  deleteCustomer: Customer;
  message: string;
  customerType: CustomerType[] = [];
  p = 1;
  searchName = '';
  searchEmail = '';
  searchCustomerType = '';
  searchDayOfBirth = '';
  searchDayOfBirth2 = '';


  constructor(private _customerService: CustomerServiceService,
              private router: Router) {
  }

  ngOnInit(): void {
    this._customerService.findAll().subscribe(data => {
      this.customers = data;
    });
    this._customerService.getListCustomerType().subscribe(data => {
      this.customerType = data
    });
  }

  customerDelete(id: number) {
    this._customerService.findById(id).subscribe(data => {
      this.deleteCustomer = data;
    })
  }

  deleteCustomerById(id: number) {
    this._customerService.deleteCustomer(id).subscribe(data => {
      this.message = "Delete success!"
      this.router.navigateByUrl("customer/list");
      this.ngOnInit()
    }, error => {
      this.message = "Delete not success!"
    })
  }

  findNameEmailCustomerTypeDayOfBirth() {
    this.p = 1;
    this._customerService.searchNameEmailCustomerType(
      this.searchName, this.searchEmail, this.searchCustomerType).subscribe(
      data => {
        this.customers = data.filter(value => {
            const format = new Date(value.dateOfBirth);
            if (this.searchDayOfBirth !== "" || this.searchDayOfBirth2 !== "") {
              if (this.searchDayOfBirth == "") {
                let startDate1 = new Date("0001-01-01");
                let endDate = new Date(this.searchDayOfBirth2);
                if (format >= startDate1 && format <= endDate) {
                  return data;
                }
              } else if (this.searchDayOfBirth2 == "") {
                const startDate = new Date(this.searchDayOfBirth);
                let endDate1 = new Date();
                if (format >= startDate && format <= endDate1) {
                  return data;
                }
              } else {
                const startDate = new Date(this.searchDayOfBirth);
                const endDate1 = new Date(this.searchDayOfBirth2);
                if (format >= startDate && format <= endDate1) {
                  return data;
                }
              }
            } else {
              return data;
            }
          }
        );
      });
  }

  resetSearch() {
    this.ngOnInit();
  }
}
