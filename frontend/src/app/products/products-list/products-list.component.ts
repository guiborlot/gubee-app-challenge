import { Component, ElementRef, OnInit, ViewChild } from "@angular/core";
import { Observable, tap } from "rxjs";
import { ProductsService } from "../products.service";
import {MatTableDataSource} from "@angular/material/table";

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

    technologies: any = [];
    markets: any = [];
    marketsChecked: any = [];
    technologiesChecked: any = [];

    constructor(private service: ProductsService) {}

    ngOnInit(): void {
        this.service.list().subscribe(res => {
          this.dataSource$ = res;
          this.loadAllTechnologies(res);
          this.loadAllMarkets(res);
        });
        
    }

    loadAllMarkets(products: any){
      let allMarkets: any = [];
      products.forEach((product:any) => {
        allMarkets.push(product.market);
      })
      this.loadUniqueMarkets(allMarkets);
    }

    loadUniqueMarkets(allMarkets: string[]){
      this.markets = [... new Set(allMarkets)];
    }

    loadAllTechnologies(products: any){
      let allTechs: any = [];
      products.forEach((product:any) => {
        product.technologies.forEach((tech:string) => {
          allTechs.push(tech);
        })
      })
      this.loadUniqueTechnologies(allTechs);
    }

    loadUniqueTechnologies(allTechs: string[]){
      allTechs.forEach((tech:any) => {
        if(!this.technologies.includes(tech)) {
          this.technologies.push(tech);
        }
      });
    }

    filterTechnologies(technology: string, event: any){
      if(!this.technologiesChecked.find((element:string) => element == technology) && event.checked){
        this.technologiesChecked.push(technology)
      } else {
        this.technologiesChecked = this.technologiesChecked.filter((item:string) => item!=technology);
      }
    }

    filterMarkets(market: string, event: any){
      if(!this.marketsChecked.find((element: string) => element == market) && event.checked){
        this.marketsChecked.push(market)
      } else {
        this.marketsChecked = this.marketsChecked.filter((item:string) => item!=market)
      }
    }

    filterRows(row: any){
      let hasTechnology = false;
      for(let i=0; i<row.technologies.length; i++){
        if(this.technologiesChecked.includes(row.technologies[i])){
          hasTechnology = true;
        }
      }
      if(this.marketsChecked.includes(row.market) || hasTechnology){
        return false;
      } 
      if(this.marketsChecked == 0 && this.technologiesChecked == 0){
        return false;
      }
      return true;
    }
}
