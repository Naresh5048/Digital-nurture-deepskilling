import { Routes } from '@angular/router';
import { HomeComponent } from './pages/home/home';
import { CourseListComponent } from './pages/course-list/course-list';
import { SignalCourseListComponent } from './pages/signal-course-list/signal-course-list';
import { CourseDetailComponent } from './pages/course-detail/course-detail';
import { StudentProfileComponent } from './pages/student-profile/student-profile';
import { EnrollmentFormComponent } from './pages/enrollment-form/enrollment-form';
import { ReactiveEnrollmentFormComponent } from './pages/reactive-enrollment-form/reactive-enrollment-form';
import { NotFoundComponent } from './pages/not-found/not-found';

import { authGuard } from './guards/auth-guard';
import { unsavedChangesGuard } from './guards/unsaved-changes-guard';

export const routes: Routes = [
  { path: '', component: HomeComponent },
  { path: 'courses', component: CourseListComponent },
  { path: 'signals-courses', component: SignalCourseListComponent },
  { path: 'courses/:id', component: CourseDetailComponent },
  { path: 'profile', component: StudentProfileComponent, canActivate: [authGuard] },
  { path: 'enroll', component: EnrollmentFormComponent },
  { 
    path: 'enroll-reactive', 
    component: ReactiveEnrollmentFormComponent, 
    canDeactivate: [unsavedChangesGuard] 
  },
  { path: '**', component: NotFoundComponent }
];