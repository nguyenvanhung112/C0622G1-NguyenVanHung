import {Component, OnInit} from '@angular/core';
import {Product} from "../../model/product";
import {ProductService} from "../../service/product.service";
import {Observable} from "rxjs";
import {ICategory} from "../../model/icategory";

@Component({
  selector: 'app-product-list',
  templateUrl: './product-list.component.html',
  styleUrls: ['./product-list.component.css']
})
export class ProductListComponent implements OnInit {
  products: Product[] | undefined;
  p: number;
  name: string;
  category: string;
  categoryList: ICategory[] | undefined;
  message: string;

  constructor(private _productService: ProductService) {
  }

  ngOnInit(): void {
    if (this._productService.messageUpdate == true) {
      this.message = "update thành công";
      this._productService.checkMessage();
    }
    this.name = "";
    this.category = "";
    this._productService.findAllCategory().subscribe(data => {
      this.categoryList = data;
      console.log(this.categoryList)
    })
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

  search() {
    if (this.name == '' && this.category == "") {
      this.ngOnInit()
    }
    this._productService.searchByNameAndCategory(this.name, this.category).subscribe(data => {
      this.products = data
    })
  }
}
