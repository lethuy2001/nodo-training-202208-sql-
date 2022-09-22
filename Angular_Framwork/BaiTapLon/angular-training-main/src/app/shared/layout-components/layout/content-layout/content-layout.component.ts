import { Component, OnInit } from '@angular/core';
import { Subscription } from 'rxjs';
import { SwitcherService } from 'src/app/shared/services/switcher.service';

@Component({
  selector: 'app-content-layout',
  templateUrl: './content-layout.component.html',
  styleUrls: ['./content-layout.component.scss']
})
export class ContentLayoutComponent implements OnInit {

  layoutSub!: Subscription;
  sidenavtoggled1: any;

  constructor(public SwitcherService : SwitcherService) { }
  ngOnInit() {}
  
  toggleSwitcherBody() {
    this.SwitcherService.emitChange(false);
  }

}
