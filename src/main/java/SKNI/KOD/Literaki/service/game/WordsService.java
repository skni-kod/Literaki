package SKNI.KOD.Literaki.service.game;

import SKNI.KOD.Literaki.DTO.request.game.WordsRequest;
import SKNI.KOD.Literaki.DTO.response.game.WordsResponse;
import SKNI.KOD.Literaki.entity.game.Words;
import SKNI.KOD.Literaki.repository.game.WordsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class WordsService {

    @Autowired
    private WordsRepository wordsRepository;

    public List<WordsResponse> getAllWords() {
        return wordsRepository.findAll().stream()
                .map(WordsResponse::new)
                .collect(Collectors.toList());
    }

    public WordsResponse getWords(Long id){
        Words words = null;
        if(wordsRepository.existsById(id)) {
            words = wordsRepository.findById(id).get();
        }
        return new WordsResponse(words);
    }

    public WordsResponse createWords(WordsRequest wordsRequest){
        Words words = new Words(wordsRequest.getGameId(), wordsRequest.getPlayerId());
        return new WordsResponse(words);
    }

}
