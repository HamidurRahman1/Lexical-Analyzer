package cs316project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class FileReader
{
    private String file;

    public FileReader(String file)
    {
        this.file = file;
    }

    public List<String> getLines() throws IOException
    {
        return Files.readAllLines(Paths.get(this.file));
    }

    public List<String> getTokens(List<String> lines)
    {
        List<String> tokens = new LinkedList<>();

        lines.forEach(line ->
        {
            if(!line.trim().isEmpty())
            {
                String[] inp_tokens = line.split(" ");
                if(inp_tokens.length == 1) tokens.add(inp_tokens[0].trim());
                else
                {
                    for(int i = 0; i < inp_tokens.length; i++) tokens.add(inp_tokens[i].trim());
                }
            }
        });

        return tokens;
    }

}

