import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productForm: FormGroup;
  id: number;

  constructor(private _productService: ProductService,
              private _activatedRoute: ActivatedRoute,
              private _formBuilder: FormBuilder,
              private _router: Router) {
    this._activatedRoute.paramMap.subscribe((paramMap: ParamMap) => {
      this.id = +paramMap.get('id');
      const product = this.getProduct(this.id);
      this.productForm = this._formBuilder.group({
        id: [product.id],
        name: [product.name],
        price: [product.price],
        description: [product.description]
      });
    });
  }

  ngOnInit(): void {

  }

  getProduct(id: number) {
    return this._productService.findById(id);
  }

  updateProduct(id: number) {
    const product = this.productForm.value;
    this._productService.updateProduct(id, product)
  }
}
