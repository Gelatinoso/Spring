package com.ivan.restcontrollers;

import com.ivan.system.FileDownloader;
import com.ivan.system.SystemCtl;
import com.ivan.utils.Router;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

@RestController
public class DashboardRestController {
    @Autowired
    Environment environment;


    public String downloadFiles(){

        return "";
    }

    @GetMapping(Router.SERVICE_START)
    public String iniciarServicio(){
        try{
            SystemCtl.systemCtl("start", environment.getProperty("service_name"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(environment.getProperty("service_name"));
        return "Iniciando servicio";
    }

    @GetMapping(Router.SERVICE_STOP)
    public String detenerServicio(){
        try{
            SystemCtl.systemCtl("stop", environment.getProperty("service_stop"));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(environment.getProperty("service_stop"));
        return "Deteniendo servicio";
    }

    @GetMapping(Router.SERVICE_UPDATE)
    public String update(){

        boolean isDownloaded = FileDownloader.download(
                "",
                "",
                environment.getProperty("service_downloadUrl"),
                environment.getProperty("stage"));

        if(isDownloaded){
            //origen
            Path stage = Paths.get(environment.getProperty("stage"));
            //destino
            Path target = Paths.get(environment.getProperty("target"));
            //instruccion para mover archivo
            System.out.println("Descargado y movido con exito!");
            try {
                SystemCtl.systemCtl("stop", environment.getProperty("service_name"));
                Files.move(stage, target, StandardCopyOption.REPLACE_EXISTING);
                SystemCtl.systemCtl("start", environment.getProperty("service_name"));
            } catch (IOException e) {
                e.printStackTrace();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        return "Descargado y movido con éxito!";
    }
}
