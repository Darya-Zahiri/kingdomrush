package model;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

import java.io.File;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Player {
    private int id;

    private String username;

    private String password;

    private int level;

    private int diamond;

    private static Player player=new Player();

    public static boolean status=false;

    public boolean audio=true;

    public String musicFile = "C:\\Users\\zam zam\\Downloads\\clash_of_clans_combat_music.mp3";     // For example

    public Media sound = new Media(new File(musicFile).toURI().toString());
    public MediaPlayer mediaPlayer = new MediaPlayer(sound);

    //backpack


    private Player() {
        this.level=1;
        this.diamond=0;
        this.healSpell=0;
        this.coinSpell=0;
        this.freezeSpell=0;
        this.littleSpell=0;
    }

    public static Player getPlayer() {
        return player;
    }

    public static void setPlayer(Player player) {
        Player.player = player;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }

    public int getLevel() {
        return level;
    }

    public int getDiamond() {
        return diamond;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setDiamond(int diamond) {
        this.diamond = diamond;
    }

    public int coinSpell;
    public int healSpell;
    public int freezeSpell;
    public int littleSpell;

    public String signIn(String username,String password) throws SQLException {
        Player newPlayer=new Player();
        newPlayer.setUsername(username);
        newPlayer.setPassword(password);
        ResultSet resultSet= Session.database.executeQueryWithResult("select * from player where username='"+newPlayer.getUsername()+"' and password='"+newPlayer.getPassword()+"';");
        if(resultSet.next()) {
            player=newPlayer;
            player.setId(resultSet.getInt("id"));
            player.setDiamond(Integer.parseInt(resultSet.getString("diamond")));
            player.setLevel(Integer.parseInt(resultSet.getString("level")));
            player.coinSpell=(Integer.parseInt(resultSet.getString("coinSpell")));
            player.healSpell=(Integer.parseInt(resultSet.getString("healSpell")));
            player.littleSpell=(Integer.parseInt(resultSet.getString("littleSpell")));
            player.freezeSpell=(Integer.parseInt(resultSet.getString("freezeSpell")));
            return ("user found");
        }else {
            return ("user not found!!!");
        }
    }
    public String signup(String username,String password) {
        status=false;
        try {
        Player newPlayer=new Player();
        newPlayer.setUsername(username);
        newPlayer.setPassword(password);

            Session.database.executeQueryWithoutResult("insert into player (username,password,level,diamond) values('" + newPlayer.getUsername() + "','" + newPlayer.getPassword() + "',1,0);");
            try {
                ResultSet resultSet = Session.database.executeQueryWithResult("select id from player where username='" + newPlayer.getUsername() + "';");
                if (resultSet.next()) {
                    newPlayer.setId(resultSet.getInt("id"));
                    status=true;
                    return ("");
                } else {
                    return("signin error");
                }
            }catch (SQLException e){
                return ("syntax error object didnt update");
            }
        }catch (SQLException e){
            return ("username already taken!!!");
        }catch (Exception e){
            return (e.toString());
        }
    }
}
