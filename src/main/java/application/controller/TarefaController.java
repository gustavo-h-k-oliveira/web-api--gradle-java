package application.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import application.model.Tarefa;
import application.repository.TarefaRepository;

@RestController
@RequestMapping("/tarefas")
public class TarefaController {
    @Autowired
    private TarefaRepository tarefaRepo;

    // Método para listar todas as tarefas
    @GetMapping
    public Iterable<Tarefa> list() {
        return tarefaRepo.findAll();
    }

    // Método para buscar uma tarefa pelo ID
    @GetMapping("/{id}")
    public Tarefa getOne(@PathVariable long id) {
        Optional<Tarefa> resultado = tarefaRepo.findById(id);
        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Tarefa não encontrada"
            );
        }
        return resultado.get();
    }

    // Método para inserir uma nova tarefa
    @PostMapping
    public Tarefa insert(@RequestBody Tarefa novaTarefa) {
        return tarefaRepo.save(novaTarefa);
    }

    // Método para atualizar uma tarefa existente
    @PutMapping("/{id}")
    public Tarefa update(@RequestBody Tarefa dados, @PathVariable long id) {
        Optional<Tarefa> resultado = tarefaRepo.findById(id);
        if(resultado.isEmpty()) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Tarefa não encontrada"
            );
        }
        resultado.get().setDescricao(dados.getDescricao());
        return tarefaRepo.save(resultado.get());
    }

    // Método para deletar uma tarefa pelo ID
    @DeleteMapping("/{id}")
    public void delete(@PathVariable long id) {
        if (!tarefaRepo.existsById(id)) {
            throw new ResponseStatusException(
                HttpStatus.NOT_FOUND, "Tarefa não encontrada"
            );
        }
        tarefaRepo.deleteById(id);
    }
}
