package com.luizamartins.life_manager.categoriagasto;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path = "api/categoria-gasto")
public class CategoriaGastoController {

    @Autowired
    private CategoriaGastoService categoriaGastoService;

    @GetMapping
    public ResponseEntity<List<CategoriaGasto>> getAll(){
        return ResponseEntity.ok(this.categoriaGastoService.findAll());
    }

    @GetMapping(params={"page","size"})
    public ResponseEntity<Page<CategoriaGasto>> getAllByPaginate(@RequestParam int page, @RequestParam int size){
        Pageable pageable = PageRequest.of(page,size);
        return ResponseEntity.ok(this.categoriaGastoService.findAllByPageable(pageable));
    }

    @GetMapping(params="nome")
    public ResponseEntity<List<CategoriaGasto>> getFilteredCategoriaGastoByName(@RequestParam String nome){
        return ResponseEntity.ok(this.categoriaGastoService.findAllByNomeFilter(nome));
    }

    @PostMapping
    public ResponseEntity<CategoriaGasto> createCategoriaGasto(@RequestBody CategoriaGasto categoriaGasto){
        CategoriaGasto categoriaCreated = categoriaGastoService.create(categoriaGasto);
        return ResponseEntity.ok(categoriaCreated);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") long id) {
        categoriaGastoService.delete(id);
    }

    @PutMapping
    public ResponseEntity<CategoriaGasto> updateCategoriaGasto(@RequestBody CategoriaGasto categoriaGasto){
        CategoriaGasto categoriaUpdated = categoriaGastoService.update(categoriaGasto);
        return ResponseEntity.ok(categoriaUpdated);
    }
}
