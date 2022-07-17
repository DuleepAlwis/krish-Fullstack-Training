import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { AppComponent } from './app.component';
import { ComponentOneComponent } from './component-one/component-one.component';


const routes: Routes = [
  {
    path:'',
    component:AppComponent
  },
  {
    path:'componentone',
    component:ComponentOneComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
