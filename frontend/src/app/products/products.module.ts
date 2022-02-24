import { NgModule } from '@angular/core';
import { CommonModule } from '@angular/common';

import { ProductsRoutingModule } from './products-routing.module';
import { MatCardModule } from '@angular/material/card'
import {MatTableModule} from '@angular/material/table';
import { ProductsListComponent } from './products-list/products-list.component';


@NgModule({
  declarations: [ProductsListComponent],
  imports: [
    CommonModule,
    ProductsRoutingModule,
    MatCardModule,
    MatTableModule
  ]
})
export class ProductsModule { }
