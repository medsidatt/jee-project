package mr.iscae;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

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
	        List<Magasin> magasins = STOCK_SERVICE.getAllMagasins();

	        out.println("<html><head><title>Create Product</title></head><body>");
	        out.println("<h2>Create Product</h2>");
	        out.println("<form method='post' action='" + request.getContextPath() + "/createProduct'>");
	        out.println("<label for='productName'>Product Name:</label>");
	        out.println("<input type='text' id='productName' name='productName' required><br>");

	        out.println("<label for='barcode'>Barcode:</label>");
	        out.println("<input type='text' id='barcode' name='barcode' required><br>");

	        out.println("<label for='price'>Price:</label>");
	        out.println("<input type='text' id='price' name='price' required><br>");
	        
	        out.println("<label for='magasin'>Magasin:</label>");
	        out.println("<select  id='magasin' name='price >");
	        	out.print("<option >hello</option>");
	        	out.print("<option >hello</option>");
	        	out.print("<option >hello</option>");
	        out.println("</select><br>");
	        
//	        out.println("<select  id='magasin' name='price >");
//	        for(Magasin magasin : magasins) {
//	        	out.print("<option >hello</option>");
//	        }
//	        out.println("</select><br>");

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
           
           STOCK_SERVICE.addStockToMagasin("directeur", stock);
       }else
       		response.getWriter().print("Vous n'avez pas l'access");
       	
        
    }
    
    public boolean getRole(HttpServletRequest request) {
    	
    	boolean session = request.getSession() != null;
    	if(session) {
    		String role = (String) request.getSession().getAttribute("role");;
    		if(role != null && (role.equals("directeur") || role.equals("admin")))
    			return true;
    	}
    	return false;
    }
}
