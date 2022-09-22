import {Injectable} from "@angular/core";
import {Observable} from "rxjs";
import {ApiAssi} from "./api-assi";
import {Toast, ToastrService} from "ngx-toastr";
import {data} from "autoprefixer";

@Injectable({
    providedIn: "root"
})

export class AuthorService {
    constructor(private api: ApiAssi,
                private toats: ToastrService) {
    }

    createAuthor(author: any): void {
        this.api.createAuthor(author).subscribe(data => {
                if (data.id) {
                    this.toats.success("Thêm mới thành công");
                } else {
                    this.toats.error("Thêm mới thất bại")
                }
            }
        )
    }

    updateAuthor(author: any): void {
        this.api.updateAuthor(author).subscribe(data => {
                 this.toats.success("Cập nhập thành công")
            }
        )
    }

    deleteAuthor( id: number ):void{
        this.api.deleteAuthor( id ).subscribe( data => {
            this.toats.success("Xóa thành công")
        })
    }

    // getAll():any{
    //     this.api.getAllAuthor().subscribe( data =>{
    //         return data ;
    //     })
    // }
}
