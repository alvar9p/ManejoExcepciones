package org.aguzman.poointerfaces.repositorio;

import org.aguzman.poointerfaces.modelo.Cliente;
import org.aguzman.poointerfaces.repositorio.excepciones.AccesoDatosException;
import org.aguzman.poointerfaces.repositorio.excepciones.EscrituraAccesoDatosException;
import org.aguzman.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;

import java.util.List;

public interface CrudRepositorio<T> {
    List<T> listar();
    T porId(Integer id) throws AccesoDatosException;
    void crear(T cliente) throws AccesoDatosException;
    void editar(T cliente) throws AccesoDatosException;
    void eliminar(Integer id) throws AccesoDatosException;
}
