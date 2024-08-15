package upchiapas.upchiapas.Service;

import upchiapas.upchiapas.models.SalonModel;

import java.util.ArrayList;

public interface SalonService {
    SalonModel crearSalon(SalonModel salonModel);
    ArrayList<SalonModel> obtenerTodosLosSalones();
    SalonModel obtenerSalonPorId(Long idSalon);
}
