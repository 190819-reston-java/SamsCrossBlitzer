import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { ReactiveFormsModule, FormsModule } from '@angular/forms';
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
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import {IgxFinancialChartModule} from "igniteui-angular-charts/ES5/igx-financial-chart-module";
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './login/login.component';
import { AppMaterialModule } from './app-material/app-material.module';
import { AuthService } from './auth/auth.service';
import { AuthGuard } from './auth/auth.guard';
import { MatFormField, MatFormFieldModule } from '@angular/material/form-field';
import { MatInputModule } from '@angular/material/input';
import {MatAutocompleteModule} from '@angular/material/autocomplete';
import { RegisterComponent } from './register/register.component';
import { PortfoliosComponent } from './portfolios/portfolios.component';
import { MatTableModule } from '@angular/material/table';
import { MatPaginatorModule } from '@angular/material/paginator';
import { MatSortModule } from '@angular/material/sort';

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
    ForumComponent,
    LoginComponent,
    RegisterComponent,
    PortfoliosComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    BrowserAnimationsModule,
    IgxFinancialChartModule,
    HttpClientModule,
    ReactiveFormsModule,
    AppMaterialModule,
    MatFormFieldModule,
    MatInputModule,
    MatAutocompleteModule,
    ReactiveFormsModule,
    FormsModule,
    MatTableModule,
    MatPaginatorModule,
    MatSortModule,
  ],
  providers: [AuthService, AuthGuard],
  bootstrap: [AppComponent]
})
export class AppModule {
}
