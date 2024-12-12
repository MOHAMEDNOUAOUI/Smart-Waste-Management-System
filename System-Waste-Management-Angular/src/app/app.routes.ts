import { Routes } from '@angular/router';
import { RegisterComponent } from './authentication-page/register/register.component';
import { HomePageComponent } from './Client/pages/home-page/home-page.component';
import { ClientayoutComponent } from './Client/layouts/clientayout/clientayout.component';
import { AboutComponent } from './Client/pages/about/about.component';
import { LoginComponent } from './authentication-page/login/login.component';
import { AuthenticationPageComponent } from './authentication-page/authentication-page.component';

export const routes: Routes = [
    {
        path: '',
        component: ClientayoutComponent,
        children: [
          {path:'' , component:HomePageComponent},
          {path:'about' , component:AboutComponent}
        ],
      },
      {
        path: '',
        component:AuthenticationPageComponent,
        children: [
          {path: 'register' , component:RegisterComponent},
          {path: 'login' , component:LoginComponent}
        ],
      },
    { path: '**', redirectTo: '/login' },
];
