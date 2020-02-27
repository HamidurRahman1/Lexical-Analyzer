public class LexAnalyzer extends FileUtil
{
    public static String t;
    public static State state;

    private static int driver()
    {
        State nextSt;

        t = "";

        state = State.Start;

        if(Character.isWhitespace((char) currentStream))
            currentStream = getChar();
        if(currentStream == -1)
            return -1;

        while(currentStream != -1)
        {
            currentChar = (char) currentStream;
            nextSt = nextState(state, currentChar);

            if(nextSt == State.UNDEF)
            {
                if(state.isFinal())
                {
                    State possibleKeyword = isKeyword();

                    if(State.UNDEF != possibleKeyword)
                    {
                        state = possibleKeyword;
                        return 1;
                    }
                    return 1;
                }
                else
                {
                    t = t+ currentChar;
                    currentStream = getNextChar();
                    return 0;
                }
            }
            else
            {
                state = nextSt;
                t = t+ currentChar;
                currentStream = getNextChar();
            }
        }

        if(state.isFinal())
        {
            State possibleKeyword = isKeyword();

            if(State.UNDEF != possibleKeyword)
            {
                state = possibleKeyword;
                return 1;
            }
            return 1;
        }
        else
        {
            return 0;
        }
    }

    public static void getToken()
    {
        int i = driver();
        if ( i == 0 )
            displayln(t + " : Lexical Error, invalid token");
    }

    private static State nextState(State state, char c)
    {
        switch (state)
        {
            case Start:
                if(Character.isLetter(c))
                    return State.Id;
                if(Character.isDigit(c))
                    return State.Int;
                else if(c == '+')
                    return State.Add;
                else if (c == '-')
                    return State.Sub;
                else if (c == '.')
                    return State.Dot;
                else if (c == '*')
                    return State.Mul;
                else if (c == '/')
                    return State.Div;
                else if (c == '<')
                    return State.Lt;
                else if (c == '>')
                    return State.Gt;
                else if (c == '=')
                    return State.Eq;
                else if (c == '(')
                    return State.LParen;
                else if (c == ')')
                    return State.RParen;
                else if (c == '{')
                    return State.LBrace;
                else if (c == '}')
                    return State.RBrace;
                else
                    return State.UNDEF;
            case Lt:
                if(c == '=')
                    return State.Le;
                else
                    return State.UNDEF;
            case Gt:
                if(c == '=')
                    return State.Ge;
                else
                    return State.UNDEF;
            case Dot:
                if (Character.isDigit(c))
                    return State.Float;
                else
                    return State.UNDEF;
            case Id:
//                if(t.equals("if"))
//                        return State.Keyword_if;
//                else if(t.equals("then"))
//                    return State.Keyword_then;
//                else if(t.equals("else"))
//                    return State.Keyword_else;
//                else if(t.equals("or"))
//                        return State.Keyword_or;
//                else
                if(Character.isLetterOrDigit(c))
                    return State.Id;
                else
                    return State.UNDEF;
            case Add:
                if(Character.isDigit(c))
                    return State.Int;
                else if(c == '.')
                    return State.Dot;
                else
                    return State.UNDEF;
            case Sub:
                if(Character.isDigit(c))
                    return State.Int;
                else if(c == '.')
                    return State.Dot;
                else
                    return State.UNDEF;
            case Int:
                if(Character.isDigit(c))
                    return State.Int;
                else if(c == '.')
                    return State.Float;
                else if(c == 'e' || c == 'E')
                    return State.E;
                else if(c == 'f' || c == 'F')
                    return State.FloatF;
                else
                    return State.UNDEF;
            case Float:
                if(Character.isDigit(c))
                    return State.Float;
                else if(c == 'e' || c == 'E')
                    return State.E;
                else if(c == 'f' || c == 'F')
                    return State.FloatF;
                else
                    return State.UNDEF;
            case E:
                if(Character.isDigit(c))
                    return State.FloatE;
                else if(c == '+' || c == '-')
                    return State.EPlusMinus;
                else
                    return State.UNDEF;
            case EPlusMinus:
                if(Character.isDigit(c))
                    return State.FloatE;
                else
                    return State.UNDEF;
            case FloatE:
                if(Character.isDigit(c))
                    return State.FloatE;
                else if(c == 'f' || c == 'F')
                    return State.FloatF;
                else
                    return State.UNDEF;
            default:
                return State.UNDEF;
        }
    }

    public static State isKeyword()
    {
        switch (t)
        {
            case "if":
                return State.Keyword_if;
            case "then":
                return State.Keyword_then;
            case "else":
                return State.Keyword_else;
            case "or":
                return State.Keyword_or;
            case "and":
                return State.Keyword_and;
            case "not":
                return State.Keyword_not;
            case "pair":
                return State.Keyword_pair;
            case "first":
                return State.Keyword_first;
            case "second":
                return State.Keyword_second;
            case "nil":
                return State.Keyword_nil;
            default:
                return State.UNDEF;
        }
    }

    public static void main(String argv[])
    {
//        setIO(argv[0], argv[1]);

        setIO("/Users/hamidurrahman/Downloads/GitHub/Project--LexicalAnalyzer/src/inputs/in7.txt",
                "/Users/hamidurrahman/Downloads/GitHub/Project--LexicalAnalyzer/src/outputs/out1.txt");

        int i;

        while (currentStream != -1)
        {
            i = driver();
            if (i == 1)
                displayln( t + "   : " + state.toString());
            else if (i == 0)
                displayln( t + " : Lexical Error, invalid token");
        }

        closeIO();
    }
}
