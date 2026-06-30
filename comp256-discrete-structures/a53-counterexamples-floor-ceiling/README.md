# CSV17A53
CSV17 Assignment 5-3: Counterexamples, Floor & Ceiling

## Overview
Implement four functions: finding counterexamples for injectivity and surjectivity, and computing floor/ceiling without the math module. Covers Zybook Chapter 5 (Sections 5.2–5.3).

## Functions to Implement
- `find_non_injective_pair(mapping: dict) -> tuple | None` — Find (x1, x2) where f(x1)==f(x2), or None
- `find_non_surjective_element(mapping: dict, target: set)` — Find target element not in range, or None
- `my_floor(x: float) -> int` — Floor without math.floor
- `my_ceil(x: float) -> int` — Ceiling without math.ceil

## Test Cases
| Test | Description |
|------|-------------|
| T1 | find_non_injective_pair |
| T2 | find_non_surjective_element |
| T3 | my_floor |
| T4 | my_ceil |

## How to Test
```
python -m pytest main_test.py -v
```
