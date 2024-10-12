package com.luizamartins.life_manager.categoriagasto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(path = "api/categoria-gasto")
public class CategoriaGastoController {

    @Autowired
    private CategoriaGastoService categoriaGastoService;

    @GetMapping
    public List<CategoriaGasto> getAllCategoriaGasto(){
        return this.categoriaGastoService.findAll();
    }
}
