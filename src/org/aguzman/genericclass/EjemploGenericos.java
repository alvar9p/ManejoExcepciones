package org.aguzman.genericclass;

public class EjemploGenericos {
    public static <T> void imprimirCamion(Camion<T> camion){
        for (T a: camion){
            if (a instanceof Animal){
                System.out.println(((Animal)a).getNombre() + " tipo "
                        + ((Animal)a).getTipo());
            }else if (a instanceof Automovil){
                System.out.println(((Automovil)a).getMarca());
            }else if (a instanceof Maquinaria){
                System.out.println(((Maquinaria)a).getTipo());
            }
        }
    }
    public static void main(String[] args) {

        Camion<Animal> transporteCaballos = new Camion<>(5);
        // 1.- Se coloca el tipo de dato que va a contener, <Animal>
        // 2.- Se le coloca el operador diamante a Camion<>(5)
        transporteCaballos.add(new Animal("Peregrino", "Caballo"));
        transporteCaballos.add(new Animal("Grillo", "Caballo"));
        transporteCaballos.add(new Animal("Tunquén", "Caballo"));
        transporteCaballos.add(new Animal("Topocalma", "Caballo"));
        transporteCaballos.add(new Animal("Longotoma", "Caballo"));

        /*for (Animal a: transporteCaballos){
            // Animal a = (Animal) o; // Cast de Object o
            // Se quita la línea anterior y se reemplaza Object o: transporteCaballos por Animal a
            System.out.println(a.getNombre() + " tipo: " + a.getTipo());
        }*/

        imprimirCamion(transporteCaballos);

        Camion<Maquinaria> transMaquinas = new Camion<>(3);
        transMaquinas.add(new Maquinaria("Bulldozer"));
        transMaquinas.add(new Maquinaria("Grúa Horquilla"));
        transMaquinas.add(new Maquinaria("Perforadora"));

        /*for (Maquinaria m: transMaquinas){
            // Maquinaria m = (Maquinaria) o;
            System.out.println(m.getTipo());
        }*/

        imprimirCamion(transMaquinas);

        Camion<Automovil> transAuto = new Camion<>(3);
        transAuto.add(new Automovil("Toyota"));
        transAuto.add(new Automovil("Mitsubishi"));
        transAuto.add(new Automovil("Chevrolet"));

        /*for (Automovil a: transAuto){
            // Automovil a = (Automovil) o;
            System.out.println(a.getMarca());
        }*/

        imprimirCamion(transAuto);
    }
}
