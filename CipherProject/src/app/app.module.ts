import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NavbarComponent } from './navbar/navbar.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { HomeComponent } from './home/home.component';
import { PoliticsComponent } from './politics/politics.component';
import { StocksComponent } from './stocks/stocks.component';
import { NewsComponent } from './news/news.component';
import { AuthenticationComponent } from './authentication/authentication.component';
import { JSPComponent } from './jsp/jsp.component';
import { GoldComponent } from './gold/gold.component';
import { OilComponent } from './oil/oil.component';
import { USComponent } from './us/us.component';
import { ForumComponent } from './forum/forum.component';

@NgModule({
  declarations: [
    AppComponent,
    NavbarComponent,
    SidebarComponent,
    HomeComponent,
    PoliticsComponent,
    StocksComponent,
    NewsComponent,
    AuthenticationComponent,
    JSPComponent,
    GoldComponent,
    OilComponent,
    USComponent,
    ForumComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
