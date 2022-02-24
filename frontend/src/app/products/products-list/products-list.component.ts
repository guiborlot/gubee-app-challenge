import { Component, OnInit } from "@angular/core";
import { Observable, tap } from "rxjs";
import { ProductsService } from "../products.service";

@Component({
    selector: "app-products-list",
    templateUrl: "./products-list.component.html",
    styleUrls: ["./products-list.component.scss"],
})
export class ProductsListComponent implements OnInit {
    
    dataSource$!: Observable<any>;

    displayedColumns: string[] = [
        "id",
        "name",
        "description",
        "market",
        "technologies"
    ];

    technologies!: string[];

    constructor(private service: ProductsService) {}

    ngOnInit(): void {
        this.dataSource$ = this.service.list();
    }
}
