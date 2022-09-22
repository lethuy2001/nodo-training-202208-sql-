import {RouterModule, Routes} from "@angular/router";
import {BorrowBookListComponent} from "./borrow-book-list/borrow-book-list.component";
import {NgModule} from "@angular/core";


const router: Routes = [
    {
        path: '' ,
        component: BorrowBookListComponent
    }
]

@NgModule({
    imports: [RouterModule.forChild(router)] ,
    exports: [RouterModule]
})

export class BorrowBookRoutingModules {}
