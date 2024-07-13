package tipoEmpleado.Domain;

import java.util.Set;

public class TipoEmpleado {
    private Long id;
    private String tipo;
    private Set<Empleado> empleados;

    public TipoEmpleado() {
    }

    public TipoEmpleado(Set<Empleado> empleados, Long id, String tipo) {
        this.empleados = empleados;
        this.id = id;
        this.tipo = tipo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Set<Empleado> getEmpleados() {
        return empleados;
    }

    public void setEmpleados(Set<Empleado> empleados) {
        this.empleados = empleados;
    }



}
