import { Routes } from '@angular/router';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { EmpHomeComponent } from './emp-home/emp-home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import {AuthGuard} from './auth.guard';

export const routes: Routes = [
  { path: '', component: AdminHomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'admin', component: AdminHomeComponent, canActivate: [AuthGuard] },  // Protect admin route
  { path: 'employee', component: EmpHomeComponent, canActivate: [AuthGuard] },  // Protect employee route
  { path: '**', redirectTo: '' }
];
