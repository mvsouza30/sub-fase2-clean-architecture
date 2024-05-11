package sub.fase2.cleanarchitecture.carsales.infrastructure.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("CARSALES")
public class SellEntity {

    @Id
    private Long id;
    private String cpf;
    private String data;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private double preco;
    private String descricao;

    public SellEntity(String cpf, String data, String marca, String modelo, String cor, int ano, double preco, String descricao){
        this.cpf = cpf;
        this.data = data;
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
        this.descricao = descricao;
    }

    public Long getId(){
        return id;
    }
    public void setId(Long id){
        this.id = id;
    }

    public String getCpf() { return  cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }

    public String getData() { return data; }
    public void  setData(String data) { this.data = data; }

    public String getMarca(){
        return marca;
    }
    public void setMarca(String marca){
        this.marca = marca;
    }

    public String getModelo(){
        return modelo;
    }
    public void setModelo(String modelo){
        this.modelo = modelo;
    }

    public String getCor(){
        return cor;
    }
    public void setCor(String cor){
        this.cor = cor;
    }

    public int getAno(){
        return ano;
    }
    public void setAno(int ano){
        this.ano = ano;
    }

    public double getPreco(){
        return preco;
    }
    public void setPreco(double preco){
        this.preco = preco;
    }

    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
}
