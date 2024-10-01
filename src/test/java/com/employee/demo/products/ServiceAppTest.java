package com.employee.demo.products;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class ServiceAppTest {

    @Mock
    private CreateProductCommand createProductCommand;

    @Mock
    private CreateCategoryCommand createCategoryCommand;

    @InjectMocks
    private ServiceApp serviceApp;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this); // Inicializa los mocks
    }

    @Test
    void createProductTest() {
        // Datos de entrada simulados
        ProductoDto inputDto = new ProductoDto();
        inputDto.setNombre("Producto A");
        inputDto.setPrecio(100.0);
        inputDto.setCategoriaId(1L);

        // Objeto Producto devuelto simulado
        Producto producto = new Producto();
        producto.setId(1L);
        producto.setNombre("Producto A");
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        producto.setCategoria(categoria);

        // Simular el comportamiento del comando
        when(createProductCommand.execute(inputDto)).thenReturn(producto);

        // Ejecutar el método a probar
        ProductoDto resultDto = serviceApp.createProduct(inputDto);

        // Verificar el resultado
        assertNotNull(resultDto);
        assertEquals(1L, resultDto.getId());
        assertEquals("Producto A", resultDto.getNombre());
        assertEquals(100.0, resultDto.getPrecio());
        assertEquals(1L, resultDto.getCategoriaId());

        // Verificar que el método execute fue llamado una vez
        verify(createProductCommand, times(1)).execute(inputDto);
    }

    @Test
    void createCategoriaTest() {
        // Datos de entrada simulados
        CategoriaDto inputDto = new CategoriaDto();
        inputDto.setNombre("Categoria A");

        // Objeto Categoria devuelto simulado
        Categoria categoria = new Categoria();
        categoria.setId(1L);
        categoria.setNombre("Categoria A");

        // Simular el comportamiento del comando
        when(createCategoryCommand.execute(inputDto)).thenReturn(categoria);

        // Ejecutar el método a probar
        CategoriaDto resultDto = serviceApp.createCategoria(inputDto);

        // Verificar el resultado
        assertNotNull(resultDto);
        assertEquals(1L, resultDto.getId());
        assertEquals("Categoria A", resultDto.getNombre());

        // Verificar que el método execute fue llamado una vez
        verify(createCategoryCommand, times(1)).execute(inputDto);
    }
}
