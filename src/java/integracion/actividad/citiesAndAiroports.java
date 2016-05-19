/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package integracion.actividad;

import integracion.airoports.Airport;
import integracion.airoports.AirportSoap;
import integracion.paises.GlobalWeather;
import integracion.paises.GlobalWeatherSoap;
import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author Cristobal
 */
@WebService(serviceName = "citiesAndAiroports")
public class citiesAndAiroports {

    /**
     * This is a sample web service operation
     * @param pais
     * @return 
     */
    @WebMethod(operationName = "getAiroportsAndCities")
    
    public String[] hello(@WebParam(name = "pais") String pais) {
        //Get Cities
        GlobalWeather gw = new GlobalWeather();
        GlobalWeatherSoap gwSoap =  gw.getGlobalWeatherSoap();
        
        String citiesList = gwSoap.getCitiesByCountry(pais);
        //getAirports
        Airport airports = new Airport();
        AirportSoap aiportSoap =  airports.getAirportSoap();
        String airportsList = aiportSoap.getAirportInformationByCountry(pais);
        
        //result in a array
        String[] result = new String[2];
        result[0]=citiesList;
        result[1]=airportsList;
        
        return result;
    }
}
