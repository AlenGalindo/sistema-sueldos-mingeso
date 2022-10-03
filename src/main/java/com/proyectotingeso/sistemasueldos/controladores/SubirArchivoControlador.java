package com.proyectotingeso.sistemasueldos.controladores;

import com.proyectotingeso.sistemasueldos.servicios.AsistenciaServicio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


@Controller
@RequestMapping
public class SubirArchivoControlador {

    @Autowired
    AsistenciaServicio asistenciaServicio;
    @GetMapping("/subir_archivo")
    public String mostrarSubirArchivo(){
        return "subir_archivo";
    }

    @PostMapping("/cargar")
    public String uploadFile(@RequestParam("file") MultipartFile file, RedirectAttributes attributes)
            throws IOException {
        asistenciaServicio.deleteAllAsistencias();
        StringBuilder builder = new StringBuilder();
        builder.append("/");
        builder.append(file.getOriginalFilename());
        byte[] bytes = file.getBytes();
        Path path = Paths.get(builder.toString());
        Files.write(path,bytes);
        System.out.println(path+"<-");
        return "redirect:/asistencias/cargar";
    }
}
