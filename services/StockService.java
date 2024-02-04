package mr.iscae.services;

import java.util.ArrayList;
import java.util.List;

import jakarta.ws.rs.core.Response;
import mr.iscae.Magasin;
import mr.iscae.Stock;
import mr.iscae.User;

public class StockService {

    private final UserService userService = new UserService();

    private static List<Stock> stocks = new ArrayList<Stock>();
    private static List<Magasin> magasins = new ArrayList<Magasin>();

    static {
        stocks.add(new Stock("codebare1", "produit1", 200.00, 90));
        stocks.add(new Stock("codebare2", "produit2", 200.00, 90));
        magasins.add(new Magasin("magasin1", stocks));
    }

    public List<Magasin> getAllMagasins() {
        return magasins;
    }

    public List<Stock> getAllStocks() {
        return stocks;
    }

    public Stock createStock(Stock stock) {
        stocks.add(stock);
        return stock;
    }

    public Magasin getUserMagasin(String username) {
        for (User user : userService.getUsersMap().values()) {
            if (user.getUserName().equals(username)) {
                return user.getMagasin();
            }
        }
        return null;
    }

    public Stock getStockByBarcode(String barcode) {
        for (Stock stock : stocks) {
            if (stock.getBarcode().equals(barcode)) {
                return stock;
            }
        }
        return null;
    }

    public Stock addStockToMagasin(String magasinName, Stock stock) {
        Magasin magasin = getMagasinByName(magasinName);

        if (magasin != null) {
            magasin.getStock().add(stock);
            return stock;
        }

        return null;
    }
    
    public Response updateStock(String barecode, Stock stock) {
        Stock tempStock = getStockByBarcode(barecode);
        if(tempStock != null) {
        	tempStock.setBarcode(stock.getBarcode());
        	tempStock.setName(stock.getName());
        	tempStock.setQuantity(stock.getQuantity());
        	tempStock.setPrice(stock.getPrice());
        	
        	return Response.ok(tempStock).build();
        }
        return Response.serverError().entity("Le produit n'est pas modifier").build();
    }

    private Magasin getMagasinByName(String magasinName) {
        for (Magasin magasin : magasins) {
            if (magasin.getName().equals(magasinName)) {
                return magasin;
            }
        }
        return null;
    }
}