#lang racket

(define (next-est n est)
  (/ (+ est (/ n est)) 2)
  )

(define (get-est n est)
  (cond
    ((< (abs (- (expt est 2) n)) 0.001) est)
    (else (get-est n (next-est n est)))
    ))