import { Component } from '@angular/core';
import {Router, RouterLink} from '@angular/router';
import {FormsModule} from '@angular/forms';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  imports: [
    FormsModule,
    RouterLink
  ],
  styleUrls: ['./login.component.css'] // Correct style property name
})
export class LoginComponent {
  email: string = '';
  password: string = '';

  // Simulating user roles for demo purposes (replace with backend logic)
  mockUsers = [
    { email: 'admin@example.com', password: 'admin123', role: 'admin' },
    { email: 'employee@example.com', password: 'employee123', role: 'employee' }
  ];

  constructor(private router: Router) {}

  login() {
    // Simulate user login with role-based routing
    const user = this.mockUsers.find(
      (u) => u.email === this.email && u.password === this.password
    );

    if (user) {
      if (user.role === 'admin') {
        this.router.navigate(['/admin']); // Navigate to admin homepage
      } else if (user.role === 'employee') {
        this.router.navigate(['/employee']); // Navigate to employee homepage
      }
    } else {
      alert('Invalid email or password.');
    }
  }
}
