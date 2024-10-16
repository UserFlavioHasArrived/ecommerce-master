package br.com.senai.ecommerce.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "pedidos")
public class Pedido {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int andares;
    private String cor1;
    private String cor2;
    private String cor3;
    private String desenho1;
    private String desenho2;
    private String desenho3;

    public Object getAndares() {
        return andares;
    }

    public Object getCor1() {
        return cor1;
    }

    public Object getCor2() {
        return cor2;
    }

    public Object getCor3() {
        return cor3;
    }

    public Object getDesenho1() {
        return desenho1;
    }

    public Object getDesenho2() {
        return desenho2;
    }

    public Object getDesenho3() {
        return desenho3;
    }

    public void setAndares(Object andares) {
    }

    public void setCor1(Object cor1) {
    }

    public void setCor2(Object cor2) {
    }

    public void setCor3(Object cor3) {
    }

    public void setDesenho1(Object desenho1) {
    }

    public void setDesenho2(Object desenho2) {
    }

    public void setDesenho3(Object desenho3) {
    }

    // Getters e Setters
}
