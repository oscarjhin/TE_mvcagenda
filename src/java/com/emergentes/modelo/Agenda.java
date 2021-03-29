
package com.emergentes.modelo;

public class Agenda 
{
    private int id;
    private String hora, actividad, completado;

    public Agenda() 
    {
        id=0;
        hora="00:00";
        actividad="";
        completado="";
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHora() {
        return hora;
    }

    public void setHora(String hora) {
        this.hora = hora;
    }

    public String getActividad() {
        return actividad;
    }

    public void setActividad(String actividad) {
        this.actividad = actividad;
    }

    public String getCompletado() {
        return completado;
    }

    public void setCompletado(String completado) {
        this.completado = completado;
    }
    
}
