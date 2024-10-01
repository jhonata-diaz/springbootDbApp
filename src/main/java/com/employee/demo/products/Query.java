package com.employee.demo.products;

public interface Query<I, O> {
    O execute(I input);
}