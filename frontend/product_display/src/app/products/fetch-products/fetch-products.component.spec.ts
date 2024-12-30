// import { ComponentFixture, TestBed } from '@angular/core/testing';

import { FetchProductsComponent } from "./fetch-products.component";
import {of}  from 'rxjs';

// import { FetchProductsComponent } from './fetch-products.component';

// describe('FetchProductsComponent', () => {
//   let component: FetchProductsComponent;
//   let fixture: ComponentFixture<FetchProductsComponent>;

//   beforeEach(async () => {
//     await TestBed.configureTestingModule({
//       declarations: [ FetchProductsComponent ]
//     })
//     .compileComponents();

//     fixture = TestBed.createComponent(FetchProductsComponent);
//     component = fixture.componentInstance;
//     fixture.detectChanges();
//   });

//   it('should create', () => {
//     expect(component).toBeTruthy();
//   });
// });

describe('Fetch-Product-Service',()=>{
    let PRODUCTS = [
        {
    
          productName: "Bottle",
          productDescription: "used for drinking",
          createdBy: "ganesh",
          updatedBy: "ganesh"
        },
        {
    
          productName: "Bottle1",
          productDescription: "used for drinking1",
          createdBy: "ganesh1",
          updatedBy: "ganesh1"
        }
      ];
      let mockProductService: any;
      let component:FetchProductsComponent;
      
    beforeEach(() => {
        
        mockProductService=jasmine.createSpyObj(['getAllProductsOfMonth','getAllProductsByDate','getAllProductsByName','getAllProductsByMonthRange']);
        component=new FetchProductsComponent(mockProductService);

    });

    it('should get products by getAllProductsOfMonthMethod()',()=>{
        mockProductService.getAllProductsOfMonth.and.returnValue(of(true));
        component.getAllProductsOfMonthMethod();
        expect(mockProductService.getAllProductsOfMonth).toHaveBeenCalledTimes(1);
        
    })

    it('should get products by getAllProducttsByname()',()=>{
        mockProductService.getAllProductsByName.and.returnValue(of(true));
        component.getAllProductsByNameMethod();
        expect(mockProductService.getAllProductsByName).toHaveBeenCalledTimes(1);
        
    })

    
    it('should get products by getAllProducttsByMonthRange()',()=>{
        mockProductService.getAllProductsByMonthRange.and.returnValue(of(true));
        component.getAllProductsByMonthRangeMethod();
        expect(mockProductService.getAllProductsByMonthRange).toHaveBeenCalledTimes(1);
        
    })

    it('should get products by getAllProducttsByName()',()=>{
        mockProductService.getAllProductsByDate.and.returnValue(of(true));
        component.getAllProductsByDateMethod();
        expect(mockProductService.getAllProductsByDate).toHaveBeenCalledTimes(1);
        
    })

   
   




})






