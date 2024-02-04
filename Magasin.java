package mr.iscae;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Magasin {
	@JsonProperty
	private String name;
	private List<Stock> stock;
	
	
	public Magasin(String name, List<Stock> stock) {
		super();
		this.name = name;
		this.stock = stock;
	}



	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}



	public List<Stock> getStock() {
		return stock;
	}



	public void setStock(List<Stock> stock) {
		this.stock = stock;
	}

	
	
	
	
}
