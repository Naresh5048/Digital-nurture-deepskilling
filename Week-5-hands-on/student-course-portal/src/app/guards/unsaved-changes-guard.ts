import { CanDeactivateFn } from '@angular/router';
import { ReactiveEnrollmentFormComponent } from '../pages/reactive-enrollment-form/reactive-enrollment-form';

export const unsavedChangesGuard: CanDeactivateFn<ReactiveEnrollmentFormComponent> = (component) => {
  if (component.enrollForm.dirty && !component.submitted) {
    return window.confirm('You have unsaved changes. Are you sure you want to leave?');
  }
  return true;
};