package Aeropuerto.Domain;

import Ciudad.Domain.Ciudad;

public class Aeropuerto {
    private Long id;
    private String nombre;

    private Ciudad ciudad;

    private Set<Escala> escalas;

    private Set<SalidaAeropuerto> salidas;

}
