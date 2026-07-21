import { Directive, HostListener, HostBinding, Input } from '@angular/core';

@Directive({
  selector: '[appHighlight]',
  standalone: true
})
export class HighlightDirective {
  // Configurable highlight background color (defaults to yellow)
  @Input() appHighlight = 'yellow';

  @HostBinding('style.backgroundColor') backgroundColor: string | null = null;

  @HostListener('mouseenter') onMouseEnter(): void {
    this.backgroundColor = this.appHighlight;
  }

  @HostListener('mouseleave') onMouseLeave(): void {
    this.backgroundColor = null;
  }
}