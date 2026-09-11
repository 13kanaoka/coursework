#lang racket

; ---------------------------
; (rotate-left-1 x)
; x:  list
; result: list rotated by one
; ---------------------------
(define (rotate-left-1 x)
  (cond
    ((empty? (cdr x)) x)
    (else (append (cdr x) (list (car x))))
    )
 )

; test cases
(rotate-left-1 '(1 2 3 4 5))  ; '(2 3 4 5 1)


; -----------------------------
; (rotate-left-n x n)
; x:  list
; n:  number of times to rotate
; result: rotated list
; -----------------------------

(define (rotate-left-n x n)
  (cond
    ((= n 0) x)
    (else (rotate-left-n (rotate-left-1 x) (- n 1)))
    ))

; test cases
(rotate-left-n '(a b c d e f g h i j) 3)  ; '(d e f g h i j a b c)


; ---------------------------------------------
; (count-items x)
; x:  list
; result:  number of items in x (return length)
; ---------------------------------------------

(define (count-items x)
  (cond
    ((empty? x) 0)
    (else (+ 1 (count-items (cdr x))))
    ))

; test cases
(count-items '(1 2 3 4 5 6 7 8 9 10))  ; 10


; -------------------------
; (get-n x n)
; x:  list
; n:  index to get
; return:  number at index
; -------------------------

(define (get-n x n)
  (cond
    ((= n 0) (car x))
    (else (get-n (cdr x) (- n 1)))
    ))

; test cases
(get-n '(0 1 2 3 4 5) 5)  ; 5


; -------------------
; (del-n x n)
; x:  list
; n:  integer
; return:  list
; -------------------

; TO DO

; ---------------------------------------------------
; (cons-all n x)
; a:  item
; x:  list of lists
; return:  n added to the beginning of each list in x
; ---------------------------------------------------

(define (cons-all a x)
  (cond
    ((empty? (cdr x)) (list (cons a (car x))))
    (else (append (list (cons a (car x))) (cons-all a (cdr x))))
    ))

; test cases
(cons-all 1 '((2 3) (4 5) (6 7)))  ; '((1 2 3) (1 4 5) (1 6 7))