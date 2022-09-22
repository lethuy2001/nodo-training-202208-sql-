import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Constants} from "../../../shared/Constants";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {MatDialog} from "@angular/material/dialog";
import {FormBuilder} from "@angular/forms";
import {ApiAssi} from "../../../shared/services/assi/api-assi";
import {ToastrService} from "ngx-toastr";
import {ReaderFormComponent} from "../../reader-management/reader-form/reader-form.component";
import {ConfirmDialogComponent} from "../../../shared/components/confirm-dialog/confirm-dialog.component";
import {BorrowBookFormComponent} from "../borrow-book-form/borrow-book-form.component";

@Component({
  selector: 'app-borrow-book-list',
  templateUrl: './borrow-book-list.component.html',
  styleUrls: ['./borrow-book-list.component.scss']
})
export class BorrowBookListComponent implements OnInit {

    borrowBook!: MatTableDataSource<any> ;
    displayedColumns: string[] = ['nguoimuon', 'sach' , 'soluong' ,'ngaymuon', 'ngaytra',  'trangthai' ,'ghichu'  , 'control'];
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
        this.borrowBook.filter = this.authorSearch.getRawValue().name.trim().toLowerCase();
    }

    loadData( ){
        this.api.getAllBorrowBook().subscribe( data => {
            this.borrowBook = new MatTableDataSource<any>(data ) ;
            this.borrowBook.paginator = this.paginator ;
            this.borrowBook.sort = this.sort ;
            console.log(data)
        })
    }

    ngOnInit(): void {
        this.loadData();
    }


    openFormDialog( type: string , row?:any ) {
        const dialogRef = this.dialog.open( BorrowBookFormComponent, {
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
