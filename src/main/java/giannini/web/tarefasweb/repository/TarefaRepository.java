package giannini.web.tarefasweb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import giannini.web.tarefasweb.model.Tarefa;

public interface TarefaRepository extends JpaRepository<Tarefa, Integer> {

}
