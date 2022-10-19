package SKNI.KOD.Literaki.service.user;

import SKNI.KOD.Literaki.DTO.request.ProfileRequest;
import SKNI.KOD.Literaki.DTO.response.ProfileResponse;
import SKNI.KOD.Literaki.entity.games.Words;
import SKNI.KOD.Literaki.entity.login.Login;
import SKNI.KOD.Literaki.entity.user.Profile;
import SKNI.KOD.Literaki.repository.ProfileRepository;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProfileService {

    @Autowired
    private ProfileRepository profileRepository;

    public List<ProfileResponse> getAllProfiles() {
        return profileRepository.findAll().stream()
                .map(ProfileResponse::new)
                .collect(Collectors.toList());
    }

    public ProfileResponse getProfile(Long id){
        Profile profile = null;
        if(profileRepository.existsById(id)) {
            profile = profileRepository.findById(id).get();
        }
        return new ProfileResponse(profile);

    }

    public ProfileResponse createProfile(Login login){
        Profile profile = new Profile(login.getId(), login.getUsername());
        return new ProfileResponse(profile);
    }

    public ProfileResponse updateProfile(ProfileRequest profileRequest, Long id){
        Profile profile = null;
        if(profileRepository.existsById(id)) {
            profile = profileRepository.findById(id).get();
            profile.setIcon(profileRequest.getIcon());
        }
        return new ProfileResponse(profile);
    }

    public void deleteProfile(Long id){
        if(profileRepository.existsById(id)) {
            Profile profile = profileRepository.findById(id).get();
            profileRepository.delete(profile);
        }
    }
}
