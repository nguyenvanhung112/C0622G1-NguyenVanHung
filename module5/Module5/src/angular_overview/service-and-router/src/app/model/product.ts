import {ICategory} from "./icategory";

export interface Product {
  id?: number;
  name?: string;
  price?: number;
  description?: string;
  category: ICategory
}
