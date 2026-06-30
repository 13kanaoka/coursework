# CSV17A51
CSV17 Assignment 5-1: Function Properties — Domain, Range, Injective, Surjective & Bijective

## Overview
Implement six Python functions that analyze mathematical functions represented as dictionaries. Covers Zybook Chapter 5 (Sections 5.1–5.3): domain, range, well-definedness, injectivity, surjectivity, and bijectivity.

## Functions to Implement
- `get_domain(mapping: dict) -> set` — Return the domain (all input keys)
- `get_range(mapping: dict) -> set` — Return the range (all output values)
- `is_well_defined(mapping: dict, target: set) -> bool` — True if every output is in the target set
- `is_injective(mapping: dict) -> bool` — True if no two inputs map to the same output (one-to-one)
- `is_surjective(mapping: dict, target: set) -> bool` — True if every target element is hit (onto)
- `is_bijective(mapping: dict, target: set) -> bool` — True if both injective and surjective

## Test Cases

| Test | Description |
|------|-------------|
| T1 | Domain & Range: `get_domain({1:'a', 2:'b', 3:'c'})` → `{1, 2, 3}` |
| T2 | Well-defined & Injective: `is_well_defined({1:'a', 2:'z'}, {'a','b','c'})` → `False` |
| T3 | Surjective: `is_surjective({1:'a', 2:'b', 3:'c'}, {'a','b','c'})` → `True` |
| T4 | Bijective: `is_bijective({1:'a', 2:'b', 3:'c'}, {'a','b','c'})` → `True` |

## How to Test
```
python -m pytest main_test.py -v
```
