package objetos;

import java.util.ArrayList;
import java.util.List;

import classe.*;

/**
 * Created by AndreM on 20/05/2017.
 */

public class UsuarioPF implements Usuario{

    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String email;
    private String senha;
    private String tipo;

    public UsuarioPF(Long id, String nome, String sobrenome, String cpf, String email, String senha, String tipo) {
        this.id = id;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.cpf = cpf;
        this.email = email;
        this.senha = senha;
        this.tipo = tipo;
    }

    List<Usuario> usuarios = new ArrayList<Usuario>();
    public void adicionar(Usuario usuario){
        usuarios.add(usuario);
    }

    @Override
    public void remover(Usuario usuario) {
        usuarios.remove(usuario);
    }

    public Usuario getUserById(int i){
        return usuarios.get(i);
    }

    @Override
    public Long getId() {
        return id;
    }

    @Override
    public String getNome() {
        return nome;
    }

    @Override
    public String sobrenome() {
        return sobrenome;
    }

    @Override
    public String getCpf() {
        return cpf;
    }

    @Override
    public String cnpj() {
        return cnpj();
    }

    @Override
    public String getEmail() {
        return email;
    }

    @Override
    public String senha() {
        return senha;
    }

    @Override
    public String getTipo() {
        return tipo;
    }
}
