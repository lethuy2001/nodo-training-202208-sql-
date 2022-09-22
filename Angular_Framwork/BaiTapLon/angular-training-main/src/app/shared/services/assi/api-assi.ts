import {Injectable} from "@angular/core";
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";

@Injectable({
    providedIn: "root"
})

export class ApiAssi{

    apiAuthor = "http://localhost:8080/author";
    apiPublicCompany = "http://localhost:8080/nxb"
    apiBook = "http://localhost:8080/book"
    apiReader = "http://localhost:8080/BanDoc"
    apiBorrow = "http://localhost:8080/ms"

    constructor( private http: HttpClient ) {
    }

    getAllAuthor(  ): Observable<any>{
        return this.http.get(`${this.apiAuthor}`);
    }

    createAuthor( author: any ): Observable<any>{
        return this.http.post( this.apiAuthor , author ) ;
    }

    updateAuthor( author: any ): Observable<any> {
        return this.http.put( `${this.apiAuthor}/${author.id}` , author );
    }

    deleteAuthor( id: number ): Observable<any> {
        return this.http.delete( `${this.apiAuthor}/${id}`)
    }

//    Nhà Xuất bản
    getAllPublicCompanyActive(): Observable<any>{
        return this.http.get(`${this.apiPublicCompany}/findActive`)
    }

    getAllPublicCompany( ) : Observable<any >{
        return this.http.get( this.apiPublicCompany ) ;
    }

    createPublicCompany( pc: any ):Observable<any>{
        return this.http.post( this.apiPublicCompany , pc );
    }

    updatePublicCompany( pc: any ):Observable<any>{
        return this.http.put( `${this.apiPublicCompany}/${pc.id}` , pc );
    }

    deletePublicCompany( pc: any ):Observable<any>{
        return this.http.put( `${this.apiPublicCompany}/${pc.id}` , pc );
    }

//    Sách

    getAllBook( ):Observable<any>{
        return  this.http.get( this.apiBook );
    }

    createBook( pc: any ):Observable<any>{
        return this.http.post( this.apiBook , pc );
    }

    updateBook( pc: any ):Observable<any>{
        return this.http.put( `${this.apiBook}/${pc.id}` , pc );
    }

    // deleteBook( pc: any ):Observable<any>{
    //     return this.http.put( `${this.apiPublicCompany}/${pc.id}` , pc );
    // }

//    Bạn đọccd
    getAllReader(): Observable<any>{
        return this.http.get( this.apiReader )
    }

    createReader( bd: any): Observable<any> {
        return this.http.post( `${this.apiReader}` , bd );
    }

    updateReader( bd: any ): Observable<any>{
        return this.http.put(`${this.apiReader}/${bd.id}` , bd )
    }

    searchReader( name: any , add: any):Observable<any>{
        return this.http.get( `${this.apiReader}/find/${name}/${add}`)
    }

//    Sách
    getAllBorrowBook(): Observable<any> {
        return this.http.get( this.apiBorrow )
    }

    createBorroBook( bd: any): Observable<any> {
        return this.http.post( `${this.apiBorrow}` , bd );
    }

    updateBorrowBook( bd: any ): Observable<any>{
        return this.http.put(`${this.apiBorrow}/${bd.id}` , bd )
    }

}
