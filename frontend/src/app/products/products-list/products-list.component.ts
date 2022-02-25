import { Component, OnInit } from "@angular/core";
import { Observable, tap } from "rxjs";
import { ProductsService } from "../products.service";
import {MatTableDataSource} from "@angular/material/table";

@Component({
    selector: "app-products-list",
    templateUrl: "./products-list.component.html",
    styleUrls: ["./products-list.component.scss"],
})
export class ProductsListComponent implements OnInit {

    dataSource$!: MatTableDataSource<any>;

    displayedColumns: string[] = [
        "id",
        "name",
        "description",
        "market",
        "technologies"
    ];

    technologies: any = [];
    technologiesChecked: any = [];


    constructor(private service: ProductsService) {}

    ngOnInit(): void {
        this.service.list().subscribe(res => {
          this.dataSource$ = res;
          this.loadAllTechnologies(res);
        });
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

    filter(technology: string, event: any){
      if(!this.technologiesChecked.find((element:string) => element == technology) && event.checked){
        this.technologiesChecked.push(technology)
      } else {
        this.technologiesChecked = this.technologiesChecked.filter((item:string) => item!=technology);
      }
      console.log(this.technologiesChecked)
    }




}
