import {Component, OnInit} from '@angular/core';
import {Iword} from "../../model/iword";
import {DictionnaryService} from "../../service/dictionnary.service";

@Component({
  selector: 'app-dictionary-page',
  templateUrl: './dictionary-page.component.html',
  styleUrls: ['./dictionary-page.component.css']
})
export class DictionaryPageComponent implements OnInit {
  dictionaryList: Iword[] = [];

  constructor(private _dictionaryService: DictionnaryService) {

  }

  ngOnInit(): void {
    this.getAll();
  }

  getAll() {
    this.dictionaryList = this._dictionaryService.getAll();
  }
}
