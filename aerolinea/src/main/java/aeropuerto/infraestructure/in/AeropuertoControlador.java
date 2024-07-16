package aeropuerto.infraestructure.in;

import java.util.Scanner;

import aeropuerto.application.AeropueroUseCase;

public class AeropuertoControlador {

    Scanner scanner = new Scanner(System.in);
    private final AeropueroUseCase aeropueroUseCase;
    public AeropuertoControlador(Scanner scanner, AeropueroUseCase aeropueroUseCase) {
        this.scanner = scanner;
        this.aeropueroUseCase = aeropueroUseCase;
    }

    

}
