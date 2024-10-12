package com.luizamartins.life_manager.categoriagasto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Entity
@Data
@Table(name = "CATEGORIA_GASTO")
@SequenceGenerator(name="categoria_gasto_seq", allocationSize = 1)
public class CategoriaGasto {
    @Id
    @GeneratedValue(strategy= GenerationType.SEQUENCE, generator = "categoria_gasto_seq")
    @Column(name="ID_CATEGORIA_GASTO")
    private long id;

    @NotBlank
    @Size(max=20)
    @Column(name="NOME")
    private String nome;
}
