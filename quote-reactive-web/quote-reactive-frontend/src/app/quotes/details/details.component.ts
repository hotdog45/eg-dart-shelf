import { Component, Input } from '@angular/core';
import { Quote } from 'src/app/model/quote';

@Component({
  selector: 'app-details',
  templateUrl: './details.component.html'
})
export class DetailsComponent {
  @Input() quote: Quote | undefined;
}
