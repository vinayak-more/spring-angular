import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Employee } from './employee';
import { HttpClient } from '@angular/common/http';
import { Filter } from './filter';

@Injectable()
export class AppService{

    constructor(private http:HttpClient){}

    public getAllEmployees(filter:Filter):Observable<Employee[]>{
        return this.http.post<Employee[]>("http://localhost:8080/employees",filter);
    }
}