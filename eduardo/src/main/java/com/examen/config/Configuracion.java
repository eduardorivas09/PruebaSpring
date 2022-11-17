package com.examen.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Configuracion {

    @Value("${usrr}")
    String usuario;

    @Value("${paswr}")
    String clave;
    @Bean
    public DataSource getDataSource ()
    {
        DataSourceBuilder dsBuilder = DataSourceBuilder.create ();
        dsBuilder.driverClassName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dsBuilder.url ("jdbc:sqlserver://DESKTOP-0O3I3CJ;databaseName=AGENCIA;trustServerCertificate=true");
        dsBuilder.username (usuario);
        dsBuilder.password (clave);
        return (DataSource) dsBuilder.build ();
    }

}
