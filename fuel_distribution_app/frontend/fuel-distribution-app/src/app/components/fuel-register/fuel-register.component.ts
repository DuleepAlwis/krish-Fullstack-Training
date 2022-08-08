import { Component, OnInit } from '@angular/core';
import { FormControl, FormGroup, Validators } from '@angular/forms';
import { OrderDTO } from 'src/app/DTO/OrderDTO';
import { OrdersService } from 'src/app/services/orders.service';

@Component({
  selector: 'app-fuel-register',
  templateUrl: './fuel-register.component.html',
  styleUrls: ['./fuel-register.component.scss']
})
export class FuelRegisterComponent implements OnInit {

 
  orderForm = new FormGroup({
    gasSid:new FormControl('',[Validators.required]),
    name:new FormControl('',[Validators.required]),
    type:new FormControl('',[Validators.required]),
    amount:new FormControl('',[Validators.required]),
    city:new FormControl('',[Validators.required]),
    district:new FormControl('',[Validators.required]),
    address:new FormControl('',[Validators.required])

  })
  constructor(private orderService:OrdersService) { }

  ngOnInit() {
  }

  saveOrder(){
    
    let order = new OrderDTO();

    order.gasStId = this.orderForm.get("gasSid").value;
    order.gasStName = this.orderForm.get("name").value;
    order.typeOfFuel = this.orderForm.get("type").value;
    order.amount_needed = this.orderForm.get("amount").value;
    order.city = this.orderForm.get("city").value;
    order.district = this.orderForm.get("district").value;
    order.address = this.orderForm.get("address").value;

    
    this.orderService.saveOrder(order).subscribe(
      res=>{
        if(res==true){
          alert("Order saved");
        }
      }
    )

  }

}
