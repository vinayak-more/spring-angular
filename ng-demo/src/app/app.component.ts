import { Component, OnInit } from '@angular/core';
import { AppService } from './app.service';
import { Employee } from './employee';
import { Filter } from './filter';
import { SortEvent } from 'primeng/components/common/api';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.scss']
})
export class AppComponent implements OnInit {
  title = 'ng-demo';
  employees: Employee[];
  employees2: Employee[];
  cols;

  constructor(private service: AppService) {
    this.cols = [
      { field: 'id', header: 'Id' },
      { field: 'firstName', header: 'First Name' },
      { field: 'lastName', header: 'Last Name' },
      { field: 'designation', header: 'Designation' },
      { field: 'salary', header: 'salary' }
    ];
  }

  ngOnInit(): void {
    let filter = new Filter();
    filter.pageSize = 1000;
    filter.pageNumber = 0;
    this.service.getAllEmployees(filter).subscribe(e => { this.employees = e; this.employees2 = e; });
  }

  customSort(event: SortEvent) {
    let filter = new Filter();
    filter.pageSize = 1000;
    filter.pageNumber = 0;
    filter.sortBy=event.field;
    this.service.getAllEmployees(filter).subscribe(e => { this.employees = e; this.employees2 = e; });
  //   event.data.sort((data1, data2) => {
  //     let value1 = data1[event.field];
  //     let value2 = data2[event.field];
  //     let result = null;

  //     if (value1 == null && value2 != null)
  //       result = -1;
  //     else if (value1 != null && value2 == null)
  //       result = 1;
  //     else if (value1 == null && value2 == null)
  //       result = 0;
  //     else if (typeof value1 === 'string' && typeof value2 === 'string')
  //       result = value1.localeCompare(value2);
  //     else
  //       result = (value1 < value2) ? -1 : (value1 > value2) ? 1 : 0;

  //     return (event.order * result);
  //   });
   }
}
