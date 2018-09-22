package station.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import station.dto.CuveDto;
import station.dto.DepotageRequest;
import station.service.CuveService;

import javax.ws.rs.*;
import java.util.List;

@Controller
@Path("/cuve")

public class CuveWebService {
    @Autowired
    CuveService cuveService;


    @POST
    @Produces("application/json")
    public void addCuve(CuveDto cuveRequest) {
        cuveService.create(cuveRequest);
        return;
    }


    @Path("/all")
    @GET
    @Produces("application/json")
    public List<CuveDto> findAll() {
        return cuveService.findAll();
    }

    @Path("/depotage")
    @PUT
    @Produces("application/json")
    public void deposer(DepotageRequest depotageRequest) {
        cuveService.deposer(depotageRequest.getIdCuve(), depotageRequest.getQuantite());
        return;
    }
}
