import {Garage} from "./garage";

export interface Ticket {
  "id": number,
  "price": number,
  "startPoint": string,
  "endPoint": string
  "startDay": string;
  "time": string;
  "garage": Garage;
  "quantity": number;
}
