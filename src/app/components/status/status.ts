import { Component, OnInit } from '@angular/core';
import { StatusService, Status } from '../../service/status.service';
import { CommonModule } from '@angular/common';

@Component({
  selector: 'app-status-list',
  standalone: true,
  imports: [CommonModule],
  templateUrl: './status.html',
})
export class StatusListComponent implements OnInit {
  statuses: Status[] = [];

  constructor(private statusService: StatusService) {}

  ngOnInit() {
    this.statusService.getAll().subscribe((data: Status[]) => {
      this.statuses = data;
      console.log("Statuses:", data);
    });
  }
}