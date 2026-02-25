package com.MeetingPlanningCR.service;


import com.MeetingPlanningCR.domain.Sala;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class SalaService {

    private final Map<Long, Sala> salas = new HashMap<>();
    private Long nextId = 1L;

    private Long generarId(){
        return nextId++;
    }

    public List<Sala> getSalas(){
        return new ArrayList<>(salas.values());
    }

    public Optional<Sala> getSala(Long id){
        return Optional.ofNullable(salas.get(id));
    }

    public Sala save(Sala sala){  //voy a usar un concepto de recursion para guardar la sala.
        if (sala.getId()==null){
            sala.setId(generarId());
        }
        salas.put(sala.getId(), sala);
        return sala;
    }

    public void delete(Long id){
        if(!salas.containsKey(id)){
            throw new IllegalArgumentException("No existe la sala id: " + id);
        }
        salas.remove(id);
    }



}
