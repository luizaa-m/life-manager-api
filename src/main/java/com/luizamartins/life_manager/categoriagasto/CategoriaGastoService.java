package com.luizamartins.life_manager.categoriagasto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaGastoService {
    private final CategoriaGastoRepository categoriaGastoRepository;

    @Autowired
    protected CategoriaGastoService(CategoriaGastoRepository categoriaGastoRepository){
        this.categoriaGastoRepository=categoriaGastoRepository;
    }

    public List<CategoriaGasto> findAll(){
        return categoriaGastoRepository.findAll();
    }

    public Page<CategoriaGasto> findAllByPageable(Pageable pageable){
        return categoriaGastoRepository.findAll(pageable);
    }

    @Transactional
    public CategoriaGasto create(CategoriaGasto categoriaGasto){
        return categoriaGastoRepository.save(categoriaGasto);
    }

    @Transactional
    public void delete(long id){
        categoriaGastoRepository.deleteById(id);
    }

    @Transactional
    public CategoriaGasto update(CategoriaGasto categoriaGasto){
        if(!categoriaGastoRepository.existsById(categoriaGasto.getId())){
            throw new RuntimeException();
        }
        return categoriaGastoRepository.save(categoriaGasto);
    }
}
