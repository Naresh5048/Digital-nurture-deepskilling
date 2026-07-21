import { Component, OnInit } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormControl, ReactiveFormsModule } from '@angular/forms';
import { Observable, debounceTime, distinctUntilChanged } from 'rxjs';
import { CourseCardComponent } from '../../components/course-card/course-card';
import { CourseStateService } from '../../services/course-state';
import { Course } from '../../models/course';

@Component({
  selector: 'app-course-list',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule, CourseCardComponent],
  templateUrl: './course-list.html',
  styleUrl: './course-list.css'
})
export class CourseListComponent implements OnInit {
  searchControl = new FormControl('');
  filteredCourses$!: Observable<Course[]>;

  constructor(private courseState: CourseStateService) {}

  ngOnInit(): void {
    // Assign stream after constructor dependency injection completes
    this.filteredCourses$ = this.courseState.filteredCourses$;

    // Debounce search box input
    this.searchControl.valueChanges.pipe(
      debounceTime(300),
      distinctUntilChanged()
    ).subscribe(term => {
      this.courseState.setSearchTerm(term || '');
    });
  }

  onGradeFilterChange(event: Event): void {
    const select = event.target as HTMLSelectElement;
    this.courseState.setGradeFilter(select.value);
  }

  trackByCourseId(index: number, course: Course): number | string {
    return course.id;
  }

  onEnroll(courseId: number | string): void {
    console.log('Enrolled in course:', courseId);
  }
}