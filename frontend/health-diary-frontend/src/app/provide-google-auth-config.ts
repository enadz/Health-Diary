import { GoogleLoginProvider, SocialAuthServiceConfig } from 'angularx-social-login';

export const provideGoogleAuthConfig = () => ({
  provide: 'SocialAuthServiceConfig',
  useValue: {
    autoLogin: false,
    providers: [
      {
        id: GoogleLoginProvider.PROVIDER_ID,
        provider: new GoogleLoginProvider(
          '795094502559-t4hu0d42kn0v7ihb3e8ljr8ihk1ctcqg.apps.googleusercontent.com', //clientID 
          { scope: 'profile email https://www.googleapis.com/auth/fitness.activity.read https://www.googleapis.com/auth/fitness.sleep.read https://www.googleapis.com/auth/fitness.heart_rate.read https://www.googleapis.com/auth/fitness.oxygen_saturation.read' }
        )
      }
    ],
  } as SocialAuthServiceConfig,
});

// const googleLoginOptions = {
//   scope: 'profile email, https://www.googleapis.com/auth/fitness.activity.read, https://www.googleapis.com/auth/fitness.sleep.read, https://www.googleapis.com/auth/fitness.heart_rate.read, https://www.googleapis.com/auth/fitness.oxygen_saturation.read'
// }; // https://developers.google.com/api-client-library/javascript/reference/referencedocs#gapiauth2clientconfig



// Client ID
//     795094502559-t4hu0d42kn0v7ihb3e8ljr8ihk1ctcqg.apps.googleusercontent.com
// Client secret
//     oEcPk_GnX7ZxBId6tQF-hhTi