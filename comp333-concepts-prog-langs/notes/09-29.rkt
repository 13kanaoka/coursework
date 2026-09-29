#lang racket

;==============================================
(define (next-est n est)
  (/ (+ est (/ n est)) 2)
  )

(define (get-est n est)
  (cond
    ((< (abs (- (expt est 2) n)) 0.0001) est)
    (else (get-est n (next-est n est)))
    ))

;(exact->inexact (get-est 2 1))
;(exact->inexact (get-est 10 1))
;(exact->inexact (get-est 25 1))
;(exact->inexact (get-est 40 1))
;==============================================



;==============================================
(define (int-list n)
  (range 2 n)
  )

(define (factor-list n)
  (filter (lambda (x) (= 0 (modulo n x))) (int-list n))
)

;(factor-list 12)
;(factor-list 13)
;(factor-list 100)

(define (is-prime? n) (empty? (factor-list n)))

;(is-prime? 10)
;(is-prime? 11)
;(is-prime? 12)
;(is-prime? 13)

(define (list-primes n) (filter is-prime? (inclusive-range 2 n)))

(displayln (list-primes 10))
(displayln (list-primes 100))
(displayln (list-primes 1000))

(length (list-primes 10))
(length (list-primes 100))
(length (list-primes 1000))