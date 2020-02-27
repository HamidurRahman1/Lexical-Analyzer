
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

public class FileUtil
{
    public static BufferedReader inputStream;
    public static PrintWriter outputStream;

    public static int currentStream;
    public static char currentChar;

    public static int getNextChar()
    {
        try
        {
            return inputStream.read();
        }
        catch(IOException e)
        {
            e.printStackTrace();
            return -1;
        }
    }

    public static int getChar()
    {
        int i = getNextChar();
        while (Character.isWhitespace((char)i))
            i = getNextChar();
        return i;
    }

    public static void display(String s)
    {
        outputStream.print(s);
    }

    public static void displayln(String s)
    {
        outputStream.println(s);
    }

    public static void setIO(String inFile, String outFile)
    {
        try
        {
            inputStream = new BufferedReader(new FileReader(inFile));
            outputStream = new PrintWriter(new FileOutputStream(outFile));
            currentStream = inputStream.read();
        }
        catch(FileNotFoundException e)
        {
            e.printStackTrace();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }

    public static void closeIO()
    {
        try
        {
            inputStream.close();
            outputStream.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
