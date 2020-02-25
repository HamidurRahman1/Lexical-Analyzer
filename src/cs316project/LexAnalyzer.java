package cs316project;

import java.io.IOException;
import java.util.LinkedList;
import java.util.List;

public class LexAnalyzer
{
    private List<Token> tokens = new LinkedList<>();

    public void validateTokens(List<String> tokens)
    {
        if(tokens == null) throw new NullPointerException("Null list given.");

        tokens.forEach(token -> driver(token));
    }

    private void driver(String originalToken)
    {
        Token token = new Token();
        State nextState;

        for(int i = 0; i < originalToken.length(); i++)
        {
            char c = originalToken.charAt(i);
            nextState = nextState(token.getState(), c);

            if(nextState == State.UNDEF)
            {
                if(token.getState().isFinal())
                {
                    Token t1 = new Token(token.getToken()+String.valueOf(c), token.getState(), true);
                    tokens.add(t1);
                    token = new Token("", State.Start, false);
                }
                else
                {
                    Token t1 = new Token(token.getToken()+String.valueOf(c), token.getState(), false);
                    tokens.add(t1);
                    System.out.println(t1.getToken()+" : Lexical Error, invalid token");
                    token = new Token("", State.Start, false);
                }
            }
            else
            {
                token.setState(nextState);
                token.setToken(token.getToken()+c);
            }
        }

        if(token.getState().isFinal())
        {
            token.setValid(true);
            tokens.add(token);
        }
    }

    private State nextState(State state, char c)
    {
        switch (state)
        {
            case Start:
                if(Character.isLetter(c))
                    return State.Id;
                if(Character.isDigit(c))
                    return State.Int;
                else if(c == '+')
                    return State.Plus;
                else if (c == '-')
                    return State.Minus;
                else if (c == '*')
                    return State.Times;
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
            case Period:
                if (Character.isDigit(c))
                    return State.Float;
                else
                    return State.UNDEF;
            case Id:
                if(Character.isLetterOrDigit(c))
                    return State.Id;
                else
                    return State.UNDEF;
            case Plus:
                if(Character.isDigit(c))
                    return State.Int;
                else if(c == '.')
                    return State.Period;
                else
                    return State.UNDEF;
            case Minus:
                if(Character.isDigit(c))
                    return State.Int;
                else if(c == '.')
                    return State.Period;
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
                else
                    return State.UNDEF;
            default:
                return State.UNDEF;
        }
    }

    public static void main(String[] args) throws IOException
    {
        List<String> tokens = new FileReader("src/cs316project/inps/in1.txt").getLines().getTokens();
        LexAnalyzer lexAnalyzer = new LexAnalyzer();
        lexAnalyzer.validateTokens(tokens);
        lexAnalyzer.tokens.forEach(token ->
        {
            if(token.isValid())
            {
                System.out.println(token.getToken() + " : " + token.getState());
            }
            else
            {
                System.out.println(token.getToken() + " : Lexical Error, invalid token");
            }
        });
    }
}
