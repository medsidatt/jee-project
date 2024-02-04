package mr.iscae.services;

import java.util.ArrayList;
import java.util.List;
import mr.iscae.Magasin;
import mr.iscae.Stock;
import mr.iscae.User;

public class StockService {

	private final UserService userService = new UserService();
	
	private static List<Stock> stocks = new ArrayList<Stock>();

	
	
	static {
		stocks.add(new Stock("codebare1", "produit1", 200.00, 90));
		stocks.add(new Stock("codebare2", "produit2", 200.00, 90));
		
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


	public Stock getStockByName(String stockName) {
		for (Stock stock : stocks) {
            if (stock.getName().equals(stockName)) {
                return stock;
            }
        }
		return null;
	}
	
	
}
