package com.scisw.phonecontacts.service;

import com.scisw.phonecontacts.domain.login.request.SignInRequest;
import com.scisw.phonecontacts.domain.login.request.SignUpRequest;
import com.scisw.phonecontacts.domain.login.response.JwtAuthenticationResponse;

public interface AuthenticationService {
    JwtAuthenticationResponse signup(SignUpRequest request);

    JwtAuthenticationResponse signIn(SignInRequest request);
}
