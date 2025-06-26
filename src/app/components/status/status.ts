import { Component, OnInit } from '@angular/core';
import { StatusService, Status } from '../../service/status.service';
import { CommonModule } from '@angular/common';
import { FormBuilder, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-status-list',
  standalone: true,
  imports: [CommonModule, ReactiveFormsModule],
  templateUrl: './status.html',
  styleUrls: ['./status.component.css'],
})
export class StatusListComponent implements OnInit {
  statuses: Status[] = [];
  statusForm: FormGroup;
  editingStatus: Status | null = null;

  constructor(private statusService: StatusService, private fb: FormBuilder) {
    this.statusForm = this.fb.group({
      statName: [''],
      isFinal: [false]
    });
  }

  ngOnInit() {
    this.loadStatuses();
  }

  loadStatuses() {
    this.statusService.getAll().subscribe((data: Status[]) => {
      this.statuses = data;
      console.log("Statuses:", data);
    });
  }

  addStatus() {
    const newStatus = this.statusForm.value;
    this.statusService.createStatus(newStatus).subscribe((createdStatus: Status) => {
      this.loadStatuses(); // Перезагрузка списка
      this.statuses.push(createdStatus); // Добавляем новую запись с id
      this.statusForm.reset({ statName: '', isFinal: false });
    }, (error) => {
      console.error('Ошибка при добавлении статуса:', error);
    });
  }

  onSubmit() {
    if (this.editingStatus) {
      const updatedStatus = { ...this.editingStatus, ...this.statusForm.value };
      this.statusService.updateStatus(updatedStatus).subscribe(() => {
        this.loadStatuses();
        this.editingStatus = null;
        this.statusForm.reset();
      }, (error) => {
        console.error('Ошибка при обновлении статуса:', error);
      });
    }
  }

  editStatus(status: Status) {
    this.editingStatus = { ...status };
    this.statusForm.patchValue(status);
  }

  deleteStatus(id: number) {
    if (confirm('Вы уверены, что хотите удалить этот статус?')) {
      this.statusService.deleteStatus(id).subscribe(() => {
        this.loadStatuses();
      }, (error) => {
        console.error('Ошибка при удалении статуса:', error);
      });
    }
  }

  cancelEdit() {
    this.editingStatus = null;
    this.statusForm.reset();
  }
}