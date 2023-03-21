package SKNI.KOD.Literaki.controller.game;

import SKNI.KOD.Literaki.DTO.request.game.WordsRequest;
import SKNI.KOD.Literaki.DTO.response.game.WordsResponse;
import SKNI.KOD.Literaki.service.game.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("words")
public class WordsController {

    @Autowired
    private WordsService wordsService;

    @GetMapping
    public List<WordsResponse> getGames() {
        return wordsService.getAllWords();
    }

    @GetMapping("/{id}")
    public WordsResponse getWords(@PathVariable Long id) {
        return wordsService.getWords(id);
    }

    @PostMapping
    public ResponseEntity<?> createWords(WordsRequest wordsRequest){
    WordsResponse wordsResponse = wordsService.createWords(wordsRequest);
    return ResponseEntity.ok(wordsResponse);
    }

}
