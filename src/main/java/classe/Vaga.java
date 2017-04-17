package classe;

import java.util.Date;

/**
 * Created by Andreh on 15/04/2017.
 */

public class Vaga{

    private Long idVaga;
    private String nome;
    private String desc;
    private String local;
    private Date anuncio;

    public Long getIdVaga() {
        return idVaga;
    }

    public void setIdVaga(Long idVaga) {
        this.idVaga = idVaga;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getLocal() {
        return local;
    }

    public void setLocal(String local) {
        this.local = local;
    }

    public Date getAnuncio() {
        return anuncio;
    }

    public void setAnuncio(Date anuncio) {
        this.anuncio = anuncio;
    }
}