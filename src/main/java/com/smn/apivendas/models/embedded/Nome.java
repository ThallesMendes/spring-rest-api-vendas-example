package com.smn.apivendas.models.embedded;

import javax.persistence.Embeddable;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Embeddable
public class Nome {

    @NotNull
    @Size(max = 60)
    private String nome;

    @NotNull
    @Size(max = 60)
    private String sobrenome;

    public Nome(){

    }

    public Nome(String nome, String sobrenome){
        this.nome = nome;
        this.sobrenome = sobrenome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }
}
