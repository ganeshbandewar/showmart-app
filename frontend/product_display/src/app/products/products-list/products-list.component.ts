import { Component, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from 'src/app/model/product.model';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-products-list',
  templateUrl: './products-list.component.html',
  styleUrls: ['./products-list.component.css']
})
export class ProductsListComponent implements OnInit {

  products:Product[];
  constructor(private productService:ProductService) { }

  ngOnInit(): void {
    this.getAllProductsOnstarting();
    }

    getAllProductsOnstarting(){
      this.productService.getAllProducts().subscribe(data=>{
        this.products=data;
        console.log(data);
      })
    }
  }

  