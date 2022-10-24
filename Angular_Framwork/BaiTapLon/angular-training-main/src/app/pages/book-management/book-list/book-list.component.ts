import {Component, OnInit, ViewChild} from '@angular/core';
import {MatTableDataSource} from "@angular/material/table";
import {Constants} from "../../../shared/Constants";
import {MatPaginator} from "@angular/material/paginator";
import {MatSort} from "@angular/material/sort";
import {MatDialog} from "@angular/material/dialog";
import {FormBuilder} from "@angular/forms";
import {ApiAssi} from "../../../shared/services/assi/api-assi";
import {ToastrService} from "ngx-toastr";
import {
    PublicCompanyFormComponent
} from "../../public_company-management/public-company-form/public-company-form.component";
import {ConfirmDialogComponent} from "../../../shared/components/confirm-dialog/confirm-dialog.component";
import {BookFormComponent} from "../book-form/book-form.component";

@Component({
  selector: 'app-book-list',
  templateUrl: './book-list.component.html',
  styleUrls: ['./book-list.component.scss']
})
export class BookListComponent implements OnInit {


    books!: MatTableDataSource<any> ;
    displayedColumns: string[] = ['ma', 'ten',  'chude' ,'tagia', 'nxb' , 'namsx' , 'tongSach','mota' , 'control'];
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
        this.books.filter = this.authorSearch.getRawValue().name.trim().toLowerCase();
    }

    loadData( ){
        this.api.getAllBook().subscribe( data => {
            this.books = new MatTableDataSource<any>(data ) ;
            this.books.paginator = this.paginator ;
            this.books.sort = this.sort ;
            console.log(data)
        })
    }

    ngOnInit(): void {
        this.loadData();
    }


    openFormDialog( type: string , row?:any ) {
        const dialogRef = this.dialog.open( BookFormComponent , {
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

    slides = [
        { img: 'https://via.placeholder.com/600.png/09f/fff' },
        { img: 'https://via.placeholder.com/600.png/021/fff' },
        { img: 'https://via.placeholder.com/600.png/321/fff' },
        { img: 'https://via.placeholder.com/600.png/422/fff' },
        { img: 'https://via.placeholder.com/600.png/654/fff' },
      ];
      slideConfig = { slidesToShow: 4, slidesToScroll:1};
      addSlide() {
        this.slides.push({ img: 'http://placehold.it/350x150/777777' });
      }
      removeSlide() {
        this.slides.length = this.slides.length - 1;
      }
      slickInit(e: any) {
        console.log('slick initialized');
      }
      breakpoint(e: any) {
        console.log('breakpoint');
      }
      afterChange(e: any) {
        console.log('afterChange');
      }
      beforeChange(e: any) {
        console.log('beforeChange');
      }

}
