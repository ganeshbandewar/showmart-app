import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Product } from '../model/product.model';

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  private firstURL="http://localhost:8084/api/v1/getproductbyid";
  private secondURL="http://localhost:8084/api/v1/product";
  private thirdURL="http://localhost:8084/api/v1/getproductsinmonth";
  private fourthURL="http://localhost:8084/api/v1/getproductsbydate";
  private fifthURL="http://localhost:8084/api/v1/getproductsbyname";
  private sixthURL="http://localhost:8084/api/v1/product";


 

  

  constructor(private httpClient:HttpClient) { }

  getProduct(id:number):Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.firstURL}/${id}`);
  }

  getProduct1(id:number):Observable<Product>{
    return this.httpClient.get<Product>(`${this.firstURL}/${id}`);
  }

  createProduct(product:Product):Observable<Object>{
    return this.httpClient.post(`${this.secondURL}`,product);
  }

  getAllProducts():Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.secondURL}`);
  }
  getAllProductsOfMonth(id:number):Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.thirdURL}/${id}`);
  }

  getAllProductsByDate(da:string):Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.fourthURL}/${da}`);
  }

  getAllProductsByName(da:string):Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.fifthURL}/${da}`);
  }

  getAllProductsByMonthRange(start:string,end:string):Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${this.sixthURL}/${start}/${end}`);
  }

  deleteMyProduct(id:number):Observable<Product>{
    return this.httpClient.delete<Product>(`${this.sixthURL}/${id}`);
  }
  updateMyProduct(id:number,product:Product):Observable<Product>{
    return this.httpClient.put<Product>(`${this.sixthURL}/${id}`,product);
  }


}
