package entities;

public class ImportedProduct extends Product{
	
	private double custumsFee;

	public ImportedProduct(String name, double price, double custumsFee) {
		super(name, price);
		this.custumsFee = custumsFee;
	}
	
	public double getCustumsFee() {
		return custumsFee;
	}

	public void setCustumsFee(double custumsFee) {
		this.custumsFee = custumsFee;
	}


	public double totalprice() {
		return price+custumsFee;
	}
	
	@Override
    public String priceTag(){
		StringBuilder sb= new StringBuilder();
		sb.append(name);
		sb.append(" $ ");
		sb.append(String.format("%.2f", totalprice()));
		
		sb.append(" (Customs fee: $");
		sb.append(String.format("%.2f", custumsFee));
		sb.append(")");
		return sb.toString();
	}
	
	

}
