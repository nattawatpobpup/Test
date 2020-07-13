import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs/Observable';

@Injectable({
  providedIn: 'root'
})
export class FieldService {
  public API = '//localhost:8080';
  constructor(private http: HttpClient) { }


  getGender(): Observable<any> {
    return this.http.get(this.API + '/Gender');
  }
  getCar(): Observable<any> {
    return this.http.get(this.API + '/Car');
  }
  getUser(): Observable<any> {
    return this.http.get(this.API + '/userName');
  }
  getOrder(): Observable<any> {
    return this.http.get(this.API + '/order');
  }
}
