package cs316project;

public class Token
{
    private String token;
    private State state;
    private boolean isValid;

    public Token() {
        this("", State.Start, false);
    }

    public Token(String token, State state, boolean isValid) {
        this.token = token;
        this.state = state;
        this.isValid = isValid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
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
                ", state=" + state.toString() +
                ", isValid=" + isValid +
                '}';
    }
}
