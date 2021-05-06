/*
 * This file is part of the medsafe-backend-service-web application which is commercial software
 * created by MedVision360 B.V. The source code is proprietary and confidential.
 *
 * Unauthorized copying of this file, via any medium is strictly prohibited.
 *
 * Copyright (c) by MedVision360 B.V. All rights reserved.
 */

package ssst.healthdiary.backend.services;

import com.google.api.client.googleapis.auth.oauth2.GoogleTokenResponse;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import ssst.healthdiary.backend.dtos.google.GoogleTokenPayload;
import ssst.healthdiary.backend.mappers.GoogleTokenResponseMapper;
import ssst.healthdiary.backend.repositories.GoogleTokenRepository;

@Slf4j
@Service
@AllArgsConstructor
public class GoogleTokenService implements GoogleTokenServiceInterface {

  private GoogleTokenRepository googleTokenResponseRepository;

  @Override
  public GoogleTokenPayload save(final String userId, final GoogleTokenResponse googleToken) {
    return googleTokenResponseRepository.findByUserId(userId)
        .map(entity -> {
          entity.setAccessToken(googleToken.getAccessToken());
          entity.setRefreshToken(googleToken.getRefreshToken());
          return entity;
        })
        .map(entity -> googleTokenResponseRepository.save(entity))
        .map(GoogleTokenResponseMapper.INSTANCE::toPayload)
        .orElseThrow();
  }
}
