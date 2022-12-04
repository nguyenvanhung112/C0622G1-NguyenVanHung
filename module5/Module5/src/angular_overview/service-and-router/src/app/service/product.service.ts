import {Injectable} from '@angular/core';
import {Product} from "../model/product";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {environment} from "../../environments/environment";
import {ICategory} from "../model/icategory";

@Injectable({
  providedIn: 'root'
})
export class ProductService {
  messageUpdate:boolean = false;

  constructor(private httpClient: HttpClient) {
  }

  checkMessage(){
    this.messageUpdate =! this.messageUpdate;
  }

  findAll(): Observable<Product[]> {
    return this.httpClient.get<Product[]>(environment.url_list);
  }

  saveProduct(product): Observable<Product> {
    return this.httpClient.post<Product>(environment.url_list, product);
  }

  findById(id: number): Observable<Product> {
    return this.httpClient.get<Product>(environment.url_findById + id);
  }

  updateProduct(id: number, product: Product): Observable<Product> {
    return this.httpClient.put<Product>(environment.url_edit + id, product);
  }

  deleteProduct(id: number): Observable<Product> {
    return this.httpClient.delete<Product>(environment.url_list + "/" + id)
  }

  findAllCategory(): Observable<ICategory[]> {
    return this.httpClient.get<ICategory[]>(environment.url_category);
  }
  searchByNameAndCategory(name:string,category:string):Observable<Product[]>{
    return this.httpClient.get<Product[]>(`${environment.url_list}?name_like=${name}&category.name_like=${category}`)
  }
}
