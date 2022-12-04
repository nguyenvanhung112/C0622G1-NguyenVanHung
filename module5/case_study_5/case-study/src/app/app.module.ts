import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { FooterComponent } from './footer/footer.component';
import { HeaderComponent } from './header/header.component';
import { NavigationComponent } from './navigation/navigation.component';
import {stringify} from "querystring";
import { ListComponent } from './facility/list/list.component';
import { CreateComponent } from './facility/create/create.component';
import { EditComponent } from './facility/edit/edit.component';
import { ListCustomerComponent } from './customer/list-customer/list-customer.component';
import { EditCustomerComponent } from './customer/edit-customer/edit-customer.component';
import { CreateCustomerComponent } from './customer/create-customer/create-customer.component';
import { CreateContractComponent } from './contract/create-contract/create-contract.component';
import { ListContractComponent } from './contract/list-contract/list-contract.component';
import { AppRoutingModule } from './app-routing.module';
import {HttpClientModule} from "@angular/common/http";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {NgxPaginationModule} from "ngx-pagination";

@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    FooterComponent,
    HeaderComponent,
    NavigationComponent,
    ListComponent,
    CreateComponent,
    EditComponent,
    ListCustomerComponent,
    EditCustomerComponent,
    CreateCustomerComponent,
    CreateContractComponent,
    ListContractComponent
  ],
    imports: [
        BrowserModule,
        HttpClientModule,
        AppRoutingModule,
        ReactiveFormsModule,
        FormsModule,
        NgxPaginationModule
    ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
