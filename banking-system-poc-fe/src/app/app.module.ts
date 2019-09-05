import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { RouterModule, Routes } from '@angular/router';
import { AppComponent } from './app.component';
import { AccountDetailComponent } from './account-detail/account-detail.component';
import { AccountTransactionComponent } from './account-transaction/account-transaction.component';
import {NgxPaginationModule} from 'ngx-pagination'; // <-- import the module
const appRoutes: Routes=[
{path: 'transaction',component:AccountTransactionComponent}
]
@NgModule({
  declarations: [
    AppComponent,
    AccountDetailComponent,
    AccountTransactionComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    RouterModule.forRoot(
      appRoutes,
      {enableTracing:true}
    ),
    NgxPaginationModule//add here
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
