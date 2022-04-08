package com.example.demo.Service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@Service
public class CSVService {

    /**
     * Metodo per leggere le prime 10 righe del CSV
     * @param csvName --> file csv in ingesso
     * @return Lista di stringhe (ogni linea del csv)
     */
    public List<String> readCsv(String csvName) throws IOException {
        List<String> linesInCSV = new ArrayList<>();

        Path currentRelativePath = Paths.get("");
        String basePath = currentRelativePath.toAbsolutePath().toString();
        Path pathToFile = Paths.get(basePath, "csv", csvName);

        Files.lines(pathToFile).skip(1)  //skippo la prima linea
                //.limit(1000) //prendo solo le prime 10 linee
                .forEach(linesInCSV::add);
        return linesInCSV;
    }


    /**
     * metodo che controlla un array e verifica che sia popolato
     * @param arr
     * @param i
     */
    public String stringChecked(String[] arr, int i){

        try {
            return arr[i];
        }
        catch(Exception e) {
            log.error(e.toString());
        }
        return "";
    }



}
