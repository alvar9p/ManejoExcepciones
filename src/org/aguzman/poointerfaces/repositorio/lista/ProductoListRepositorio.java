package org.aguzman.poointerfaces.repositorio.lista;

import org.aguzman.poointerfaces.modelo.Producto;
import org.aguzman.poointerfaces.repositorio.AbstractaListRepositorio;
import org.aguzman.poointerfaces.repositorio.Direccion;
import org.aguzman.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.List;

public class ProductoListRepositorio extends AbstractaListRepositorio<Producto> {

    @Override
    public void editar(Producto producto) throws LecturaAccesoDatoException {
        Producto p = porId(producto.getId());
        p.setDescripcion(producto.getDescripcion());
        p.setPrecio(producto.getPrecio());
    }

    @Override
    public List<Producto> listar(String campo, Direccion dir) {
        return null;
    }
}
