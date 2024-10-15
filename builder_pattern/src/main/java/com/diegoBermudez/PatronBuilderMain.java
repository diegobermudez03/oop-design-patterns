package com.diegoBermudez;


import com.diegoBermudez.transferencia.datos.Estudiante;

public class PatronBuilderMain {
    public static void main(String[] args) {
        Estudiante est = new Estudiante.EstudianteBuilder()
                .setNombre("Gilberto Santarrosa")
                .setGenero("Masculino")
                .setEdad(49)
                .setDireccion("Santurce "
                        + "San Juan", "Puerto Rico", "Puerto Rico", "03400")
                .addContactos("Fania All Star", "555777888", "123", "Estudios",
                        "New York", "Estados Unidos"
                        , "USA", "10023")
                .addContactos("Ruben Blades", "202020", null, "Celular")
                .addTelefonos("88889999", null, "Celular")
                .addTelefonos("1010103030", null, "Estudios")
                .addPrograma("Ingenieria de sistemas", 8)
                .build();
        System.out.println(est);
    }
}
