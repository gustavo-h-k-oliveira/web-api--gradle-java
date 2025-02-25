package application.model;

import application.record.TarefaDTO;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Tarefa {
    // Identificador único da tarefa
    @Id
    private Long id;
    
    // Descrição da tarefa
    private String descricao;

    public Tarefa(TarefaDTO dto) {
        this.id = dto.id();
        this.descricao = dto.descricao();    
    }
}
