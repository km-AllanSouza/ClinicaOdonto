package com.clinicaOdontologica.ClinicaOdonto.service;

import com.clinicaOdontologica.ClinicaOdonto.model.Consulta;
import com.clinicaOdontologica.ClinicaOdonto.model.Horario;
import com.clinicaOdontologica.ClinicaOdonto.repository.ConsultaRepository;
import com.clinicaOdontologica.ClinicaOdonto.repository.DentistaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.sql.ClientInfoStatus;
import java.sql.SQLException;
import java.sql.Time;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ConsultaService {
    @Autowired
    ConsultaRepository repository;

    @Autowired
    HorarioService serviceHorario;
    ConsultaService service;

    public ResponseEntity salvar(Consulta consulta) throws SQLException {
        List<Consulta> listverificaDentistaPaciente = verificarDentistaPaciente(consulta.getIdDentista().getId(), consulta.getIdPaciente().getId());
        if (!listverificaDentistaPaciente.isEmpty()){
            List<Horario> listHorarioValido = serviceHorario.buscarHorario(consulta.getHorario());
            if (!listHorarioValido.isEmpty()){
                List<Consulta> listHorario = verificarHorario(consulta.getHorario(),consulta.getData(), consulta.getIdDentista().getId());
                if (!listHorario.isEmpty()){
                    return new ResponseEntity<>("Horario indisponivel", HttpStatus.CONFLICT);
                }
                return new ResponseEntity(repository.save(consulta), HttpStatus.OK);

            }
            return new ResponseEntity<>("O horario informado não condiz com os horarios de marcação do consultorio. Verifique se o horario esta cadastrado, para mais informações consulte o gerente",HttpStatus.OK);

        }
        return new ResponseEntity("Dentista ou paciente informado não foi encontrado, verifique se os mesmos estão cadastrados", HttpStatus.NOT_FOUND);
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
    public List<Consulta> verificarDentistaPaciente(Long idD, Long idP){
        return repository.findByIdDentistaIdAndIdPacienteId(idD, idP);
    }

}
