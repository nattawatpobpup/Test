import { Component, OnInit } from '@angular/core';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material';
import {FieldService} from '../shared/field/field.service';
import {DomSanitizer} from '@angular/platform-browser';
import {Router} from '@angular/router';

@Component({
  selector: 'app-add-user',
  templateUrl: './add-user.component.html',
  styleUrls: ['./add-user.component.css']
})
export class AddUserComponent implements OnInit {
  Data: any = {
    name: '',
    age: '',
    genderSelect: '',
    passport: ''
  };
  genders: Array<any>;
  http: String = 'http://localhost:8080/';
  constructor(private router: Router, private httpClient: HttpClient, private snackBar: MatSnackBar , private fieldService: FieldService) { }

  ngOnInit() {
    this.fieldService.getGender().subscribe(data => {
      this.genders = data;

    });

  }

  adduser() {
    this.httpClient.post(this.http + 'addUser/' + this.Data.genderSelect + '/' + this.Data.age , this.Data)
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
