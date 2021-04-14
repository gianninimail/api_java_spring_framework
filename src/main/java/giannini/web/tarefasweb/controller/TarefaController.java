package giannini.web.tarefasweb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import giannini.web.tarefasweb.model.Tarefa;
import giannini.web.tarefasweb.service.TarefaService;

@RestController
@RequestMapping("/api/tarefa")
public class TarefaController {
	
	@Autowired
	private TarefaService service;

	@GetMapping
	public List<Tarefa> getAll() {
		return service.getTodasTarefas();
	}
	
	@GetMapping(value = "{_id}")
	public Tarefa getForID(@PathVariable Integer _id) {
		return service.getTarefaForID(_id);
	}
	
	@PostMapping
	public Tarefa create(@RequestBody Tarefa _obj) {
		return service.create(_obj);
	}
	
	@PutMapping(value = "{_id}")
	public Tarefa update(@PathVariable Integer _id, @RequestBody Tarefa _obj) {
		return service.update(_id, _obj);
	}
	
	@DeleteMapping("{_id}")
	@ResponseStatus(code = HttpStatus.NO_CONTENT)
	public void delete(@PathVariable Integer _id) {
		service.delete(_id);
	}
}
