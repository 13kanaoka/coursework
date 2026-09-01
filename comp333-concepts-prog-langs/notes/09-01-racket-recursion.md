# 9/1 - Recursion in Racket

## factorial recursion
```racket
(define (fr n)
	(cond
		( (= n 0) 1 )
		( else (* n (fr (- n 1) )) )
	)
)

(fr 5)
;> 120
```

## sumlist recursion
```racket
(sumlist '(3 4 5) )
;> 12

; how does it work? -> recursion
(define (sumlist x)
	(cond
		( (empty? x) 0 ) 						; base case -> empty list
		( else (+ (car x) (sumlist (cdr x))) )  ; recursive case -> recurse on the sumlist of cdr
	)
)
```

## count items
```racket
(define (countitems x)
	(cond
		( (empty? x) 0)
		(else (+ 1 (countitems (cdr x))))
	)
)
```

## reverse list
```racket
(define (reverse-list x)
  (cond
    ( (empty? x) '() )
    ( else (append (reverse-list (cdr x)) (list (car x))))
    )
)
```

## Range
```racket
(range 1 5)
;> '(1 2 3 4)

(inclusive-range 1 5)
;> '(1 2 3 4 5)
```

## loop example
```racket
(define (fi n)
	(for ((i ( inclusive-range 1 n)))
		(println i)
	)
)

(fi 5)
; 1
; 2
; 3
; 4
; 5
```