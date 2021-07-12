package ssst.healthdiary.backend.services;

import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import ssst.healthdiary.backend.dtos.google.GoogleTokenPayload;


public interface GoogleTokenServiceInterface {

  GoogleTokenPayload save(String userId, GoogleTokenResponse googleToken);
}
