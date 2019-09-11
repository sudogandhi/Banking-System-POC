import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

// used to create fake backend
import { fakeBackendProvider } from './_helpers';

import { AppComponent } from './app.component';
import { routing } from './app.routing';

import { AlertComponent } from './_directives';
import { AuthGuard } from './_guards';
import { JwtInterceptor, ErrorInterceptor } from './_helpers';
import { AlertService, AuthenticationService, UserService } from './_services';
import { HomeComponent } from './home';
import { LoginComponent } from './login';
import { RegisterComponent } from './register';

import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';
import { AccountDetailComponent } from './account-detail/account-detail.component';
import { AccountTransactionComponent } from './account-transaction/account-transaction.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavbarDemoComponent } from './navbar-demo/navbar-demo.component';
import { GenerateStatementComponent } from './generate-statement/generate-statement.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {MatFormFieldModule} from '@angular/material/typings/esm5/form-field';
import {MatButtonModule, MatInputModule, MatNativeDateModule, MatSelectModule, MatTableModule, MatTabsModule} from '@angular/material';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MoneyTransferComponent } from './money-transfer/money-transfer.component';
import { RequestAccountComponent } from './request-account/request-account.component';
//import {MatInputModule} from '@angular/material/typings/esm5/input';
// <-- import the module
const appRoutes: Routes = [
  {
    path: 'account_details',
    component: AccountDetailComponent
  },
  {
    path: 'generate_statement',
    component: GenerateStatementComponent
  },
  {
    path: 'money_transfer',
    component: MoneyTransferComponent
  },
  {
    path:'request_account',
    component: RequestAccountComponent
  }
];
@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    RouterModule.forRoot(
      appRoutes,
      {enableTracing: true}),
    NgxPaginationModule, // add here
    routing,
    FormsModule,
    MatSelectModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTableModule,
    MatInputModule,
    MatTabsModule
  ],
    declarations: [
        AppComponent,
        AlertComponent,
        HomeComponent,
        LoginComponent,
        AccountDetailComponent,
        AccountTransactionComponent,
        RegisterComponent,
        DashboardComponent,
        NavbarDemoComponent,
        GenerateStatementComponent,
        MoneyTransferComponent,
        RequestAccountComponent
    ],
    providers: [
        AuthGuard,
        AlertService,
        AuthenticationService,
        UserService,
        { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
        { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },

        // provider used to create fake backend
        fakeBackendProvider
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }
