package modelo.Infraestructure.in;

import java.util.List;
import java.util.Scanner;

import fabricante.Domain.Entity.Fabricante;
import fabricante.Infraestructure.out.FabricanteRepository;
import modelo.Application.ModeloUseCase;
import modelo.Domain.entity.Modelo;
import utils.Consola;

public class ModeloControlador {

    private final Scanner scanner = new Scanner(System.in);
    private final ModeloUseCase modeloUseCase;

    public ModeloControlador(ModeloUseCase modeloUseCase) {
        this.modeloUseCase = modeloUseCase;
    }

    public void crearModelo() {
        System.out.println(" ---- Menu Crear Modelo ---");

        System.out.println("Ingrese el nombre del modelo: ");
        String nombre = Consola.SCANNER.nextLine();

        // Obtener la lista de fabricantes
        FabricanteRepository fabricanteRepo = new FabricanteRepository();
        List<Fabricante> fabricantes = fabricanteRepo.ObtenerTodosLosFabricantes();

        // Mostrar la lista de fabricantes y permitir al usuario seleccionar uno
        mostrarFabricantes(fabricantes);
        System.out.println("Ingrese el ID del Fabricante: ");
        Long idFabricante = Consola.SCANNER.nextLong();
        Consola.SCANNER.nextLine();  // Consumir el salto de línea después de nextLong

        // Buscar el fabricante seleccionado
        Fabricante fabricanteSeleccionado = fabricantes.stream()
                .filter(fabricante -> fabricante.getId().equals(idFabricante))
                .findFirst()
                .orElse(null);

        if (fabricanteSeleccionado != null) {
            // Crear el nuevo modelo
            Modelo nuevoModelo = new Modelo();
            nuevoModelo.setNombre(nombre);
            nuevoModelo.setFabricante(fabricanteSeleccionado);

            // Usar ModeloUseCase para crear el modelo
            modeloUseCase.crearModelo(nuevoModelo);
            System.out.println("Modelo creado con éxito.");
        } else {
            System.out.println("Fabricante no encontrado. Verifique el ID y vuelva a intentarlo.");
        }
    }

    private void mostrarFabricantes(List<Fabricante> fabricantes) {
        System.out.println("Fabricantes disponibles:");
        for (Fabricante fabricante : fabricantes) {
            System.out.printf("ID: %d, Nombre: %s%n", fabricante.getId(), fabricante.getNombre());
        }
    }
}