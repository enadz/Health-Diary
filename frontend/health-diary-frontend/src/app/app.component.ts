import {HttpClient, HttpHeaders} from '@angular/common/http';
import { Variable } from '@angular/compiler/src/render3/r3_ast';
import { Component } from '@angular/core';
import { GoogleLoginProvider, SocialAuthService as AngularXSocialAuthService, SocialUser } from 'angularx-social-login';

@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'health-diary-frontend';
  user:SocialUser;

  constructor(private socialAuth: AngularXSocialAuthService) {
  }

  ngOnInit(): void {
    this.socialAuth.authState.subscribe((user) =>{
      this.user = user;
    })    
  }

    
  signInWithGoogle(): void {
    this.socialAuth
      .signIn(GoogleLoginProvider.PROVIDER_ID)
      .then((res) => {
        console.log(res);
        this.user= res;
      });
  }

  signOut(): void{
    this.socialAuth.signOut();
    console.log("You've been signed out")
  }


/*
forwardUserAuthToken(){
  this.http.post('localhost:8080/api/userToken',
  {
    "authToken": "{{user.authToken}}"
  },
    {
      headers: {
        'Access-Control-Allow-Origin':'*',
        //'Authorization': 'Bearer {{user.authToken}}',
      }

    })
    .subscribe(value => {
      console.log(value);
    });
}

getSteps() {
  this.http.post('https://www.googleapis.com/fitness/v1/users/me/dataset:aggregate',
  {
    "aggregateBy": [{
      "dataTypeName": "com.google.step_count.delta",
      "dataSourceId": "derived:com.google.step_count.delta:com.google.android.gms:estimated_steps"
    }],
    "bucketByTime": { "durationMillis": 86400000 },
    "startTimeMillis": "1621460022000",
    "endTimeMillis": "1621510022000"
  },
    {
      headers: {
        'Access-Control-Allow-Origin':'*',
        'Authorization': 'Bearer {{user.authToken}}',
      }

    })
    .subscribe(value => {
      console.log(value);
    });
}

getSleep(){
this.http.get("https://www.googleapis.com/fitness/v1/users/me/sessions?startTime==2021-06-06T00:00.000Z&endTime=2021-06-06T23:59:59.999Z&activityType=72",
{
  headers: {
    'Access-Control-Allow-Origin':'*',
    'Authorization': 'Bearer {{user.authToken}}',
  }

})
.subscribe(value => {
  console.log(value);
});

}*/
/*  fitnes() {
    this.http.get('https://accounts.google.com/o/oauth2/v2/auth?redirect_uri=http://localhost:4200&prompt=consent&response_type=code&client_id=795094502559-t4hu0d42kn0v7ihb3e8ljr8ihk1ctcqg.apps.googleusercontent.com&scope=https://www.googleapis.com/auth/fitness.activity.read+https://www.googleapis.com/auth/fitness.blood_glucose.read&access_type=offline',
      {
        headers: {
          'Authorization': '{{user.authToken}}',
        }
      })
      .subscribe(value => {
        console.log(value);
      });
  }*/

}
