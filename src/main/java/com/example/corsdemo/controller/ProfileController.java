package com.example.corsdemo.controller;

import com.example.corsdemo.entity.Profile;
import com.example.corsdemo.repository.ProfileRepository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(
    origins = "http://localhost:5500",
    methods = {RequestMethod.GET}
)
public class ProfileController {

    private final ProfileRepository profileRepository;

    public ProfileController(ProfileRepository profileRepository) {
        this.profileRepository = profileRepository;
    }

    @GetMapping("/profile")
    public Profile getProfile() {

        return profileRepository.findAll()
                .stream()
                .findFirst()
                .orElse(new Profile(
                        "Charishma",
                        "charishma@example.com",
                        "CSE Student"
                ));
    }
}