package SKNI.KOD.Literaki.service.game;

import SKNI.KOD.Literaki.DTO.request.game.BoardRequest;
import SKNI.KOD.Literaki.DTO.response.game.BoardResponse;
import SKNI.KOD.Literaki.entity.game.Board;
import SKNI.KOD.Literaki.repository.game.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {
    @Autowired
    private BoardRepository boardRepository;

    public BoardResponse getResponse(Long id) {
        Board board = null;
        if(boardRepository.existsById(id))  board = boardRepository.findById(id).get();
        return new BoardResponse(board);
    }

    public List<BoardResponse> getAllBoards() {
        return boardRepository.findAll()
                .stream()
                .map(BoardResponse::new)
                .collect(Collectors.toList());
    }

    public BoardResponse createBoard(BoardRequest boardRequest){
        Board board = new Board();
        //TODO: implement: create both players wordbags, create list of fields
        return new BoardResponse(board);
    }

    public BoardResponse updateBoard(BoardRequest boardRequest){
        Board board = null;
        if(boardRepository.existsById(boardRequest.getBoardId())){
            board = boardRepository.findById(boardRequest.getBoardId()).get();
            board.setPlayerTwoScore(boardRequest.getPlayerTwoScore());
            board.setPlayerTwoScore(boardRequest.getPlayerTwoScore());
            boardRepository.save(board);
        }
        return new BoardResponse(board);
    }

    public void deleteBoard(BoardResponse boardResponse){
        if(boardRepository.existsById(boardResponse.getBoardId())){
            //TODO: delete both players wordbags, delete list of fields
            boardRepository.deleteById(boardResponse.getBoardId());
        }

    }

}
