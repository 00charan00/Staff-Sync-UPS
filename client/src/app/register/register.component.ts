import {Component} from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {FormsModule} from '@angular/forms';
import {StaffService} from '../service/staff.service';
import {RegisterReq, StaffRole} from '../model/register-req';
import {AuthService} from '../service/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  imports: [
    FormsModule,
    RouterLink
  ],
  styleUrls: ['./register.component.css'] // Corrected property name
})
export class RegisterComponent {
  name: string = '';
  email: string = '';
  password: string = '';
  role: string = '';

  constructor(private router: Router,private staffServer:StaffService,private authService:AuthService) {}

  register() {

    if(this.name != '' && this.email != '' && this.password != ''){
      this.staffServer.registerStaff(
        new RegisterReq(
          this.name,
          this.email,
          this.password
        )
      ).subscribe(res => {
        if(res.status){
          if(res.role == StaffRole.ROLE_ADMIN){
            this.authService.adminLogin();
          }else if(res.role == StaffRole.ROLE_EMPLOYEE){
            this.authService.login();
          }
        }else{
          console.log(false)
        }
      })
    }
  }
}
