import {Component, OnInit} from '@angular/core';
import {CustomerServiceService} from "../../service/customer-service.service";
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {CustomerType} from "../../model/customer-type";
import {Customer} from "../../model/customer";
import {ActivatedRoute, ParamMap} from "@angular/router";
import validate = WebAssembly.validate;

@Component({
  selector: 'app-edit-customer',
  templateUrl: './edit-customer.component.html',
  styleUrls: ['./edit-customer.component.css']
})
export class EditCustomerComponent implements OnInit {

  createForm: FormGroup;
  listCustomerType: CustomerType[] = [];
  customer: Customer;
  id: number;
  message: string;

  equals(o1: CustomerType, o2: CustomerType) {
    return o1.id === o2.id;
  }

  constructor(private _customerService: CustomerServiceService,
              private _formBuilder: FormBuilder,
              private _activatedRoute: ActivatedRoute) {
  }

  ngOnInit(): void {
    this._customerService.getListCustomerType().subscribe(data => {
      this.listCustomerType = data
    })
    this._activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get("id")
    })
    this._customerService.findById(this.id).subscribe(data => {
      this.customer = data;
      this.createForm = this._formBuilder.group({
        img: ["ok"],
        name: [this.customer.name],
        dateOfBirth: [this.customer.dateOfBirth],
        gender: [this.customer.gender],
        idCard: [this.customer.idCard],
        phone: [this.customer.phone],
        email: [this.customer.email],
        address: [this.customer.address],
        customerType: [this.customer.customerType]
      })
    });
  }

  updateCustomer(id:number) {
    const customer = this.createForm.value;
    this._customerService.updateCustomer(id,customer).subscribe(data=>{
     this.message = "Update success!"
      this.customer = data;
      this.createForm = this._formBuilder.group({
        img: ["ok"],
        name: [this.customer.name],
        dateOfBirth: [this.customer.dateOfBirth],
        gender: [this.customer.gender],
        idCard: [this.customer.idCard],
        phone: [this.customer.phone],
        email: [this.customer.email],
        address: [this.customer.address],
        customerType: [this.customer.customerType]
      })
    })
  }
}
