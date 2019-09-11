import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import {AccountDetailComponent} from './account-detail/account-detail.component';
import {GenerateStatementComponent} from './generate-statement/generate-statement.component';
import {MoneyTransferComponent} from './money-transfer/money-transfer.component';


const routes: Routes = [
];
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
