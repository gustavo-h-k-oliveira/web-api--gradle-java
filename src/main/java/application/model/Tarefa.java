package application.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
public class Tarefa {
    // Identificador único da tarefa
    @Id
    private Long id;
    
    // Descrição da tarefa
    private String descricao;
}
