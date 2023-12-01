package corso.WelcomToEsports.modelli;

public class Game extends Entity {
    private String titolo;
    
    public Game() {
    	
    }

	public Game(int id, String titolo) {
		super(id);
		this.titolo = titolo;
	}

	@Override
	public String toString() {
		return "Game [titolo=" + titolo + ", id=" + getId() + "]";
	}

	public String getTitolo() {
		return titolo;
	}

	public void setTitolo(String titolo) {
		this.titolo = titolo;
	}
    
    
    
    
    
}

