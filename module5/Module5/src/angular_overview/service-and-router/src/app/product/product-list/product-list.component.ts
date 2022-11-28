import {Component, OnInit} from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";
import {Observable} from "rxjs";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] | undefined;
  constructor(private _productService: ProductService) {
  }

  ngOnInit(): void {
    this._productService.findAll().subscribe(
      data => {
        this.products = data;
      }, error => {
        console.log("Lấy danh sách thất bại")
      }, () => {
        console.log("Kết thúc lấy danh sách")
      }
    )
  }
}
