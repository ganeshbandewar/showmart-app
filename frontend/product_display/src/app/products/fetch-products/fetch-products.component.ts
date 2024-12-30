import { HttpErrorResponse } from '@angular/common/http';
import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Product } from 'src/app/model/product.model';
import { ProductService } from 'src/app/service/product.service';

@Component({
  selector: 'app-fetch-products',
  templateUrl: './fetch-products.component.html',
  styleUrls: ['./fetch-products.component.css']
})
export class FetchProductsComponent implements OnInit{

  isErrorThere:boolean=false;
  errorOnFront:string='';
  disableCondition:boolean=true;
  found:boolean=true;
  sk:boolean=true;
  startMonth:any=1;
  endMonth:any=1;
  dateValue:Date=new Date();
  selectedValue: any = "byMonth";
  products: Product[];
  pNum: any;
  constructor(private productService: ProductService,
    private router:Router) { }

  ngOnInit(): void {

  }


  getAllProductsOfMonthMethod(){
    this.products=[];
    console.log(this.pNum);
    this.productService.getAllProductsOfMonth(this.pNum).subscribe((data) => {
      this.products = data;
      if(this.products.length==0){
        this.found=false
      }else{
        this.found=true;
      }
      console.log(this.products);
    },
    (errorMessage:HttpErrorResponse)=>{
      this.isErrorThere=true;
      this.errorOnFront="For "+this.pNum+" "+errorMessage.error;
      console.log(errorMessage.error);
    })
   }

   getAllProductsByDateMethod(){
    this.products=[];
      
    this.productService.getAllProductsByDate(this.dateValue.toString()).subscribe((data)=>{
      this.products=data;
      if(this.products.length==0){
        this.found=false
      }else{
        this.found=true;
      }
    },
    (errorMessage:HttpErrorResponse)=>{
      this.isErrorThere=true;
      this.errorOnFront="For "+this.dateValue.toString()+" "+errorMessage.error;
      console.log(errorMessage.error);
    })
    console.log(this.dateValue.toString());
   }

   getAllProductsByNameMethod(){
    this.products=[];
    this.productService.getAllProductsByName(this.pNum).subscribe((data)=>{
      this.products=data;
      if(this.products.length==0){
        this.found=false
      }else{
        this.found=true;
      }
    },
    (errorMessage:HttpErrorResponse)=>{
      this.isErrorThere=true;
      this.errorOnFront="For "+this.pNum+" "+errorMessage.error;
      console.log(errorMessage.error);
    })
   }


   getAllProductsByMonthRangeMethod(){
    this.products=[];
    this.productService.getAllProductsByMonthRange(this.startMonth,this.endMonth).subscribe((data)=>{
      this.products=data;
      if(this.products.length==0){
        this.found=false
      }else{
        this.found=true;
      }
    },
    (errorMessage:HttpErrorResponse)=>{
      this.isErrorThere=true;
      this.errorOnFront="For "+this.startMonth+" to "+this.endMonth+ " "+errorMessage.error;
      console.log(errorMessage.error);
    })
   }



  onSubmit() {
    this.isErrorThere=false;
    if (this.selectedValue == "byMonth") {
      this.getAllProductsOfMonthMethod();
      
    }

    if(this.selectedValue=="byDate"){
      
      this.getAllProductsByDateMethod();
      
    }
    if(this.selectedValue=="byName"){
      
     this.getAllProductsByNameMethod();
     
    }

    if(this.selectedValue=="byMonthRange"){
      this.getAllProductsByMonthRangeMethod();
    }
  }

  getCondition(){
    if(this.selectedValue=='byDate' && this.dateValue!=(undefined)){
      this.disableCondition=!this.disableCondition; 
    }
    if(this.selectedValue=='byMonth' && this.pNum!=undefined && this.pNum>=1 && this.pNum<=12){
      this.disableCondition=!this.disableCondition;
    }
    if(this.selectedValue=='byName' && this.pNum!=undefined && typeof this.pNum==='string'){
      this.disableCondition=!this.disableCondition;
    }
    if(this.selectedValue=='byMonthRange' && this.startMonth!=undefined && this.endMonth!=undefined && this.startMonth<=this.endMonth
    && this.startMonth>=1 && this.startMonth<=12 && this.endMonth>=1 && this.endMonth<=12){
      this.disableCondition=!this.disableCondition;
    }
 return this.disableCondition;
 }

 deleteProduct(id:number){
  this.productService.deleteMyProduct(id).subscribe(data=>{
    console.log(data);
    this.onSubmit();
  })
 }

 updateProduct(id:number){
console.log(id);
this.router.navigate(['update-product',id]);
 }
 










}
