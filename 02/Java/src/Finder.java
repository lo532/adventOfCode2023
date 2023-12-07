import java.util.HashMap;
import java.util.Map;

public class Finder {


    public final Map<String, Integer> maxCubes = new HashMap<>() {{
        put("red", 12);
        put("green", 13);
        put("blue", 14);
    }};

    public int validateGame(String game) {
        Map<String, String> gameMap = formatGame(game);

        int gameID = Integer.parseInt(gameMap.get("gameID"));
        String gameValues = gameMap.get("gameValues");
        String[] gameSets = gameValues.split(";");

        for (String gameSet : gameSets) {
            for (String innerSet: gameSet.split(",")) {
                String cubeColour = innerSet.strip().split(" ")[1];
                int cubeCount = Integer.parseInt(innerSet.strip().split(" ")[0]);
                if (cubeCount > maxCubes.get(cubeColour)) {
                    return 0;
                }
            }
        }
        return gameID;
    }

    public int getFewestNumberOfCubes(String game) {
        Map<String, String> gameMap = formatGame(game);
        Map<String, Integer> fewestCubesMap = new HashMap<>();

        String gameValues = gameMap.get("gameValues");
        String[] gameSets = gameValues.split(";");

        for (String gameSet : gameSets) {
            for (String innerSet: gameSet.split(",")) {
                String cubeColour = innerSet.strip().split(" ")[1];
                int cubeCount = Integer.parseInt(innerSet.strip().split(" ")[0]);

                if (fewestCubesMap.get(cubeColour) == null) {
                    fewestCubesMap.put(cubeColour, cubeCount);
                } else {
                    if (cubeCount > fewestCubesMap.get(cubeColour)) {
                        fewestCubesMap.put(cubeColour, cubeCount);
                    }
                }
            }
        }
        return fewestCubesMap.values().stream().reduce(1, (a,b) -> a * b);
    }

    public Map<String, String> formatGame(String gameStream) {

        String[] gameInput = gameStream.split(":");
        String gameID = gameInput[0].split(" ")[1];
        String gameValues = gameInput[1];

        return new HashMap<>() {{
            put("gameID", gameID);
            put("gameValues", gameValues);
        }};
    }

}
