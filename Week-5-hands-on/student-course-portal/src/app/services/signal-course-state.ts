import { Injectable, signal, computed, effect } from '@angular/core';
import { CourseService } from './course';
import { Course } from '../models/course';

@Injectable({
  providedIn: 'root'
})
export class SignalCourseStateService {
  // 1. Writable Signals for Core State
  readonly courses = signal<Course[]>([]);
  readonly searchTerm = signal<string>('');
  readonly selectedGrade = signal<string>('all');

  // 2. Computed Signals (automatically re-evaluate when dependencies change)
  readonly filteredCourses = computed(() => {
    const list = this.courses();
    const search = this.searchTerm().toLowerCase();
    const grade = this.selectedGrade();

    return list.filter(course => {
      const matchesSearch = course.name.toLowerCase().includes(search) ||
                            course.code.toLowerCase().includes(search);
      const matchesGrade = grade === 'all' || course.gradeStatus === grade;
      return matchesSearch && matchesGrade;
    });
  });

  readonly totalCoursesCount = computed(() => this.courses().length);
  readonly filteredCoursesCount = computed(() => this.filteredCourses().length);

  constructor(private courseService: CourseService) {
    this.loadCourses();

    // 3. Signal Effect for Logging State Changes
    effect(() => {
      console.log(`[Signal State Effect] Filtered count: ${this.filteredCoursesCount()} / ${this.totalCoursesCount()}`);
    });
  }

  loadCourses(): void {
    this.courseService.getCourses().subscribe({
      next: (data) => this.courses.set(data),
      error: (err) => console.error('Error loading signals state:', err)
    });
  }

  setSearchTerm(term: string): void {
    this.searchTerm.set(term);
  }

  setGradeFilter(grade: string): void {
    this.selectedGrade.set(grade);
  }
}