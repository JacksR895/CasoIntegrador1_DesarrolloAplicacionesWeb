package com.MeetingPlanningCR.service;

import com.MeetingPlanningCR.domain.Reunion;
import com.MeetingPlanningCR.domain.Sala;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class ReunionService {

    private final Map<Long, Reunion> reuniones = new HashMap<>(); //Lo bueno de hashmaps es poder guardar varios entidades en una combinacion, por eso lo uso para almacenar.
    private Long nextId = 1L;

    private final SalaService salaService; //Tengo que salvar las funciones de guardar varias reuniones en una sala. Por eso de una guardo la variable.

    public ReunionService(SalaService salaService) {
        this.salaService = salaService;
    }

    private Long generarId(){
        return nextId++;
    }

    public List<Reunion> getReuniones(){ //mismo que cree en SalaService
        return new ArrayList<>(reuniones.values());
    }

    public Optional<Reunion> getReunion(Long id){ //mismo que cree en salaservice
        return Optional.ofNullable(reuniones.get(id));
    }

    public Reunion save(Reunion reunion ){
        if(salaService.getSala(reunion.getSalaId()).isPresent()){  //tengo que comprobar primero si la sala existe o esta asignada para salvar la reunion.
            if (reunion.getId()==null){
                reunion.setId(generarId());
            }
            reuniones.put(reunion.getId(), reunion);
            return reunion;
        } else {
            throw new IllegalArgumentException("No existe la sala id: " + reunion.getSalaId());
        }
    }

    public void delete(Long id){
        if (reuniones.containsKey(id)){
            reuniones.remove(id);
        } else {
            throw new IllegalArgumentException("No existe la reunion id: " + id);
        }
    }

    public String getNombreSala(Long salaId){
        Optional<Sala> sala = salaService.getSala(salaId);

        if(sala.isPresent()){
            return sala.get().getNombre(); //tengo que extraerla doble por que como esta dentro de un optional, entonces no es una variable simple.
        }  else {
            return "No existe la sala";
        }
    }







}
