import { NgModule } from '@angular/core';
import {Routes, RouterModule, Route} from '@angular/router';


import { AccountDetailComponent } from './account-detail/account-detail.component';
import { GenerateStatementComponent } from './generate-statement/generate-statement.component';
import { DashboardComponent } from './dashboard/dashboard.component';
import { MoneyTransferComponent } from './money-transfer/money-transfer.component';
import { HomeComponent } from './home/home.component';
import { LoginRegistrationPageComponent } from './login-registration-page/login-registration-page.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { EditProfileComponent } from './edit-profile/edit-profile.component';
import { RequestAccountComponent } from './request-account/request-account.component';
import {CustomerHomeComponent} from './customer-home/customer-home.component';
import { SamplebuttonComponent } from './samplebutton/samplebutton.component';
import { RedirectionComponentComponent } from './redirection-component/redirection-component.component';
// import { appRoutes } from './app.routing';

const routes :Routes =[

  { path:'dashboard',component:DashboardComponent},
  { path:'edit_profile',component:EditProfileComponent},
  { path:'account_details',component: AccountDetailComponent},
  { path:'generate_statement',component: GenerateStatementComponent},
  { path:'money_transfer',component:MoneyTransferComponent},
  { path:'request_account',component: RequestAccountComponent},
  { path:'home',component:HomeComponent},
  { path:'login_register',component:LoginRegistrationPageComponent},
  { path:'login',component:LoginComponent},
  { path:'register',component:RegisterComponent},
  { path: 'customer_home', component: CustomerHomeComponent},
  { path: 'admin',component: SamplebuttonComponent},
  { path: 'redirect', component: RedirectionComponentComponent}
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})

export class AppRoutingModule { }
