package org.example.entity;

import lombok.*;
import javax.persistence.Column;
import javax.persistence.*;
import java.time.LocalDate;
import java.math.BigDecimal;
import java.time.LocalTime;

@Entity
@Table(name = "alugueis")
@Data
@NoArgsConstructor
public class Aluguel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID", unique = true)
    private int id;
    @Column(name = "LOCAL_ENTREGA")
    private String localEntrega;
    @Column(name = "LOCAL_DEVOLUCAO")
    private String localDevolucao;
    @Column(name = "DATA_PEDIDO")
    private LocalDate dataPedido;
    @Column(name = "DATA_ENTREGA")
    private LocalDate dataEntrega;
    @Column(name = "DATA_DEVOLUCAO")
    private LocalDate dataDevolucao;
    @Column(name = "HORARIO_ENTREGA")
    private LocalTime horarioEntrega;
    @Column(name = "HORARIO_DEVOLUCAO")
    private LocalTime horarioDevolucao;
    @Column(name = "VALOR_TOTAL")
    private BigDecimal valorTotal;
    @ManyToOne
    @JoinColumn(name = "VEICULO_ID")
    private Veiculo veiculo;
    @ManyToOne
    @JoinColumn(name = "PESSOA_ID")
    private Pessoa pessoa;

    public Aluguel(String localEntrega, String localDevolucao, LocalDate dataPedido, LocalDate dataEntrega, LocalDate dataDevolucao, LocalTime horarioEntrega, LocalTime horarioDevolucao, BigDecimal valorTotal, Veiculo veiculo, Pessoa pessoa) {
        this.localEntrega = localEntrega;
        this.localDevolucao = localDevolucao;
        this.dataPedido = dataPedido;
        this.dataEntrega = dataEntrega;
        this.dataDevolucao = dataDevolucao;
        this.horarioEntrega = horarioEntrega;
        this.horarioDevolucao = horarioDevolucao;
        this.valorTotal = valorTotal;
        this.veiculo = veiculo;
        this.pessoa = pessoa;
    }
}
