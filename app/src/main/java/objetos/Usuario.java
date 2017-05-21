package objetos;

/**
 * Created by AndreM on 20/05/2017.
 */

public interface Usuario {

    public void adicionar(Usuario usuario);
    public void remover(Usuario usuario);
    public Usuario getUserById(int i);

    public Long getId();
    public String getNome();
    public String sobrenome();
    public String getCpf();
    public String cnpj();
    public String getEmail();
    public String senha();
    public String getTipo();
}
