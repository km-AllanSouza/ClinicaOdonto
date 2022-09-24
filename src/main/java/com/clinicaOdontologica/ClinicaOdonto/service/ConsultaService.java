package com.clinicaOdontologica.ClinicaOdonto.service;

import com.clinicaOdontologica.ClinicaOdonto.model.Consulta;
import com.clinicaOdontologica.ClinicaOdonto.model.Dentista;
import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.PacienteDTO;
import com.clinicaOdontologica.ClinicaOdonto.repository.ConsultaRepository;
import com.clinicaOdontologica.ClinicaOdonto.repository.DentistaRepository;
import com.clinicaOdontologica.ClinicaOdonto.repository.PacienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    ConsultaRepository repository;
    @Autowired
    DentistaRepository dentistaService;

    public Consulta salvar(Consulta consulta) {
        Long dentistaId = consulta.getIdDentista().getId();
        Optional<Dentista> dentista = dentistaService.findById(dentistaId);
        System.out.println("o nome do dentista é: " + dentista.get().getNome());

    public Consulta salvar(Consulta consulta) throws SQLException {
        System.out.println(buscarTodos());

        return repository.save(consulta);
    }

    public List<Consulta> buscarTodos(){
        List<Consulta> consultaList = repository.findAll();

        return consultaList;
    }

    public void alterar(Consulta consulta){
        repository.save(consulta);
    }

    public void excluir(Long id){
        repository.deleteById(id);
    }

    public Optional<Consulta> buscarPorId(Long id){
        return repository.findById(id);
    }
    public List<Consulta> verificarHorario(Time hora, Date data, Long idD){
       return repository.findByHorarioAndDataAndIdDentistaId(hora, data, idD);


    }

}
