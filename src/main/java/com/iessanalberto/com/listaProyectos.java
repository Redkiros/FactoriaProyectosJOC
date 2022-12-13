package com.iessanalberto.com;

import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;

import java.util.ArrayList;
@XmlRootElement(name = "proyectos")
public class listaProyectos {
    ArrayList<Proyecto> proyectos;

    public listaProyectos() {
    }

    public ArrayList<Proyecto> getProyectos() {
        return proyectos;
    }

    public void setProyectos(ArrayList<Proyecto> proyectos) {
        this.proyectos = proyectos;
    }

}
