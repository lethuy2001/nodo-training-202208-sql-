import {Component, Inject, OnInit} from '@angular/core';
import {Constants} from "../../../shared/Constants";
import {FormBuilder, Validators} from "@angular/forms";
import {ApiAssi} from "../../../shared/services/assi/api-assi";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {AuthorListComponent} from "../../author-management/author-list/author-list.component";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-book-form',
  templateUrl: './book-form.component.html',
  styleUrls: ['./book-form.component.scss']
})
export class BookFormComponent implements OnInit {
    TYPE_DIALOG = Constants.TYPE_DIALOG;
    title = ''
    listNXB:any ;
    listAuthor: any ;

    bookForm = this.fb.group({
        id: null,
        ma: [''],
        ten: ['', [Validators.required]],
        nhaXuatBan: this.fb.group( {
            id: [ '' , Validators.required]
        }) ,
        tacGia: this.fb.group( {
            id: ['' , Validators.required]
        }) ,
        soluongcon: 0 ,
        soluongmuon: 0 ,
        chude: ['', [Validators.required]],
        mota: [''],
        namsanxuat: ['' , [Validators.required]],
        tongsosach: ['', [Validators.required , Validators.min(1)] ]
    })


    constructor(private api: ApiAssi, private fb: FormBuilder, @Inject(MAT_DIALOG_DATA) public dataDialog?: any,
                private dialogRef?: MatDialogRef<AuthorListComponent>, private toats?: ToastrService) {
    }

    ngOnInit(): void {
        if (this.dataDialog.type === this.TYPE_DIALOG.NEW) {
            this.title = 'Thêm mới sách'
        } else {
            this.title = 'Cập nhập sách'
            if (this.dataDialog.row) {
                this.bookForm.patchValue(this.dataDialog.row);
                console.log(this.bookForm.getRawValue())
            }
        }
        this.getAllAuthor();
        this.getAllPublicCompany() ;
    }

    getAllAuthor(){
        this.api.getAllAuthor().subscribe( data => {
            this.listAuthor = data ;
        })
    }

    getAllPublicCompany(){
        this.api.getAllPublicCompanyActive().subscribe( data => {
            this.listNXB = data ;
        })
    }

    Submit() {
        this.bookForm.markAllAsTouched();
        if (this.bookForm.invalid) {
            console.log("Có lỗi ")
            return;
        }
        console.log(this.bookForm.getRawValue())
        if (this.bookForm.value.id) {
            console.log(this.bookForm.getRawValue())
            this.api.updateBook(this.bookForm.getRawValue()).subscribe({
                next: (value) => {
                    this.toats?.success("Cập nhập thành công")
                },
                error: (e) => {
                    this.toats?.error("Cập nhập thất bại")
                }
            })
        } else {
            console.log("create")
            this.api.createBook(this.bookForm.getRawValue()).subscribe({
                next: (value) => {
                    this.toats?.success("Thêm mới thành công")
                },
                error: (err) => {
                    this.toats?.error("Thêm mới thất bại")
                }
            })
        }
        this.dialogRef!.close(Constants.RESULT_CLOSE_DIALOG.SUCCESS);
    }

    onDismiss(): void {
        this.dialogRef?.close(Constants.RESULT_CLOSE_DIALOG.CLOSE);
    }

    isValidate(name: string, error: string) {
        return this.bookForm.get(name)?.hasError(error) && this.bookForm.get(name)?.touched;
    }

}
