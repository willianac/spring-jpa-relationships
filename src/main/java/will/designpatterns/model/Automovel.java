package will.designpatterns.model;

import jakarta.persistence.*;

@Entity
public class Automovel {
    @Id
    @GeneratedValue
    private long id;
    private String modelo;
    private Integer ano;
    private String versao;
    private boolean novoDeFabrica;
    private Double valor;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "fabricante_id")
    private Fabricante fabricante;

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Integer getAno() {
        return ano;
    }

    public void setAno(Integer ano) {
        this.ano = ano;
    }

    public String getVersao() {
        return versao;
    }

    public void setVersao(String versao) {
        this.versao = versao;
    }

    public boolean isNovoDeFabrica() {
        return novoDeFabrica;
    }

    public void setNovoDeFabrica(boolean novoDeFabrica) {
        this.novoDeFabrica = novoDeFabrica;
    }

    public Double getValor() {
        return valor;
    }

    public void setValor(Double valor) {
        this.valor = valor;
    }

    public Fabricante getFabricante() {
        return fabricante;
    }

    public void setFabricante(Fabricante fabricante) {
        this.fabricante = fabricante;
    }
}
