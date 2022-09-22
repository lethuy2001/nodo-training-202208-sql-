import {Component, Inject, OnInit} from '@angular/core';
import {FormBuilder, Validators} from "@angular/forms";
import {Constants} from "../../../shared/Constants";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {AuthorListComponent} from "../author-list/author-list.component";
import {ApiAssi} from "../../../shared/services/assi/api-assi";
import {MatSnackBar} from "@angular/material/snack-bar";
import {AuthorService} from "../../../shared/services/assi/author.service";

@Component({
  selector: 'app-author-form',
  templateUrl: './author-form.component.html',
  styleUrls: ['./author-form.component.scss']
})
export class AuthorFormComponent implements OnInit {

    TYPE_DIALOG = Constants.TYPE_DIALOG ;
    title = ''

    authorForm = this.fb.group( {
        id: null,
        ma: ['' , [Validators.required , Validators.maxLength(5)]] ,
        ten: ['' , [Validators.required]] ,
        sdt: ['' , [Validators.required , Validators.pattern(/^(0?)(3[2-9]|5[6|8|9]|7[0|6-9]|8[0-6|8|9]|9[0-4|6-9])[0-9]{7}$/)]] ,
        diachi: ['' , [Validators.required]] ,
        mota: ['' ] ,
    })


  constructor( private author: AuthorService , private fb: FormBuilder ,@Inject(MAT_DIALOG_DATA) public dataDialog?: any ,
               private dialogRef?: MatDialogRef<AuthorListComponent>  ) { }

  ngOnInit(): void {
        if( this.dataDialog.type === this.TYPE_DIALOG.NEW ){
            this.title = 'Thêm mới tác giả'
        }else{
            this.title = 'Cập nhập tác giả'
            if( this.dataDialog.row ){
                this.authorForm.patchValue( this.dataDialog.row );
            }
        }
  }


  Submit(){
        this.authorForm.markAllAsTouched() ;
        if( this.authorForm.invalid ){
            return ;
        }

      console.log("Create")
      console.log(this.authorForm.getRawValue())
        if( this.authorForm.value.id ){
            console.log("Update--------")
            console.log(this.authorForm.getRawValue())
            this.author.updateAuthor( this.authorForm.getRawValue() );
        }else{
            this.author.createAuthor( this.authorForm.getRawValue() ) ;
        }
        this.dialogRef!.close( Constants.RESULT_CLOSE_DIALOG.SUCCESS ) ;
  }

  onDismiss(): void {
        this.dialogRef?.close(Constants.RESULT_CLOSE_DIALOG.CLOSE);
    }

  isValidate( name: string , error: string ){
      console.log( this.authorForm.get(name)?.hasError(error) && this.authorForm.get(name)?.touched )
       return this.authorForm.get(name)?.hasError(error) && this.authorForm.get(name)?.touched;
  }
}
