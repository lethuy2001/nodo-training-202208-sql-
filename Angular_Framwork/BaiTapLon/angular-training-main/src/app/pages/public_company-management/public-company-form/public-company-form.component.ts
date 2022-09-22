import {Component, Inject, OnInit} from '@angular/core';
import {Constants} from "../../../shared/Constants";
import {FormBuilder, Validators} from "@angular/forms";
import {AuthorService} from "../../../shared/services/assi/author.service";
import {MAT_DIALOG_DATA, MatDialogRef} from "@angular/material/dialog";
import {AuthorListComponent} from "../../author-management/author-list/author-list.component";
import {ToastrService} from "ngx-toastr";
import {ApiAssi} from "../../../shared/services/assi/api-assi";

@Component({
    selector: 'app-public-company-form',
    templateUrl: './public-company-form.component.html',
    styleUrls: ['./public-company-form.component.scss']
})
export class PublicCompanyFormComponent implements OnInit {

    TYPE_DIALOG = Constants.TYPE_DIALOG;
    title = ''

    pcForm = this.fb.group({
        id: null,
        ma: [''],
        ten: ['', [Validators.required]],
        trangthai: [1, [Validators.required]],
        diachi: ['', [Validators.required]],
        mota: [''],
    })


    constructor(private api: ApiAssi, private fb: FormBuilder, @Inject(MAT_DIALOG_DATA) public dataDialog?: any,
                private dialogRef?: MatDialogRef<AuthorListComponent>, private toats?: ToastrService) {
    }

    ngOnInit(): void {
        if (this.dataDialog.type === this.TYPE_DIALOG.NEW) {
            this.title = 'Thêm mới nhà xuất bản'
        } else {
            this.title = 'Cập nhập nhà xuất bản'
            if (this.dataDialog.row) {
                this.pcForm.patchValue(this.dataDialog.row);
            }
        }
    }

    Submit() {
        this.pcForm.markAllAsTouched();
        if (this.pcForm.invalid) {
            return;
        }
        console.log(this.pcForm.getRawValue())
        if (this.pcForm.value.id) {
            console.log(this.pcForm.getRawValue())
            this.api.updatePublicCompany(this.pcForm.getRawValue()).subscribe({
                next: (value) => {
                    this.toats?.success("Cập nhập thành công")
                },
                error: (e) => {
                    this.toats?.error("Cập nhập thất bại")
                }
            })
        } else {
            console.log("create")
            this.api.createPublicCompany(this.pcForm.getRawValue()).subscribe({
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
        return this.pcForm.get(name)?.hasError(error) && this.pcForm.get(name)?.touched;
    }
}
