import { Injectable } from '@angular/core';

@Injectable() // Omit providedIn: 'root' to demonstrate component-level scoping
export class NotificationService {
  private messages: string[] = [];

  addNotification(message: string): void {
    this.messages.push(message);
  }

  getNotifications(): string[] {
    return this.messages;
  }
}