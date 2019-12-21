import { Component, OnInit } from '@angular/core';
import { UserService } from '../user.service';

@Component({
  selector: 'app-inbox',
  templateUrl: './inbox.component.html',
  styleUrls: ['./inbox.component.css']
})
export class InboxComponent implements OnInit {

  // users;
  // selectedUser;
  mails: any;
  selectedUser;
  constructor(private service: UserService) {
     this.getData();
  }

  ngOnInit() {
  }

    getData() {
    this.service.inbox().subscribe(data => {
      console.log(data);
      this.mails = data;
    }, err => {
      console.log(err);
    }, () => {
      console.log('data got successfully');
    });
    }

    deleteData(mails) {
      console.log(mails);
      this.service.delete(mails).subscribe(data => {
        console.log(data);
        this.getData();
      }, err => {
        console.log(err);
      }, () => {
        console.log('data deleted successfully');
      });
    }

}
