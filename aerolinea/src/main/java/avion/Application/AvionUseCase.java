package avion.Application;

import avion.Domain.Entity.Avion;
import avion.Domain.Services.AvionServices;

public class AvionUseCase {
    private final AvionServices avionServices;

    public AvionUseCase(AvionServices avionServices) {
        this.avionServices = avionServices;
    }
    public void crearAvion(Avion avion){
        avionServices.CrearAvion(avion);
    }

}
