import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { OrderDTO } from '../DTO/OrderDTO';
import { Observable } from 'rxjs';
import { Global } from '../DTO/Global';

@Injectable({
  providedIn: 'root'
})
export class OrdersService {

   base_url = Global.base_url;
   dispatchOrder = Global.dispatchDelivery;

  constructor(private http:HttpClient) { }

  public saveOrder(order:OrderDTO):Observable<Boolean>{

    return this.http.post<Boolean>(this.base_url+"/order/save",order);
  }

  public pendingOrders():Observable<OrderDTO[]>{

    return this.http.get<OrderDTO[]>(this.base_url+"/order/pendingOrders");
  }

  public pendingDelivery(category):Observable<OrderDTO[]>{

    return this.http.get<OrderDTO[]>(this.dispatchOrder+"/dispatch/pendingDeliveryOrders");
  }

  public setStatusToDispatch(id){
    return this.http.put<Boolean>(this.dispatchOrder+"/dispatch/order/"+id,null);
  }

  public getAllOrders():Observable<OrderDTO[]>{
    return this.http.get<OrderDTO[]>(this.base_url+"/order/getAllOrders");
  }

  public allocateFuel(id){
    return this.http.put<Boolean>(this.base_url+"/order/allocateFuel/"+id,null);
  }

  public removeOrder(id){
    return this.http.delete<Boolean>(this.base_url+"/order/removeOrder/"+id);
  }
}
