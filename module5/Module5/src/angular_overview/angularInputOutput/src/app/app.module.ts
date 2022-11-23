import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppComponent } from './app.component';
import { NameCardComponent } from './name-card/name-card.component';
import { ProcessBarComponent } from './process-bar/process-bar.component';
import { RatingBarComponent } from './rating-bar/rating-bar.component';
import { CountdownTimerComponent } from './countdown-timer/countdown-timer.component';

@NgModule({
  declarations: [
    AppComponent,
    NameCardComponent,
    ProcessBarComponent,
    RatingBarComponent,
    CountdownTimerComponent
  ],
  imports: [
    BrowserModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
