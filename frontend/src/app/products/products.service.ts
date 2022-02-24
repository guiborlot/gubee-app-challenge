import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { tap } from "rxjs";

@Injectable({
    providedIn: "root",
})
export class ProductsService {
    private readonly API = "http://localhost:8085/products";

    constructor(private http: HttpClient) {}

    list(){
        return this.http.get(this.API).pipe(tap(console.log));
    }
}
