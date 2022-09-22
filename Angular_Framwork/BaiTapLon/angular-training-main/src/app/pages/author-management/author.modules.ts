import {NgModule} from "@angular/core";
import {CommonModule} from "@angular/common";
import {BookRoutingModule} from "../book-management/book-routing.module";
import {SharedModule} from "../../shared/shared.module";
import {MatTableModule} from "@angular/material/table";
import {MatPaginatorModule} from "@angular/material/paginator";
import {MatFormFieldModule} from "@angular/material/form-field";
import {MatCheckboxModule} from "@angular/material/checkbox";
import {MatDialogModule} from "@angular/material/dialog";
import {MatInputModule} from "@angular/material/input";
import {NgSelectModule} from "@ng-select/ng-select";
import {NgxDatatableModule} from "@swimlane/ngx-datatable";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {AuthorFormComponent} from "./author-form/author-form.component";
import {AuthorListComponent} from "./author-list/author-list.component";
import {AuthorRoutingModules} from "./author-routing.modules";
import {MatCardModule} from "@angular/material/card";
import {MatDividerModule} from "@angular/material/divider";
import {MatButtonModule} from "@angular/material/button";
import {MatSortModule} from "@angular/material/sort";
import {MatIconModule} from "@angular/material/icon";
import {MatSelectModule} from "@angular/material/select";

@NgModule({
    declarations: [
        AuthorListComponent ,
        AuthorFormComponent
    ] ,
    imports: [
        CommonModule,
        AuthorRoutingModules,
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
        FormsModule, ReactiveFormsModule, MatCardModule, MatDividerModule, MatIconModule, MatSelectModule
    ],
    entryComponents: [AuthorFormComponent]
})
export class AuthorModules {

}
