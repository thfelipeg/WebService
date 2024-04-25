package ps2.restapidb;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;


@RestController
public class DisciplinaController {

    @Autowired
    private DisciplinaRepo disciplinaRepo;

    @GetMapping("/api/disciplinas")
    Iterable<Disciplina> getDisciplinas() {
        return disciplinaRepo.findAll();
    }

    @GetMapping("/api/disciplinas/{id}")
    Optional<Disciplina> getDisciplina(@PathVariable long id) {
        return disciplinaRepo.findById(id);
    }

    @PostMapping("/api/disciplinas")
    Disciplina createDisciplina(@RequestBody Disciplina disciplina) {
        Disciplina createdDisciplina = disciplinaRepo.save(disciplina);
        return createdDisciplina;
    }

    @PutMapping("/api/disciplinas/{disciplinaId}")
    Optional<Disciplina> updateDisciplina(@RequestBody Disciplina disciplinaReq, @PathVariable long disciplinaId) {
        Optional<Disciplina> optionalDisciplina = disciplinaRepo.findById(disciplinaId);
        if (optionalDisciplina.isPresent()) {
            if (disciplinaReq.getId() == disciplinaId) {
                disciplinaRepo.save(disciplinaReq);
                return optionalDisciplina;
            }
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND,
                "ERRO - Não foi possível alterar os dados da disciplina de código "+disciplinaId);
    }

    @DeleteMapping("/api/disciplinas/{id}")
    void deleteDisciplina(@PathVariable long id) {
        disciplinaRepo.deleteById(id);
    }
}
