import { Component } from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {FormsModule} from '@angular/forms';

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
  role: string = 'employee'; // To capture admin/employee role selection

  constructor(private router: Router) {}

  register() {
    if (this.role === 'admin') {
      this.router.navigate(['/admin']); // Navigate to admin homepage
    } else if (this.role === 'employee') {
      this.router.navigate(['/employee']); // Navigate to employee homepage
    } else {
      alert('Please select a role.');
    }
  }
}
