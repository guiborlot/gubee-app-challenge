import { TOUCH_BUFFER_MS } from "@angular/cdk/a11y/input-modality/input-modality-detector";
import { Component, OnInit } from "@angular/core";
import { Observable} from "rxjs";
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

    checkMarket(market:string){
      if(this.marketsChecked.includes(market)){
        this.marketsChecked = this.marketsChecked.filter((e:string) => e != market)
      } else {
        this.marketsChecked.push(market);
      }
    }

    checkTechnology(technology:string){
      if(this.technologiesChecked.includes(technology)){
        this.technologiesChecked = this.technologiesChecked.filter((e:string) => e != technology);
      } else {
        this.technologiesChecked.push(technology);
      }
    }

    filter(){
      this.service.list(this.marketsChecked, this.technologiesChecked).subscribe(res => this.dataSource$ = res);
    }
}
