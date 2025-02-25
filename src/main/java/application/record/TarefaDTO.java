package application.record;

import application.model.Tarefa;

public record TarefaDTO(long id, String descricao) {
    public TarefaDTO(Tarefa tarefa) {
        this(tarefa.getId(), tarefa.getDescricao());
    }
}
