package com.clinicaOdontologica.ClinicaOdonto.service;

import com.clinicaOdontologica.ClinicaOdonto.dao.impl.PacienteDAOH2;
import com.clinicaOdontologica.ClinicaOdonto.model.Endereco;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.EnderecoDTO;
import com.clinicaOdontologica.ClinicaOdonto.repository.EnderecoRepository;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    EnderecoRepository repository;
    private static final Logger logger = LogManager.getLogger(EnderecoService.class);
    public Endereco salvar(Endereco endereco)  {
        logger.info("Salvando Endereco");
        return repository.save(endereco);
    }
    public List<EnderecoDTO> buscarTodos() throws SQLException{
        logger.info("Buscando endercos Salvos");
        List<Endereco> listEndereco = repository.findAll();
        List<EnderecoDTO> listEnderecoDTO = new ArrayList<>();

        for (Endereco e : listEndereco){
            listEnderecoDTO.add(new EnderecoDTO(e));
        }
        logger.info("Retornando uma lista de enderecos");
        return listEnderecoDTO;
    }
    public Boolean alterar(Endereco endereco){

        if ((repository.findById(endereco.getId()).isPresent())){
            repository.save(endereco);
            logger.info("Endereco alterado");
            return true;
        }
        logger.info("Endereco não encontado ao alterar");
        return false;

    }
    public Boolean excluir(Long id)  {
        if (repository.findById(id).isPresent()){
            repository.deleteById(id);
            logger.info("Endereco de id "+id+" excluido com sucesso");
            return true;
        }
        logger.info("Endereco não encontado ao excluir");
        return false;
    }
    public Optional<Endereco> buscaPorId(Long id)  {

        logger.info("Endereco de id "+id+" encontrado");
        return repository.findById(id);
    }
}
