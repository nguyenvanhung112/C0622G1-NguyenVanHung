import { NgModule } from '@angular/core';
import {RouterModule, Routes} from "@angular/router";
import {TodoComponent} from "./todo/todo.component";
import {TodoDeleteComponent} from "./todo-delete/todo-delete/todo-delete.component";

const routes: Routes = [{
  path: 'todo/list',
  component: TodoComponent
},
  {
    path: 'todo/delete/:id',
    component: TodoDeleteComponent
  }];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
