import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loggedIn: boolean = false;

  constructor(private router: Router) {}

  // Call this method when the user successfully logs in
  login(): void {
    this.loggedIn = true;
    this.router.navigate(['/admin']);  // Redirect to admin page after login
  }

  // Call this method when the user logs out
  logout(): void {
    this.loggedIn = false;
    this.router.navigate(['/login']);  // Redirect to login page
  }

  // Check if the user is logged in
  isAuthenticated(): boolean {
    return this.loggedIn;
  }
}
