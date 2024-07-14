package tripulacionDeVuelo.Domain;

import empleado.Domain.Empleado;
import escala.Domain.Escala;
import rolTripulante.Domain.RolTripulante;

public class TripulacionDeVuelo {
    private Long id;
    private Escala vuelo;
    private Empleado empleado;
    private RolTripulante rol;

    public TripulacionDeVuelo() {
    }

    public TripulacionDeVuelo(Empleado empleado, Long id, RolTripulante rol, Escala vuelo) {
        this.empleado = empleado;
        this.id = id;
        this.rol = rol;
        this.vuelo = vuelo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Escala getVuelo() {
        return vuelo;
    }

    public void setVuelo(Escala vuelo) {
        this.vuelo = vuelo;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public RolTripulante getRol() {
        return rol;
    }

    public void setRol(RolTripulante rol) {
        this.rol = rol;
    }  

}
