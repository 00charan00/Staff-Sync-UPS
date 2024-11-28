import { Injectable } from '@angular/core';
import { Router } from '@angular/router';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loggedIn: boolean = false;
  private isAdmin: boolean = false;

  constructor(private router: Router) {}

  // Call this method when the user successfully logs in
  login(): void {
    this.loggedIn = true;
    this.router.navigate([''])
  }

  adminLogin(){
    this.loggedIn = true;
    this.isAdmin = true;
    this.router.navigate(['/admin'])
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

  isAdministrator():boolean{
    return this.isAdmin;
  }
}
