package br.ufba.tomorrow.todoProject.api.controllers;

import br.ufba.tomorrow.todoProject.api.dto.TodoCreateDTO;
import br.ufba.tomorrow.todoProject.api.dto.TodoDTO;
import br.ufba.tomorrow.todoProject.api.dto.TodoUpdateDTO;
import br.ufba.tomorrow.todoProject.domain.entities.Estado;
import br.ufba.tomorrow.todoProject.domain.entities.Todo;
import br.ufba.tomorrow.todoProject.domain.services.TodoService;
import br.ufba.tomorrow.todoProject.repository.TodoRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/todos")
public class TodoController {
    private final TodoService service;
    public TodoController(TodoService service){
        this.service = service;
    }

    @GetMapping("/{userId}")
    public ResponseEntity<List<TodoDTO>> listarPorUsuario(@PathVariable long userId){
        return new ResponseEntity<List<TodoDTO>>(service.listarTodosDeUmUsuario(userId), HttpStatus.OK);
    }
    @GetMapping("/{userId}/{estado}")
    public ResponseEntity<List<TodoDTO>> listarPorUsuarioEstado(@PathVariable long userId, @PathVariable Estado estado){
        return new ResponseEntity<List<TodoDTO>>(service.listarTodosDeUmUsuarioComEstado(userId, estado), HttpStatus.OK);
    }
    @DeleteMapping("/{todoId}")
    public ResponseEntity<?> RemoverUsuario(@PathVariable long todoId){
        return null;
    }
    @PostMapping
    public ResponseEntity<TodoDTO> criar(@RequestBody TodoCreateDTO todo){
        return new ResponseEntity<TodoDTO>(service.criar(todo), HttpStatus.CREATED);
    }
    @PutMapping
    public ResponseEntity<TodoDTO> alterar (@RequestBody TodoUpdateDTO todo) throws Exception{
        return new ResponseEntity<TodoDTO>(service.alterar(todo), HttpStatus.OK);
    }
    @PatchMapping
    public  ResponseEntity<?> concluir(){return null;}


}
