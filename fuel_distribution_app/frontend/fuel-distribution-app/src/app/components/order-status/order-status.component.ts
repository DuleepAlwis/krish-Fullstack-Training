import { Component, OnInit } from '@angular/core';
import { OrderDTO } from 'src/app/DTO/OrderDTO';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-order-status',
  templateUrl: './order-status.component.html',
  styleUrls: ['./order-status.component.scss']
})
export class OrderStatusComponent implements OnInit {

   orders:OrderDTO[] = [];

  constructor(private orderSerivce:OrdersService) { }

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
              res[i].status = "Delivery pending";
            }else if(res[i].status=="1"){
              res[i].status = "Already delivered";
            }else if(res[i].status=="2"){
              res[i].status = "Already delivered";
            }
            this.orders.push(res[i]);
            console.log(this.orders[i]);
          }
        }
      }
    )
  }
}
