import pytest
import main


# ============================================================
# T1 — edges that EXIST in the graph (edgetest must return True)
# ============================================================
@pytest.mark.T1
def test_edge_b_to_a():
    assert main.edgetest(1, 0) is True

@pytest.mark.T1
def test_edge_b_self_loop():
    assert main.edgetest(1, 1) is True

@pytest.mark.T1
def test_edge_c_to_b():
    assert main.edgetest(2, 1) is True

@pytest.mark.T1
def test_edge_d_to_a():
    assert main.edgetest(3, 0) is True

@pytest.mark.T1
def test_edge_d_to_b():
    assert main.edgetest(3, 1) is True


# ============================================================
# T2 — edges that DO NOT exist (edgetest must return False),
#       including self-loop edge cases
# ============================================================
@pytest.mark.T2
def test_no_edge_a_to_a():
    assert main.edgetest(0, 0) is False

@pytest.mark.T2
def test_no_edge_a_to_b():
    assert main.edgetest(0, 1) is False

@pytest.mark.T2
def test_no_edge_b_to_c():
    assert main.edgetest(1, 2) is False

@pytest.mark.T2
def test_no_edge_c_to_c():
    assert main.edgetest(2, 2) is False

@pytest.mark.T2
def test_no_edge_d_to_d():
    assert main.edgetest(3, 3) is False


# ============================================================
# T3 — in-degree for every node
# ============================================================
@pytest.mark.T3
def test_indegree_a():
    assert main.indegree(0) == 2

@pytest.mark.T3
def test_indegree_b():
    assert main.indegree(1) == 3

@pytest.mark.T3
def test_indegree_c():
    assert main.indegree(2) == 0

@pytest.mark.T3
def test_indegree_d():
    assert main.indegree(3) == 0


# ============================================================
# T4 — out-degree for every node
# ============================================================
@pytest.mark.T4
def test_outdegree_a():
    assert main.outdegree(0) == 0

@pytest.mark.T4
def test_outdegree_b():
    assert main.outdegree(1) == 2

@pytest.mark.T4
def test_outdegree_c():
    assert main.outdegree(2) == 1

@pytest.mark.T4
def test_outdegree_d():
    assert main.outdegree(3) == 2
