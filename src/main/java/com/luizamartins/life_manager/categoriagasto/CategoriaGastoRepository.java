package com.luizamartins.life_manager.categoriagasto;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoriaGastoRepository extends JpaRepository<CategoriaGasto,Long> {
    List<CategoriaGasto> findByNomeContains(String nome);
}
