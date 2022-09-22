import {Component, Input, OnInit} from '@angular/core';
import {FormControl} from "@angular/forms";

@Component({
    selector: 'app-inline-message',
    templateUrl: './inline-message.component.html',
    styleUrls: ['./inline-message.component.scss']
})
export class InlineMessageComponent implements OnInit {
    // @ts-ignore
    @Input() formName: FormControl;
    // @ts-ignore
    @Input() message;

    constructor() {
    }

    ngOnInit(): void {
    }

}
