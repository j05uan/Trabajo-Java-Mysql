package aerolinea.infraestructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import aerolinea.domain.entity.Aerolinea;
import aerolinea.domain.services.AerolineaServices;
import resource.ConfiguracionBaseDeDatos;

public class AerolineaRepository implements AerolineaServices {

    
    Scanner scanner = new Scanner(System.in);
    @Override
    public void crearAerolinea (Aerolinea aerolinea) {
        String sql =" INSERT INTO aereolineas(nombre) VALUES(?)";
        try (Connection connection = ConfiguracionBaseDeDatos.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            statement.setString(1, aerolinea.getNombre());
            
            try (ResultSet generatedKeys = statement.getGeneratedKeys() ){
                if (generatedKeys.next()) {
                    aerolinea.setId(generatedKeys.getLong(1));
                }

            } 

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    
    public List<Aerolinea> obtenerTodasLasAerolineas() {
        String sql = "SELECT * FROM aerolineas";
        List<Aerolinea> aerolineas = new ArrayList<>();

        try (Connection connection = ConfiguracionBaseDeDatos.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql);
            ResultSet resultSet = statement.executeQuery()) {

            while (resultSet.next()) {
                Aerolinea aerolinea = new Aerolinea();
                aerolinea.setId(resultSet.getLong("id"));
                aerolinea.setNombre(resultSet.getString("nombre"));  // Ajustar según el esquema de tu base de datos
                aerolineas.add(aerolinea);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aerolineas;
    }

    public Aerolinea obtenerAerolineaPorId(Long id) {
        String sql = "SELECT * FROM aerolineas WHERE id = ?";
        Aerolinea aerolinea = null;

        try (Connection connection = ConfiguracionBaseDeDatos.getConnection();
            PreparedStatement statement = connection.prepareStatement(sql)) {

            statement.setLong(1, id);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    aerolinea = new Aerolinea();
                    aerolinea.setId(resultSet.getLong("id"));
                    aerolinea.setNombre(resultSet.getString("nombre"));  // Ajustar según el esquema de tu base de datos
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return aerolinea;
    }


    public void actualizarAerolinea() {
        System.out.println("---- Actualizar Aerolínea ----");
    
        
        listarAerolineas();
    
        System.out.println("Ingrese el ID de la Aerolínea que desea actualizar: ");
        Long id = Long.parseLong(scanner.nextLine());
    
        Aerolinea aerolineaExistente = aerolineaUseCase.obtenerAerolineaPorId(id);
    
        if (aerolineaExistente != null) {
            System.out.println("Ingrese el nuevo nombre de la Aerolínea: ");
            String nuevoNombre = scanner.nextLine();
    
            aerolineaExistente.setNombre(nuevoNombre);
    
            aerolineaUseCase.actualizarAerolinea(aerolineaExistente);
    
            System.out.println("Aerolínea actualizada con éxito.");
        } else {
            System.out.println("No se encontró ninguna aerolínea con el ID proporcionado.");
        }
    }
    


    public void eliminarAerolinea() {
        System.out.println("---- Eliminar Aerolínea ----");
    
        // Listar todas las aerolíneas
        listarAerolineas();
    
        System.out.println("Ingrese el ID de la Aerolínea que desea eliminar: ");
        Long id = Long.parseLong(scanner.nextLine());
    
        Aerolinea aerolineaExistente = aerolineaUseCase.obtenerAerolineaPorId(id);
    
        if (aerolineaExistente != null) {
            aerolineaUseCase.eliminarAerolinea(id);
            System.out.println("Aerolínea eliminada con éxito.");
        } else {
            System.out.println("No se encontró ninguna aerolínea con el ID proporcionado.");
        }
    }

    public List<Aerolinea> listarAerolineas() {
        List<Aerolinea> aerolineas = new ArrayList<>();
        String sql = "SELECT * FROM aerolineas";  // Consulta para seleccionar todas las aerolíneas

        try (
            Connection conn = getConnection();
            PreparedStatement stmt = conn.prepareStatement(sql);
            ResultSet rs = stmt.executeQuery();
        ) {
            // Procesa los resultados
            while (rs.next()) {
                Aerolinea aerolinea = new Aerolinea();
                aerolinea.setId(rs.getLong("id"));
                aerolinea.setNombre(rs.getString("nombre"));
                

                aerolineas.add(aerolinea);
            }
        } catch (SQLException e) {
            e.printStackTrace();
            
        }

        return aerolineas;
    }

   
    
}
