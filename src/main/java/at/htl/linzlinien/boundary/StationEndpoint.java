package at.htl.linzlinien.boundary;

import at.htl.linzlinien.control.StationRepository;
import at.htl.linzlinien.entity.Station;

import javax.inject.Inject;
import javax.json.Json;
import javax.json.JsonArray;
import javax.json.JsonArrayBuilder;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("/station")
public class StationEndpoint {

    @Inject
    StationRepository repository;

    /**
     * localhost:8080/api/station?line=1
     *
     * @param lineName
     * @return all Stations of the given line
     */
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public JsonArray printAllStationsPerLine(@QueryParam("line") String lineName) {
        List<Station> stations = repository.stationsPerLine(lineName);
        JsonArrayBuilder builder = Json.createArrayBuilder();

        stations.stream()
                .map(station -> Json.createObjectBuilder()
                        .add("line", station.getLine().getName())
                        .add("station", station.getLocation().getName())
                        .build())
                .forEach(builder::add);

        return builder.build();
    }
}