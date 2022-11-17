package com.examen.web;

import com.examen.modelo.Aerolinea;
import com.examen.servicio.AerolineaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<List<Aerolinea>> obtenerTodo(){
        return new ResponseEntity<>(aerolineaServicio.buscarTodo(), HttpStatus.OK);
    }

    @GetMapping("/buscarid/{ruc}")
    public Aerolinea buscarId(@PathVariable String ruc){
        return aerolineaServicio.buscarId(ruc);
    }

    @PostMapping("/guardar/")
    public ResponseEntity guardar(@RequestBody Aerolinea aerolinea){
        aerolineaServicio.guardar(aerolinea);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @DeleteMapping("/eliminar/{ruc}")
    public ResponseEntity eliminar(@PathVariable String ruc){
        aerolineaServicio.eliminar(ruc);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
