import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {AuthorListComponent} from "./author-list/author-list.component";

const routes: Routes = [
    {
        path: '',
        component: AuthorListComponent
    }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class AuthorRoutingModules{
}
