package uce.edu.ec.ApiSupletorio.service;

import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import uce.edu.ec.ApiSupletorio.model.Tarea;
import uce.edu.ec.ApiSupletorio.repository.TareaRepository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class TareaService {

    @Autowired
    private TareaRepository tareaRepository;

    public Tarea crearTarea(Tarea tarea) {
        tarea.setFechaCreacion(LocalDateTime.parse(LocalDateTime.now().toString()));
        return tareaRepository.save(tarea);
    }

    public Optional<Tarea> actualizarTarea(Long id, Tarea tareaActualizada) {
        return tareaRepository.findById(id).map(tarea -> {
            tarea.setTitulo(tareaActualizada.getTitulo());
            tarea.setDescripcion(tareaActualizada.getDescripcion());
            tarea.setEstado(tareaActualizada.getEstado());
            return tareaRepository.save(tarea);
        });
    }



    public List<Tarea> listarTareas() {
        return tareaRepository.findAll();
    }

    public List<Tarea> listarTareasPorEstado(String estado) {
        return tareaRepository.findByEstado(estado);
    }

    public void eliminarTarea(Long id) {
        if (tareaRepository.existsById(id)) {
            tareaRepository.deleteById(id);
        } else {
            throw new EntityNotFoundException("Tarea no encontrada con ID: " + id);
        }
    }
}

