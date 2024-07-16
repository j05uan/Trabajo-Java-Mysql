package aerolinea.domain.services;

import aerolinea.domain.entity.Aerolinea;
import java.util.List;

public interface AerolineaServices {

    void crearAerolinea(Aerolinea aerolinea);

    List<Aerolinea> obtenerTodasLasAerolineas();

    Aerolinea obtenerAerolineaPorId(Long id);

    void actualizarAerolinea(Aerolinea aerolinea);

    void eliminarAerolinea(Long id);
}
