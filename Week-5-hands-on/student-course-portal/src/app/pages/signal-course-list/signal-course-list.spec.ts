import { ComponentFixture, TestBed } from '@angular/core/testing';
import { provideHttpClient } from '@angular/common/http';
import { SignalCourseListComponent } from './signal-course-list';

describe('SignalCourseListComponent', () => {
  let component: SignalCourseListComponent;
  let fixture: ComponentFixture<SignalCourseListComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [SignalCourseListComponent],
      providers: [provideHttpClient()]
    }).compileComponents();

    fixture = TestBed.createComponent(SignalCourseListComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});