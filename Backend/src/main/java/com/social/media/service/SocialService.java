package com.social.media.service;

import com.social.media.model.SocialUser;
import com.social.media.repository.SocialUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SocialService {

    @Autowired
    private SocialUserRepository socialUserRepository;


    public ResponseEntity<SocialUser> saveSocialUser(SocialUser socialUser) {

        return new ResponseEntity<SocialUser> (socialUserRepository.save(socialUser), HttpStatus.ACCEPTED );
    }


    public ResponseEntity<List<SocialUser>> getAllUsers() {

        return new  ResponseEntity<List<SocialUser>> (socialUserRepository.findAll() , HttpStatus.ACCEPTED);

    }
}
