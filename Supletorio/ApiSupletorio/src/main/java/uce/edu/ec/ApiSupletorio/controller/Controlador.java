package uce.edu.ec.ApiSupletorio.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import uce.edu.ec.ApiSupletorio.model.Tarea;
import uce.edu.ec.ApiSupletorio.service.TareaService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/tareas")
public class Controlador {

    @Autowired
    private TareaService tareaService;

    @PostMapping
    public ResponseEntity<Tarea> crearTarea(@RequestBody Tarea tarea) {
        Tarea nuevaTarea = tareaService.crearTarea(tarea);
        return new ResponseEntity<>(nuevaTarea, HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Tarea>> listarTareas() {
        List<Tarea> tareas = tareaService.listarTareas();
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    }

    //endpoint
    @GetMapping("/estado/{estado}")
    public ResponseEntity<List<Tarea>> listarTareasPorEstado(@PathVariable String estado) {
        List<Tarea> tareas = tareaService.listarTareasPorEstado(estado);
        return new ResponseEntity<>(tareas, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Tarea> actualizarTarea(@PathVariable Long id, @RequestBody Tarea tarea) {
        Optional<Tarea> tareaActualizada = tareaService.actualizarTarea(id, tarea);
        return tareaActualizada.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> eliminarTarea(@PathVariable Long id) {
        tareaService.eliminarTarea(id);
        return ResponseEntity.noContent().build();
    }
}

