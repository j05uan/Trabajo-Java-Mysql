package aerolinea.Infraestructure.in;

import java.util.Scanner;

import aerolinea.Application.AerolineaUseCase;
import aerolinea.Domain.Entity.Aerolinea;
import utils.Consola;

public class AerolineaControlador {

    Scanner scanner = new Scanner(System.in);

    private final AerolineaUseCase aerolineaUseCase;

    public AerolineaControlador(AerolineaUseCase aerolineaUseCase) {
        this.aerolineaUseCase = aerolineaUseCase;
    }

    // Agregar metodos que necesito para la gestion de la entidad
    public void crearAerolinea(){

        System.out.println("---- Menu Crear Aerolinea ----");

        System.out.println("Ingrese el nombre de la Aerolinea: ");
        String nombre = Consola.SCANNER.nextLine();

        Aerolinea aerolinea = new Aerolinea();
        aerolinea.setNombre(nombre);

    }

}
