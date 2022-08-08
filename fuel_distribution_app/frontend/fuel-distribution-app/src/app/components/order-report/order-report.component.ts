import { Component, OnInit } from '@angular/core';
import { OrderDTO } from 'src/app/DTO/OrderDTO';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-order-report',
  templateUrl: './order-report.component.html',
  styleUrls: ['./order-report.component.scss']
})
export class OrderReportComponent implements OnInit {

  orders:OrderDTO[] = [];
  
  constructor(private orderSerivce:OrdersService) { }

  ngOnInit() {
    this.getAllOrders();
  }

  getAllOrders(){

    return this.orderSerivce.getAllOrders().subscribe(
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
            console.log(this.orders[i]);
          }
        }
      }
    )
  }

  removeOrder(id){

    return this.orderSerivce.removeOrder(id).subscribe(res=>{
      if(res==true){
        alert("Order removed");
        this.orders = [];
        this.getAllOrders();
      }else{
        alert("Something went wrong");
      }
    })
  }
}

