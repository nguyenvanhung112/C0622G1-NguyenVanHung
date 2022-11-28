import {Injectable} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {Todo} from "../todo";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class TodoService {

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<Todo[]> {
    return this.httpClient.get<Todo[]>(environment.url_api)
  }
}
