import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Observable } from 'rxjs';
import { EnrollmentService } from '../../services/enrollment';
import { NotificationService } from '../../services/notification';
import { Course } from '../../models/course';

@Component({
  selector: 'app-student-profile',
  standalone: true,
  imports: [CommonModule],
  providers: [NotificationService],
  templateUrl: './student-profile.html',
  styleUrl: './student-profile.css'
})
export class StudentProfileComponent implements OnInit {
  enrolledCourses$!: Observable<Course[]>;

  constructor(
    private enrollmentService: EnrollmentService,
    private notificationService: NotificationService
  ) {}

  ngOnInit(): void {
    this.enrolledCourses$ = this.enrollmentService.getEnrolledCourses();
    this.notificationService.addNotification('Loaded profile enrolled courses.');
  }

  get notifications(): string[] {
    return this.notificationService.getNotifications();
  }
}