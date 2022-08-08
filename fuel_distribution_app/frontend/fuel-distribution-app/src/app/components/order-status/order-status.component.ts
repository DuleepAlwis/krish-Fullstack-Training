import { Component, OnInit } from '@angular/core';
import { OrderDTO } from 'src/app/DTO/OrderDTO';
import { OrdersService } from 'src/app/services/orders.service';
import { SheduleServiceService } from 'src/app/services/shedule-service.service';

@Component({
  selector: 'app-order-status',
  templateUrl: './order-status.component.html',
  styleUrls: ['./order-status.component.scss']
})
export class OrderStatusComponent implements OnInit {

   orders:OrderDTO[] = [];

  constructor(private orderSerivce:OrdersService,private sheduleService:SheduleServiceService) { }

  ngOnInit() {
    this.getAllPendingOrders();
  }

  getAllPendingOrders(){

    return this.orderSerivce.pendingOrders().subscribe(
      res=>{
        if(res!=null){
          for(var i=0;i<res.length;i++){
            //this.orders[i]=(res[i]);
            if(res[i].status=="0"){
              res[i].status = "Allocation pending";
            }else if(res[i].status=="1"){
              res[i].status = "Delivery pending";
            }else if(res[i].status=="2"){
              res[i].status = "Delivery Scheduled";
            }else if(res[i].status=="3"){
              res[i].status = "Vehicle allocated";
            }
            this.orders.push(res[i]);
            //console.log(this.orders[i]);
          }
        }
      }
    )
  }

  allocateFuel(id){
    this.orderSerivce.allocateFuel(id).subscribe(res=>{
      if(res==true){
       // alert("Fuel allocated");
        this.orders = [];
        this.getAllPendingOrders();
      }else{
       // alert("Fuel not allocated");
      }
    });
  }

  allocateVehicle(id){
    this.sheduleService.allocateVehicle(id).subscribe(res=>{
      if(res==true){
        // alert("Fuel allocated");
         this.orders = [];
         this.getAllPendingOrders();
       }else{
        // alert("Fuel not allocated");
       }
    })
  }
}
