import {AbstractControl, FormGroup, ValidationErrors, ValidatorFn} from "@angular/forms";
import {control} from "leaflet";

export function CompareDate( a: string , b: string ): ValidatorFn{

    return ( control: AbstractControl ): ValidationErrors | null => {
        const formGroup = control as FormGroup

        if( formGroup.get(a)?.value <= formGroup.get(b)?.value ){
            return null ;
        }else {
            return { checkDate: true }
        }
    }
}
