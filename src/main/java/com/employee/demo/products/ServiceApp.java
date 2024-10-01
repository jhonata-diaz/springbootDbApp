package com.employee.demo.products;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ServiceApp {



    private CreateProductCommand createProductCommand;
    private CreateCategoryCommand createCategoryCommand;

    public ServiceApp(CreateProductCommand createProductCommand, CreateCategoryCommand createCategoryCommand) {
        this.createProductCommand = createProductCommand;
        this.createCategoryCommand = createCategoryCommand;
    }

    public ProductoDto createProduct(ProductoDto productoDto) {

        Producto data=createProductCommand.execute(productoDto);
        ProductoDto dto=new ProductoDto();
        dto.setId(data.getId());
        dto.setNombre(data.getNombre());
        dto.setPrecio(productoDto.getPrecio());
        dto.setCategoriaId(data.getCategoria().getId());

        return dto;

    }

    public CategoriaDto createCategoria(CategoriaDto categoriaDto) {
        Categoria data=createCategoryCommand.execute(categoriaDto);

        CategoriaDto returncat=new CategoriaDto();
        returncat.setId(data.getId());
        returncat.setNombre(data.getNombre());

        return returncat;

    }

}
