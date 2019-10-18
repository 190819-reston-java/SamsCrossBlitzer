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
import { LoginComponent } from './login/login.component';
import { AuthGuard } from './auth/auth.guard';
import { RegisterComponent } from './register/register.component';
import { PortfolioComponent } from './portfolio/portfolio.component';


const routes: Routes = [
{
  path: "register",
  component: RegisterComponent,
},
{
  path: "home",
  component: HomeComponent,
},
{
  path: "authentication", canActivate: [AuthGuard],
  component: AuthenticationComponent,
},
{
  path: "gold", canActivate: [AuthGuard],
  component: GoldComponent,
},
{
  path: "portfolio", canActivate: [AuthGuard],
  component: PortfolioComponent,
},
{
  path: "navbar", canActivate: [AuthGuard],
  component: NavbarComponent,
},
{
  path: "news", canActivate: [AuthGuard],
  component: NewsComponent,
},
{
  path: "oil", canActivate: [AuthGuard],
  component: OilComponent,
},
{
  path: "politics", canActivate: [AuthGuard],
  component: PoliticsComponent,
},
{
  path: "sidebar", canActivate: [AuthGuard],
  component: SidebarComponent,
},
{
  path: "stocks", canActivate: [AuthGuard],
  component: StocksComponent,
},
{
  path: "us", canActivate: [AuthGuard],
  component: USComponent,
},
{
  path: "forum", canActivate: [AuthGuard],
  component: ForumComponent,
},
{
   path: '', canActivate: [AuthGuard],
   component: HomeComponent
},
{
   path: 'login',
   component: LoginComponent
}

];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
