package SKNI.KOD.Literaki.controller.user;

import SKNI.KOD.Literaki.DTO.response.user.OldGameResponse;
import SKNI.KOD.Literaki.service.user.OldGameService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("oldgames")
public class OldGameController {

    @Autowired
    private OldGameService oldGameService;

    @GetMapping
    public List<OldGameResponse> getAllOldGames() {
        return oldGameService.getAllOldGames();
    }

    @GetMapping("/{id}")
    public OldGameResponse getOldGame(@PathVariable Long id){
        return oldGameService.getOldGame(id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deleteOldGame(@PathVariable Long id){
        oldGameService.deleteOldGame(id);
        return ResponseEntity.ok().build();
    }


}
