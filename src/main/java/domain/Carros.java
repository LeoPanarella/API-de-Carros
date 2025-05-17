package domain;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Data
@Table(name = "carro")
public class Carros {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String nome;
    private String tipo;
}


