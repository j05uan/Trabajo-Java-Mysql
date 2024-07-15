package aerolinea.Application;

import aerolinea.Domain.Entity.Aerolinea;
import aerolinea.Domain.Services.AerolineaServices;

public class AerolineaUseCase {
    private final AerolineaServices aerolineaServices;

    public AerolineaUseCase(AerolineaServices aerolineaServices) {
        this.aerolineaServices = aerolineaServices;
    }
    
    public void crearAerolinea(Aerolinea aerolinea){
        aerolineaServices.CrearAerolinea(aerolinea);
    }
}
