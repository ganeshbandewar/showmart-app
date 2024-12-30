import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotFoundComponent } from './errorr/not-found/not-found.component';
import { AddProductComponent } from './products/add-product/add-product.component';
import { FetchProductsComponent } from './products/fetch-products/fetch-products.component';
import { ProductsListComponent } from './products/products-list/products-list.component';
import { UpdateProductComponent } from './products/update-product/update-product.component';

const routes: Routes = [
  {path:'products',component:ProductsListComponent},
  {path:'Add-product',component:AddProductComponent},
  {path:'',redirectTo:'products',pathMatch:'full'},
  {path:'fetch-products',component:FetchProductsComponent},
  {path:'update-product/:id',component:UpdateProductComponent},
   {path:'**',component: NotFoundComponent}
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }
