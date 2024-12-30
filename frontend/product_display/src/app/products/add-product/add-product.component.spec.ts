// import { ComponentFixture, TestBed } from '@angular/core/testing';

import { Router } from "@angular/router";
import { Product } from "src/app/model/product.model"
import { AddProductComponent } from "./add-product.component";
import {of} from 'rxjs';

// import { AddProductComponent } from './add-product.component';

// describe('AddProductComponent', () => {
//   let component: AddProductComponent;
//   let fixture: ComponentFixture<AddProductComponent>;

//   beforeEach(async () => {
//     await TestBed.configureTestingModule({
//       declarations: [ AddProductComponent ]
//     })
//     .compileComponents();

//     fixture = TestBed.createComponent(AddProductComponent);
//     component = fixture.componentInstance;
//     fixture.detectChanges();
//   });

//   it('should create', () => {
//     expect(component).toBeTruthy();
//   });
// });

describe('Add-Product-Componet', () => {
    let PRODUCT: Product;
    let component: AddProductComponent;
    let mockProductService: any;
    let router:Router;

    beforeEach(() => {
        
        mockProductService=jasmine.createSpyObj(['createProduct']);
        component=new AddProductComponent(mockProductService,router);
    })

    describe('saveproduct',()=>{
        it('should create product in backend',()=>{
            let ONLYPRODUCT = {
                productName: "Bottle",
                productDescription: "used for drinking",
                createdBy: "ganesh",
                updatedBy: "ganesh"
            };
            mockProductService.createProduct.and.returnValue(of(true));
            component.product=ONLYPRODUCT;
            component.saveProduct();
            expect(mockProductService.createProduct).toHaveBeenCalledTimes(1);
    
        })
    })
})
