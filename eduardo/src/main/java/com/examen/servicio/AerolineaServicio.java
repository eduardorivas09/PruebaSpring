package com.examen.servicio;

import com.examen.modelo.Aerolinea;
import com.examen.repo.dao.AerolineaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AerolineaServicio {

    private AerolineaDao aerolineaDao;

    @Autowired
    public AerolineaServicio(AerolineaDao aerolineaDao){
        this.aerolineaDao = aerolineaDao;
    }

    public void guardar(Aerolinea aerolinea){
        aerolineaDao.guardar(aerolinea);
    }

    public List<Aerolinea> buscarTodo(){
        return aerolineaDao.buscarTodo();
    }

    public Aerolinea buscarId(String ruc){
        return aerolineaDao.buscarId(ruc);
    }

    public void eliminar(String ruc){
        aerolineaDao.eliminar(ruc);
    }
}
