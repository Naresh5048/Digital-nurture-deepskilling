import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { CourseCardComponent } from '../../components/course-card/course-card';
import { SignalCourseStateService } from '../../services/signal-course-state';
import { Course } from '../../models/course';

@Component({
  selector: 'app-signal-course-list',
  standalone: true,
  imports: [CommonModule, FormsModule, CourseCardComponent],
  templateUrl: './signal-course-list.html',
  styleUrl: './signal-course-list.css'
})
export class SignalCourseListComponent {
  constructor(public signalState: SignalCourseStateService) {}

  onSearchChange(term: string): void {
    this.signalState.setSearchTerm(term);
  }

  onGradeChange(grade: string): void {
    this.signalState.setGradeFilter(grade);
  }

  trackByCourseId(index: number, course: Course): number | string {
    return course.id;
  }

  onEnroll(courseId: number | string): void {
    console.log('Signal List Enrolled in:', courseId);
  }
}