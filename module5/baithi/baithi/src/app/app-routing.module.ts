import {NgModule} from '@angular/core';
import {Routes, RouterModule} from '@angular/router';
import {ListComponent} from "./list/list.component";
import {CreateComponent} from "./create/create.component";
import {EditComponent} from "./edit/edit.component";


const routes: Routes = [
  {
    path: "vexe",
    component: ListComponent
  },
  {
    path: "vexe/add",
    component: CreateComponent
  },
  {
    path: "vexe/edit/:id",
    component: EditComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule {
}
