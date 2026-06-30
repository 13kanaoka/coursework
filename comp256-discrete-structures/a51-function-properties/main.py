from __future__ import annotations


def get_domain(mapping: dict) -> set:
    """Return the domain X (all inputs of the function)."""
    # === TODO ===
    # Your code here
    return set(mapping.keys())
    # === END TODO ===


def get_range(mapping: dict) -> set:
    """Return the range — the set of outputs actually mapped to."""
    # === TODO ===
    # Your code here
    return set(mapping.values())
    # === END TODO ===


def is_well_defined(mapping: dict, target: set) -> bool:
    """Return True if every output value is in the target set."""
    # === TODO ===
    # Your code here
    for value in mapping.values():
        if value not in target:
            return False
    return True
    # === END TODO ===


def is_injective(mapping: dict) -> bool:
    """Return True if f is one-to-one (no two inputs map to same output)."""
    # === TODO ===
    # Your code here
    if len(mapping.values()) == len(set(mapping.values())):
        return True
    return False
    # === END TODO ===


def is_surjective(mapping: dict, target: set) -> bool:
    """Return True if f is onto (range == target)."""
    # === TODO ===
    # Your code here
    for item in target:
        if item not in mapping.values():
            return False
    return True
    # === END TODO ===


def is_bijective(mapping: dict, target: set) -> bool:
    """Return True if f is both injective and surjective."""
    # === TODO ===
    # Your code here
    return (is_injective(mapping) and is_surjective(mapping, target))
    # === END TODO ===
