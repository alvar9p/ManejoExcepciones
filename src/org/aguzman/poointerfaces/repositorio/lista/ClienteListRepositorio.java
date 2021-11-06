package org.aguzman.poointerfaces.repositorio.lista;

import org.aguzman.poointerfaces.modelo.Cliente;
import org.aguzman.poointerfaces.repositorio.AbstractaListRepositorio;
import org.aguzman.poointerfaces.repositorio.Direccion;
import org.aguzman.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class ClienteListRepositorio extends AbstractaListRepositorio<Cliente> {

    @Override
    public void editar(Cliente cliente) throws LecturaAccesoDatoException {
        Cliente c = this.porId(cliente.getId());
        c.setNombre(cliente.getNombre());
        c.setApellido(cliente.getApellido()); // Se pasa por el argumento que recibe
    }

    @Override
    public List<Cliente> listar(String campo, Direccion dir) {
        List<Cliente> listaOrdenada = new ArrayList<>(this.dataSource);
        listaOrdenada.sort(new Comparator<Cliente>() {
            @Override
            public int compare(Cliente a, Cliente b) {
                int resultado =  0;
                if (dir == Direccion.ASC){
                    resultado = this.ordenar(a,b);
                }else if(dir == Direccion.DESC){
                    resultado = this.ordenar(b,a);
                }
                return resultado;

            }
            private int ordenar(Cliente a, Cliente b){
                int resultado = 0;
                switch (campo){
                    case "id" ->
                            resultado = a.getId().compareTo(b.getId());
                    case "nombre" ->
                            resultado = a.getNombre().compareTo(b.getNombre());
                    case "apellido" ->
                            resultado = a.getApellido().compareTo(b.getApellido());
                }
                return resultado;
            }
        });
        return listaOrdenada;
    }

}
