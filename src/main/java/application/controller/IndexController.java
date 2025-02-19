package application.controller;

// Importações necessárias
import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;

@RestController
@RequestMapping("/")
public class IndexController {
    // Lista de frutas inicializada como uma lista vazia
    // private List<String> frutas = Arrays.asList("Maça", "Banana", "Morango");
    private List<String> frutas = new ArrayList<String>();
    
    // Método GET para retornar a lista de frutas
    @GetMapping
    public List<String> home() {
        return frutas;
    }

    // Método POST para adicionar uma fruta à lista e retornar a lista atualizada
    @PostMapping
    public List<String> postHome(@RequestBody String fruta) {
        frutas.add(fruta);
        return frutas;
    }
}
