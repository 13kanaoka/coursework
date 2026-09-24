#lang racket

; -----------------------------------------------------------------
; returns list from 2 to n - 1
(define (int-list n)
    (range 2 n)
)

; test cases
(display "int-list")
(newline)
(int-list 5)
(int-list 2)
(int-list 10)
(newline)
; -----------------------------------------------------------------


; -----------------------------------------------------------------
; returns a new list with only the factors of n remaining
(define (factor-list n)
  (filter (lambda (x)(= 0 (modulo n x))) (int-list n))
  )

; test cases
(display "factor-list")
(newline)
(factor-list 5)
(factor-list 6)
(factor-list 12)
(factor-list 100)
(newline)
; -----------------------------------------------------------------


; -----------------------------------------------------------------
; returns T or F depending on if n is prime
(define (is-prime? n)
  (empty? (factor-list n))
  )

; test cases
(display "is-prime?")
(newline)
(is-prime? 2)
(is-prime? 3)
(is-prime? 10)
(is-prime? 11)
(newline)
; -----------------------------------------------------------------