package com.luizamartins.life_manager.categoriagasto;

import com.luizamartins.life_manager.core.exceptions.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

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

    public List<CategoriaGasto> findAllByNomeFilter(String nome){
        return categoriaGastoRepository.findByNomeContains(nome);
    }

    @Transactional
    public CategoriaGasto create(CategoriaGasto categoriaGasto){
        return categoriaGastoRepository.save(categoriaGasto);
    }

    @Transactional
    public void delete(long id){
        if(!categoriaGastoRepository.existsById(id)){
            throw new EntityNotFoundException();
        }
        categoriaGastoRepository.deleteById(id);
    }

    @Transactional
    public CategoriaGasto update(CategoriaGasto categoriaGasto){
        if(!categoriaGastoRepository.existsById(categoriaGasto.getId())){
            throw new EntityNotFoundException();
        }
        return categoriaGastoRepository.save(categoriaGasto);
    }
}
