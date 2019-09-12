import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {ReactiveFormsModule} from '@angular/forms';
import {HttpClientModule, HTTP_INTERCEPTORS} from '@angular/common/http';
import { CommonModule } from '@angular/common';
import { SamplebuttonComponent } from './samplebutton/samplebutton.component';
import { MaterialModule } from './material/material.module';

import {FormsModule} from '@angular/forms';


import {platformBrowserDynamic} from '@angular/platform-browser-dynamic';




// used to create fake backend



import {HttpInterceptorBasicService} from './_services/http/http-interceptor-basic.service';

// import { LoginComponent } from './login';

// import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';
import { AccountDetailComponent } from './account-detail/account-detail.component';
import { AccountTransactionComponent } from './account-transaction/account-transaction.component';
import {NgxPaginationModule} from 'ngx-pagination';
import { DashboardComponent } from './dashboard/dashboard.component';
import { NavbarDemoComponent } from './navbar-demo/navbar-demo.component';
import { GenerateStatementComponent } from './generate-statement/generate-statement.component';
import {BrowserAnimationsModule} from '@angular/platform-browser/animations';
import {
  MatButtonModule, MatButtonToggleModule,
  MatFormFieldModule,
  MatInputModule, MatMenuModule,
  MatNativeDateModule,
  MatSelectModule,
  MatTableModule,
  MatTabsModule
} from '@angular/material';
import {MatDatepickerModule} from '@angular/material/datepicker';
import { MoneyTransferComponent } from './money-transfer/money-transfer.component';
import { RequestAccountComponent } from './request-account/request-account.component';
import { HomeComponent } from './home/home.component'; // <-- import the module
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { LoginRegistrationPageComponent } from './login-registration-page/login-registration-page.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { LoginService } from './login/login.service';
import { NewUserEntryService } from './register/new-user-entry.service';
import { AppRoutingModule } from './app-routing.module';
import {AppComponent} from './app.component';
import {JwtInterceptor} from './_helpers/jwt.interceptor';
import {AuthenticationService} from './_services/authentication.service';
import {AuthGuard} from './_guards';
import {AlertService, UserService} from './_services';
import {ErrorInterceptor, fakeBackendProvider} from './_helpers';
import {appRoutes, routing} from './app.routing';


@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    NgxPaginationModule,
    routing,
    // add here
    FormsModule,
    MatSelectModule,
    BrowserAnimationsModule,
    MatButtonModule,
    MatDatepickerModule,
    MatNativeDateModule,
    MatTableModule,
    MatInputModule,
    MatFormFieldModule,
    RouterModule.forRoot(appRoutes, {enableTracing: false}),
    MatTabsModule,
    MatMenuModule,
    MatButtonToggleModule
  ],
    declarations: [
        AppComponent,
        AccountDetailComponent,
        AccountTransactionComponent,
        DashboardComponent,
        NavbarDemoComponent,
        GenerateStatementComponent,
        MoneyTransferComponent,
        RequestAccountComponent,
        EditProfileComponent,
        LoginRegistrationPageComponent,
        LoginComponent,
        RegisterComponent,
        DashboardComponent,
        NavbarDemoComponent,
        // AddEmpComponent,
        SamplebuttonComponent,
        HomeComponent
    ],
    providers: [
        LoginService,
        NewUserEntryService,
        AuthGuard,
        AlertService,
        AuthenticationService,
        UserService,
        { provide: HTTP_INTERCEPTORS, useClass: JwtInterceptor, multi: true },
        { provide: HTTP_INTERCEPTORS, useClass: ErrorInterceptor, multi: true },
    {provide: HTTP_INTERCEPTORS, useClass: HttpInterceptorBasicService, multi: true},

        // provider used to create fake backend
        fakeBackendProvider
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }
