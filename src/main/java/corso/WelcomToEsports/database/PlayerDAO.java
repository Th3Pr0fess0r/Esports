package corso.WelcomToEsports.database;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;

import corso.WelcomToEsports.modelli.Player;

public class PlayerDAO {

    private static PlayerDAO instance;

    private PlayerDAO() {
    }

    public static PlayerDAO getInstance() {
        if (instance == null)
            instance = new PlayerDAO();
        return instance;
    }

    private HashMap<Integer, Player> readAll(String query, String... params) {
        ArrayList<HashMap<String, Object>> listaMappe = Database.getInstance().eseguiQuery(query, params);
        HashMap<Integer, Player> result = new HashMap<>();
        for (HashMap<String, Object> record : listaMappe) {
            Player player = new Player();
            player.setId((int) record.get("id"));
            player.setNickname((String) record.get("nickname"));
            player.setNome((String) record.get("nome"));
            player.setDataNascita((Date) record.get("dataNascita"));
            player.setGamesRole((String) record.get("gamesRole"));
            player.setIdTeam((int) record.get("idTeam"));
            result.put(player.getId(), player);
        }
        return result;
    }

    private boolean update(String query, String... params) {
        return Database.getInstance().eseguiUpdate(query, params);
    }

    public HashMap<Integer, Player> read() {
        String query = "SELECT * FROM players";
        return readAll(query);
    }

    public boolean create(HashMap<String, String> parametri) {
        String query = "INSERT INTO players (nickname, nome, dataNascita, gamesRole, idTeam) VALUES (?, ?, ?, ?, ?)";
        return update(query,
                parametri.get("nickname"),
                parametri.get("nome"),
                parametri.get("dataNascita"),
                parametri.get("gamesRole"),
                parametri.get("idTeam")
        );
    }

    public boolean update(HashMap<String, String> parametri) {
        String query = "UPDATE players SET nickname = ?, nome = ?, dataNascita = ?, gamesRole = ?, idTeam = ? WHERE id = ?";
        return update(query,
                parametri.get("nickname"),
                parametri.get("nome"),
                parametri.get("dataNascita"),
                parametri.get("gamesRole"),
                parametri.get("idTeam"),
                parametri.get("id")
        );
    }

    public boolean delete(HashMap<String, String> parametri) {
        String query = "DELETE FROM players WHERE id = ?";
        return update(query, parametri.get("id"));
    }
}
