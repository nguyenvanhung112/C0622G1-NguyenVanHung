import {Component, OnInit} from '@angular/core';
import {ProductService} from "../../service/product.service";
import {ActivatedRoute, ParamMap, Router} from "@angular/router";
import {FormBuilder, FormControl, FormGroup} from "@angular/forms";
import {Observable} from "rxjs";
import {Product} from "../../model/product";
import {ICategory} from "../../model/icategory";

@Component({
  selector: 'app-product-edit',
  templateUrl: './product-edit.component.html',
  styleUrls: ['./product-edit.component.css']
})
export class ProductEditComponent implements OnInit {
  productForm: FormGroup;
  id: number;
  product: Product;
  categoryList: ICategory[] | undefined;
  message: string;

  equals(o1: ICategory, o2: ICategory) {
    return o1.id === o2.id;
  }

  constructor(private _productService: ProductService,
              private _activatedRoute: ActivatedRoute,
              private _formBuilder: FormBuilder,
              private _router: Router) {
  }

  ngOnInit(): void {

    this._productService.findAllCategory().subscribe(data => {
      this.categoryList = data;
    })
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


  updateProduct(id: number) {
    const product = this.productForm.value;
    this._productService.updateProduct(id, product).subscribe(data => {
        this.productForm = this._formBuilder.group({
          id: [data.id],
          name: [data.name],
          price: [data.price],
          description: [data.description],
          category: [data.category]
        })
        this.message = "Sửa thành công"
      },
      error => {
        this.message = "Sửa thất bại"
      });
  }
}
