import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {SharedModule} from "../../shared/shared.module";
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatDialogModule} from "@angular/material/dialog";
import {MatInputModule} from "@angular/material/input";
import {NgSelectModule} from "@ng-select/ng-select";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {MatButtonModule} from "@angular/material/button";
import {MatSortModule} from "@angular/material/sort";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatCardModule} from "@angular/material/card";
import {MatDividerModule} from "@angular/material/divider";
import {MatIconModule} from "@angular/material/icon";
import {MatSelectModule} from "@angular/material/select";
import {PublicCompanyFormComponent} from "./public-company-form/public-company-form.component";
import {PublicCompanyRoutingModules} from "./public-company-routing.modules";
import {PublicCompanyListComponent} from "./public-company-list/public-company-list.component";
import {MatRadioModule} from "@angular/material/radio";

@NgModule({
    declarations: [
        PublicCompanyFormComponent ,
        PublicCompanyListComponent
    ] ,
    imports: [
        CommonModule,
        PublicCompanyRoutingModules,
        SharedModule,
        MatTableModule,
        MatPaginatorModule,
        MatFormFieldModule,
        MatCheckboxModule,
        MatDialogModule,
        MatInputModule,
        NgSelectModule,
        NgxDatatableModule,
        MatButtonModule,
        MatSortModule,
        NgbModule,
        FormsModule, ReactiveFormsModule, MatCardModule, MatDividerModule, MatIconModule, MatSelectModule, MatRadioModule
    ],
    entryComponents: [PublicCompanyFormComponent]
})
export class PublicCompanyModules {

}
