import pytest
import main


G1 = main.G1   # 4-node directed graph from §7.5 figure


# ============================================================
# T1 — n = 1: direct neighbors (must match the cell-14 hint examples)
# ============================================================
@pytest.mark.T1
def test_n1_from_a():
    """graph_power(G1, 0, 1) returns [3]   (a -> d)"""
    assert main.graph_power(G1, 0, 1) == [3]

@pytest.mark.T1
def test_n1_from_b():
    """graph_power(G1, 1, 1) returns [0]   (b -> a)"""
    assert main.graph_power(G1, 1, 1) == [0]

@pytest.mark.T1
def test_n1_from_c():
    """graph_power(G1, 2, 1) returns [1, 3]   (c -> b, c -> d)"""
    assert main.graph_power(G1, 2, 1) == [1, 3]

@pytest.mark.T1
def test_n1_from_d():
    """graph_power(G1, 3, 1) returns [0]   (d -> a)"""
    assert main.graph_power(G1, 3, 1) == [0]


# ============================================================
# T2 — n = 2: walks of length 2
# ============================================================
@pytest.mark.T2
def test_n2_from_a():
    """a -> d -> a   so [0]"""
    assert main.graph_power(G1, 0, 2) == [0]

@pytest.mark.T2
def test_n2_from_b():
    """b -> a -> d   so [3]"""
    assert main.graph_power(G1, 1, 2) == [3]

@pytest.mark.T2
def test_n2_from_c():
    """c -> b -> a  AND  c -> d -> a   union = [0]"""
    assert main.graph_power(G1, 2, 2) == [0]

@pytest.mark.T2
def test_n2_from_d():
    """d -> a -> d   so [3]"""
    assert main.graph_power(G1, 3, 2) == [3]


# ============================================================
# T3 — n = 3 and n = 0 base case
# ============================================================
@pytest.mark.T3
def test_n3_from_a():
    """a -> d -> a -> d  so [3]"""
    assert main.graph_power(G1, 0, 3) == [3]

@pytest.mark.T3
def test_n3_from_b():
    """b -> a -> d -> a  so [0]"""
    assert main.graph_power(G1, 1, 3) == [0]

@pytest.mark.T3
def test_n3_from_c():
    """c -> b -> a -> d  AND  c -> d -> a -> d   union = [3]"""
    assert main.graph_power(G1, 2, 3) == [3]

@pytest.mark.T3
def test_n3_from_d():
    """d -> a -> d -> a  so [0]"""
    assert main.graph_power(G1, 3, 3) == [0]

@pytest.mark.T3
def test_n0_returns_self():
    """Length-0 walk from key ends at key itself."""
    for k in range(4):
        assert main.graph_power(G1, k, 0) == [k]


# ============================================================
# T4 — Structural properties + a different graph
# ============================================================
@pytest.mark.T4
def test_no_outgoing_edge_returns_empty():
    """If `key` has no outgoing edges, graph_power(G, key, 1) = []."""
    G_a_isolated = [
        [0, 0, 0, 0],   # a has no outgoing edges
        [1, 0, 0, 0],
        [0, 1, 0, 1],
        [1, 0, 0, 0],
    ]
    assert main.graph_power(G_a_isolated, 0, 1) == []

@pytest.mark.T4
def test_self_loop_n_steps():
    """A self-loop at vertex 0 alone: graph_power returns [0] for any n >= 0."""
    G_self_loop = [
        [1, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0],
        [0, 0, 0, 0],
    ]
    for n in range(5):
        assert main.graph_power(G_self_loop, 0, n) == [0]

@pytest.mark.T4
def test_ascending_order_no_duplicates():
    """Every returned list is strictly ascending (no duplicates, sorted)."""
    for k in range(4):
        for n in range(4):
            out = main.graph_power(G1, k, n)
            assert out == sorted(set(out))

@pytest.mark.T4
def test_g1_full_n3_newgraph():
    """The cell-15 final NewGraph for n=3:
    each key's row is graph_power(G1, key, 3) marked as 1s."""
    expected = [
        [0, 0, 0, 1],   # 0 -> [3]
        [1, 0, 0, 0],   # 1 -> [0]
        [0, 0, 0, 1],   # 2 -> [3]
        [1, 0, 0, 0],   # 3 -> [0]
    ]
    NewGraph = [[0] * 4 for _ in range(4)]
    for key in range(4):
        for v in main.graph_power(G1, key, 3):
            NewGraph[key][v] = 1
    assert NewGraph == expected
