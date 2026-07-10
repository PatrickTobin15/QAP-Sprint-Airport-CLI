package com.patrick.airportcli.client;

import com.patrick.airportcli.model.AircraftAirports;
import com.patrick.airportcli.model.CityAirports;
import com.patrick.airportcli.model.PassengerAircraft;
import com.patrick.airportcli.model.UsedAirport;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class ApiClientTest {

    @Mock
    private HttpExecutor httpExecutor;

    private ApiClient apiClient;

    private static final String BASE_URL = "http://localhost:8080";

    @BeforeEach
    void setUp() {
        apiClient = new ApiClient(httpExecutor, BASE_URL);
    }

    @Test
    void getCitiesWithAirports_parsesResponseIntoCityAirportsList() throws Exception {
        String json = "[{\"cityId\":1,\"cityName\":\"Halifax\",\"airports\":"
                + "[{\"id\":1,\"name\":\"Halifax Stanfield\",\"code\":\"YHZ\"}]}]";
        when(httpExecutor.get(BASE_URL + "/api/cities/airports-summary")).thenReturn(json);

        List<CityAirports> result = apiClient.getCitiesWithAirports();

        assertEquals(1, result.size());
        assertEquals("Halifax", result.get(0).getCityName());
        assertEquals(1, result.get(0).getAirports().size());
        assertEquals("YHZ", result.get(0).getAirports().get(0).getCode());
    }

    @Test
    void getPassengersWithAircraft_parsesResponseIntoPassengerAircraftList() throws Exception {
        String json = "[{\"passengerId\":1,\"firstName\":\"Grace\",\"lastName\":\"Smith\",\"aircraft\":"
                + "[{\"id\":1,\"type\":\"737\",\"airlineName\":\"Air Canada\"}]}]";
        when(httpExecutor.get(BASE_URL + "/api/passengers/aircraft-summary")).thenReturn(json);

        List<PassengerAircraft> result = apiClient.getPassengersWithAircraft();

        assertEquals(1, result.size());
        assertEquals("Grace", result.get(0).getFirstName());
        assertEquals("Air Canada", result.get(0).getAircraft().get(0).getAirlineName());
    }

    @Test
    void getAircraftWithAirports_parsesResponseIntoAircraftAirportsList() throws Exception {
        String json = "[{\"aircraftId\":1,\"type\":\"737\",\"airlineName\":\"WestJet\",\"airports\":"
                + "[{\"id\":2,\"name\":\"Toronto Pearson\",\"code\":\"YYZ\"}]}]";
        when(httpExecutor.get(BASE_URL + "/api/aircraft/airports-summary")).thenReturn(json);

        List<AircraftAirports> result = apiClient.getAircraftWithAirports();

        assertEquals(1, result.size());
        assertEquals("WestJet", result.get(0).getAirlineName());
        assertEquals("YYZ", result.get(0).getAirports().get(0).getCode());
    }

    @Test
    void getAirportsUsedByPassengers_parsesResponseIntoUsedAirportList() throws Exception {
        String json = "[{\"airportId\":2,\"name\":\"Toronto Pearson\",\"code\":\"YYZ\",\"cityName\":\"Toronto\"}]";
        when(httpExecutor.get(BASE_URL + "/api/airports/used-by-passengers")).thenReturn(json);

        List<UsedAirport> result = apiClient.getAirportsUsedByPassengers();

        assertEquals(1, result.size());
        assertEquals("Toronto Pearson", result.get(0).getName());
        assertEquals("Toronto", result.get(0).getCityName());
    }

    @Test
    void getCitiesWithAirports_handlesEmptyList() throws Exception {
        when(httpExecutor.get(BASE_URL + "/api/cities/airports-summary")).thenReturn("[]");

        List<CityAirports> result = apiClient.getCitiesWithAirports();

        assertEquals(0, result.size());
    }
}
