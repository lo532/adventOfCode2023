import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new FileReader("/Users/lota/IdeaProjects/AdventOfCode2023/input_2.txt"));
        Finder gameFinder = new Finder();
        String line;
        int counter = 0;
        while ((line = br.readLine()) != null ) {
            counter += gameFinder.getFewestNumberOfCubes(line);
        }
        System.out.println(counter);
    }
}