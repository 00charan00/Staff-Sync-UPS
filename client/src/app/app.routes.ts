import { Routes } from '@angular/router';
import { AdminHomeComponent } from './admin-home/admin-home.component';
import { EmpHomeComponent } from './emp-home/emp-home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import {AuthGuard} from './auth.guard';
import {AboutComponent} from './about/about.component';
import {EventsComponent} from './events/events.component';

export const routes: Routes = [
  { path: '', component: AdminHomeComponent },
  { path: 'register', component: RegisterComponent },
  { path: 'login', component: LoginComponent },
  { path: 'about', component: AboutComponent },
  { path: 'events', component: EventsComponent },
  { path: 'signup', component: RegisterComponent },
  { path: 'admin', component: AdminHomeComponent, canActivate: [AuthGuard] },  // Protect admin route
  { path: 'employee', component: EmpHomeComponent, canActivate: [AuthGuard] },  // Protect employee route
  { path: '**', redirectTo: '' }
];
