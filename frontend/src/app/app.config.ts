import { ApplicationConfig } from '@angular/core';
import { provideRouter } from '@angular/router';
import { provideClientHydration } from '@angular/platform-browser';
import { importProvidersFrom } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { appRoutes } from './app.routes';
import { HttpClientModule, provideHttpClient, withFetch } from '@angular/common/http';
import { provideAnimationsAsync } from '@angular/platform-browser/animations/async';

export const appConfig: ApplicationConfig = {
  providers: [
    provideRouter(appRoutes), 
    provideClientHydration(),
    importProvidersFrom(FormsModule, HttpClientModule),  // ✅ NavbarComponent eliminado
    provideHttpClient(withFetch()), provideAnimationsAsync()
  ]
};
