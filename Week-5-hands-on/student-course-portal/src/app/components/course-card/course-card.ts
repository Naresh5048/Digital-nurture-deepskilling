import { Component, Input, Output, EventEmitter, OnChanges, SimpleChanges } from '@angular/core';
import { CommonModule } from '@angular/common';
import { HighlightDirective } from '../../directives/highlight';
import { CreditLabelPipe } from '../../pipes/credit-label-pipe';
import { EnrollmentService } from '../../services/enrollment';
import { Course } from '../../models/course';

@Component({
  selector: 'app-course-card',
  standalone: true,
  imports: [CommonModule, HighlightDirective, CreditLabelPipe],
  templateUrl: './course-card.html',
  styleUrl: './course-card.css'
})
export class CourseCardComponent implements OnChanges {
  @Input() course!: Course;
  @Output() enrollRequested = new EventEmitter<number>();

  isExpanded = false;

  constructor(private enrollmentService: EnrollmentService) {}

  ngOnChanges(changes: SimpleChanges): void {
    console.log('CourseCard Input Changed:', changes);
  }

  get isEnrolled(): boolean {
    return this.enrollmentService.isEnrolled(this.course.id);
  }

  toggleEnrollment(): void {
    if (this.isEnrolled) {
      this.enrollmentService.unenroll(this.course.id);
    } else {
      this.enrollmentService.enroll(this.course.id);
    }
    this.enrollRequested.emit(this.course.id);
  }

  get cardClasses() {
    return {
      'card--enrolled': this.isEnrolled,
      'card--full': this.course.credits >= 4,
      'expanded': this.isExpanded
    };
  }

  get statusBorderColor(): string {
    switch (this.course.gradeStatus) {
      case 'passed': return '#16a34a';
      case 'failed': return '#dc2626';
      case 'pending': return '#64748b';
      default: return '#cbd5e1';
    }
  }

  toggleExpand(): void {
    this.isExpanded = !this.isExpanded;
  }
}