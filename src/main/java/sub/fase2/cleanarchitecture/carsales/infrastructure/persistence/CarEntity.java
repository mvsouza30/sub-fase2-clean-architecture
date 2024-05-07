package sub.fase2.cleanarchitecture.carsales.infrastructure.persistence;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;

@Table("CARS")
public class CarEntity {

    @Id
    private Long id;
    private String marca;
    private String modelo;
    private String cor;
    private int ano;
    private double preco;

    public CarEntity(String marca, String modelo, String cor, int ano, double preco){
        this.marca = marca;
        this.modelo = modelo;
        this.cor = cor;
        this.ano = ano;
        this.preco = preco;
    }

    public Long getId(){
        return id;
    }

    public void setId(Long id){
        this.id = id;
    }

    public String getMarca(){
        return marca;
    }

    public void setMarca(){
        this.marca = marca;
    }

    public String getModelo(){
        return modelo;
    }

    public void setModelo(){
        this.modelo = modelo;
    }

    public String getCor(){
        return cor;
    }

    public void setCor(){
        this.cor = cor;
    }

    public int getAno(){
        return ano;
    }

    public void setAno(){
        this.ano = ano;
    }

    public double getPreco(){
        return preco;
    }

    public void setPreco(){
        this.preco = preco;
    }


}
