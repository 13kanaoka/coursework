from __future__ import annotations

def find_non_injective_pair(mapping: dict) -> tuple | None:
    """Return (x1, x2) where f(x1)==f(x2) and x1!=x2, or None if injective."""
    # === TODO ===
    # Your code here
    seen = {}
    for key, value in mapping.items():
        if value in seen:
            return (seen[value], key)
        seen[value] = key
    # === END TODO ===


def find_non_surjective_element(mapping: dict, target: set):
    """Return one target element with no input mapping to it, or None if surjective."""
    # === TODO ===
    # Your code here
    for item in target:
        if item not in mapping.values():
            return item
    # === END TODO ===


def my_floor(x: float) -> int:
    """Return floor(x) without using math.floor."""
    # === TODO ===
    # Your code here
    if x > 0:
        return int(x)
    else:
        if x % 1 == 0:
            return int(x)
        return (int(x) - 1)
    # === END TODO ===


def my_ceil(x: float) -> int:
    """Return ceil(x) without using math.ceil."""
    # === TODO ===
    # Your code here
    if x > 0:
        if x % 1 == 0:
            return int(x)
        return (int(x) + 1)
    else:
        return int(x)
    # === END TODO ===