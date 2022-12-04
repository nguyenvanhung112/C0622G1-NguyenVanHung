import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {FormBuilder, FormGroup, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {ICategory} from "../../model/icategory";

@Component({
  selector: 'app-product-create',
  templateUrl: './product-create.component.html',
  styleUrls: ['./product-create.component.css']
})
export class ProductCreateComponent implements OnInit {
  productForm: FormGroup;
  message: string;
  categoryList: ICategory[] | undefined;

  constructor(private _productService: ProductService,
              private _formBuilder: FormBuilder) {
  }

  ngOnInit(): void {
    this._productService.findAllCategory().subscribe(data => {
      this.categoryList = data;
      this.productForm = this._formBuilder.group({
        id: [],
        name: ["name product",[
          Validators.required
        ]],
        price: [],
        description: [],
        category: []
      })
    });
  }

  submit() {
    if (this.productForm.valid) {
      const product = this.productForm.value;
      this._productService.saveProduct(product).subscribe(data => {
          this.productForm = this._formBuilder.group({
            id: [data.id],
            name: [data.name],
            price: [data.price],
            description: [data.description],
            category: [data.category]
          })
          this.message = "Thêm mới thành công"
        });
    }
      this.message = "Thêm mới thất bại"
  }
}
