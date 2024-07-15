package avion.Infraestructure.in;

import avion.Application.AvionUseCase;
import utils.Consola;

public class AvionControlador {
    private final AvionUseCase avionUseCase;

    public AvionControlador(AvionUseCase avionUseCase) {
        this.avionUseCase = avionUseCase;    
    }

    public void crearAvion(){
        System.out.println("----- Menu Crear Avion --------");

    }
    int opcion = Integer.parseInt(Consola.SCANNER.nextLine());
    
}
