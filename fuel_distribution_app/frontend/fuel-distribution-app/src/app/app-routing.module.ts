import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { FuelRegisterComponent } from './components/fuel-register/fuel-register.component';
import { OrderReportComponent } from './components/order-report/order-report.component';
import { OrderStatusComponent } from './components/order-status/order-status.component';
import { SheduledOrdersComponent } from './components/sheduled-orders/sheduled-orders.component';


const routes: Routes = [
  {
    path:'fuelapp',
    component:FuelRegisterComponent
  },
  {
    path:"orderStatus",
    component:OrderStatusComponent
  },
  {
    path:"orderReport",
    component:OrderReportComponent
  },
  {
    path:"sheduledOrders",
    component:SheduledOrdersComponent
  }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
