import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material';
import {FieldService} from '../shared/field/field.service';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-add-orser',
  templateUrl: './add-orser.component.html',
  styleUrls: ['./add-orser.component.css']
})
export class AddOrserComponent implements OnInit {
  cars: Array<any>;
  users: Array<any>;
  Data: any = {
    user: '',
    car: ''
  };

  http: String = 'http://localhost:8080/';
  constructor(private router: Router, private httpClient: HttpClient, private snackBar: MatSnackBar , private fieldService: FieldService) { }

  ngOnInit() {
    this.fieldService.getCar().subscribe(data => {
      this.cars = data;
      console.log(this.cars);
    });
    this.fieldService.getUser().subscribe(data => {
      this.users = data;

    });
  }

  addorder() {
    this.httpClient.post(this.http + 'addOrder/' + this.Data.user + '/' + this.Data.car, this.Data)
      .subscribe(data => {
          this.snackBar.open('COMPLETE', 'OK', {duration: 3000});
          this.router.navigate(['']);
        }, error => {
          this.snackBar.open(error.error.message, 'OK', {duration: 3000});
          console.log(error);
        }
      );
  }
}
