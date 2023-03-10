import { Injectable } from '@angular/core';
import { ActivatedRouteSnapshot, Router, RouterStateSnapshot, CanActivate } from '@angular/router';
import { RoutingConstants } from '@core/navigation';
import { Logger } from '@core/logger/logger.service';
import { CredentialsService } from './credentials.service';

const log = new Logger('Authentication Guard');

@Injectable()
export class AuthenticationGuard implements CanActivate {
    constructor(private router: Router, private credentialsService: CredentialsService) { }

    canActivate(route: ActivatedRouteSnapshot, state: RouterStateSnapshot): boolean {
        if (this.credentialsService.isAuthenticated()) {
            return true;
        }

        log.debug('Not authenticated, redirecting and adding redirect url...');
        this.router.navigate([RoutingConstants.LOGIN], { queryParams: { redirect: state.url }, replaceUrl: true });
        return false;
    }
}
