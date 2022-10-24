import {NgModule} from "@angular/core";
import {BookListComponent} from "./book-list/book-list.component";
import {BookFormComponent} from "./book-form/book-form.component";
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
import {NgbModule} from "@ng-bootstrap/ng-bootstrap";
import {FormsModule, ReactiveFormsModule} from "@angular/forms";
import {BookRoutingModule} from "./book-routing.module";
import {MatIconModule} from "@angular/material/icon";
import {MatCardModule} from "@angular/material/card";
import {MatRadioModule} from "@angular/material/radio";
import {MatSortModule} from "@angular/material/sort";
import {MatDatepickerModule} from "@angular/material/datepicker";
import {MatNativeDateModule, MatOptionModule} from "@angular/material/core";
import {MatSelectModule} from "@angular/material/select";
import { SlickCarouselModule } from 'ngx-slick-carousel';

@NgModule({
    declarations: [
        BookListComponent ,
        BookFormComponent
    ] ,
    imports: [
        CommonModule,
        BookRoutingModule,
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
        MatOptionModule ,
        SlickCarouselModule
    ],
    entryComponents: [BookFormComponent]
})

export class BookModules {}
