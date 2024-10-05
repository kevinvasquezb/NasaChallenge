package com.test.nasachallenge.service;

import com.test.nasachallenge.attribute.FireData;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.io.BufferedReader;
import java.io.StringReader;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
@Service
public class FireDataService {

    private final RestTemplate restTemplate;

    public FireDataService(RestTemplateBuilder builder){
        this.restTemplate = builder.build();
    }

    // Método para procesar los datos CSV y devolver una lista de objetos FireData
    public List<FireData> parseCsvData(String csvData) {
        List<FireData> fireDataList = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new StringReader(csvData))) {
            String line;
            boolean firstLine = true;

            while ((line = reader.readLine()) != null) {
                // Omitir la primera línea (encabezados)
                if (firstLine) {
                    firstLine = false;
                    continue;
                }

                // Dividir la línea en columnas
                String[] fields = line.split(",");
                FireData fireData = new FireData();
                fireData.setLatitude(Double.parseDouble(fields[0]));
                fireData.setLongitude(Double.parseDouble(fields[1]));
                fireData.setBrightness(Double.parseDouble(fields[2]));
                fireData.setDate(fields[5]);  // Fecha del foco de calor
                fireData.setSatellite(fields[7]);
                fireData.setInstrument(fields[8]);

                fireDataList.add(fireData);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return fireDataList;
    }

    // Método para obtener los datos de la API y devolver una lista de objetos FireData
    public List<FireData> getFireData(){

        // Obtener la fecha actual
        String currentDate = LocalDate.now().toString();

        String apiKey = "e3b77479e44d031cd3d589c31db9f3ca";
        String url = "https://firms.modaps.eosdis.nasa.gov/api/area/csv/" + apiKey + "/VIIRS_SNPP_NRT/-69.6,-23.0,-57.0,-9.5/1/"+currentDate;

        String csvData = restTemplate.getForObject(url, String.class);

        System.out.printf("Datos recibidos de la API: " + csvData);

        if(csvData != null && csvData.startsWith("latitud")){
            return parseCsvData(csvData);
        }else{
            System.out.println("Error en la API" + csvData);
            return new ArrayList<>();
        }
    }
}

