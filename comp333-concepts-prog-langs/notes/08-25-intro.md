# 8/25 — Intro to Racket

## Racket
Racket is not an industrial-level language, but a prototyping language used to test and play with fundamental parts of a program during the planning phase.

### REPL
- **R**ead
- **E**val
- **P**rint
- **L**oop

## Prefix Notation for Functions

| Typical | Racket |
|---|---|
| `fibonacci(n)` | `(fibonacci n)` |
| `3 + 5` | `(+ 3 5)` |
| `27 * 3 + 54 * 2` | `(+ (* 27 3) (* 54 2))` |

Function calls are themselves written as lists, e.g. `(+ 3 5)`:
- `+` is the function
- `3` and `5` are the parameters

## Lists
- `(5 10 15 20)`
- `(a b c d e)`
- `((a b c) (d e f) (g h i))`

### Empty lists
Represented as `null` or `'()`
```racket
(empty? '())       ; #t
(empty? '(1 2 3))  ; #f
```

### List commands
```racket
x = '(5 10 15 20)
```
- `(car x)` → first element → `5`
- `(cdr x)` → rest of the list (everything *except* the first element) → `'(10 15 20)`

### Recursive functions
```racket
(define (sumlist x)
  (cond
    [(empty? x) 0]
    [else (+ (car x) (sumlist (cdr x)))]))
```

- **Base case:** `(empty? x)` → returns `0`
- **Recursive case:** `(+ (car x) (sumlist (cdr x)))`