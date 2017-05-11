/**
 *
 */
package classe;

public class Usuario {
    private Long id;
    private String nome;
    private String sobrenome;
    private String cpf;
    private String cnpj;
    private String email;
    private String senha;
    private String tipo;

//    public Usuario(String nome, String sobrenome, String cpf, String cnpj, String email, String senha, String tipo) {
//    }

    /**
     * @param id
     * @param nome
     * @param sobrenome
     * @param cpf
     * @param cnpj
     * @param email
     * @param senha
     * @param tipo
     */

    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    /**
     * @return the senha
     */

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    /**
     * @param senha the senha to set
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }

    /**
     * @return the usuario
     */
    public String getUsuario() {
        return nome;
    }

    /**
     * @param nome the usuario to set
     */
    public void setUsuario(String nome) {
        this.nome = nome;
    }

    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the usuario to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}