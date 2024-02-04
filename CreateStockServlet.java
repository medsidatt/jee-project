package mr.iscae;

import java.io.IOException;
import java.io.PrintWriter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import mr.iscae.services.StockService;

@WebServlet("/createProduct")
public class CreateStockServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
	private static final StockService STOCK_SERVICE = new StockService();

	 protected void doGet(HttpServletRequest request, HttpServletResponse response)
	            throws ServletException, IOException {
	        response.setContentType("text/html");
	        PrintWriter out = response.getWriter();
	        

	        out.println("<html><head><title>Create Product</title></head><body>");
	        out.println("<h2>Create Product</h2>");
	        out.println("<form method='post' action='" + request.getContextPath() + "/createProduct'>");
	        out.println("<label for='productName'>Product Name:</label>");
	        out.println("<input type='text' id='productName' name='productName' required><br>");

	        out.println("<label for='barcode'>Barcode:</label>");
	        out.println("<input type='text' id='barcode' name='barcode' required><br>");

	        out.println("<label for='price'>Price:</label>");
	        out.println("<input type='text' id='price' name='price' required><br>");

	        out.println("<label for='quantity'>Quantity:</label>");
	        out.println("<input type='text' id='quantity' name='quantity' required><br>");
	        
	        out.println("<input type='submit' value='Create Product'>");
	        out.println("</form>");
	        out.println("</body></html>");
	    }


    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
       if(getRole(request)) {
    	   String productName = request.getParameter("productName");
           String barcode = request.getParameter("barcode");
           double price = Double.parseDouble(request.getParameter("price"));
           int quantity = Integer.parseInt(request.getParameter("quantity"));

           Stock stock = new Stock(barcode, productName, price, quantity);
           
           STOCK_SERVICE.createStock(stock);
       }else
       		response.getWriter().print("Vous n'avez pas l'access");
       	
        
    }
    
    public boolean getRole(HttpServletRequest request) {
    	if(request.getSession() != null && request.getSession().getAttribute("role") != null) {
    		return true;
    	}
    	return false;
    }
}
