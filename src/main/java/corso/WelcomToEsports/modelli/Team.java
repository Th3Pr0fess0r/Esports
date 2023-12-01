package corso.WelcomToEsports.modelli;

public class Team extends Entity {
    private String nome; // "nome" corresponds to "name" in English
    private String nazione; // "nazione" corresponds to "country" in English
    private int idGames; // "idGames" corresponds to "gameId" in English
	
    public Team(int id, String nome, String nazione, int idGames) {
		super(id);
		this.nome = nome;
		this.nazione = nazione;
		this.idGames = idGames;
	}
    public Team() {

    }
    
	@Override
	public String toString() {
		return "Team [nome=" + nome + ", nazione=" + nazione + ", idGames=" + idGames + ", id=" + getId() + "]";
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getNazione() {
		return nazione;
	}
	public void setNazione(String nazione) {
		this.nazione = nazione;
	}
	public int getIdGames() {
		return idGames;
	}
	public void setIdGames(int idGames) {
		this.idGames = idGames;
	}
    
    
}


