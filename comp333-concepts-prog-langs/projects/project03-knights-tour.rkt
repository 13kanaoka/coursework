#lang racket

(define (get-board dim) (list dim (make-list (* dim dim) 0 )))
(define (rc->index rc dim) (+ (* (car rc) dim) (cadr rc)))
(define (update-board b rc v) (list (car b) (list-set (cadr b) (rc->index rc (car b)) v)))

(define (display-cell b rc)
  (let ((v (list-ref (cadr b) (rc->index rc (car b)))))
    (display " ") )
   ))





; test cases

; (define B (get-board 8))
; (display-board B)
; more is supposed to be here but I missed it


(define offsets '((-2 1) (-1 2) (1 2) (2 1) (2 -1) (1 -2) (-1 -2) (-2 -1)))

(define (moves rc)
  (map (lambda (mv) (map + rc mv)) offsets)
  )

(define (on-board? rc dim)
  (and (<= 0 (car rc)) (< (car rc) dim) (<= 0 (cadr rc)) (< (cadr rc) dim))
  )
(define (on-board-moves rc dim)
  (filter (lambda (mv) (ob-board? mv dim)) (moves rc))
  )

(define (unvisited? b rc)
  (= 0 (list-ref (cadr b) (rc->index rc (car b))))
  )
(define (get-unvisited-moves b rc)
  (filter (lambda (mv) (unvisited? b mv)) (on-board-moves rc (car b)))
  )

(define (get-two-step-moves b rc)
  (map (lambda (mv) (get-unvisited-moves b mv)) (get-unvisited-moves b rc))
  )

(define (best-move b rc)
  (let ((list1 (get-unvisited-moves b rc)))
    (cond
      ((empty? list1) null)
      (else
       (let* ((list2 (get-two-step-moves b rc))
              (list3 (map length list2))
              (index (index-of list3 (apply min list3)))
              )
         (list-ref list1 index)
         )))))

(define (tour dim rc)
  (tour-h (get-board dim) rc 1)
  )
(define (tour-h b rc step)
  (let* ((b1 (update-board b rc step))
         (nm (best-move b1 rc)))
    (display-board b1)
    (cond
      ((empty? nm) (displayln "done"))
      (else (tour-h b1 nm (+ step 1)))
      )))