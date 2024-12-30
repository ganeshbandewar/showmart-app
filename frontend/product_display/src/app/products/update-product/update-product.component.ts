import { Component, OnInit } from '@angular/core';
import { NgForm } from '@angular/forms';
import { ActivatedRoute, Router } from '@angular/router';
import { Product } from 'src/app/model/product.model';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-update-product',
  templateUrl: './update-product.component.html',
  styleUrls: ['./update-product.component.css']
})
export class UpdateProductComponent implements OnInit {

  id:number;
  productUpdated:boolean=false;
  product:Product=new Product();
  constructor(private productService:ProductService,
    private route:ActivatedRoute,
    private router:Router) { }

  ngOnInit(): void {
    this.id=this.route.snapshot.params['id'];
    this.productService.getProduct1(this.id).subscribe(data=>{
      this.product=data;
    })
  }


  onSubmit(aform:NgForm){
    console.log(this.product);
    console.log(aform);
    this.productService.updateMyProduct(this.id,this.product).subscribe(data=>{
      console.log(data);
    })

    setTimeout(() => {
      this.productUpdated=!this.productUpdated; 
    }, 3000);
    this.productUpdated=!this.productUpdated; 



    
  }

}
