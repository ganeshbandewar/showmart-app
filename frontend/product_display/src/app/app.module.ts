import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { AddProductComponent } from './products/add-product/add-product.component';
import { ProductsListComponent } from './products/products-list/products-list.component';
import { FetchProductsComponent } from './products/fetch-products/fetch-products.component';
import {HttpClientModule} from '@angular/common/http'
import { FormsModule,ReactiveFormsModule } from '@angular/forms';
import { NotFoundComponent } from './errorr/not-found/not-found.component';
import { UpdateProductComponent } from './products/update-product/update-product.component';
@NgModule({
  declarations: [
    AppComponent,
    AddProductComponent,
    ProductsListComponent,
    FetchProductsComponent,
    NotFoundComponent,
    UpdateProductComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule,
    ReactiveFormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
