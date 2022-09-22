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
import {MatSortModule} from "@angular/material/sort";
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {MatIconModule} from "@angular/material/icon";
import {MatCardModule} from "@angular/material/card";
import {MatRadioModule} from "@angular/material/radio";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule, MatOptionModule} from "@angular/material/core";
import {MatSelectModule} from "@angular/material/select";
import {BorrowBookFormComponent} from "./borrow-book-form/borrow-book-form.component";
import {BorrowBookListComponent} from "./borrow-book-list/borrow-book-list.component";
import {BorrowBookRoutingModules} from "./borrow-book-routing.modules";

@NgModule({
    declarations: [
        BorrowBookFormComponent ,
        BorrowBookListComponent
    ] ,
    imports: [
        CommonModule,
        BorrowBookRoutingModules ,
        SharedModule,
        MatTableModule,
        MatPaginatorModule,
        MatFormFieldModule,
        MatCheckboxModule,
        MatDialogModule,
        MatInputModule,
        NgSelectModule,
        NgxDatatableModule,
        MatSortModule,
        NgbModule,
        FormsModule,
        ReactiveFormsModule,
        MatIconModule,
        MatCardModule,
        MatRadioModule,
        MatDatepickerModule,
        MatNativeDateModule,
        MatSelectModule ,
        MatOptionModule
    ],
    entryComponents: [BorrowBookFormComponent]
})

export class BorrowBookModules {}
