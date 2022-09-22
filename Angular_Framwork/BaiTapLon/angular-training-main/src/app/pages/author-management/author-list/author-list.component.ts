import {Component, OnInit, ViewChild} from '@angular/core';
import {MatPaginator} from "@angular/material/paginator";
import {ApiAssi} from "../../../shared/services/assi/api-assi";
import {MatTableDataSource} from "@angular/material/table";
import {MatSort} from "@angular/material/sort";
import {MatDialog} from "@angular/material/dialog";
import {ConfirmDialogComponent} from "../../../shared/components/confirm-dialog/confirm-dialog.component";
import {AuthorFormComponent} from "../author-form/author-form.component";
import {Constants} from "../../../shared/Constants";
import {FormBuilder, Validators} from "@angular/forms";
import {AuthorService} from "../../../shared/services/assi/author.service";
import {signOut} from "@angular/fire/auth";

@Component({
  selector: 'app-author-list',
  templateUrl: './author-list.component.html',
  styleUrls: ['./author-list.component.scss']
})

export class AuthorListComponent implements OnInit {

  authors!: MatTableDataSource<any> ;
  displayedColumns: string[] = ['ma', 'ten', 'sdt', 'diachi' , 'mota' , 'control'];
  TYPE_DIALOG = Constants.TYPE_DIALOG ;
  @ViewChild(MatPaginator) paginator!: MatPaginator;
  @ViewChild(MatSort) sort!: MatSort;

  authorSearch = this.fb.group( {
      name: '',
      address: ''
  })


  constructor( private author: AuthorService ,
               private dialog: MatDialog ,
               private fb: FormBuilder  ,
               private api: ApiAssi ) {
  }

    applyFilter() {
        // const filterValue = (event.target as HTMLInputElement).value;
        // console.log( filterValue )
        this.authors.filter = this.authorSearch.getRawValue().name.trim().toLowerCase();
    }

  findAuthor()  {

  }

  loadData( ){
      this.api.getAllAuthor().subscribe( data => {
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
      const dialogRef = this.dialog.open( AuthorFormComponent , {
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

  openDeleteDialog( id: number ) {
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
              console.log(id)
              this.api.deleteAuthor( id ).subscribe( () => {
                  this.loadData() ;
              })

          }
      })
  }
}
