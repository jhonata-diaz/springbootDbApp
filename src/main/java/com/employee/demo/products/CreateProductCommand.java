package com.employee.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreateProductCommand implements Command<ProductoDto,Producto>{


    @Autowired
    private CategoryRepository categoryRepository;

    private final ProductRepository productRepository;

    public CreateProductCommand(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }


    @Override
    public Producto execute(ProductoDto input) {

        Producto product = new Producto();
        product.setNombre(input.getNombre());
        product.setPrecio(input.getPrecio());
        Categoria find=categoryRepository.findById(input.getCategoriaId()).orElse(null);

        product.setCategoria(find);
        Producto data=productRepository.save(product);

        return data;
    }
}
