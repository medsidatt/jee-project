// AdminRessource.java
package mr.iscae;

import java.util.List;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.PUT;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import mr.iscae.services.StockService;

@Path("/secure/admin")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AdminRessource {
    private final StockService stockService = new StockService();

    @GET
    @Path("/produits")
    public List<Stock> getAllStocks() {
        return stockService.getAllStocks();
    }

    @GET
    @Path("/produits/{barecode}")
    public Stock getByBarecode(@PathParam("barecode") String barecode) {
        return stockService.getStockByBarcode(barecode);
    }
    
    @PUT
    @Path("/produits/{barecode}")
    public Response updateProduit(@PathParam("barecode") String barecode, Stock stock) {
        return stockService.updateStock(barecode, stock);
    }

    @PUT
    @Path("/produits/qte/{barecode}")
    public Response updateProduitQuantity(@PathParam("barecode") String barecode, UpdateStockRequest quantity) {
        Stock tempStock = stockService.getStockByBarcode(barecode);
        if (tempStock != null) {
            tempStock.setQuantity(quantity.getQuantity());
            return Response.ok(tempStock).build();
        }
        return Response.serverError().entity(tempStock).build();
    }
}
