package cs316project;

public enum State
{
    // non-final states     ordinal number
    Start,                  // 0
    Period,                 // 1
    E,                      // 2
    F,                      // 3
    EPlusMinus,             // 4

    // final states
    Id,                     // 5
    Int,                    // 6
    Float,                  // 7
    FloatE,                 // 8
    FloatF,                 // 9
    Plus,                   // 10
    Minus,                  // 11
    Times,                  // 12
    Div,                    // 13
    LParen,                 // 14
    RParen,                 // 15

    UNDEF;

    public boolean isFinal()
    {
        return (this.compareTo(State.Id) >= 0);
    }
}
