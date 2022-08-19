import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppComponent } from './app.component';
import { QuotesComponent } from './quotes/quotes.component';
import { DetailsComponent } from './quotes/details/details.component';
import { FormsModule } from '@angular/forms';
import { HttpClientModule } from '@angular/common/http';
import { QuoteBlockingService } from './sevices/quote-blocking.service';
import { QuoteReactiveService } from './sevices/quote-reactive.service';

@NgModule({
  declarations: [
    AppComponent,
    QuotesComponent,
    DetailsComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [
    QuoteBlockingService,
    QuoteReactiveService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
