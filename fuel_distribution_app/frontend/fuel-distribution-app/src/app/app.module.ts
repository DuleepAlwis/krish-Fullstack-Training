import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { FuelRegisterComponent } from './components/fuel-register/fuel-register.component';
import { AppHeaderComponent } from './components/app-header/app-header.component';
import { ReactiveFormsModule } from '@angular/forms';
import { OrderStatusComponent } from './components/order-status/order-status.component';
import { OrderReportComponent } from './components/order-report/order-report.component';
import { HttpClientModule } from '@angular/common/http';
import { SheduledOrdersComponent } from './components/sheduled-orders/sheduled-orders.component';

@NgModule({
  declarations: [
    AppComponent,
    FuelRegisterComponent,
    AppHeaderComponent,
    OrderStatusComponent,
    OrderReportComponent,
    SheduledOrdersComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    ReactiveFormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
