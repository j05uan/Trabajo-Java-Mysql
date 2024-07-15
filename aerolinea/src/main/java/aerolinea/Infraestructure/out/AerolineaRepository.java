package aerolinea.Infraestructure.out;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import aerolinea.Domain.Entity.Aerolinea;
import aerolinea.Domain.Services.AerolineaServices;
import resource.ConfiguracionBaseDeDatos;

public class AerolineaRepository implements AerolineaServices {

    String sql =" INSERT INTO aereolineas(nombre) VALUES(?)";

    @Override
    public void CrearAerolinea(Aerolinea aerolinea) {
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
    
}
