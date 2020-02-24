package cs316project;

import java.io.IOException;
import java.util.List;

public class LexAnalyzer
{
    public static void main(String[] args) throws IOException
    {
        FileReader fileReader = new FileReader("src/cs316project/inps/in1.txt");
        List<String> lines = fileReader.getLines();
        System.out.println(fileReader.getTokens(lines).size());
    }
}
