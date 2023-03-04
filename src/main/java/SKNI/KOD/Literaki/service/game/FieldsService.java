package SKNI.KOD.Literaki.service.game;

import SKNI.KOD.Literaki.DTO.response.game.FieldsResponse;
import SKNI.KOD.Literaki.entity.game.Board;
import SKNI.KOD.Literaki.entity.game.Fields;
import SKNI.KOD.Literaki.repository.game.BoardRepository;
import SKNI.KOD.Literaki.repository.game.FieldsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class FieldsService {

    @Autowired
    FieldsRepository fieldsRepository;
    @Autowired
    BoardRepository boardRepository;

    public FieldsResponse getField(Long id){
        Fields fields = null;
        if(fieldsRepository.existsById(id)) {
            fields = fieldsRepository.findById(id).get();
        }
        return new FieldsResponse(fields);
    }

    public List<FieldsResponse> getAllFieldsByBoard(Long id){
        if(boardRepository.existsById(id)){
            return  fieldsRepository.findAllByBoard(boardRepository.findById(id).get())
                    .stream().map(FieldsResponse::new).collect(Collectors.toList());
        }
        return new ArrayList<>();
    }

    public void deleteAllByBoard(Long id){
        if(boardRepository.existsById(id))
            fieldsRepository.deleteAllByBoard(boardRepository.findById(id).get());

    }

    //TODO: do we need more?
}
