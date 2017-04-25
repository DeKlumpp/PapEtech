/**
 * 
 */
package classe;

public class Usuario {
    private Integer id;
    private String usuario;
    private String senha;
    private String tipo;
    /**
     * @param id
     * @param usuario
     * @param senha
     */
    public Usuario(String usuario, String senha, String tipo) {
	this.usuario = usuario;
	this.senha = senha;
    this.tipo = tipo;
    }
    /**
     * @return the id
     */
    public Integer getId() {
	return id;
    }
    /**
     * @param id
     *            the id to set
     */
    public void setId(Integer id) {
	this.id = id;
    }
    /**
     * @return the senha
     */
    public String getSenha() {
	return senha;
    }
    /**
     * @param senha
     *            the senha to set
     */
    public void setSenha(String senha) {
	this.senha = senha;
    }
    /**
     * @return the usuario
     */
    public String getUsuario() {
	return usuario;
    }
    /**
     * @param usuario
     *            the usuario to set
     */
    public void setUsuario(String usuario) {
	this.usuario = usuario;
    }

    public String getTipo() {
        return tipo;
    }
    /**
     * @param tipo
     *            the usuario to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
}