# Project--LexicalAnalyzer

<div font="monaco">
  <pre>Consider the following EBNF defining 18 token categories ⟨id⟩ through ⟨RBrace⟩:

⟨letter⟩ → a | b | ... | z | A | B | ... | Z
⟨digit⟩ → 0 | 1 | ... | 9
⟨id⟩ → ⟨letter⟩ {⟨letter⟩ | ⟨digit⟩}
⟨int⟩ → [+|−] {⟨digit⟩}+
⟨float⟩ → [+|−] ( {⟨digit⟩}+ "." {⟨digit⟩}  |  "." {⟨digit⟩}+ )
⟨floatE⟩ → (⟨int⟩ | ⟨float⟩) (e|E) [+|−] {⟨digit⟩}+
⟨floatF⟩ → (⟨int⟩ | ⟨float⟩ | ⟨floatE⟩) ("f" | "F")
⟨add⟩ → +
⟨sub⟩ → −
⟨mul⟩ → *
⟨div⟩ → /
⟨lt⟩ → <
⟨le⟩ → "<="
⟨gt⟩ → >
⟨ge⟩ → ">="
⟨eq⟩ → =
⟨LParen⟩ → (
⟨RParen⟩ → )
⟨LBrace⟩ → {
⟨RBrace⟩ → }
</pre>

<p>⟨letter⟩ and ⟨digit⟩ are not token categories by themselves; rather, they are auxiliary categories to assist the definitions of the tokens ⟨id⟩, ⟨int⟩, ⟨float⟩, ⟨floatE⟩, ⟨floatF⟩.</p>

According to the above definitions, the integers and floating-point numbers may be signed with "+" or "−". Moreover, the integer or fractional part, but not both, of a string in ⟨float⟩ may be empty. The following is a DFA to accept the 18 token categories.

The objective of this project is to implement a lexical analyzer that accepts the 18 token categories plus the following keywords, all in lowercase letters only:

<pre>if, then, else, or, and, not, pair, first, second, nil</pre>

These keywords cannot be used as identifiers, but can be parts of identifiers, like "iff" and "delse". In this and the next three projects, the identifiers and keywords are case-sensitive. The implementation should be based on the above DFA. Your lexical analyzer program should clearly separate the driver and the state-transition function so that the driver will remain invariant and only state-transition functions will change from DFA to DFA. The enumerated or integer type is suggested for representation of states.

The following keyword recognition method is adequate for this project.
Create 10 additional DFA states for the keywords.
The DFA initially accepts the keywords as identifiers.
Each time the DFA accepts an identifier, check if it is one of the keywords, and if so, move the DFA to the corresponding keyword state.

The lexical analyzer program is to read an input text file, extract the tokens in it, and write them out one by one on separate lines. Each token should be flagged with its category. The output should be sent to an output text file. Whenever invalid tokens are found, error messages should be printed, and the reading process should continue.
</div>
