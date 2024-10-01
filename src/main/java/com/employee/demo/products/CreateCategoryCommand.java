package com.employee.demo.products;

import org.springframework.stereotype.Component;

@Component
public class CreateCategoryCommand implements Command<CategoriaDto, Categoria> {

    private final CategoryRepository categoryRepository;
    public CreateCategoryCommand(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public Categoria execute(CategoriaDto input) {
        Categoria categoria = new Categoria();
        categoria.setNombre(input.getNombre());
        Categoria data=categoryRepository.save(categoria);

        return data;
    }
}
