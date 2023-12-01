package corso.WelcomToEsports.database;

import java.util.ArrayList;
import java.util.HashMap;

import org.springframework.stereotype.Repository;

import corso.WelcomToEsports.modelli.Game;

@Repository
public class GameDAO {

    private static GameDAO instance;

    private GameDAO() {
    }

    public static GameDAO getInstance() {
        if (instance == null)
            instance = new GameDAO();
        return instance;
    }

    private HashMap<Integer, Game> readAll(String query, String... params) {
        ArrayList<HashMap<String, Object>> listaMappe = Database.getInstance().eseguiQuery(query, params);
        HashMap<Integer, Game> result = new HashMap<>();
        for (HashMap<String, Object> record : listaMappe) {
            Game game = new Game();
            game.setId((int) record.get("id"));
            game.setTitolo((String) record.get("titolo"));
            result.put(game.getId(), game);
        }
        return result;
    }

    private boolean update(String query, String... params) {
        return Database.getInstance().eseguiUpdate(query, params);
    }

    public HashMap<Integer, Game> read() {
        String query = "SELECT * FROM games";
        return readAll(query);
    }

    public boolean create(HashMap<String, String> parametri) {
        String query = "INSERT INTO games (titolo) VALUES (?)";
        return update(query, parametri.get("titolo"));
    }

    public boolean update(HashMap<String, String> parametri) {
        String query = "UPDATE games SET titolo = ? WHERE id = ?";
        return update(query, parametri.get("titolo"), parametri.get("id"));
    }

    public boolean delete(HashMap<String, String> parametri) {
        String query = "DELETE FROM games WHERE id = ?";
        return update(query, parametri.get("id"));
    }
}
