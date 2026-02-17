package com.social.media.controller;

import com.social.media.model.SocialGroup;
import com.social.media.model.SocialUser;
import com.social.media.service.SocialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@org.springframework.stereotype.Controller
public class Controller {

    @Autowired
    private SocialService service;

    @GetMapping("/api/social")
    public ResponseEntity<List<SocialUser>>  getSocialUser(){
        return service.getAllUsers();
    }

    @PostMapping("/api/social")
    public ResponseEntity<SocialUser> saveSocialUser(@RequestBody SocialUser socialUser){
        return service.saveSocialUser(socialUser);
    }
}
