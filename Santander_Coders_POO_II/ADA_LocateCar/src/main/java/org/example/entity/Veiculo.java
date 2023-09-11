package org.example.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "veiculos")
@Data
@NoArgsConstructor
public class Veiculo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private int id;
    @Column(name = "PLACA", unique = true)
    private String placa;
    @Column(name = "MODELO")
    private String modelo;
    @Column(name = "CATEGORIA")
    private CategoriaVeiculo categoriaVeiculo;
    @Column(name = "DATA_OCUPADA")
    private List<LocalDate> datasOcupadas = new ArrayList<>();
    @OneToMany
    private List<Aluguel> alugueis;

    public Veiculo(String placa, String modelo, CategoriaVeiculo categoriaVeiculo) {
        this.placa = placa;
        this.modelo = modelo;
        this.categoriaVeiculo = categoriaVeiculo;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("ID: ").append(id).append("\n");
        stringBuilder.append("Placa: ").append(placa).append("\n");
        stringBuilder.append("Modelo: ").append(modelo).append("\n");
        stringBuilder.append("Categoria do veículo: ").append(categoriaVeiculo).append("\n");

        stringBuilder.append("Datas Ocupadas:\n");
        for (LocalDate data : datasOcupadas) {
            stringBuilder.append("- ").append(data).append("\n");
        }

        stringBuilder.append("Alugueis:\n");
        for (Aluguel aluguel : alugueis) {
            stringBuilder.append("- ").append(aluguel).append("\n");
        }

        return stringBuilder.toString();
    }
}
