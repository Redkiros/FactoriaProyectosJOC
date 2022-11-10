package com.iessanalberto.com;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.w3c.dom.Node;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) throws JAXBException {

        JAXBContext jaxbContext = JAXBContext.newInstance(listaProyectos.class, Usuario.class);

        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();

        listaProyectos listaProyectos;
        Usuario listaUsuarios;
        listaProyectos = (com.iessanalberto.com.listaProyectos) unmarshaller.unmarshal(new File("src/main/resources/proyectos.xml"));
        listaUsuarios = (com.iessanalberto.com.Usuario) unmarshaller.unmarshal(new File("src/main/resources/usuarios.xml"));

        Path path = Path.of("target/Proyecto.json");
        Path path2 = Path.of("target/Usuario.json");
        GsonBuilder gsonBuilder = new GsonBuilder();
        Gson gson = gsonBuilder.setPrettyPrinting().create();
        String textoProyecto = gson.toJson(listaProyectos);
        String textoUsuario = gson.toJson(listaUsuarios);

        try {
            Files.write(path, textoProyecto.getBytes());
            Files.write(path2, textoUsuario.getBytes());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}