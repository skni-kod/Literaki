package SKNI.KOD.Literaki.controller.game;

import SKNI.KOD.Literaki.service.game.FieldsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("fields")
public class FieldsController {

    @Autowired
    FieldsService fieldsService;

    @GetMapping("/board/{id}")
    public ResponseEntity<?> getBoardFields(@PathVariable Long id){
        return ResponseEntity.ok(fieldsService.getAllFieldsByBoard(id));
    }

    @GetMapping("{id}")
    public ResponseEntity<?> getField(@PathVariable Long id){
        return ResponseEntity.ok(fieldsService.getField(id));
    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<?> deleteAllBoardFields(@PathVariable Long id){
        fieldsService.deleteAllByBoard(id);
        return ResponseEntity.ok().build();
    }
}
