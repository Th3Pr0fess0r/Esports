package corso.WelcomToEsports.modelli;

import java.util.Date;

public class Match extends Entity {
	private Date dataMatch; 
	private int idGames; 
	private int idTeamHome;
	private int idTeamAway;
	private int pointsHome; 
	private int pointsAway;

	public Match() {

	}
	public Match(int id, Date dataMatch, int idGames, int idTeamHome, int idTeamAway, int pointsHome, int pointsAway) {
		super(id);
		this.dataMatch = dataMatch;
		this.idGames = idGames;
		this.idTeamHome = idTeamHome;
		this.idTeamAway = idTeamAway;
		this.pointsHome = pointsHome;
		this.pointsAway = pointsAway;
	}

	@Override
	public String toString() {
		return "Match [dataMatch=" + dataMatch + ", idGames=" + idGames + ", idTeamHome=" + idTeamHome + ", idTeamAway="
				+ idTeamAway + ", pointsHome=" + pointsHome + ", pointsAway=" + pointsAway + ", id=" + getId() + "]";
	}

	public Date getDataMatch() {
		return dataMatch;
	}

	public void setDataMatch(Date dataMatch) {
		this.dataMatch = dataMatch;
	}

	public int getIdGames() {
		return idGames;
	}

	public void setIdGames(int idGames) {
		this.idGames = idGames;
	}

	public int getIdTeamHome() {
		return idTeamHome;
	}

	public void setIdTeamHome(int idTeamHome) {
		this.idTeamHome = idTeamHome;
	}

	public int getIdTeamAway() {
		return idTeamAway;
	}

	public void setIdTeamAway(int idTeamAway) {
		this.idTeamAway = idTeamAway;
	}

	public int getPointsHome() {
		return pointsHome;
	}

	public void setPointsHome(int pointsHome) {
		this.pointsHome = pointsHome;
	}

	public int getPointsAway() {
		return pointsAway;
	}

	public void setPointsAway(int pointsAway) {
		this.pointsAway = pointsAway;
	} 



}
