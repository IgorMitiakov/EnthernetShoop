import { Routes } from '@angular/router';
import { CustomerListComponent } from './components/customer/customer';
import { ProductListComponent } from './components/product/product';
import { StatusListComponent } from './components/status/status';
import { OrderListComponent } from './components/order/order';
import { HomeComponent} from './hompage/home/home';

export const routes: Routes = [
{ path: '', component: HomeComponent  },
{ path: 'customers', component: CustomerListComponent },
{ path: 'products', component: ProductListComponent },
{ path: 'statuses', component: StatusListComponent },
{ path: 'orders', component: OrderListComponent },

];