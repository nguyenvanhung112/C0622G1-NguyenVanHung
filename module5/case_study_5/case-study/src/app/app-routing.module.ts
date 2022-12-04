import {NgModule} from '@angular/core';
import {CommonModule} from '@angular/common';
import {RouterModule, Routes} from "@angular/router";
import {ListComponent} from "./facility/list/list.component";
import {CreateComponent} from "./facility/create/create.component";
import {EditComponent} from "./facility/edit/edit.component";
import {ListCustomerComponent} from "./customer/list-customer/list-customer.component";
import {CreateCustomerComponent} from "./customer/create-customer/create-customer.component";
import {EditCustomerComponent} from "./customer/edit-customer/edit-customer.component";
import {ListContractComponent} from "./contract/list-contract/list-contract.component";
import {CreateContractComponent} from "./contract/create-contract/create-contract.component";
import {HomeComponent} from "./home/home.component";


const routes: Routes = [
  {
    path: "facility",
    component: ListComponent
  },
  {
    path: "facility/create",
    component: CreateComponent
  },
  {
    path: "facility/edit/:id",
    component: EditComponent
  },
  {
    path: "customer/list",
    component: ListCustomerComponent
  },
  {
    path: "customer/create",
    component: CreateCustomerComponent
  },
  {
    path: "customer/edit/:id",
    component: EditCustomerComponent
  },
  {
    path: "contract/list",
    component: ListContractComponent
  },
  {
    path: "contract/create",
    component: CreateContractComponent
  },
  {
    path: "home",
    component: HomeComponent
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
