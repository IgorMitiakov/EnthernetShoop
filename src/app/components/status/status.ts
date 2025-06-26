import { Component } from '@angular/core';
import { CommonModule } from '@angular/common';
import { FormsModule } from '@angular/forms';
import { Status, StatusService } from '../../service/status.service';

@Component({
  selector: 'app-status',
  standalone: true,
  imports: [CommonModule, FormsModule],
  templateUrl: './status.html'
})
export class StatusComponent {
  statuses: Status[] = [];
  newStatus: Status = { idStatus: 0, statName: ''}; 
  editMode = false;
  editStatus: Status | null = null;

  constructor(private statusService: StatusService) {
    this.loadAll();
  }

  loadAll() {
    this.statusService.getAll().subscribe(data => this.statuses = data);
  }

  addStatus() {
    this.statusService.create(this.newStatus).subscribe(() => {
      this.loadAll();
      this.newStatus = { idStatus: 0, statName: ''}; 
    });
  }

  deleteStatus(id: number) {
    this.statusService.delete(id).subscribe(() => this.loadAll());
  }

  startEdit(status: Status) {
    this.editMode = true;
    this.editStatus = { ...status };
  }

  saveEdit() {
    if (!this.editStatus) return;
    this.statusService.update(this.editStatus).subscribe(() => {
      this.loadAll();
      this.editMode = false;
      this.editStatus = null;
    });
  }
}