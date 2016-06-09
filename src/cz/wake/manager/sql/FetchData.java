package cz.wake.manager.sql;

import cz.wake.manager.Main;
import org.bukkit.entity.Player;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.UUID;

public class FetchData {

    public synchronized int getPlayerTotalVotes(UUID uuid){
        try{
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT votes FROM votes WHERE uuid = '" + uuid.toString() + "'");
            if(localResultSet.next()){
                return localResultSet.getInt("votes");
            }
            localResultSet.close();
        } catch(SQLException localSQLException){
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getPlayerCoins(UUID uuid){
        try{
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT balance FROM CraftCoins WHERE uuid = '" + uuid.toString() + "'");
            if(localResultSet.next()){
                return localResultSet.getInt("balance");
            }
            localResultSet.close();
        } catch(SQLException localSQLException){
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getPlayerWeekVotes(UUID uuid){
        try{
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT week FROM votes WHERE uuid = '" + uuid.toString() + "'");
            if(localResultSet.next()){
                return localResultSet.getInt("week");
            }
            localResultSet.close();
        } catch(SQLException localSQLException){
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public synchronized int getPlayerMonthVotes(UUID uuid){
        try{
            ResultSet localResultSet = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery("SELECT month FROM votes WHERE uuid = '" + uuid.toString() + "'");
            if(localResultSet.next()){
                return localResultSet.getInt("month");
            }
            localResultSet.close();
        } catch(SQLException localSQLException){
            localSQLException.printStackTrace();
        }
        return 0;
    }

    public final boolean hasData(final Player p) {

        Boolean hasData = Boolean.valueOf(false);

        final String query = "SELECT * FROM votes WHERE uuid = '" + p.getUniqueId().toString() + "';";

        try {
            ResultSet result = Main.getInstance().getMySQL().getCurrentConnection().createStatement().executeQuery(query);
            if (result.next()) {
                hasData = Boolean.valueOf(true);
            }
            result.close();
        } catch (SQLException e) {
            //Nic
        }
        return hasData.booleanValue();
    }
}