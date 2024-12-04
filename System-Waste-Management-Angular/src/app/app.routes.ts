import { Routes } from '@angular/router';
import { HomePageComponent } from './Client/pages/home-page/home-page.component';
import { RegisterComponent } from './register/register.component';

export const routes: Routes = [
    {path: 'Client' , component: HomePageComponent},
    {path: 'Register' , component:RegisterComponent}
];
