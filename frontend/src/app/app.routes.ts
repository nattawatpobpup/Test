import { Routes, RouterModule } from '@angular/router';
import { AddUserComponent } from './add-user/add-user.component';
import { AddCarComponent } from './add-car/add-car.component';
import { AddOrserComponent } from './add-orser/add-orser.component';
import { PaybackComponent} from './payback/payback.component';
import {FixCarComponent} from './fix-car/fix-car.component';
import { MainComponent } from './main/main.component';

const routes: Routes = [
  { path: '',  redirectTo: '/', pathMatch: 'full' },
  {path: '', component : MainComponent},
  {path: 'addUser', component : AddUserComponent},
  {path: 'addCar', component : AddCarComponent},
  {path: 'addOrder', component : AddOrserComponent},
  {path: 'payBack', component : PaybackComponent},
  {path: 'fixCar', component : FixCarComponent}

]
export const routing = RouterModule.forRoot(routes);
