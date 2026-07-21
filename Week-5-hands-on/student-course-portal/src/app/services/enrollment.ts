import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { map } from 'rxjs/operators';
import { CourseService } from './course';
import { Course } from '../models/course';

@Injectable({
  providedIn: 'root'
})
export class EnrollmentService {
  private enrolledCourseIds: (number | string)[] = [];

  constructor(private courseService: CourseService) {}

  enroll(courseId: number | string): void {
    if (!this.isEnrolled(courseId)) {
      this.enrolledCourseIds.push(courseId);
    }
  }

  unenroll(courseId: number | string): void {
    this.enrolledCourseIds = this.enrolledCourseIds.filter(id => id !== courseId);
  }

  isEnrolled(courseId: number | string): boolean {
    return this.enrolledCourseIds.includes(courseId);
  }

  // Returns an Observable array of enrolled Course objects
  getEnrolledCourses(): Observable<Course[]> {
    return this.courseService.getCourses().pipe(
      map(courses => courses.filter(c => this.enrolledCourseIds.includes(c.id)))
    );
  }
}