import java.io.FileNotFoundException;
import java.util.*;

public class Statistics {
    private List<Cyclist> cyclists;
    public Statistics(String fileName) throws FileNotFoundException {
        cyclists = new TDFFileReader(fileName).readFile();
    }
    public Set<String> getTeams(){
        Set<String> teams = new HashSet<>();
        for (Cyclist cyclist : cyclists){
            teams.add(cyclist.getTeam());
        }
        return teams;
        // Alternative one-liner below:
        // return getTeamsWithMembers().keySet();
    }

    public Map<String, Set<String>> getTeamsWithMembers(){
        Map<String, Set<String>> teamsWithMembers = new HashMap<>();

        for (Cyclist cyclist : cyclists){
            teamsWithMembers.putIfAbsent(cyclist.getTeam(), new HashSet<>());
            teamsWithMembers.get(cyclist.getTeam()).add(cyclist.getName());
        }

        return teamsWithMembers;
    }

    public Set<String> getTeamMembers(String team){
        return getTeamsWithMembers().get(team);
    }
}
