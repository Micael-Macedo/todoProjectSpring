package br.ufba.tomorrow.todoProject.api.dto;

import br.ufba.tomorrow.todoProject.domain.entities.Usuario;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class UsuarioCreateDTO {
    @NotBlank(message="O email não pode ser em branco!")
    @Email(message="O email não é válido!")
    String email;
    @Size(min=5, max=20, message="A senha deve ter entre 5 e 20 caracteres")
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
