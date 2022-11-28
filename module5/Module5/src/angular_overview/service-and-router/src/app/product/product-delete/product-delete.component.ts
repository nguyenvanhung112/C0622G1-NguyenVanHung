import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {Product} from "../../model/product";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
  productForm: FormGroup;
  id: number;
  product:Product;
  message:string;
  constructor(private _productService: ProductService,
              private _activatedRoute: ActivatedRoute,
              private _formBuilder: FormBuilder,
              private _router: Router) {

  }

  ngOnInit(): void {
    this._activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      this._productService.findById(this.id).subscribe(
        data => {
          this.product = data[0];
          this.productForm = this._formBuilder.group({
            id: [this.product.id],
            name: [this.product.name],
            price: [this.product.price],
            description: [this.product.description],
            category: [this.product.category]
          });
        });
    });
  }

  deleteProduct(id: number) {
    this._productService.deleteProduct(id).subscribe(data=>{
      this._router.navigate(['/product/list']);
    });
  }
}
