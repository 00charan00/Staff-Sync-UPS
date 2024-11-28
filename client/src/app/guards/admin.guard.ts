import {ActivatedRouteSnapshot, CanActivate, Router, RouterStateSnapshot} from '@angular/router';
import {AuthService} from '../service/auth.service';

export  class AdminGuard implements CanActivate{

  constructor(private authService:AuthService,private route:Router) {
  }

  canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean{
    if(this.authService.isAuthenticated() && this.authService.isAdministrator())return true;
    this.route.navigate(['/register'])
    return false;
  }

}
