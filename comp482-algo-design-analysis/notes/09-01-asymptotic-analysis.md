# 9/1 - asymptotic analysis

## Merge Sort
```
T(n) = T(n / 2) + T(n / 2) + c1n + c2
     = 2T(n / 2) + cn
```

## Asymptotic notation: O, o, Ω, ω, Θ

Each is a **set of functions** defined relative to `g(n)`. "`f(n) = O(g(n))`" is the standard abuse of notation for "`f(n) ∈ O(g(n))`".

### The five, as comparisons
| Notation | Bound | Analogy | Definition (for `n ≥ n₀`) |
|---|---|---|---|
| `O(g)` | upper bound (tight or loose) | `f ≤ g` | `∃ c, n₀ > 0` such that `0 ≤ f(n) ≤ c·g(n)` |
| `Ω(g)` | lower bound (tight or loose) | `f ≥ g` | `∃ c, n₀ > 0` such that `0 ≤ c·g(n) ≤ f(n)` |
| `Θ(g)` | tight bound (both) | `f = g` | `∃ c₁, c₂, n₀ > 0` such that `0 ≤ c₁·g(n) ≤ f(n) ≤ c₂·g(n)` |
| `o(g)` | strict upper bound | `f < g` | `∀ c > 0, ∃ n₀` such that `0 ≤ f(n) < c·g(n)` |
| `ω(g)` | strict lower bound | `f > g` | `∀ c > 0, ∃ n₀` such that `0 ≤ c·g(n) < f(n)` |

Big vs little: big-O/Ω need the inequality for **some** constant `c`; little-o/ω need it for **every** `c` → the ratio actually goes to 0 (or ∞).

### Relationships
- **Θ = O ∩ Ω:**  `f(n) = Θ(g(n))  ⟺  f(n) = O(g(n))` **and** `f(n) = Ω(g(n))`.
- **Transpose symmetry:**
  - `f(n) = O(g(n))  ⟺  g(n) = Ω(f(n))`
  - `f(n) = o(g(n))  ⟺  g(n) = ω(f(n))`
- **Θ is symmetric:**  `f(n) = Θ(g(n))  ⟺  g(n) = Θ(f(n))`.
- **Little implies big (strict ⇒ non-strict):**
  - `f(n) = o(g(n))  ⟹  f(n) = O(g(n))`  (but not the reverse)
  - `f(n) = ω(g(n))  ⟹  f(n) = Ω(g(n))`
- `o` and `ω` are mutually exclusive with `Θ`: if `f = o(g)` or `f = ω(g)`, then `f ≠ Θ(g)`.

### Limit test (when the limit exists)
```
lim f(n)/g(n) = 0        ⟹  f = o(g)   (so also O, not Ω/Θ)
lim f(n)/g(n) = c, 0<c<∞ ⟹  f = Θ(g)  (so also O and Ω)
lim f(n)/g(n) = ∞        ⟹  f = ω(g)   (so also Ω, not O/Θ)
```
Not every pair is comparable — e.g. `sin n` vs `cos n` fit none of these.

### Examples
- `4n + 3 = Θ(n)`, and also `= O(n)`, `O(n²)`, `Ω(n)`, `Ω(1)`.
- `4n = o(n²)`, `4n = ω(1)`, `4n = ω(√n)`.
- `n log n = o(n^1.0000001)`;  `n log n = ω(n)`.
- Insertion sort worst case `= Θ(n²)`; merge sort `= Θ(n log n)`.

