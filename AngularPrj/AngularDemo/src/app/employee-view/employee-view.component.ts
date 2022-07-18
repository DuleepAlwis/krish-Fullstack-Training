import { Component, OnInit } from '@angular/core';
import { Employee } from '../module/Employee';
import { EmployeeServiceService } from '../services/employee-service.service';

@Component({
  selector: 'app-employee-view',
  templateUrl: './employee-view.component.html',
  styleUrls: ['./employee-view.component.scss']
})
export class EmployeeViewComponent implements OnInit {

   employeeList:Employee[] = [];

  constructor(private empSerivce:EmployeeServiceService) { 
    console.log("Constructer")
  }

  ngOnInit() {

    // this.empSerivce.getEmployees().subscribe(
    //   res=>{
    //     console.log(res);
    //     //this.employeeList = res;
    //   }
    //)
    console.log("Init");
    this.employeeList = [
      {"id":1,"name":"User1","address":"aaa1"},
      {"id":2,"name":"User2","address":"aaa2"},
      {"id":3,"name":"User3","address":"aaa3"}
  ];
  }



}
