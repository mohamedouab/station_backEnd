package station.ws;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import station.dto.ConnectionRequest;
import station.dto.PompeDto;
import station.service.PompeHistoriqueService;
import station.service.PompeService;

import javax.ws.rs.*;
import java.util.List;

@Controller
@Path("/pompe")

public class PompeWebService {
    @Autowired
    PompeService pompeService;

    @Autowired
    PompeHistoriqueService pompeHistoriqueService;

    @POST
    @Produces("application/json")
    public void addPompe(PompeDto pompeRequest) {
        pompeService.create(pompeRequest);
        return;
    }

    @Path("/all")
    @GET
    @Produces("application/json")
    public List<PompeDto> findAll() {
        return pompeService.findAll();
    }

    @Path("/updateIndex")
    @PUT
    @Produces("application/json")
    public void upadteIndex(PompeDto pompeRequest) {
        pompeService.updateIndex(pompeRequest);
        return;
    }

    @Path("/calculate")
    @GET
    @Produces("application/json")
    public List<PompeDto> calculate() {
        List<PompeDto> listPompeDtao = pompeService.findAll();
        for (PompeDto pompeDto : listPompeDtao) {
            int nbrLitre = Integer.valueOf(pompeDto.getIndex()) - Integer.valueOf(pompeDto.getLastIndex());
            pompeDto.setRecette(nbrLitre * 380);
        }
        return listPompeDtao;
    }

    @Path("/connection")
    @PUT
    @Produces("application/json")
    public void connecter(ConnectionRequest connectionRequest) {
        pompeService.connectPompeToCuve(connectionRequest.getIdPompe(), connectionRequest.getIdCuve());
        return;
    }

    @Path("/allHistory")
    @GET
    @Produces("application/json")
    public List<PompeDto> findAllHistory() {
        return pompeHistoriqueService.findAll();
    }
}
