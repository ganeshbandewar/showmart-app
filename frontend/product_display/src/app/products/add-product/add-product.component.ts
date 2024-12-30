import { Component, OnInit, ViewChild } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/model/product.model';
import { ProductService } from 'src/app/service/product.service';
import {NgForm} from '@angular/forms';
import { HttpErrorResponse } from '@angular/common/http';

@Component({
  selector: 'app-add-product',
  templateUrl: './add-product.component.html',
  styleUrls: ['./add-product.component.css']
})
export class AddProductComponent implements OnInit {
   
  @ViewChild("addform") productForm:NgForm;

  productSaved:boolean=false;
  product:Product=new Product();
  products:Product[];
  constructor(private productService:ProductService,
    private router:Router) { }

  ngOnInit(): void {
// this.getAllProduct();
  }

  private getAllProduct(){
    this.productService.getProduct(2).subscribe(data=>{
this.products=data;
console.log(this.products);
    })
  }
  saveProduct(){
    this.productService.createProduct(this.product).subscribe((data)=>{
      console.log(data);

    },(errorMee:HttpErrorResponse)=>{
  console.log(errorMee.error);
    });
    
  }


  onSubmit(aform:NgForm){
    console.log(this.product);
    console.log(aform);
    
    this.saveProduct();

    aform.form.reset();
    this.productSaved=!this.productSaved;
    setTimeout(() => {
      this.productSaved=!this.productSaved; 
    }, 3000);
    
  }


}
