from __future__ import annotations



def get_inverse(mapping: dict, target: set) -> dict:
    """Return f⁻¹ as a dict. Raise ValueError if f is not bijective."""
    # === TODO ===
    # Your code here

    # check if one to one
    if len(mapping.values()) != len(set(mapping.values())):
        raise ValueError
    
    # check if onto
    for item in target:
        if item not in mapping.values():
            raise ValueError
    
    # swap keys and values to get inverse, then return
    return {value: key for key, value in mapping.items()}
    # === END TODO ===


def compose(f: dict, g: dict) -> dict:
    """Return f∘g as a dict (apply g first, then f).
    For each key x in g, compute f(g(x)).
    Raise ValueError if g(x) is not in f's domain.
    """
    # === TODO ===
    # Your code here
    res = {}
    for key, value in g.items():
        if value in f.keys():
            res[key] = f[g[key]]
        else:
            raise ValueError

    return res
    # === END TODO ===