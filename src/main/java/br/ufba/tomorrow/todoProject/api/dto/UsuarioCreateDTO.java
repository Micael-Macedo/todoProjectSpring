package br.ufba.tomorrow.todoProject.api.dto;

import br.ufba.tomorrow.todoProject.domain.entities.Usuario;

public class UsuarioCreateDTO {
    String email;
    String senha;

    public UsuarioCreateDTO(){}

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public UsuarioCreateDTO(Usuario usu){
        this.email = usu.getEmail();
        this.senha = usu.getSenha();

    }
}
