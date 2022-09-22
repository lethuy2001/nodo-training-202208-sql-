import {NgModule} from "@angular/core";
import {RouterModule, Routes} from "@angular/router";
import {PublicCompanyListComponent} from "./public-company-list/public-company-list.component";

const routes: Routes = [
    {
        path: '',
        component: PublicCompanyListComponent
    }
]

@NgModule({
    imports: [RouterModule.forChild(routes)],
    exports: [RouterModule]
})

export class PublicCompanyRoutingModules {
}
