#lang racket

; ---------------------------
; (rotate-left-1 x)
; x:  list
; result: list rotated by one
; ---------------------------
(define (rotate-left-1 x)
  (cond
    ((empty? x) x)
    ((empty? (cdr x)) x)
    (else (append (cdr x) (list (car x))))
    )
 )

; test cases
(display "rotate-left-1")
(newline)
(rotate-left-1 '()) ; '()
(rotate-left-1 '(a)) ; '(a)
(rotate-left-1 '(a b c)) ; '(b c a)
(newline)




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
(display "rotate-left-n")
(newline)
(rotate-left-n '(a b c) 0) ; '(a b c)
(rotate-left-n '(a b c d e) 2) ; '(c d e a b)
(rotate-left-n '(a b c d e) 5) ; '(a b c d e)
(newline)




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
(display "count-items")
(newline)
(count-items '()) ; 0
(count-items '(a)) ; 1
(count-items '(a b c d e)) ; 5
(newline)




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
(display "get-n")
(newline)
(get-n '(a b c d e) 0) ; 'a
(get-n '(a b c d e) 4) ; 'e
(get-n '(a b c d e) 1) ; 'b
(newline)




; -------------------
; (del-n x n)
; x:  list
; n:  integer (position)
; return:  list with the nth element removed
; -------------------
(define (del-n x n)
  (cond
    ((= n 0) (cdr x))
    (else (cons (car x) (del-n (cdr x) (- n 1))))
    ))

; test cases
(display "del-n")
(newline)
(del-n '(a b c d e) 0)  ; '(b c d e)
(del-n '(a b c d e) 1)  ; '(a c d e)
(del-n '(a b c d e) 2)  ; '(a b d e)
(del-n '(a b c d e) 4)  ; '(a b c d)
(newline)




; -----------------------------------------------------
; (rotate-right-1 x)
; x:  list
; return:  list rotated right by one
; -----------------------------------------------------
(define (rotate-right-1 x)
  (cond
    ((empty? x) x)
    (else
      (define n (- (count-items x) 1))
      (cons (get-n x n) (del-n x n)))
  ))

; test cases
(display "rotate-right-1")
(newline)
(rotate-right-1 '())
(rotate-right-1 '(a b c d e)) ; '(e a b c d)
(rotate-right-1 '(a)) ; '(a)
(rotate-right-1 '(a b)) ; '(b a)
(rotate-right-1 '(a b c d e f g)) ; '(g a b c d e f)
(newline)




; -----------------------------------------------------
; (reverse-list x)
; x:  list
; return:  list with items in reverse order
; -----------------------------------------------------
(define (reverse-list x)
  (cond
    ((empty? x) x)
    ((empty? (cdr x)) x)
    (else (append (reverse-list (cdr x)) (list (car x))))
  ))

; test cases
(display "reverse-list")
(newline)
(reverse-list '(a)) ; '(a)
(reverse-list '(a b)) ; '(b a)
(reverse-list '(a b c d e)) ; '(e d c b a)
(newline)




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
(display "cons-all")
(newline)
(cons-all 'a '((b c) (d e) (f g))) ; '((a b c) (a d e) (a f g))
(newline)




; -----------------------------------------------------
; (ph-1 x n)
; x:  list
; n:  integer (position)
; return:  list of lists -> nth element cons'd onto each
;          permutation
; -----------------------------------------------------
(define (ph-1 x n)
  (cons-all (get-n x n) (perm (del-n x n)))
  )


; -----------------------------------------------------
; (ph-2 x n)
; x:  list
; n:  integer (length x - 1)
; return:  list of lists -> ph-1 evaluated for every
;          position 0 through n, all appended together
; -----------------------------------------------------
(define (ph-2 x n)
  (cond
    ((= n 0) (ph-1 x n))
    (else (append (ph-1 x n) (ph-2 x (- n 1))))
   ))


; -----------------------------------------------------
; (perm x)
; x:  list
; return:  list of lists of all permutations of x
; -----------------------------------------------------

(define (perm x)
  (cond
    ((empty? x) null)
    ((empty? (cdr x)) (list x))
    ((empty? (cddr x)) (list x (reverse x)))
    (else (ph-2 x (- (length x) 1)))
  )
)

; test cases
(display "perm")
(newline)
(perm '(a b)) ; '((a b) (b a)) 2! = 2 permutations
(perm '(a b c)) ; '((c a b) (c b a) (b a c) (b c a) (a b c) (a c b)) 3! = 6 permutations
(perm '(a b c d))
; '((d c a b) (d c b a) (d b a c) (d b c a) (d a b c) 4! = 24 permutations
; (d a c b) (c d a b) (c d b a) (c b a d) (c b d a)
; (c a b d) (c a d b) (b d a c) (b d c a) (b c a d)
; (b c d a) (b a c d) (b a d c) (a d b c) (a d c b)
; (a c b d) (a c d b) (a b c d) (a b d c))