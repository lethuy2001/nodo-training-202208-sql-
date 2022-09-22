import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Constants} from "../../../shared/Constants";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {MatDialog} from "@angular/material/dialog";
import {FormBuilder} from "@angular/forms";
import {ApiAssi} from "../../../shared/services/assi/api-assi";
import {ToastrService} from "ngx-toastr";
import {BookFormComponent} from "../../book-management/book-form/book-form.component";
import {ConfirmDialogComponent} from "../../../shared/components/confirm-dialog/confirm-dialog.component";
import {ReaderFormComponent} from "../reader-form/reader-form.component";

@Component({
  selector: 'app-reader-list',
  templateUrl: './reader-list.component.html',
  styleUrls: ['./reader-list.component.scss']
})
export class ReaderListComponent implements OnInit {


    readers!: MatTableDataSource<any> ;
    displayedColumns: string[] = ['ma' ,'ten', 'sdt',  'diachi' ,'ngaysinh', 'ngaytaotaikhoan',  'hang' , 'control'];
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
        // console.log("===== " , this.authorSearch.getRawValue().name , " ====")
        // this.api.searchReader( this.authorSearch.getRawValue().name  , this.authorSearch.getRawValue().address ).subscribe( data => {
        //     console.log(data)
        // })
        this.readers.filter = this.authorSearch.getRawValue().name.trim().toLowerCase();
    }

    loadData( ){
        this.api.getAllReader().subscribe( data => {
            this.readers = new MatTableDataSource<any>(data ) ;
            this.readers.paginator = this.paginator ;
            this.readers.sort = this.sort ;
            console.log(data)
        })
    }

    ngOnInit(): void {
        this.loadData();
    }


    openFormDialog( type: string , row?:any ) {
        const dialogRef = this.dialog.open( ReaderFormComponent , {
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
