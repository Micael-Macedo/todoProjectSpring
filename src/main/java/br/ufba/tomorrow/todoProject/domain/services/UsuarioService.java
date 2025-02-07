package br.ufba.tomorrow.todoProject.domain.services;

import br.ufba.tomorrow.todoProject.api.dto.UsuarioCreateDTO;
import br.ufba.tomorrow.todoProject.api.dto.UsuarioDTO;
import br.ufba.tomorrow.todoProject.domain.entities.Usuario;
import br.ufba.tomorrow.todoProject.repository.UsuarioRepository;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UsuarioService {
    private final UsuarioRepository repo;
    private final PasswordEncoder passwordEncoder;

    public UsuarioService(UsuarioRepository repo, PasswordEncoder passwordEncoder){
        this.repo = repo;
        this.passwordEncoder = passwordEncoder;
    }
    public UsuarioDTO criar(UsuarioCreateDTO dto) throws DataIntegrityViolationException {
        Usuario usu = repo.findByEmail(dto.getEmail());
        if(usu != null) throw new DataIntegrityViolationException("Já existe um usuario cadastrado com esse email");
        Usuario novo = new Usuario(dto);
        novo.setSenha(passwordEncoder.encode(dto.getSenha()));
        return new UsuarioDTO(repo.save(novo));
    }





}
