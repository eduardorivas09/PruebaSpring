package com.examen.web;

import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class Configuracion {

    @Bean
    public DataSource getDataSource ()
    {
        DataSourceBuilder dsBuilder = DataSourceBuilder.create ();
        dsBuilder.driverClassName ("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        dsBuilder.url ("jdbc:sqlserver://DESKTOP-0O3I3CJ;databaseName=AGENCIA;trustServerCertificate=true");
        dsBuilder.username ("sa");
        dsBuilder.password ("sqlserver");
        return (DataSource) dsBuilder.build ();
    }

}
