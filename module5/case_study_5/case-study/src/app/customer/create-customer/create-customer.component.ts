import { Component, OnInit } from '@angular/core';
import {CustomerServiceService} from "../../service/customer-service.service";
import {FormBuilder, FormGroup} from "@angular/forms";
import {CustomerType} from "../../model/customer-type";

@Component({
  selector: 'app-create-customer',
  templateUrl: './create-customer.component.html',
  styleUrls: ['./create-customer.component.css']
})
export class CreateCustomerComponent implements OnInit {
  message:string;
  formCustomer: FormGroup;
  listCustomerType: CustomerType[]=[];
  constructor(private _customerService:CustomerServiceService,
              private _formBuilder: FormBuilder) { }

  ngOnInit(): void {
    this._customerService.getListCustomerType().subscribe(data=>{
      this.listCustomerType = data
    });
      this.formCustomer = this._formBuilder.group({
        img:["ok"],
        name: [],
        dateOfBirth: [],
        gender: [],
        idCard: [],
        phone: [],
        email: [],
        address: [],
        customerType: []

    });

  }

  addNewCustomer() {
    const customer = this.formCustomer.value;
    this._customerService.saveCustomer(customer).subscribe(data=>{
      this.formCustomer = this._formBuilder.group({
        img:["ok"],
        name: [data.name],
        dateOfBirth: [data.dateOfBirth],
        gender: [data.gender],
        idCard: [data.idCard],
        phone: [data.phone],
        email: [data.email],
        address: [data.address],
        customerType: [data.customerType]
      })
      this.message = "Add new success"
    })
  }
}
