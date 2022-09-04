package com.clinicaOdontologica.ClinicaOdonto.service;

import com.clinicaOdontologica.ClinicaOdonto.dao.IDao;
import com.clinicaOdontologica.ClinicaOdonto.model.Endereco;
import com.clinicaOdontologica.ClinicaOdonto.model.Paciente;
import com.clinicaOdontologica.ClinicaOdonto.model.dto.EnderecoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class EnderecoService {
    @Autowired
    IDao<Endereco> enderecoDaoH2;

    public Endereco salvar(Endereco endereco) throws SQLException {
        return enderecoDaoH2.salvar(endereco);
    }
    public List<EnderecoDTO> buscarTodos() throws SQLException{
        List<Endereco> listEndereco = enderecoDaoH2.buscarTodos();
        List<EnderecoDTO> listEnderecoDTO = new ArrayList<>();

        for (Endereco e : listEndereco){
            listEnderecoDTO.add(new EnderecoDTO(e));
        }
        return listEnderecoDTO;
    }
    public void alterar(Endereco endereco) throws SQLException{
        enderecoDaoH2.alterar(endereco);
    }
    public void excluir(int id) throws SQLException {
        enderecoDaoH2.excluir(id);
    }
    public Optional<Endereco> buscaPorId(int id) throws SQLException {
        return enderecoDaoH2.buscarPorId(id);
    }
}
