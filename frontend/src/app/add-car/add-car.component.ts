import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material';
import {FieldService} from '../shared/field/field.service';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-add-car',
  templateUrl: './add-car.component.html',
  styleUrls: ['./add-car.component.css']
})
export class AddCarComponent implements OnInit {
  Data: any = {
    carName: '',
    carId: '',
   };
  http: String = 'http://localhost:8080/';
  constructor(private router: Router, private httpClient: HttpClient, private snackBar: MatSnackBar , private fieldService: FieldService) { }

  ngOnInit() {
  }

  addcar() {
    this.httpClient.post(this.http + 'addCar', this.Data)
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
