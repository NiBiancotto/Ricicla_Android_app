package Model;

public class Product {
	private int id;
	private String nome;
	private String bidone;
	
	public Product(){}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getBidone() {
		return bidone;
	}

	public void setBidone(String bidone) {
		this.bidone = bidone;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", nome=" + nome + ", bidone=" + bidone
				+ "]";
	}
	
	

}
