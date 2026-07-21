import { Injectable } from '@angular/core';
import { BehaviorSubject, Observable, combineLatest } from 'rxjs';
import { map, switchMap, tap } from 'rxjs/operators';
import { CourseService } from './course';
import { Course } from '../models/course';

@Injectable({
  providedIn: 'root'
})
export class CourseStateService {
  // State subjects holding latest values
  private coursesSubject = new BehaviorSubject<Course[]>([]);
  private searchTermSubject = new BehaviorSubject<string>('');
  private selectedGradeSubject = new BehaviorSubject<string>('all');

  // Exposed Readonly Observables
  courses$ = this.coursesSubject.asObservable();
  searchTerm$ = this.searchTermSubject.asObservable();
  selectedGrade$ = this.selectedGradeSubject.asObservable();

  // Derived Stream: Combines search term + grade filter + course list reactively
  filteredCourses$: Observable<Course[]> = combineLatest([
    this.courses$,
    this.searchTerm$,
    this.selectedGrade$
  ]).pipe(
    map(([courses, search, grade]) => {
      return courses.filter(course => {
        const matchesSearch = course.name.toLowerCase().includes(search.toLowerCase()) ||
                              course.code.toLowerCase().includes(search.toLowerCase());
        const matchesGrade = grade === 'all' || course.gradeStatus === grade;
        return matchesSearch && matchesGrade;
      });
    })
  );

  constructor(private courseService: CourseService) {
    this.loadInitialCourses();
  }

  loadInitialCourses(): void {
    this.courseService.getCourses().subscribe({
      next: (courses) => this.coursesSubject.next(courses),
      error: (err) => console.error('Error loading state courses:', err)
    });
  }

  setSearchTerm(term: string): void {
    this.searchTermSubject.next(term);
  }

  setGradeFilter(grade: string): void {
    this.selectedGradeSubject.next(grade);
  }
}