package com.luizamartins.life_manager.categoriagasto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CategoriaGastoDTO {
    private long id;

    @NotBlank
    @Size(max=20)
    public String nome;
}
