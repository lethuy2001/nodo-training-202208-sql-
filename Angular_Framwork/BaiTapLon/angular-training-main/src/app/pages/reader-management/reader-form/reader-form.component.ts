import {Component, Inject, OnInit} from '@angular/core';
import {Constants} from "../../../shared/Constants";
import {FormBuilder, Validators} from "@angular/forms";
import {AuthorService} from "../../../shared/services/assi/author.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {AuthorListComponent} from "../../author-management/author-list/author-list.component";
import {ApiAssi} from "../../../shared/services/assi/api-assi";
import {ToastrService} from "ngx-toastr";

@Component({
  selector: 'app-reader-form',
  templateUrl: './reader-form.component.html',
  styleUrls: ['./reader-form.component.scss']
})
export class ReaderFormComponent implements OnInit {

    TYPE_DIALOG = Constants.TYPE_DIALOG ;
    title = ''

    readerForm = this.fb.group( {
        id: null,
        ma: [''] ,
        ten: ['' , [Validators.required]] ,
        sdt: ['' , Validators.required ] ,
        diachi: ['' , [Validators.required]] ,
        hang: [1 ] ,
        ngaysinh: ['' , [Validators.required ] ] ,
        ngaytaotaikhoan: ''
    })


    constructor( private api: ApiAssi , private fb: FormBuilder ,@Inject(MAT_DIALOG_DATA) public dataDialog?: any ,
                 private dialogRef?: MatDialogRef<AuthorListComponent>  , private toat?: ToastrService ) { }

    ngOnInit(): void {
        if( this.dataDialog.type === this.TYPE_DIALOG.NEW ){
            this.title = 'Thêm mới bạn đọc'
        }else{
            this.title = 'Cập nhập bạn đọc'
            if( this.dataDialog.row ){
                this.readerForm.patchValue( this.dataDialog.row );
            }
        }
    }

    Submit(){
        this.readerForm.markAllAsTouched() ;
        if( this.readerForm.invalid ){
            return ;
        }

        console.log("Create")
        console.log(this.readerForm.getRawValue())
        if( this.readerForm.value.id ){
            console.log("Update--------")
            console.log(this.readerForm.getRawValue())
            this.api.updateReader( this.readerForm.getRawValue() ).subscribe( {
                next: (value) => {
                    this.toat?.success("Cập nhập thành công")
                },
                error: (err) => {
                    this.toat?.error("Cập nhập thất bại")
                }
            })
        }else{
            this.api.createReader( this.readerForm.getRawValue() ).subscribe( {
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
        return this.readerForm.get(name)?.hasError(error) && this.readerForm.get(name)?.touched;
    }

}
