package SKNI.KOD.Literaki.controller;

import SKNI.KOD.Literaki.DTO.response.OldGameResponse;
import SKNI.KOD.Literaki.service.user.OldGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("oldgames")
public class OldGameController {

    @Autowired
    private OldGameService oldGameService;

    @GetMapping("")
    public List<OldGameResponse> getAllOldGames() {
        return oldGameService.getAllOldGames();
    }

    @GetMapping("/{id}")
    public OldGameResponse getOldGame(@PathVariable Long id){
        return oldGameService.getOldGame(id);
    }


}
