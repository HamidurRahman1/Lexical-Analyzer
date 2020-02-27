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

    public static int currentStream; // the current input character on "inputStream"
    public static char currentChar; // used to convert the variable "currentStream" to the char type whenever necessary

    // Returns the next character on the input stream.
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

    // Returns the next non-whitespace character on the input stream.
    // Returns -1, end-of-stream, if the end of the input stream is reached.
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

    // Sets the input and output streams to "inFile" and "outFile", respectively.
    // Sets the current input character "currentStream" to the first character on the input stream.
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
