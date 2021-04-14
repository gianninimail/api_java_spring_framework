package giannini.web.tarefasweb.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import giannini.web.tarefasweb.model.Tarefa;
import giannini.web.tarefasweb.repository.TarefaRepository;

@Service
public class TarefaService {

	@Autowired
	private TarefaRepository repo;
	
	public List<Tarefa> getTodasTarefas() {
		return repo.findAll();
	}
	
	public Tarefa getTarefaForID(Integer _id) {
		return repo.findById(_id).get();
	}

	public Tarefa create(Tarefa _obj) {
		return repo.save(_obj);
	}
	
	public Tarefa  update(Integer _id, Tarefa _ojb) {
		Optional<Tarefa> tarefaOptional = repo.findById(_id);
		if (!tarefaOptional.isPresent()) {
			throw new EntityNotFoundException("Recurso não encontrado!");
		}
		
		Tarefa tarefaBanco = tarefaOptional.get();
		_ojb.setId(tarefaBanco.getId());
		
		return repo.save(_ojb);
	}

	public void delete(Integer _id) {
		repo.deleteById(_id);
	}
}
