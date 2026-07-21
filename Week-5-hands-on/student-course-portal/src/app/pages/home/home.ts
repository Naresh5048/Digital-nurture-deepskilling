import { Component, OnInit, OnDestroy } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { CommonModule } from '@angular/common';
import { CourseService } from '../../services/course';

@Component({
  selector: 'app-home',
  standalone: true,
  imports: [FormsModule, CommonModule],
  templateUrl: './home.html',
  styleUrl: './home.css'
})
export class HomeComponent implements OnInit, OnDestroy {
  portalName = 'Student Course Portal';
  isPortalActive = true;
  message = '';
  searchTerm = '';
  availableCoursesCount = 0;

  constructor(private courseService: CourseService) {}

  ngOnInit(): void {
    console.log('HomeComponent initialised');
    // Subscribe to the Observable stream to get array length
    this.courseService.getCourses().subscribe({
      next: (courses) => {
        this.availableCoursesCount = courses.length;
      },
      error: (err) => console.error('Failed to load courses count:', err)
    });
  }

  ngOnDestroy(): void {
    console.log('HomeComponent destroyed');
  }

  onEnrollClick(): void {
    this.message = 'Enrollment opened!';
  }
}