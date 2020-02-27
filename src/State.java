
public enum State
{
    // non-final states     ordinal number
    Start,                  // 0
    Dot,                    // 1
    E,                      // 2
    EPlusMinus,             // 3

    // final states
    Id,                     // 4
    Int,                    // 5
    Float,                  // 6
    FloatE,                 // 7
    FloatF,                 // 8
    Add,                    // 9
    Sub,                    // 10
    Mul,                    // 11
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

    Keyword_if,             // 22
    Keyword_then,           // 23
    Keyword_else,           // 24
    Keyword_or,             // 25
    Keyword_and,            // 26
    Keyword_not,            // 27
    Keyword_pair,           // 28
    Keyword_first,          // 29
    Keyword_second,         // 30
    Keyword_nil,            // 31

    UNDEF;                  // 32

    public boolean isFinal()
    {
        return (this.compareTo(State.Id) >= 0);
    }
}
