package br.ufba.tomorrow.todoProject.api.dto;

import br.ufba.tomorrow.todoProject.domain.entities.Usuario;

public class UsuarioDTO {
    Long id;
    String email;

    public UsuarioDTO(){}

    public UsuarioDTO(Usuario usu){
        this.id = usu.getId();
        this.email = usu.getEmail();
    }

}
