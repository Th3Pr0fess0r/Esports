package corso.WelcomToEsports.database;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import corso.WelcomToEsports.modelli.Team;

@Repository
public class TeamDAO {

    private static TeamDAO instance;

    private TeamDAO() {
    }

    public static TeamDAO getInstance() {
        if (instance == null)
            instance = new TeamDAO();
        return instance;
    }

    private HashMap<Integer, Team> readAll(String query, String... params) {
        ArrayList<HashMap<String, Object>> listaMappe = Database.getInstance().eseguiQuery(query, params);
        HashMap<Integer, Team> result = new HashMap<>();
        for (HashMap<String, Object> record : listaMappe) {
            Team team = new Team();
            team.setId((int) record.get("id"));
            team.setNome((String) record.get("nome"));
            team.setNazione((String) record.get("nazione"));
            team.setIdGames((int) record.get("idGames"));
            result.put(team.getId(), team);
        }
        return result;
    }

    private boolean update(String query, String... params) {
        return Database.getInstance().eseguiUpdate(query, params);
    }

    public HashMap<Integer, Team> read() {
        String query = "SELECT * FROM teams";
        return readAll(query);
    }

    public boolean create(HashMap<String, String> parametri) {
        String query = "INSERT INTO teams (nome, nazione, idGames) VALUES (?, ?, ?)";
        return update(query,
                parametri.get("nome"),
                parametri.get("nazione"),
                parametri.get("idGames")
        );
    }

    public boolean update(HashMap<String, String> parametri) {
        String query = "UPDATE teams SET nome = ?, nazione = ?, idGames = ? WHERE id = ?";
        return update(query,
                parametri.get("nome"),
                parametri.get("nazione"),
                parametri.get("idGames"),
                parametri.get("id")
        );
    }

    public boolean delete(HashMap<String, String> parametri) {
        String query = "DELETE FROM teams WHERE id = ?";
        return update(query, parametri.get("id"));
    }
}
