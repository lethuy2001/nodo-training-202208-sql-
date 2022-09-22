import {Component, Inject, OnInit} from '@angular/core';
import {Constants} from "../../../shared/Constants";
import {FormBuilder, Validators} from "@angular/forms";
import {ApiAssi} from "../../../shared/services/assi/api-assi";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {AuthorListComponent} from "../../author-management/author-list/author-list.component";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-borrow-book-form',
  templateUrl: './borrow-book-form.component.html',
  styleUrls: ['./borrow-book-form.component.scss']
})
export class BorrowBookFormComponent implements OnInit {

    TYPE_DIALOG = Constants.TYPE_DIALOG ;
    title = ''
    listBook : any ;
    listReader: any ;
    checkButton = false ;

    borrowBookForm = this.fb.group( {
        id: null,
        trangthai: [1 , Validators.required ] ,
        ghichu: ['' ] ,
        soluong: [0 , [Validators.required , Validators.max(5) , Validators.min(1) ]] ,
        ngaygiomuon: '',
        ngaytra: ['' , Validators.required] ,
        sach: this.fb.group( {
            id: ['' , Validators.required]
        }) ,
        banDoc: this.fb.group( {
            id: ['' , Validators.required]
        })
    })


    constructor( private api: ApiAssi , private fb: FormBuilder ,@Inject(MAT_DIALOG_DATA) public dataDialog?: any ,
                 private dialogRef?: MatDialogRef<AuthorListComponent>  , private toat?: ToastrService ) { }

    ngOnInit(): void {
        if( this.dataDialog.type === this.TYPE_DIALOG.NEW ){
            this.checkButton = false ;
            this.title = 'Thêm mới bạn đọc'
        }else{
            this.checkButton = true ;
            this.title = 'Cập nhập bạn đọc'
            if( this.dataDialog.row ){
                this.borrowBookForm.patchValue( this.dataDialog.row );
            }
        }
        this.getAllSach() ;
        this.getAllReader() ;
    }

    getAllSach() {
        this.api.getAllBook().subscribe( data => {
            this.listBook = data
        })
    }

    getAllReader() {
        this.api.getAllReader().subscribe( data => {
            this.listReader = data ;
        })
    }

    Submit(){
        this.borrowBookForm.markAllAsTouched() ;
        if( this.borrowBookForm.invalid ){
            return ;
        }

        console.log("Create")
        console.log(this.borrowBookForm.getRawValue())
        if( this.borrowBookForm.value.id ){
            console.log("Update--------")
            this.api.updateBorrowBook( this.borrowBookForm.getRawValue() ).subscribe( {
                next: (value) => {
                    this.toat?.success("Cập nhập thành công")
                },
                error: (err) => {
                    this.toat?.error("Cập nhập thất bại")
                }
            })
        }else{
            this.api.createBorroBook( this.borrowBookForm.getRawValue() ).subscribe( {
                next: (value) => {
                    this.toat?.success("Thêm mới thành công")
                },
                error: (err) => {
                    this.toat?.error("Thêm mới thất bại")
                }
            })
        }
        this.dialogRef!.close( Constants.RESULT_CLOSE_DIALOG.SUCCESS ) ;
    }

    onDismiss(): void {
        this.dialogRef?.close(Constants.RESULT_CLOSE_DIALOG.CLOSE);
    }

    isValidate( name: string , error: string ){
        return this.borrowBookForm.get(name)?.hasError(error) && this.borrowBookForm.get(name)?.touched;
    }
}
