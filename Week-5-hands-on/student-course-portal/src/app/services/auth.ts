import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  private loggedIn = true; // Hardcoded logged in state

  isLoggedIn(): boolean {
    return this.loggedIn;
  }

  setLoggedIn(status: boolean): void {
    this.loggedIn = status;
  }
}