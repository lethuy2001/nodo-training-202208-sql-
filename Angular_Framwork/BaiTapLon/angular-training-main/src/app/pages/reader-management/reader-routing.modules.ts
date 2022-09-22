import {RouterModule, Routes} from "@angular/router";
import {ReaderListComponent} from "./reader-list/reader-list.component";
import {NgModule} from "@angular/core";


const routes: Routes  = [
    {
        path: '' ,
        component: ReaderListComponent
    }
]

@NgModule( {
    imports: [RouterModule.forChild(routes)] ,
    exports: [RouterModule]
})

export class ReaderRoutingModules {}
