package cs316project;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LexAnalyzer
{
    public static void main(String[] args) throws IOException
    {
        List<String> tokens = new FileReader("src/cs316project/inps/in1.txt").getLines().getTokens();
        Tokenizer tokenizer = new Tokenizer();
        tokenizer.validateTokens(tokens);
    }
}
