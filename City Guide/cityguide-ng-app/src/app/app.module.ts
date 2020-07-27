import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavigationComponent} from './navigation/navigation.component';
import {NewCityComponent} from './new-city/new-city.component';
import {CitiesComponent} from './cities/cities.component';
import {NotFoundComponent} from './not-found/not-found.component';
import {Router, RouterModule, Routes} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {GuideComponent} from './guide/guide.component';

const appRoutes: Routes = [
  {
    path: 'cities',
    component: CitiesComponent
  },
  {
    path: 'new-city',
    component: NewCityComponent
  },
  {
    path: 'guide',
    component: GuideComponent
  },
  {
    path: '',
    component: GuideComponent,
    pathMatch: 'full'
  },
  {
    path: '**',
    component: NotFoundComponent
  }
]

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    NewCityComponent,
    CitiesComponent,
    NotFoundComponent,
    GuideComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    RouterModule.forRoot(appRoutes, {enableTracing: true})
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
