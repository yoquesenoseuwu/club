/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gestiondeeventos;
import java.sql.Date;
import java.sql.Time;

/**
 *
 * @author tm_galli
 */
public class Calendario {
    private int idCalendario; // Este será autoincrementado por la base de datos
    private Date fecha;
    private Time hora;
    private String descripcion;
    private String lugar;

    // Constructor
    public Calendario(Date fecha, Time hora, String descripcion, String lugar) {
        this.fecha = fecha;
        this.hora = hora;
        this.descripcion = descripcion;
        this.lugar = lugar;
    }

    // Getter para idCalendario
    public int getIdCalendario() {
        return idCalendario;
    }

    // No hay setter para idCalendario, ya que es autoincremental

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLugar() {
        return lugar;
    }

    public void setLugar(String lugar) {
        this.lugar = lugar;
    }

    
}


