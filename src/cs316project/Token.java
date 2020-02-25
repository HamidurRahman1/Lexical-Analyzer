package cs316project;

public class Token
{
    private String token;
    private StringBuilder tokenValue;
    private State state;
    private boolean isValid;

    public Token() {
    }

    public Token(String token) {
        this.state = State.Start;
        this.token = token;
        this.tokenValue = new StringBuilder();
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public StringBuilder getTokenValue() {
        return tokenValue;
    }

    public void setTokenValue(StringBuilder tokenValue) {
        this.tokenValue = tokenValue;
    }

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Token{" +
                "token='" + token + '\'' +
                ", tokenValue='" + tokenValue.toString() + '\'' +
                ", state=" + state +
                '}';
    }
}
