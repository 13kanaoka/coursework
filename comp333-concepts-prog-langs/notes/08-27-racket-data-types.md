# 8/27 - Racket Data Types

## Numbers
```text
          /> exact (int, rational)
numbers -
          \> inexact (decimal)
```
```racket
(exact->inexact x)
(inexact->exact x)
```

## Symbols (≈ variables / identifiers in most languages)
```text
x y z
large library of predefined functions
```

### assigning symbols (java vs racket)
#### java
```java
int x;
x = 5;
```
#### racket
```racket
(define x 5)
```

## Lists
Fundamental/core data structure in Racket
```racket
'(3 4 5 6 7)
'(a b c d)
'((a b) ((c d) (e f)) g)   ; nested list

; quote = treat the parens as literal list data,
; not as a function call to evaluate
```

## Lambda Expressions
Anonymous function - a binding between a param list and a function body that uses those params
```racket
; evaluating a lambda yields a procedure value
(lambda (x y) (+ (* 2 x) y))
;> #<procedure>
```
```racket
; call it inline:  2*x + y  with x=3, y=5
((lambda (x y) (+ (* 2 x) y)) 3 5)
;> 11
```
```racket
; bind the lambda to symbol f
(define f (lambda (x y) (+ (* 2 x) y)))
(f 3 5)
;> 11

; more common: define-form sugar that avoids lambda
(define (f x y) (+ (* 2 x) y))
(f 3 5)
;> 11
```

## More about lists
### construct lists
list
```racket
(list 3 4 5)
;> '(3 4 5)
```
cons
```racket
(cons 3 4)
;> '(3 . 4)          ; a pair, not a list

(cons 4 '())
;> '(4)

(cons 3 (cons 4 '()))
;> '(3 4)
```
append
```racket
(append '(a b c) '(p q r))   ; takes two or more lists
;> '(a b c p q r)

(append '(a b c) 'd)         ; non-list final arg -> improper list
;> '(a b c . d)
```

### decompose lists
car
```racket
(car '(a b c))   ; first element
;> 'a
```
cdr
```racket
(cdr '(a b c))   ; everything but the first
;> '(b c)
```
list-ref
```racket
(list-ref '(a b c) 0)   ; element at index 0
;> 'a
```

## if / else
```java
// java
if (a) return b;
else if (c) return d;
else return e;
```
```racket
; racket
(cond
    (a b)
    (c d)
    (else e))
```

### func with if-else
```racket
(define (f n)
    (cond
        ((= n 10) 20)
        ((= n 11) 30)
        (else 40)))
```

## Recursion
```python
# python
def fact(n):
    if n == 0:
        return 1

    return (n * fact(n - 1))
```
```racket
; racket
(define (fact n)
    (cond
        ((= n 0) 1)
        (else (* n (fact (- n 1))))))
```
