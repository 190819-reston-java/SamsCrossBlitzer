import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { HomeComponent } from './home/home.component';
import { AuthenticationComponent } from './authentication/authentication.component';
import { GoldComponent } from './gold/gold.component';
import { JSPComponent } from './jsp/jsp.component';
import { NavbarComponent } from './navbar/navbar.component';
import { NewsComponent } from './news/news.component';
import { USComponent } from './us/us.component';
import { StocksComponent } from './stocks/stocks.component';
import { SidebarComponent } from './sidebar/sidebar.component';
import { PoliticsComponent } from './politics/politics.component';
import { OilComponent } from './oil/oil.component';
import { ForumComponent } from './forum/forum.component';


const routes: Routes = [
{
  path: "home",
  component: HomeComponent,
},
{
  path: "authentication",
  component: AuthenticationComponent,
},
{
  path: "gold",
  component: GoldComponent,
},
{
  path: "jsp",
  component: JSPComponent,
},
{
  path: "navbar",
  component: NavbarComponent,
},
{
  path: "news",
  component: NewsComponent,
},
{
  path: "oil",
  component: OilComponent,
},
{
  path: "politics",
  component: PoliticsComponent,
},
{
  path: "sidebar",
  component: SidebarComponent,
},
{
  path: "stocks",
  component: StocksComponent,
},
{
  path: "us",
  component: USComponent,
},
{
  path: "forum",
  component: ForumComponent,
},

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
