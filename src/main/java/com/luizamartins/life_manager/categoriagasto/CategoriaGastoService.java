package com.luizamartins.life_manager.categoriagasto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaGastoService {
    private final CategoriaGastoRepository categoriaGastoRepository;

    @Autowired
    private CategoriaGastoService(CategoriaGastoRepository categoriaGastoRepository){
        this.categoriaGastoRepository=categoriaGastoRepository;
    }

    public List<CategoriaGasto> findAll(){
        return categoriaGastoRepository.findAll();
    }
}
