package com.clinicaOdontologica.ClinicaOdonto.service;

import com.clinicaOdontologica.ClinicaOdonto.dao.IDao;
import com.clinicaOdontologica.ClinicaOdonto.model.Endereco;
import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.EnderecoDTO;
import com.clinicaOdontologica.ClinicaOdonto.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    //IDao<Endereco> enderecoDaoH2;
    EnderecoRepository repository;
    public Endereco salvar(Endereco endereco)  {
        return repository.save(endereco);
    }
    public List<EnderecoDTO> buscarTodos() throws SQLException{
        List<Endereco> listEndereco = repository.findAll();
        List<EnderecoDTO> listEnderecoDTO = new ArrayList<>();

        for (Endereco e : listEndereco){
            listEnderecoDTO.add(new EnderecoDTO(e));
        }
        return listEnderecoDTO;
    }
    public void alterar(Endereco endereco){
        repository.save(endereco);
    }
    public void excluir(Long id)  {
        repository.deleteById(id);
    }
    public Optional<Endereco> buscaPorId(Long id)  {
        return repository.findById(id);
    }
}
