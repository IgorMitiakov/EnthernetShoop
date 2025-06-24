import { Routes } from '@angular/router';
import { ProductListComponent } from './components/product/product';
import { StatusListComponent } from './components/status/status';
export const routes: Routes = [
    { path: 'persons', component: ProductListComponent },
    { path: 'points', component: StatusListComponent },
    { path: '', redirectTo: '/persons', pathMatch: 'full' }
];