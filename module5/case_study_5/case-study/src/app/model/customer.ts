import {CustomerType} from "./customer-type";

export interface Customer {
  id: number,
  img:string,
  name: string,
  dateOfBirth: string,
  gender: number,
  idCard: string,
  phone: string,
  email: string,
  address: string,
  customerType: CustomerType
}
