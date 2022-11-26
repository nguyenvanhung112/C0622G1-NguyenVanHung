import { Component, OnInit } from '@angular/core';
import {Iword} from "../../model/iword";
import {DictionnaryService} from "../../service/dictionnary.service";
import {ActivatedRoute} from "@angular/router";

@Component({
  selector: 'app-dictionary-detail',
  templateUrl: './dictionary-detail.component.html',
  styleUrls: ['./dictionary-detail.component.css']
})
export class DictionaryDetailComponent implements OnInit {
  translateWord: Iword;
  index: number;

  constructor(private _dictionaryService:DictionnaryService,
              private _activatedRoute: ActivatedRoute) {

  }

  ngOnInit(): void {
    this.getMean();
  }

  private getMean() {
    this.index = this._activatedRoute.snapshot.params['index'];
    this.translateWord = this._dictionaryService.getMeanWordByIndex(this.index);
  }
}
