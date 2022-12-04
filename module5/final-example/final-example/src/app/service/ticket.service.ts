import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Ticket} from "../model/ticket";
import {Garage} from "../model/garage";
import {environment} from "../../environments/environment";

@Injectable({
  providedIn: 'root'
})
export class TicketService {

  constructor(private httpClient: HttpClient) {

  }

  findAll(): Observable<Ticket[]> {
    return this.httpClient.get<Ticket[]>(environment.ticketUrl)
  }

  findAllNhaXe(): Observable<Garage[]> {
    return this.httpClient.get<Garage[]>(environment.garageUrl)
  }


  save(ticket: Ticket): Observable<Ticket> {
    return this.httpClient.post<Ticket>(environment.ticketUrl, ticket)
  }

  search(startPoint: string, endPoint: string, firstDay: string, secondDay: string): Observable<Ticket[]> {
    return this.httpClient.get<Ticket[]>(environment.ticketUrl + "/search?startPoint=" + startPoint + "&endPoint=" + endPoint
      + "&firstDay=" + firstDay + "&secondDay=" + secondDay);
  }

  findById(id: number): Observable<Ticket> {
    return this.httpClient.get<Ticket>(environment.ticketUrl + "/" + id)
  }

  update(id: number, ticket: Ticket): Observable<Ticket> {
    return this.httpClient.put<Ticket>(environment.ticketUrl + "/" + id, ticket)
  }

  delete(id: number): Observable<Ticket> {
    return this.httpClient.delete<Ticket>(environment.ticketUrl + "/" + id)
  }

  order(id: number, ticketForm: Ticket): Observable<Ticket> {
    return this.httpClient.put<Ticket>(environment.ticketUrl + "/order/" + id, ticketForm)
  }
}
