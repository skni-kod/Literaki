package SKNI.KOD.Literaki.controller;

import SKNI.KOD.Literaki.DTO.response.WordsResponse;
import SKNI.KOD.Literaki.service.games.WordsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("words")
public class WordsController {

    @Autowired
    private WordsService wordsService;

    @GetMapping("")
    public List<WordsResponse> getGames() {
        return wordsService.getAllWords();
    }

    @GetMapping("/{id}")
    public WordsResponse getWords(@PathVariable Long id) {
        return wordsService.getWords(id);
    }
}
