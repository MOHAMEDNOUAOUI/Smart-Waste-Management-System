import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class AuthServiceService {
  private baseUrl = 'http://localhost:8082/auth';

  constructor(private http: HttpClient) { }

  register(username: string, email: string, password: string, confirmPassword: string): Observable<any> {
    const registrationRequest = {
      username,
      email,
      password,
      confirmPassword
    };

    return this.http.post<any>(`${this.baseUrl}/register`, registrationRequest, {
    });
  }
}
