import { Component, OnInit } from '@angular/core';
import {Router} from '@angular/router';
import {HttpClient} from '@angular/common/http';
import {MatSnackBar} from '@angular/material';
import {FieldService} from '../shared/field/field.service';
import {DomSanitizer} from '@angular/platform-browser';

@Component({
  selector: 'app-payback',
  templateUrl: './payback.component.html',
  styleUrls: ['./payback.component.css']
})
export class PaybackComponent implements OnInit {
  ShowAll: Array<any>;
  showAllColumns: string[] = ['no', 'name' , 'carId' , 'timestart' , 'timeend' , 'payback'];
  http: String = 'http://localhost:8080/';

  constructor(private router: Router, private httpClient: HttpClient, private snackBar: MatSnackBar , private fieldService: FieldService, private sanitizer: DomSanitizer) { }

  ngOnInit() {
    this.fieldService.getOrder().subscribe(data => {
      this.ShowAll = data;
      console.log(this.ShowAll);
    });
  }

  payback(id) {
    this.httpClient.put(this.http + 'paybackOrder/' + id , PaybackComponent)
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
