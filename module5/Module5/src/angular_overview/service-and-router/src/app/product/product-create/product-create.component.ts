import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {FormBuilder, FormGroup} from "@angular/forms";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  private productForm: FormGroup;

  constructor(private _productService: ProductService,
              private _formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this.productForm = this._formBuilder.group({
      id: [],
      name: [],
      price: [],
      description: []
    })
  }

  submit() {
    const product = this.productForm.value;
    this._productService.saveProduct(product);
    this.productForm.reset();
  }
}
