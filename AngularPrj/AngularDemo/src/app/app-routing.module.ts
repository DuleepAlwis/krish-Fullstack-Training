import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { ComponentOneComponent } from './component-one/component-one.component';
import { EmployeeViewComponent } from './employee-view/employee-view.component';


const routes: Routes = [
  {
    path:'',
    component:AppComponent
  },
  {
    path:'DemoOne',
    component:ComponentOneComponent
  },
  {
    path:'viewEmps',
    component:EmployeeViewComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
