# 8/25 - Intro to C Syntax

Organized from the Java / C comparison chart. The rows where the two languages **differ** are the ones to actually memorize; the rest is muscle memory from Java.

## Same in Java and C

| Concept | Syntax |
|---|---|
| comment | `/* multi-line */` and `// single-line` |
| assignment | `i = i + j;` |
| block | `{ statement1; statement2; }` — braces optional around a single statement |
| conditional | `if (expression) block; else block;` |
| for loop | `for (init; condition; incr/decr) block;` |
| while loop | `while (condition) block;` |
| return | `return;` (procedure) / `return x;` (function) |
| break out of a loop | `break;` |
| skip to next iteration | `continue;` |
| function call | `x = m(y, z);` |
| procedure call | `m(y, z);` |
| equality / inequality | `==` , `!=` |
| arithmetic operators | unary `-` (negation), `+ - * / %` |
| character type | `char` |
| declare integer vars | `int i, j, k;` |
| function definition | `char a(int b) { ... return 'X'; }` |

### logical operators

| Operator | Meaning |
|---|---|
| `&` | AND — always evaluates both sides \* |
| `&&` | short-circuit AND — if the left side is false, the right side is not evaluated |
| `\|` | OR — always evaluates both sides \* |
| `\|\|` | short-circuit OR — if the left side is true, the right side is not evaluated |
| `!` | NOT |

\* In C, `&` and `|` on integer operands are **bitwise**, not logical — they only act "logical" when both sides are exactly `0` or `1`. Use `&&` / `||` for conditions. (See gotchas.)

## Differences (Java vs C)

| Concept | Java | C |
|---|---|---|
| string concatenation | `"a" + "b"` | no operator — use `strcat()` from `<string.h>` |
| integral types | `byte` 8-bit, `short` 16, `int` 32, `long` 64 — fixed widths | `short`, `int`, `long` — widths are machine dependent |
| floating-point types | `float` 32-bit, `double` 64 — fixed | `float`, `double` — machine dependent |
| boolean type | `boolean` | no built-in boolean; use `int`, or `#include <stdbool.h>` for `bool` |
| constant | `final int MAX = 100;` | `#define MAX 100` (preprocessor) or `const int MAX = 100;` |
| array declare + create | `int[] a = new int[10];` | `int a[10];` |
| 2-D array declare + create | `float[][] b = new float[10][100];` | `float b[10][100];` — cannot leave `[]` empty |
| string variable | `String s;` | `char *s;` |
| class / complex type | `class r { char a; int b; }` | `struct r { char a; int b; };` |
| pointer variable | no equivalent | `int *b = NULL;` |
| memory allocation | `ClassX x = new ClassX();` — sized by the JVM | `xtype *x; x = (xtype *) malloc(sizeof(xtype));` — sized manually |
| input | `Scanner sc = new Scanner(System.in);`<br>`int x = sc.nextInt();`<br>`float f = sc.nextFloat();`<br>`String s = sc.next();` | `int x; float y; char z[N];`<br>`scanf("%d", &x);`<br>`scanf("%f", &y);`<br>`scanf("%s", z);`<br>pass the **address**; an array name already decays to one |
| output | `System.out.println("... ASCII value " + (int) c);` | `printf("... ASCII value %d\n", (int) c);` |
| garbage collection | automatic | manual: `free(x);` |

## Gotchas / corrections to the handout

- **`bool.h` should be `<stdbool.h>`** — the C99 header that defines `bool`, `true`, `false`. Without it, C just uses `int` (`0` = false, non-zero = true).
- **C integer widths aren't purely "machine dependent"** — the standard guarantees minimums: `char` ≥ 8 bits, `short` ≥ 16, `int` ≥ 16, `long` ≥ 32, `long long` ≥ 64, with `sizeof(char) ≤ short ≤ int ≤ long`. For exact widths use `<stdint.h>` (`int32_t`, `uint8_t`, …).
- **`char` is not really "the same"** — Java `char` is 16-bit UTF-16; C `char` is 8 bits and may be signed or unsigned (implementation-defined).
- **Input row bugs in the chart:** `Scanner.nextFloat()` returns a `float`, not a `double`. `scanf("%s", z)` needs `z` to already point at writable space (a `char` array or `malloc`'d buffer), stops at the first whitespace, and has no bounds check — use a width, e.g. `scanf("%31s", z)` for a 32-byte buffer.
- **`int(c)` in the output row is not valid Java** — the cast is `(int) c`.
- **`#define` vs `const`:** `#define MAX 100` is pure text substitution by the preprocessor (no type, no scope, not visible to the debugger). `const int MAX = 100;` is a typed, scoped constant — usually the better choice in modern C.
- **Every `struct` definition ends with a semicolon:** `struct r { ... };` — forgetting it is a classic first-week C error.
