import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Global } from '../DTO/Global';

@Injectable({
  providedIn: 'root'
})
export class SheduleServiceService {

  url = Global.sheduleService;

  constructor(private http:HttpClient) { }


  public allocateVehicle(id):Observable<Boolean>{
   return this.http.put<Boolean>(this.url+"/shedule/allocateVehicle/"+id,null);
  }
}
