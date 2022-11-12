package com.examen.repo.dao;

import com.examen.modelo.Aerolinea;

import java.util.List;

public interface AerolineaDao {

    void guardar(Aerolinea aerolinea);
    List<Aerolinea> buscarTodo();
    Aerolinea buscarId(String ruc);
    void eliminar(String ruc);

}
