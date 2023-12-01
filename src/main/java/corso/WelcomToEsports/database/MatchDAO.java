package corso.WelcomToEsports.database;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import corso.WelcomToEsports.modelli.Match;

@Repository
public class MatchDAO {

    private static MatchDAO instance;

    private MatchDAO() {
    }

    public static MatchDAO getInstance() {
        if (instance == null)
            instance = new MatchDAO();
        return instance;
    }

    private HashMap<Integer, Match> readAll(String query, String... params) {
        ArrayList<HashMap<String, Object>> listaMappe = Database.getInstance().eseguiQuery(query, params);
        HashMap<Integer, Match> result = new HashMap<>();
        for (HashMap<String, Object> record : listaMappe) {
            Match match = new Match();
            match.setId((int) record.get("id"));
            match.setDataMatch((Date) record.get("dataMatch"));
            match.setIdGames((int) record.get("idGames"));
            match.setIdTeamHome((int) record.get("idTeamHome"));
            match.setIdTeamAway((int) record.get("idTeamAway"));
            match.setPointsHome((int) record.get("pointsHome"));
            match.setPointsAway((int) record.get("pointsAway"));
            result.put(match.getId(), match);
        }
        return result;
    }

    private boolean update(String query, String... params) {
        return Database.getInstance().eseguiUpdate(query, params);
    }

    public HashMap<Integer, Match> read() {
        String query = "SELECT * FROM matches";
        return readAll(query);
    }

    public boolean create(HashMap<String, String> parametri) {
        String query = "INSERT INTO matches (dataMatch, idGames, idTeamHome, idTeamAway, pointsHome, pointsAway) VALUES (?, ?, ?, ?, ?, ?)";
        return update(query,
                parametri.get("dataMatch"),
                parametri.get("idGames"),
                parametri.get("idTeamHome"),
                parametri.get("idTeamAway"),
                parametri.get("pointsHome"),
                parametri.get("pointsAway")
        );
    }

    public boolean update(HashMap<String, String> parametri) {
        String query = "UPDATE matches SET dataMatch = ?, idGames = ?, idTeamHome = ?, idTeamAway = ?, pointsHome = ?, pointsAway = ? WHERE id = ?";
        return update(query,
                parametri.get("dataMatch"),
                parametri.get("idGames"),
                parametri.get("idTeamHome"),
                parametri.get("idTeamAway"),
                parametri.get("pointsHome"),
                parametri.get("pointsAway"),
                parametri.get("id")
        );
    }

    public boolean delete(HashMap<String, String> parametri) {
        String query = "DELETE FROM matches WHERE id = ?";
        return update(query, parametri.get("id"));
    }
}
