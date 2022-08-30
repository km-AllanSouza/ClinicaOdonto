package com.clinicaOdontologica.ClinicaOdonto.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao <T>{

    T salvar(T t) throws SQLException;

    List<T> buscar() throws SQLException;

    void alterar(T t) throws SQLException;

    void excluir(int id) throws SQLException;
}
