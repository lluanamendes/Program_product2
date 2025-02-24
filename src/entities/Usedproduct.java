package entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Usedproduct extends Product{
	DateTimeFormatter fmt=DateTimeFormatter.ofPattern("dd/MM/yyyy");
	private LocalDate manuFactureDate;

	public Usedproduct(String name, double price, LocalDate facture) {
		super(name, price);
		this.manuFactureDate=facture;
	}

	public LocalDate getManuFactureDate() {
		return manuFactureDate;
	}

	public void setManuFactureDate(LocalDate manuFactureDate) {
		this.manuFactureDate = manuFactureDate;
	}
	
	@Override
    public String priceTag(){
		StringBuilder sb= new StringBuilder();
		sb.append(super.priceTag());
		sb.append("(Manufacture date: ");
		sb.append(fmt.format(manuFactureDate));
		sb.append(")");
		
		return sb.toString();
	}

}
