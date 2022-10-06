package com.leonardo;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class ValoresTest {

    Valores valores = new Valores();

    // Inserir Valores
    @Test
    public void valorNegativo() {
        assertFalse(valores.ins(-1));
    }

    @Test
    public void valorPositivo() {
        assertTrue(valores.ins(10));
    }

    // Excluir Valores
    @Test
    public void excluirIndiceValido() {
        valores.ins(10);
        assertEquals(10, valores.del(0));
    }

    @Test
    public void excluirIndiceInvalido() {
        assertEquals(-1, valores.del(2));
    }

    // Tamanho da Lista de Valores
    @Test
    public void tamanhoListaValores() {
        valores.ins(1);
        valores.ins(2);
        valores.ins(3);

        assertEquals(3, valores.size());
    }

    // Média dos Valores
    @Test
    public void mediaValores() {
        valores.ins(1); // 1/1
        assertEquals(1, valores.mean());

        valores.ins(2); // 3/2
        assertEquals(1.5, valores.mean());

        valores.ins(3); // 6/3
        assertEquals(2, valores.mean());

        valores.ins(4); // 10/4
        assertEquals(2.5, valores.mean());

        valores.ins(5); // 15/5
        assertEquals(3, valores.mean());
    }
}
