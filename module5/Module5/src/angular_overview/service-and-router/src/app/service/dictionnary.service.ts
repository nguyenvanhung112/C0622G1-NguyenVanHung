import {Injectable} from '@angular/core';
import {Iword} from "../model/iword";

@Injectable({
  providedIn: 'root'
})
export class DictionnaryService {

  dictionaryList: Iword[] = [{
    word: 'pen', mean: 'bút'
  }, {
    word: 'banana', mean: 'chuối'
  }, {
    word: 'apple', mean: 'táo'
  },];


  constructor() {
    this.getAll();
  }

  getAll(){
   return this.dictionaryList;
  }

  getMeanWordByIndex(index: number) {
   return this.dictionaryList[index];
  }
}
