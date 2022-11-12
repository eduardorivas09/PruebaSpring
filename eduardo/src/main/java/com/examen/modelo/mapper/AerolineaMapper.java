package com.examen.modelo.mapper;

import com.examen.modelo.Aerolinea;
import org.springframework.jdbc.core.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

public class AerolineaMapper implements RowMapper<Aerolinea> {

    public Aerolinea mapRow(ResultSet rs, int rpwNum) throws SQLException {
        Aerolinea aerolinea= new Aerolinea();
        aerolinea.setRuc(rs.getString("RUC").trim());
        aerolinea.setNombre(rs.getString("NOMBRE"));
        return aerolinea;
    }
}
