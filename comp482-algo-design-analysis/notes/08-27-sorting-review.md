# 8/27 - Sorting Review

> Expanded from a stub — reconcile against lecture. Framed for analysis: comparison model, asymptotics, in-place, stability.

## Why review sorting
- Shared baseline for every analysis technique in the course: loop invariants, recurrences, best/avg/worst case, lower bounds.
- **Comparison model:** the algorithm may only compare elements (`<`, `>`, `==`) — no arithmetic on keys. Everything below except counting/radix/bucket is a comparison sort.
- Vocabulary:
	- **in-place** - `O(1)` (or `O(log n)`) extra space beyond the input array
	- **stable** - equal keys keep their original relative order
	- **adaptive** - runs faster when the input is already partly sorted

## Elementary sorts - Θ(n²)

### Selection sort
Idea: repeatedly select the smallest element of the unsorted suffix and swap it into place.
```text
selectionSort(A):
  for i = 0 to n-2:
    min = i
    for j = i+1 to n-1:
      if A[j] < A[min]: min = j
    swap A[i], A[min]
```
- Invariant: after iteration `i`, `A[0..i]` holds the `i+1` smallest elements, sorted.
- Comparisons: always `(n-1) + (n-2) + ... + 1 = n(n-1)/2 = Θ(n²)` — best = average = worst.
- Swaps: `Θ(n)` (one per outer pass) — useful when writes are expensive.
- In-place. **Not stable** (the long-distance swap can reorder equal keys). Not adaptive.

### Insertion sort
Idea: grow a sorted prefix; take the next element and shift it left into position.
```text
insertionSort(A):
  for i = 1 to n-1:
    key = A[i]
    j = i - 1
    while j >= 0 and A[j] > key:
      A[j+1] = A[j]
      j = j - 1
    A[j+1] = key
```
- Best case (already sorted): `Θ(n)` — inner loop never runs. **Adaptive.**
- Average and worst (reverse sorted): `Θ(n²)`.
- In-place. **Stable** (guard is `>`, not `>=`).
- Best elementary sort in practice; commonly used as the base case for quicksort / merge sort on small subarrays.

### Bubble sort
Idea: sweep the array, swapping adjacent out-of-order pairs; the largest element "bubbles" to the end each pass.
```text
bubbleSort(A):
  for i = 0 to n-2:
    swapped = false
    for j = 0 to n-2-i:
      if A[j] > A[j+1]:
        swap A[j], A[j+1]
        swapped = true
    if not swapped: break        # early exit -> Θ(n) on sorted input
```
- Average and worst: `Θ(n²)`. Best (with the early-exit flag): `Θ(n)`.
- In-place. **Stable.** Mostly pedagogical — more swaps than insertion sort for the same asymptotics.

## Divide-and-conquer sorts - Θ(n log n)

### Merge sort
Idea: split in half, sort each half recursively, merge the two sorted halves.
```text
mergeSort(A, lo, hi):
  if lo >= hi: return
  mid = (lo + hi) / 2
  mergeSort(A, lo, mid)
  mergeSort(A, mid+1, hi)
  merge(A, lo, mid, hi)          # linear scan of two runs into a temp buffer
```
- Recurrence: `T(n) = 2T(n/2) + Θ(n)` → `Θ(n log n)` (Master Theorem, case 2). Best = average = worst.
- **Not in-place:** `Θ(n)` auxiliary array for the merge; `Θ(log n)` recursion stack.
- **Stable** (break merge ties toward the left run).
- Preferred when stability matters, or for external / linked-list data.

### Quicksort
Idea: pick a pivot, partition so `left ≤ pivot ≤ right`, recurse on both sides.
```text
quickSort(A, lo, hi):
  if lo >= hi: return
  p = partition(A, lo, hi)       # Lomuto or Hoare; returns final pivot index
  quickSort(A, lo, p-1)
  quickSort(A, p+1, hi)
```
- Average: `Θ(n log n)` expected over random pivots (balanced splits give `T(n) = 2T(n/2) + Θ(n)`).
- Worst: `Θ(n²)` — e.g. already-sorted input with a first/last-element pivot, or all-equal keys with Lomuto partition.
- Mitigations: randomized pivot, median-of-three, or introsort (switch to heapsort past recursion depth `2 log n`).
- **In-place** (`Θ(log n)` stack using the recurse-smaller-side-first trick). **Not stable.**
- Usually fastest in practice for in-memory arrays: good cache locality, tight inner loop.

### Heapsort
Idea: build a max-heap in the array, then repeatedly move the root to the end and sift down.
```text
heapSort(A):
  buildMaxHeap(A)                # Θ(n)
  for i = n-1 down to 1:
    swap A[0], A[i]
    siftDown(A, 0, i)            # Θ(log n) each
```
- `Θ(n log n)` best = average = worst.
- **In-place**, `O(1)` extra. **Not stable.**
- No `Θ(n²)` failure mode, but larger constants and worse locality than quicksort.

## Lower bound for comparison sorts
- Any comparison sort maps to a binary **decision tree**: internal node = one comparison, leaf = one of the `n!` possible orderings of the input.
- A tree of height `h` has at most `2^h` leaves, so `2^h ≥ n!` → `h ≥ log₂(n!) = Θ(n log n)` (Stirling's approximation).
- ⇒ **every comparison sort is Ω(n log n)** in the worst case. Merge sort and heapsort are asymptotically optimal.

## Beating n log n (non-comparison sorts)
Only possible by assuming something about the keys:

| Sort | Assumption | Time | Stable | In-place |
|---|---|---|---|---|
| Counting sort | integer keys in a small range `[0, k]` | `Θ(n + k)` | yes | no |
| Radix sort | fixed-width keys, `d` digits in base `b` (LSD, stable counting per digit) | `Θ(d(n + b))` | yes | no |
| Bucket sort | keys roughly uniform over an interval | `Θ(n)` expected | yes | no |

## Summary

| Sort | Best | Average | Worst | Space | Stable | Adaptive |
|---|---|---|---|---|---|---|
| Selection | Θ(n²) | Θ(n²) | Θ(n²) | O(1) | no | no |
| Insertion | Θ(n) | Θ(n²) | Θ(n²) | O(1) | yes | yes |
| Bubble | Θ(n) | Θ(n²) | Θ(n²) | O(1) | yes | yes |
| Merge | Θ(n log n) | Θ(n log n) | Θ(n log n) | Θ(n) | yes | no |
| Quick | Θ(n log n) | Θ(n log n) | Θ(n²) | O(log n) | no | no |
| Heap | Θ(n log n) | Θ(n log n) | Θ(n log n) | O(1) | no | no |
