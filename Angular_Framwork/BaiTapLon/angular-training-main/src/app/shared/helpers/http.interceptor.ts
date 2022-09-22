import {Injectable} from '@angular/core';
import {
    HttpEvent,
    HttpInterceptor,
    HttpHandler,
    HttpRequest,
    HTTP_INTERCEPTORS,
    HttpHeaders
} from '@angular/common/http';
import {StorageService} from "../services/storage.service";
import {Observable, throwError} from 'rxjs';
import {catchError} from 'rxjs/operators';
import {Router} from "@angular/router";

@Injectable()
export class HttpRequestInterceptor implements HttpInterceptor {
    constructor(private storageSerice: StorageService, private router: Router) {
    }

    intercept(req: HttpRequest<any>, next: HttpHandler): Observable<HttpEvent<any>> {
        const userToken = this.storageSerice.getToken();
        let httpHeader = new HttpHeaders({
            'Content-Type': 'application/json',
            'Access-Control-Allow-Origin': '*',
            'Access-Control-Allow-Headers': 'Content-Type',
            'Access-Control-Allow-Methods': 'GET,POST,OPTIONS,DELETE,PUT',
        });
        if (userToken !== null) {
            httpHeader = httpHeader.append('Authorization', 'Bearer ' + userToken)
        }
        req = req.clone({
            headers: httpHeader
        });
        return next.handle(req).pipe(catchError(err => {
            if (err?.status === 401 && err?.error?.code === 'ACCESS_TOKEN_EXPIRED') {
                // auto logout if 401 response returned from api
                this.storageSerice.clearToken();
                this.router.navigate(['/auth/login'])
            }
            const error = (err && err.error && err.error.message)
            console.error(err);
            return throwError(error);
        }));
    }
}

export const httpInterceptorProviders = [
    {provide: HTTP_INTERCEPTORS, useClass: HttpRequestInterceptor, multi: true},
];
