package SKNI.KOD.Literaki.controller;

import SKNI.KOD.Literaki.DTO.request.ProfileRequest;
import SKNI.KOD.Literaki.DTO.response.ProfileResponse;
import SKNI.KOD.Literaki.service.user.ProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("profiles")
public class ProfileController {

    @Autowired
    private ProfileService profileService;

    @GetMapping("")
    public List<ProfileResponse> getAllProfiles() {
        return profileService.getAllProfiles();
    }

    @GetMapping("/{id}")
    public ProfileResponse getProfile(@PathVariable Long id){
        return profileService.getProfile(id);
    }

    @PutMapping("/{id}/update")
    public ResponseEntity<?> updateProfile(ProfileRequest profileRequest){
        ProfileResponse profileResponse = profileService.updateProfile(profileRequest);
        return ResponseEntity.ok(profileResponse);
    }

}
