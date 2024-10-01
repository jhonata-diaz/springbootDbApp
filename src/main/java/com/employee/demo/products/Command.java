package com.employee.demo.products;

public interface Command<I, O> {
    O execute(I input);
}
