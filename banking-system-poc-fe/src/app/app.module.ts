import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import {FormsModule, ReactiveFormsModule} from '@angular/forms';
import { HttpClientModule, HTTP_INTERCEPTORS } from '@angular/common/http';

// used to create fake backend
// import { fakeBackendProvider } from './_helpers';

import { AppComponent } from './app.component';
//import { routing } from './app.routing';

// import { AlertComponent } from './_directives';
// import { AuthGuard } from './_guards';
// import { JwtInterceptor, ErrorInterceptor } from './_helpers';
// import { AlertService, AuthenticationService, UserService } from './_services';

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
import {MatFormFieldModule} from '@angular/material/typings/esm5/form-field';
import {MatButtonModule, MatInputModule, MatNativeDateModule, MatSelectModule, MatTableModule, MatTabsModule} from '@angular/material';
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


@NgModule({
  imports: [
    BrowserModule,
    ReactiveFormsModule,
    HttpClientModule,
    AppRoutingModule,
    NgxPaginationModule, // add here
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
        HomeComponent
    ],
    providers: [
        LoginService,
        NewUserEntryService
    ],
    bootstrap: [AppComponent]
})

export class AppModule { }
