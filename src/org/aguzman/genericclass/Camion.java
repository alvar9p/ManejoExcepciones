package org.aguzman.genericclass;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Camion<T> implements Iterable<T>{
    // 1.- Se coloca <T> justo después del nombre de la clase para indicar que tiene un parámetro genérico
    // 5.- Iterable del tipo <T>
    private List objetos;
    // 3.- Se coloca la <T> a la lista para indicar que el tipo List va a contener elementos
    // del tipo T, ejemplo lista maquinaria, automoviles, animal, etc.
    private int max;

    public Camion(int max) {
        this.max = max;
        this.objetos = new ArrayList<>();
        // 4.- Al ArrayList solo se le coloca <>
    }

    public void add(T objeto){
        // 2.- Se cambiá el tipo Object al tipo "T" genérico
        if (this.objetos.size() <= max){
            this.objetos.add(objeto);
        }else {
            throw new RuntimeException("no hay mas espacio");
        }
    }

    @Override
    public Iterator<T> iterator() {
        // 6.- Colocar <T>en el tipo de retorno, igual que la interfaz
        return this.objetos.iterator();
    }
}
