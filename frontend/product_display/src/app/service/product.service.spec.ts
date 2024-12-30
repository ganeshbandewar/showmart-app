// import { TestBed } from '@angular/core/testing';

import { HttpClient } from "@angular/common/http"
import { ProductService } from "./product.service";
import { of } from 'rxjs';

// import { ProductService } from './product.service';

// describe('ProductService', () => {
//   let service: ProductService;

//   beforeEach(() => {
//     TestBed.configureTestingModule({});
//     service = TestBed.inject(ProductService);
//   });

//   it('should be created', () => {
//     expect(service).toBeTruthy();
//   });
// });

describe('Product Service', () => {
  let httpClientSpy: jasmine.SpyObj<HttpClient>;
  let httpClientSpy1: jasmine.SpyObj<HttpClient>;
  let productService: ProductService;
  let productService1: ProductService;
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

  let PRODUCTSBYNAME=[
    {
      productName: "Bottle",
      productDescription: "used for drinking",
      createdBy: "ganesh",
      updatedBy: "ganesh"
    }
  ];
  let ONLYPRODUCT={ productName: "Bottle",
  productDescription: "used for drinking",
  createdBy: "ganesh",
  updatedBy: "ganesh"
};


  beforeEach(() => {
    httpClientSpy = jasmine.createSpyObj('HttpClient', ['get']);
    httpClientSpy1 = jasmine.createSpyObj('HttpClient', ['post']);
    productService = new ProductService(httpClientSpy);
    productService1 = new ProductService(httpClientSpy1);
  })
  describe('getAllProduct()', () => {
    it('should return all products from backend when getAllproductscalled', (done: DoneFn) => {
      httpClientSpy.get.and.returnValue(of(PRODUCTS));
      productService.getAllProducts().subscribe({
        next: (products) => {
          expect(products).toEqual(PRODUCTS);
          done();
        },
        error: () => {
          done.fail;
        },
      });
      expect(httpClientSpy.get).toHaveBeenCalledTimes(1);
    })
  })


  describe('getAllProductsOfMonth()', () => {
    it('should return all products from backend of specific month when getAllproductOfMonth called', (done: DoneFn) => {
      httpClientSpy.get.and.returnValue(of(PRODUCTS));
      productService.getAllProductsOfMonth(11).subscribe({
        next: (products) => {
          expect(products).toEqual(PRODUCTS);
          done();
        },
        error: () => {
          done.fail;
        },
      });
      expect(httpClientSpy.get).toHaveBeenCalledTimes(1);
    })
  })

  describe('getAllProductsByDate()', () => {
    it('should return all products from backend of specific date when getAllproductOfDate called', (done: DoneFn) => {
      httpClientSpy.get.and.returnValue(of(PRODUCTS));
      productService.getAllProductsByDate('2022-11-22').subscribe({
        next: (products) => {
          expect(products).toEqual(PRODUCTS);
          done();
        },
        error: () => {
          done.fail;
        },
      });
      expect(httpClientSpy.get).toHaveBeenCalledTimes(1);
    })
  })

  describe('getAllProductsByName()', () => {
    it('should return all products from backend of specific name when getAllProdictsByname called', (done: DoneFn) => {
      httpClientSpy.get.and.returnValue(of(PRODUCTSBYNAME));
      productService.getAllProductsByName('Bottle').subscribe({
        next: (products) => {
          expect(products).toEqual(PRODUCTSBYNAME);
          done();
        },
        error: () => {
          done.fail;
        },
      });
      expect(httpClientSpy.get).toHaveBeenCalledTimes(1);
    })
  })

  describe(' getAllProductsByMonthRange()', () => {
    it('should return all products from backend of month rangewhen getAllProductsByMonthrange called', (done: DoneFn) => {
      httpClientSpy.get.and.returnValue(of(PRODUCTS));
      productService.getAllProductsByMonthRange('11','11').subscribe({
        next: (products) => {
          expect(products).toEqual(PRODUCTS);
          done();
        },
        error: () => {
          done.fail;
        },
      });
      expect(httpClientSpy.get).toHaveBeenCalledTimes(1);
    })
  })


  describe('createProduct()', () => {
    it('should create product in backend when createProduct called by passing product ', (done: DoneFn) => {
      httpClientSpy1.post.and.returnValue(of(ONLYPRODUCT));
      productService1.createProduct(ONLYPRODUCT).subscribe({
        next: (product) => {
          expect(product).toEqual(ONLYPRODUCT);
          done();
        },
        error: () => {
          done.fail;
        },
      });
      expect(httpClientSpy1.post).toHaveBeenCalledTimes(1);
    })
  })


  



})




