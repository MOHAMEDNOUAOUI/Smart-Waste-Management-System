import { Routes } from '@angular/router';
import { RegisterComponent } from './register/register.component';
import { HomePageComponent } from './Client/pages/home-page/home-page.component';
import { ClientayoutComponent } from './Client/layouts/clientayout/clientayout.component';
import { AboutComponent } from './Client/pages/about/about.component';

export const routes: Routes = [
    {
        path: '',
        component: ClientayoutComponent,
        children: [
          {path:'home' , component:HomePageComponent},
          {path:'about' , component:AboutComponent}
        ],
      },
    {path: 'register' , component:RegisterComponent},
    { path: '**', redirectTo: '/client/login' },
];
