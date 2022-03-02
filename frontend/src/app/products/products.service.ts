import { HttpClient } from "@angular/common/http";
import { Injectable } from "@angular/core";
import { take, tap } from "rxjs";

@Injectable({
    providedIn: "root",
})
export class ProductsService {
    private readonly API = "http://localhost:8080/products";

    constructor(private http: HttpClient) {}

    list(markets?:string[], technologies?:string[]){
        return this.http.get(this.urlCompose(markets,technologies)).pipe(tap(console.log), take(1));
    }

    urlCompose(markets?:string[], technologies?:string[]){
        let url = this.API;
        if(markets != undefined && technologies != undefined){
            url += '?'
            markets.forEach(market => {
                url += `market=${market}&`;
            });
            technologies.forEach(technology => {
                url += `technology=${technology}&`;
            });
        }
        url = url.replace(/ /g, "%20")
        console.log(url);
        return url;
    }
}
