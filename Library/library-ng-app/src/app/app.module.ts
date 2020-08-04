import {BrowserModule} from '@angular/platform-browser';
import {NgModule} from '@angular/core';

import {AppRoutingModule} from './app-routing.module';
import {AppComponent} from './app.component';
import {NavigationComponent} from './navigation/navigation.component';
import {BooksComponent} from './books/books.component';
import {AuthorsComponent} from './authors/authors.component';
import {GenresComponent} from './genres/genres.component';
import {Router, RouterModule, Routes} from "@angular/router";
import {FormsModule} from "@angular/forms";
import {HttpClientModule} from "@angular/common/http";
import {CreateAuthorComponent} from './authors/create-author/create-author.component';
import {CreateGenreComponent} from './genres/create-genre/create-genre.component';
import {CreateBookComponent} from './books/create-book/create-book.component';
import {NgMultiSelectDropDownModule} from "ng-multiselect-dropdown";
import {UpdateAuthorComponent} from './authors/update-author/update-author.component';
import {UpdateGenreComponent} from './genres/update-genre/update-genre.component';
import { UpdateBookComponent } from './books/update-book/update-book.component';

const appRoutes: Routes = [
  {
    path: 'books',
    component: BooksComponent
  },
  {
    path: 'books-new',
    component: CreateBookComponent
  },
  {
    path: 'books-update/:id',
    component: UpdateBookComponent
  },
  {
    path: 'authors',
    component: AuthorsComponent
  },
  {
    path: 'authors-new',
    component: CreateAuthorComponent
  },
  {
    path: 'authors-update/:id',
    component: UpdateAuthorComponent
  },
  {
    path: 'genres',
    component: GenresComponent
  },
  {
    path: 'genres-new',
    component: CreateGenreComponent
  },
  {
    path: 'genres-update/:id',
    component: UpdateGenreComponent
  },
  {
    path: '',
    component: BooksComponent,
    pathMatch: 'full'
  }
];

@NgModule({
  declarations: [
    AppComponent,
    NavigationComponent,
    BooksComponent,
    AuthorsComponent,
    GenresComponent,
    CreateAuthorComponent,
    CreateGenreComponent,
    CreateBookComponent,
    UpdateAuthorComponent,
    UpdateGenreComponent,
    UpdateBookComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    RouterModule.forRoot(appRoutes),
    NgMultiSelectDropDownModule.forRoot()
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
