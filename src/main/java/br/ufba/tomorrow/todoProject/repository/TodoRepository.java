package br.ufba.tomorrow.todoProject.repository;

import br.ufba.tomorrow.todoProject.domain.entities.Estado;
import br.ufba.tomorrow.todoProject.domain.entities.Todo;
import br.ufba.tomorrow.todoProject.domain.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface TodoRepository extends JpaRepository<Todo, Long> {
    public Todo save(Todo t);
    public List<Todo> findByUsuario(Usuario usu);
    public List<Todo> findByUsuarioAndEstado(Usuario usu, Estado estado);
    public Todo findById(long id);
}
