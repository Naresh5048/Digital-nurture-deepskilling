import { ComponentFixture, TestBed } from '@angular/core/testing';
import { CourseCardComponent } from './course-card';
import { Course } from '../../models/course';

describe('CourseCardComponent', () => {
  let component: CourseCardComponent;
  let fixture: ComponentFixture<CourseCardComponent>;

  const dummyCourse: Course = {
    id: 101,
    name: 'Test Driven Development',
    code: 'CS999',
    credits: 4,
    gradeStatus: 'passed'
  };

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [CourseCardComponent]
    }).compileComponents();

    fixture = TestBed.createComponent(CourseCardComponent);
    component = fixture.componentInstance;
    component.course = dummyCourse;
    fixture.detectChanges();
  });

  it('should create and bind input course data', () => {
    expect(component).toBeTruthy();
    const compiled = fixture.nativeElement as HTMLElement;
    expect(compiled.querySelector('h3')?.textContent).toContain('Test Driven Development');
  });

  it('should emit enrollRequested event when toggleEnrollment is called', () => {
    let emittedId: number | string | undefined;
    component.enrollRequested.subscribe((id) => {
      emittedId = id;
    });

    component.toggleEnrollment();
    expect(emittedId).toBe(101);
  });
});