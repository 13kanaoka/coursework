#lang racket

; -----------------------------------------------------------
; rand-list
; n = (int) # of nums in output
; rng = (int) range of possible nums 0 - rng-1
; output: list of n random nums in range 0 - rng-1
; -----------------------------------------------------------
(define (rand-list n rng)
  (cond
    ((= n 1) (list (random rng)))
    (else (cons (random rng) (rand-list (- n 1) rng)))
    ))

; test cases
(rand-list 10 10)
(rand-list 5 50)
(rand-list 8 2)


; -----------------------------------------------------------
; is-sorted?
; x = list
; output: #t if list is sorted, #f if not
; -----------------------------------------------------------
(define (is-sorted? x)
  (cond
    ((empty? x) #t)
    ((empty? (cdr x)) #t)
    ((<= (car x) (cadr x)) (is-sorted? (cdr x)))
    (else #f)
    ))

; test cases
(is-sorted? null) ; #t
(is-sorted? '(5)) ; #t
(is-sorted? '(5 4)) ; #f
(is-sorted? '(5 5)) ; #t
(is-sorted? '(4 5)) ; #t
(is-sorted? '(4 5 5)) ; #t
(is-sorted? '(5 5 4)) ; #f
(is-sorted? '(1 2 3 4 5)) ; #t
(is-sorted? '(5 5 5 5 5)) ; #t
(is-sorted? '(4 3 1 2 3)) ; #f
(is-sorted? '(1 2 3 4 3)) ; #f


; -----------------------------------------------------------
; split-list
; x = list of numbers x
; output: list of two lists which divide x into two equal sized sublists
; -----------------------------------------------------------
(define (split-list x)
  (define h (quotient (length x) 2))
  (list (take x h) (drop x h))
  )

; test cases
(split-list null) ; '(() ())
(split-list '(a)) ; '((a) ())
(split-list '(a b)) ; '((a) (b))
(split-list '(a b c)) ; '((a) (b c))
(split-list '(a b c d e)) ; '((a b) (c d e))