import { Injectable } from '@angular/core';

import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Employee } from '../module/Employee';

@Injectable({
  providedIn: 'root'
})
export class EmployeeServiceService {

   baseUrl = "localhost:8080";

  constructor(private http:HttpClient) { }

  getEmployees():Observable<Employee[]>{
    return this.http.get<Employee[]>(this.baseUrl+"/employee/getAll");
  } 
}
