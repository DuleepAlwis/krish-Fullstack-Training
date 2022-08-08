import { Component, OnInit } from '@angular/core';
import { OrderDTO } from 'src/app/DTO/OrderDTO';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-sheduled-orders',
  templateUrl: './sheduled-orders.component.html',
  styleUrls: ['./sheduled-orders.component.scss']
})
export class SheduledOrdersComponent implements OnInit {

  orders : OrderDTO[] = [];

  constructor(private orderService:OrdersService) { }

  ngOnInit() {
    return this.orderService.pendingDelivery(0).subscribe(
      res=>{
        if(res!=null){
          for(var i=0;i<res.length;i++){
           this.orders[i] = res[i];
          }
        }
      }
      
    )
  }

  dispatchOrder(id){
   
    this.orderService.setStatusToDispatch(id).subscribe(
      res=>{
        if(res==true){
          alert("Order dispatched");
          
          for(var i=0;i<this.orders.length;i++){
            if(this.orders[i].id==id){
              this.orders.splice(i,1);
            }
          }
        }else{
          alert("Something went wrong");
        }
      }
    )
  }

}
