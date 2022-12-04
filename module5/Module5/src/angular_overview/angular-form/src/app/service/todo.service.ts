import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
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

  addTodo(todo: Todo): Observable<Todo> {
    return this.httpClient.post<Todo>(environment.url_api, todo);
  }

  delete(id: number) {
    return this.httpClient.delete(environment.url_api + "/" + id)
  }
}
