package cs316project;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.LinkedList;
import java.util.List;

public class FileReader
{
    private String file;
    private List<String> tokens = new LinkedList<>();
    private List<String> lines = new LinkedList<>();

    public FileReader(String file)
    {
        this.file = file;
    }

    public FileReader getLines() throws IOException
    {
        this.lines = Files.readAllLines(Paths.get(this.file));
        return this;
    }

    public List<String> getTokens()
    {
        lines.forEach(line ->
        {
            if(!line.trim().isEmpty())
            {
                String[] inp_tokens = line.split(" ");
                if(inp_tokens.length == 1)
                {
                    if(!inp_tokens[0].trim().isEmpty()) tokens.add(inp_tokens[0].trim());
                }
                else
                {
                    for(int i = 0; i < inp_tokens.length; i++)
                    {
                        if(!inp_tokens[i].trim().isEmpty()) tokens.add(inp_tokens[i].trim());
                    }
                }
            }
        });

        return tokens;
    }

}

