import {AbstractControl} from "@angular/forms";

export function SpaceValidator( c: AbstractControl ){
    return ( c.value.trim() == '' ) ? {
        isSpace: true
    }: null ;
}
