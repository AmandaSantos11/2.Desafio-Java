package org.example;

import java.util.Scanner;
public class Cadastro {
    protected String nome,cpf,email,senha;
    public Scanner digite;
    public Cadastro(String nome, String cpf, String email,String senha){
        this.nome=nome;
        this.cpf=cpf;
        this.email=email;
        this.senha=senha;
    }
    public Cadastro(){
        this.digite=new Scanner(System.in);
    }
    public String getNome() {
        return nome;
    }
    public String getCpf() {
        return cpf;
    }
    public String getEmail() {
        return email;
    }
    public String getSenha() {
        return senha;
    }
    public void cadastrarNoSistema(){}
    public void login(){}
}