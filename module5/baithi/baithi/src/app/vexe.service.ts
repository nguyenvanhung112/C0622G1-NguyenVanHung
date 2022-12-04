import {Injectable} from '@angular/core';
import {HttpClient, HttpClientModule} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ticket} from "./model/ticket";
import {environment} from "../environments/environment";
import {Garage} from "./model/garage";

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(private httpClient: HttpClient) {
  }

  findAll(): Observable<Ticket[]> {
    return this.httpClient.get<Ticket[]>(environment.veXeUrl)
  }

  findAllNhaXe(): Observable<Garage[]> {
    return this.httpClient.get<Garage[]>(environment.nhaXeUrl)
  }


  save(ticket: Ticket): Observable<Ticket> {
    return this.httpClient.post<Ticket>(environment.veXeUrl, ticket)
  }

  search(startPoint: string, endPoint: string, searchGarage: string): Observable<Ticket[]> {
    return this.httpClient.get<Ticket[]>(`${environment.veXeUrl}?diemDen_like=${endPoint}&diemDi_like=${startPoint}&nhaXe.name_like=${searchGarage}`);
  }

  findById(id: number): Observable<Ticket> {
    return this.httpClient.get<Ticket>(environment.veXeUrl + "/" + id)
  }

  update(id: number, ticket: Ticket): Observable<Ticket> {
    return this.httpClient.put<Ticket>(environment.veXeUrl + "/" + id, ticket)
  }

  delete(id: number): Observable<Ticket> {
    return this.httpClient.delete<Ticket>(environment.veXeUrl + "/" + id)
  }
}
