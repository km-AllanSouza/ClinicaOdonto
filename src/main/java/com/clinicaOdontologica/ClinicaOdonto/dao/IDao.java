package com.clinicaOdontologica.ClinicaOdonto.dao;

import java.sql.SQLException;
import java.util.List;

public interface IDao <T>{

    T salvar(T t) throws SQLException;

    List<T> buscarTodos() throws SQLException;

    void alterar(T t) throws SQLException;

    void excluir(int id) throws SQLException;
}
