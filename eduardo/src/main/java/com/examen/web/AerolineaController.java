package com.examen.web;

import com.examen.modelo.Aerolinea;
import com.examen.servicio.AerolineaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/Aerolinea")
public class AerolineaController {

    private AerolineaServicio aerolineaServicio;

    @Autowired
    public AerolineaController(AerolineaServicio aerolineaServicio){
        this.aerolineaServicio = aerolineaServicio;
    }

    @GetMapping("/todos")
    public List<Aerolinea> obtenerTodo(){
        return aerolineaServicio.buscarTodo();
    }

    @GetMapping("/buscarid/{ruc}")
    public Aerolinea buscarId(@PathVariable String ruc){
        return aerolineaServicio.buscarId(ruc);
    }

    @PostMapping("/guardar/")
    public void guardar(@RequestBody Aerolinea aerolinea){
        aerolineaServicio.guardar(aerolinea);
    }

    @DeleteMapping("/eliminar/{ruc}")
    public void eliminar(@PathVariable String ruc){
        aerolineaServicio.eliminar(ruc);
    }

}
