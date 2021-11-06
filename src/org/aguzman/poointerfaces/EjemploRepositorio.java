package org.aguzman.poointerfaces;

import org.aguzman.poointerfaces.modelo.Cliente;
import org.aguzman.poointerfaces.repositorio.*;
import org.aguzman.poointerfaces.repositorio.excepciones.AccesoDatosException;
import org.aguzman.poointerfaces.repositorio.excepciones.EscrituraAccesoDatosException;
import org.aguzman.poointerfaces.repositorio.excepciones.LecturaAccesoDatoException;
import org.aguzman.poointerfaces.repositorio.excepciones.RegistroDuplicadoAccesoDatosException;
import org.aguzman.poointerfaces.repositorio.lista.ClienteListRepositorio;

import java.util.List;

public class EjemploRepositorio {
    public static void main(String[] args) {
        try{
        OrdenablePaginableCrudRepositorio<Cliente> repo = new ClienteListRepositorio();
        repo.crear(new Cliente("Jano", "Pérez"));
        repo.crear(new Cliente("Bea", "González"));
        repo.crear(new Cliente("Luci", "Martínez"));
        Cliente andres = new Cliente("Andrés", "Guzmán");
        repo.crear(andres);
        repo.crear(andres);


        // repo.crear(null);
        // Deja crear porque estamos manejando la excepción

        List<Cliente> clientes = repo.listar();
        clientes.forEach(System.out::println);
        System.out.println("===== paginable =====");

        List<Cliente> paginable = ((PaginableRepositorio)repo).listar(0,3);
        paginable.forEach(System.out::println);

        System.out.println("===== ORDENAR =====");
        // Cambiar "apellido" por "nombre" o cualquier cosa que esté dentro del switch
        List<Cliente> cliendeOrdenAsc = ((OrdenableRepositorio)repo).listar("nombre", Direccion.ASC);
        for (Cliente c: cliendeOrdenAsc){
            System.out.println(c);
        }

        System.out.println("===== editar =====");
        Cliente beaActualizar = new Cliente("Bea", "Mena");
        beaActualizar.setId(2);
        repo.editar(beaActualizar);
        Cliente bea = repo.porId(2);
        System.out.println(bea);

        ((OrdenableRepositorio)repo).listar("nombre", Direccion.ASC).forEach(System.out::println);

        System.out.println("===== eliminar =====");
        //repo.eliminar(2);
        repo.listar().forEach(System.out::println);


        // Primero las clases hijas, luego clases padres
        }catch (RegistroDuplicadoAccesoDatosException e){
            System.out.println("Registro duplicado: " + e.getMessage());
            e.printStackTrace();
        }
        catch (LecturaAccesoDatoException e){
            System.out.println("Lectura: " + e.getMessage());
            e.printStackTrace();
        }catch (EscrituraAccesoDatosException e){
            System.out.println("Escritura: " + e.getMessage());
            e.printStackTrace();
        }
        catch (AccesoDatosException e){
            System.out.println("Genérica: " + e.getMessage());
            e.printStackTrace();

        }
    }
}
