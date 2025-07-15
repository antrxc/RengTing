import java.util.ArrayList;

public class Player extends Storage{
    private String name;
    private String playerID;
    private ArrayList<Integer> rollLog;

    public Player (String name){
        this.name = name;
        this.rollLog = new ArrayList<>();
        //TODO add a function to generate playerID in GameUtils
        this.playerID =  generate();
    }

    public String generate(){

    }

    public String getName(){
        return name;
    }

    public String getPlayerID(){
        return playerID;
    }

    public ArrayList<Integer> getRollLog() {
        return rollLog;
    }


}
