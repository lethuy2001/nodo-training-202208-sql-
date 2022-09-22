import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Constants} from "../../../shared/Constants";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {AuthorService} from "../../../shared/services/assi/author.service";
import {MatDialog} from "@angular/material/dialog";
import {FormBuilder} from "@angular/forms";
import {ApiAssi} from "../../../shared/services/assi/api-assi";
import {AuthorFormComponent} from "../../author-management/author-form/author-form.component";
import {ConfirmDialogComponent} from "../../../shared/components/confirm-dialog/confirm-dialog.component";
import {ToastService} from "../../../components/elements/toast/toast-service";
import {ToastrService} from "ngx-toastr";
import {PublicCompanyFormComponent} from "../public-company-form/public-company-form.component";

@Component({
  selector: 'app-public-company-list',
  templateUrl: './public-company-list.component.html',
  styleUrls: ['./public-company-list.component.scss']
})
export class PublicCompanyListComponent implements OnInit {

    authors!: MatTableDataSource<any> ;
    displayedColumns: string[] = ['ma', 'ten',  'diachi' , 'trangthai','mota' , 'control'];
    TYPE_DIALOG = Constants.TYPE_DIALOG ;
    @ViewChild(MatPaginator) paginator!: MatPaginator;
    @ViewChild(MatSort) sort!: MatSort;

    authorSearch = this.fb.group( {
        name: '',
        address: ''
    })

    constructor( private dialog: MatDialog ,
                 private fb: FormBuilder  ,
                 private api: ApiAssi ,
                 private toast: ToastrService ) {
    }

    applyFilter() {
        this.authors.filter = this.authorSearch.getRawValue().name.trim().toLowerCase();
    }

    loadData( ){
        this.api.getAllPublicCompany().subscribe( data => {
            this.authors = new MatTableDataSource<any>(data) ;
            this.authors.paginator = this.paginator ;
            this.authors.sort = this.sort ;
            console.log(data)
        })
    }

    ngOnInit(): void {
        this.loadData();
    }


    openFormDialog( type: string , row?:any ) {
        const dialogRef = this.dialog.open( PublicCompanyFormComponent , {
            width: '50vw',
            disableClose: true,
            hasBackdrop: true,
            data:{
                type ,
                row
            }
        });
        dialogRef.afterClosed().subscribe( rs => {
            console.log(rs)
            if( Constants.RESULT_CLOSE_DIALOG.SUCCESS === rs ){
                this.loadData();
            }
        })
    }

    openDeleteDialog( row : any ) {
        const dialogRef = this.dialog.open( ConfirmDialogComponent , {
            width: '25vw',
            disableClose: true,
            hasBackdrop: true,
            data: {
                message: 'Bạn có muốn xóa bản ghi này?'
            }
        })

        dialogRef.afterClosed().subscribe( rs => {
            if( rs === Constants.RESULT_CLOSE_DIALOG.CONFIRM ){
                this.api.deletePublicCompany(row ).subscribe( () => {
                    this.toast.success("Xóa thành công")
                    this.loadData() ;
                })

            }
        })
    }

}
