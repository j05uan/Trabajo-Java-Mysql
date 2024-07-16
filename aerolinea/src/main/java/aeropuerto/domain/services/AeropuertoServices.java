package aeropuerto.domain.services;

import aeropuerto.domain.entity.Aeropuerto;

public interface AeropuertoServices {
    void crearAeropuerto(Aeropuerto aeropuerto);
    Aeropuerto ecnotrarAeropuerto(Long id);
    void actualizarAeropuerto (Aeropuerto aeropuerto);
    void elimnarAeropuerto (Long id);
}
