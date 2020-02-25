package cs316project;

public enum State
{
    // non-final states     ordinal number
    Start,                  // 0
    Period,                 // 1
    E,                      // 2
    EPlusMinus,             // 3

    // final states
    Id,                     // 4
    Int,                    // 5
    Float,                  // 6
    FloatE,                 // 7
    FloatF,                 // 8
    Plus,                   // 9
    Minus,                  // 10
    Times,                  // 11
    Div,                    // 12
    Lt,                     // 13
    Le,                     // 14
    Gt,                     // 15
    Ge,                     // 16
    Eq,                     // 17
    LParen,                 // 18
    RParen,                 // 19
    LBrace,                 // 20
    RBrace,                 // 21

    UNDEF;                  // 22

    public boolean isFinal()
    {
        return (this.compareTo(State.Id) >= 0);
    }
}
