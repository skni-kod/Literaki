package SKNI.KOD.Literaki.controller.game;

import SKNI.KOD.Literaki.DTO.request.game.BoardRequest;
import SKNI.KOD.Literaki.service.game.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("boards")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/{id}")
    public ResponseEntity<?> getBoard(@PathVariable Long id) {
        return ResponseEntity.ok(boardService.getBoard(id));
    }

    @PostMapping
    public ResponseEntity<?> createBoard(BoardRequest boardRequest){
        return ResponseEntity.ok(boardService.createBoard(boardRequest));
    }

    @PutMapping
    public ResponseEntity<?> updateBoard(BoardRequest boardRequest){
        return ResponseEntity.ok(boardService.updateBoard(boardRequest));
    }

    @DeleteMapping
    public ResponseEntity<?> deleteBoard(BoardRequest boardRequest){
        boardService.deleteBoard(boardRequest);
        return ResponseEntity.ok().build();
    }
}
