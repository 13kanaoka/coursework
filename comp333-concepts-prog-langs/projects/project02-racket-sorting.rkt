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


; -----------------------------------------------------------
; split-list
; x = list of numbers x
; output: list of two lists which divide x into two equal sized sublists
; -----------------------------------------------------------
(define (split-list x)
  (define h (quotient (length x) 2))
  (list (take x h) (drop x h))
  )


; -----------------------------------------------------------
; merge-lists
; x = sorted list
; y = sorted list
; output: one sorted list from combined x and y
; -----------------------------------------------------------
(define (merge-lists x y)
  (cond
    ((empty? x) y)
    ((empty? y) x)
    ((<= (car x) (car y)) (cons (car x) (merge-lists (cdr x) y)))
    (else (cons (car y) (merge-lists x (cdr y))))
    ))


; -----------------------------------------------------------
; merge-sort
; x = list of nums
; output: sorted list of numbers
; -----------------------------------------------------------
(define (merge-sort x)
  (cond 
    ((or (empty? x) (empty? (cdr x))) x)
    (else 
     (define tmp (split-list x))
     (define a (car tmp))
     (define b (cadr tmp))
     (merge-lists (merge-sort a) (merge-sort b)))
    ))