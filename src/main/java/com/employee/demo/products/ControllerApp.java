package com.employee.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/apps")
public class ControllerApp {

    @Autowired
    private ServiceApp serviceApp;


    @PostMapping("/prod")
    public ResponseEntity<ProductoDto> createProduct(@RequestBody ProductoDto productoDto){

        serviceApp.createProduct(productoDto);
        return ResponseEntity.ok().body(productoDto);

    }


    @PostMapping("/cat")
    public ResponseEntity<CategoriaDto> createCategoria(@RequestBody CategoriaDto categoriaDto){
        CategoriaDto dat=serviceApp.createCategoria(categoriaDto);
        System.out.println("----------xxxxxxxxxx"+dat.getId());
        return ResponseEntity.ok().body(dat);

    }


}
