package SKNI.KOD.Literaki.service.game;

import SKNI.KOD.Literaki.DTO.request.game.LetterRequest;
import SKNI.KOD.Literaki.DTO.response.game.LetterResponse;
import SKNI.KOD.Literaki.entity.game.Letter;
import SKNI.KOD.Literaki.repository.game.LetterRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LetterService {

    @Autowired
    LetterRepository letterRepository;

    public LetterResponse getLetter(Long id){
        Letter letter = null;
        if(letterRepository.existsById(id))
            letter = letterRepository.findById(id).get();
        return new LetterResponse(letter);
    }

//    public LetterResponse updateLetter(LetterRequest letterRequest){
//        Letter letter = null;
//        if(letterRepository.existsById(letterRequest.getLetterId())){
//            letter = letterRepository.findById(letterRequest.getLetterId()).get();
//            letter.setScore(letterRequest.getScore());
//            letterRepository.save(letter);
//        }
//        return new LetterResponse(letter);
//    }

    public void deleteLetter(Long id){
        if(letterRepository.existsById(id)) letterRepository.deleteById(id);
    }

    //TODO: do we need more?
}
