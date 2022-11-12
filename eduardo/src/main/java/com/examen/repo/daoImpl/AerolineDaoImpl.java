package com.examen.repo.daoImpl;

import com.examen.modelo.Aerolinea;
import com.examen.modelo.mapper.AerolineaMapper;
import com.examen.repo.dao.AerolineaDao;
import com.examen.web.Configuracion;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.simple.SimpleJdbcInsert;
import org.springframework.stereotype.Repository;
import org.springframework.web.servlet.view.AbstractUrlBasedView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
public class AerolineDaoImpl implements AerolineaDao {

    JdbcTemplate jdbcTemplate;

    Configuracion configuracion = new Configuracion();

    @Autowired
    public AerolineDaoImpl(JdbcTemplate jdbcTemplate){
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void guardar(Aerolinea aerolinea) {
        SimpleJdbcInsert simpleJdbcInsert = new SimpleJdbcInsert(configuracion.getDataSource()).withTableName("AEROLINEA");
        Map<String, Object> parameters = new HashMap<>();
        parameters.put("RUC",aerolinea.getRuc());
        parameters.put("NOMBRE",aerolinea.getNombre());
        simpleJdbcInsert.execute(parameters);
    }

    @Override
    public List<Aerolinea> buscarTodo() {
        return jdbcTemplate.query("select * from AEROLINEA", new AerolineaMapper());
    }

    @Override
    public Aerolinea buscarId(String ruc) {
        return buscarTodo().stream().filter(x->x.getRuc().equals(ruc)).findFirst().orElse(null);
    }

    @Override
    public void eliminar(String ruc) {
        jdbcTemplate.update("Delete AEROLINEA WHERE RUC = ?",ruc);
    }
}
