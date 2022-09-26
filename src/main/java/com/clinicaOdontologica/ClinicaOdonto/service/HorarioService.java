package com.clinicaOdontologica.ClinicaOdonto.service;

import com.clinicaOdontologica.ClinicaOdonto.model.Horario;
import com.clinicaOdontologica.ClinicaOdonto.repository.HorarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.sql.Time;
import java.util.List;

@Service
public class HorarioService {
    @Autowired
    HorarioRepository repository;
    public Horario salvar(Horario horario){
        return repository.save(horario);

    }
    public List<Horario> buscarTodos() throws SQLException {
        List<Horario> listHorario = repository.findAll();
        return listHorario;
    }
    public List<Horario> buscarHorario(Time hora) throws  SQLException{
        List<Horario> listHoraValida = repository.findByHorarioInicio(hora);
        return listHoraValida;
    }
    public Boolean alterar(Horario horario){
        if ((repository.findById(horario.getId()).isPresent())){
            repository.save(horario);
            return true;
        }
        return false;

    }
    public Boolean excluir(Long id)  {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
            return true;
        }
        return false;
    }
}
