import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";

@Component({
  selector: 'app-product-delete',
  templateUrl: './product-delete.component.html',
  styleUrls: ['./product-delete.component.css']
})
export class ProductDeleteComponent implements OnInit {
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

  deleteProduct(id: number) {
    this._productService.deleteProduct(id);
    this._router.navigate(['/product/list']);
  }
}
