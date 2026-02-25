package com.MeetingPlanningCR.domain;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public class Reunion {

    private Long id;

    @NotBlank
    private String titulo;

    @NotNull
    private LocalDate fecha;

    @NotBlank
    private String hora;

    @NotNull
    private Long salaId;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }
    public LocalDate getFecha() {
        return fecha;
    }
    public void setFecha(LocalDate fecha) {
        this.fecha = fecha;
    }
    public String getHora() {
        return hora;
    }
    public void setHora(String hora) {
        this.hora = hora;
    }
    public Long getSalaId() {
        return salaId;
    }
    public void setSalaId(Long salaId) {
        this.salaId = salaId;
    }

}
