import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material';
import {FieldService} from '../shared/field/field.service';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-main',
  templateUrl: './main.component.html',
  styleUrls: ['./main.component.css']
})
export class MainComponent implements OnInit {
  http: String = 'http://localhost:8080/';


  constructor(private router: Router, private httpClient: HttpClient, private snackBar: MatSnackBar , private fieldService: FieldService) {

  }
  ngOnInit() {
  }
  adduser() {
    this.router.navigate(['addUser']);
  }
  addcar() {
    this.router.navigate(['addCar']);
  }
  addorder() {
    this.router.navigate(['addOrder']);
  }

  payback() {
    this.router.navigate(['payBack']);
  }
  fixcar() {
    this.router.navigate(['fixCar']);
  }
}
