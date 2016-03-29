package indeedPrime;

import java.util.HashMap;

public class test3 {
	static String doesCircleExist(String commands) {
        int initX = 0;
        int initY = 0;
        String direction = "north";

        int x = 0;
        int y = 0;

        for (int i = 0; i < commands.length(); i++) {

            if (commands.charAt(i) == 'L') direction=leftTurn.get(direction);
            else if (commands.charAt(i) == 'R') direction=rightTurn.get(direction);
                else if (commands.charAt(i) == 'G'){
                if (direction.equals("north")) y++;
                else if (direction.equals("east")) x++;
                    else if (direction.equals("south")) y--;
                    else if (direction.equals("west")) x--;
                    }
        }	

        if (direction.equals("north") && (((x-initX)*(x-initX) + (y-initY)*(y-initY)) > 0)) {
            return "NO";
        } else {
            return "YES";
        }
    }

    private static HashMap<String, String> leftTurn=new HashMap<>();
    private static HashMap<String, String> rightTurn=new HashMap<>();

    static {
        leftTurn.put("north", "west");
        leftTurn.put("west", "south");
        leftTurn.put("south", "east");
        leftTurn.put("east", "north");
        rightTurn.put("north", "east");
        rightTurn.put("east", "south");
        rightTurn.put("south", "west");
        rightTurn.put("west", "north");
    }



}
