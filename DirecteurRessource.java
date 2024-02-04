package mr.iscae;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import mr.iscae.services.StockService;

@Path("/secure/admin")
public class DirecteurRessource {
	private final StockService stockService = new StockService();
	@GET
	@Path("/produits")
	@Consumes(MediaType.APPLICATION_JSON)
	@Produces(MediaType.APPLICATION_JSON)
	public List<Stock> getAllStocks () {
		return stockService.getAllStocks();
	}

}
