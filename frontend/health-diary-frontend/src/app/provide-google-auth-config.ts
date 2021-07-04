import { GoogleLoginProvider, SocialAuthServiceConfig } from 'angularx-social-login';

export const provideGoogleAuthConfig = () => ({
  provide: 'SocialAuthServiceConfig',
  useValue: {
    autoLogin: false,
    providers: [
      {
        id: GoogleLoginProvider.PROVIDER_ID,
        provider: new GoogleLoginProvider(
          '795094502559-t4hu0d42kn0v7ihb3e8ljr8ihk1ctcqg.apps.googleusercontent.com' //clientID
        )
      }
    ],
  } as SocialAuthServiceConfig,
});
