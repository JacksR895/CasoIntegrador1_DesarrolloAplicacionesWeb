package com.MeetingPlanningCR.domain;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;

public class Sala {

    private Long id;

    @NotBlank
    private String nombre;

    @Min(1)
    private int capacidad;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public int getCapacidad() {
        return capacidad;
    }
    public void setCapacidad(int capacidad) {
        this.capacidad = capacidad;
    }

}
