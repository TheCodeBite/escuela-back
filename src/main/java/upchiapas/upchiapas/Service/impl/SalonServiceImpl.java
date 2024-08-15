package upchiapas.upchiapas.Service.impl;

import upchiapas.upchiapas.Repository.SalonRepository;
import upchiapas.upchiapas.Service.SalonService;
import upchiapas.upchiapas.exceptions.ValidationException;
import upchiapas.upchiapas.models.SalonModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import upchiapas.upchiapas.utils.ResponseConstantes;

import java.util.ArrayList;


@Service
public class SalonServiceImpl implements SalonService {
    @Autowired
    private SalonRepository salonRepository;

    @Override
    public SalonModel crearSalon(SalonModel salonModel) {
        if(salonModel == null) {
            throw new ValidationException(ResponseConstantes.MSG_NULL_SALON, ResponseConstantes.ERROR_NULL_SALON);
        }
        if(salonModel.getGrado() == null || salonModel.getGrado() == 0) {
            throw new ValidationException(ResponseConstantes.MSG_GRADO_VACIO, ResponseConstantes.ERROR_GRADO_VACIO);
        }
        if(salonModel.getGrupo() == null || salonModel.getGrupo().trim().isBlank()) {
            throw new ValidationException(ResponseConstantes.MSG_GRUPO_VACIO, ResponseConstantes.ERROR_GRUPO_VACIO);
        }

        return salonRepository.save(salonModel);
    }

    @Override
    public ArrayList<SalonModel> obtenerTodosLosSalones() {
        return (ArrayList<SalonModel>) salonRepository.findAll();
    }

    @Override
    public SalonModel obtenerSalonPorId(Long idSalon) {
        if(idSalon == null || idSalon == 0) {
            throw new ValidationException(ResponseConstantes.MSG_ID_NULL ,ResponseConstantes.ERROR_ID_NULL);
        }
        return salonRepository.findById(idSalon).get();
    }
}
