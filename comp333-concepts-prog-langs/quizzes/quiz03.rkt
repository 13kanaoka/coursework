#lang racket

; ------------------------------------------------------
; int-list
; a = int (start of list)
; b = int (end of list, inclusive)
; return = completed list from a -> b
; ------------------------------------------------------
(define (int-list a b)
  (cond
    ((equal? a b) (list a))
    (else (cons a (int-list (+ a 1) b)))
  ))

;test cases
(int-list 5 5)
(int-list 5 10)

; ------------------------------------------------------
; member?
; a = int
; x = list
; return = #t if a in x, else #f
; ------------------------------------------------------
(define (member? a x)
  (cond
    ((empty? x) #f)
    ((equal? a (car x)) #t)
    (else (member? a (cdr x)))
    ))

; test cases
(member? 3 '(1 2 3))
(member? 3 '(4 5 6))

; ------------------------------------------------------
; missing
; y = list
; determine all values missing from y
; ------------------------------------------------------
(define (missing y)
  (define z (int-list 1 9))
  (filter (lambda (x) (not (member? x y))) z)
 )

; test cases
(missing '(0 0 0 0 0 0 0 0 0))
(missing '(0 1 0 0 0 0 0 0 0))
(missing '(1 2 3 0 5 6 7 0 9))
(missing '(9 8 7 6 5 4 3 2 1))
(missing '(0 2 3 0 0 0 4 5 7))