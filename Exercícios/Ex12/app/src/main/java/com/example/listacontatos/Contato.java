package com.example.listacontatos;

public class Contato {

    private String nome;
    private String telefone;
    private boolean fixo;

    public Contato (String nome, String telefone, boolean fixo) {
        this.nome = nome;
        this.telefone = telefone;
        this.fixo = fixo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public boolean isFixo() {
        return fixo;
    }

    public void setFixo(boolean fixo) {
        this.fixo = fixo;
    }

    public String toString() {

        String str = this.nome + " \n " + this.telefone;

        if(fixo)
            str += " *";

        return str;
    }
}
