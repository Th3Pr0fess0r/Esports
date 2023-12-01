package corso.WelcomToEsports.modelli;

import java.util.Date;

public class Player extends Entity {
    private String nickname;
    private String nome; // "nome" corresponds to "fullName" in English
    private Date dataNascita; // "dataNascita" corresponds to "birthDate" in English
    private String gamesRole; // "gamesRole" remains the same
    private int idTeam; // "idTeam" corresponds to "teamId" in English
	
public Player() {
    	
    }
    
    public Player(int id, String nickname, String nome, Date dataNascita, String gamesRole, int idTeam) {
		super(id);
		this.nickname = nickname;
		this.nome = nome;
		this.dataNascita = dataNascita;
		this.gamesRole = gamesRole;
		this.idTeam = idTeam;
	}
	@Override
	public String toString() {
		return "Player [nickname=" + nickname + ", nome=" + nome + ", dataNascita=" + dataNascita + ", gamesRole="
				+ gamesRole + ", idTeam=" + idTeam + ", id=" + getId() + "]";
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Date getDataNascita() {
		return dataNascita;
	}
	public void setDataNascita(Date dataNascita) {
		this.dataNascita = dataNascita;
	}
	public String getGamesRole() {
		return gamesRole;
	}
	public void setGamesRole(String gamesRole) {
		this.gamesRole = gamesRole;
	}
	public int getIdTeam() {
		return idTeam;
	}
	public void setIdTeam(int idTeam) {
		this.idTeam = idTeam;
	}
    
    
}

