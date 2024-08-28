package model;

import java.sql.SQLException;

public class Session {

    public static Database database;
    public static Boolean voiceOn=true;

    static {
        try {
            database = new Database("localhost",3306,"kingdomrush","root","zahmaz123");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException(e);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    public Session() throws SQLException, ClassNotFoundException {
    }

}
