# 9/3 - solving recurrences

## Methods of solving recurrences
- Just open it up, and use your intuition, extrapolate
- Substitution method (if we know the answer)
- recursion tree method (very useful!)
- Master theorem (save our effort)

## Substitution method
How to solve this?
```
T(n) = 2T(floor n/2) + n

base case: T(1) = 1
```

1. Make a guess
     - E.g., T(n) = O(n log n)
2. Show it by induction
     - E.g., to show upper bound, we find constants c and n<sub>0</sub> such that T(n) <= c * f(n) for n = n<sub>0</sub>, n<sub>0</sub>+1, n<sub>0</sub>+2, ...

## Recursion tree method
