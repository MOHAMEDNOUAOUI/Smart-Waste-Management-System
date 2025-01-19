import { Routes } from '@angular/router';

export const routes: Routes = [
    {path:'dashboard' , loadChildren:() => import('./features/dashboard-admin/routes').then(m => m.DashboardRoutes)}
];
