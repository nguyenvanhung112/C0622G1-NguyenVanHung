import {Injectable} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Customer} from "../model/customer";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {CustomerType} from "../model/customer-type";

@Injectable({
  providedIn: 'root'
})
export class CustomerServiceService {
  constructor(private httpClient: HttpClient) {
  }


  findAll(): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(environment.customerUrl)
  }

  findById(id: number): Observable<Customer> {
    return this.httpClient.get<Customer>(environment.customerUrl + "/" + id)
  }

  deleteCustomer(id: number): Observable<Customer> {
    return this.httpClient.delete<Customer>(environment.customerUrl + "/" + id)
  }

  getListCustomerType(): Observable<CustomerType[]> {
    return this.httpClient.get<CustomerType[]>(environment.customerTypeUrl)
  }

  saveCustomer(customer: Customer): Observable<Customer> {
    return this.httpClient.post<Customer>(environment.customerUrl, customer)
  }

  updateCustomer(id: number, customer: Customer): Observable<Customer> {
    return this.httpClient.put<Customer>(environment.customerUrl + "/" + id, customer)
  }

  searchNameEmailCustomerType(name: string, email: string, customerType: string): Observable<Customer[]> {
    return this.httpClient.get<Customer[]>(
      `${environment.customerUrl}?name_like=${name}&email_like=${email}&customerType.name_like=${customerType}`
    );
  }
}
