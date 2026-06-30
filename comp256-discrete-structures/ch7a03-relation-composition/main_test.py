import pytest
import main


# ============================================================
# T1 — Participation Activity 7.4.1 expected output (cell-by-cell)
# ============================================================
R1 = [[0, 0, 0, 1], [0, 1, 1, 0], [0, 0, 0, 1], [0, 0, 1, 0]]
S1 = [[0, 0, 0, 0], [1, 0, 0, 1], [0, 0, 0, 0], [0, 0, 1, 0]]
EXPECTED_1 = [[0, 0, 1, 0], [1, 0, 0, 1], [0, 0, 1, 0], [0, 0, 0, 0]]

@pytest.mark.T1
def test_pa_7_4_1_full_matrix():
    assert main.composition(R1, S1) == EXPECTED_1

@pytest.mark.T1
def test_pa_7_4_1_row_0():
    assert main.composition(R1, S1)[0] == [0, 0, 1, 0]

@pytest.mark.T1
def test_pa_7_4_1_row_1():
    assert main.composition(R1, S1)[1] == [1, 0, 0, 1]

@pytest.mark.T1
def test_pa_7_4_1_row_3_all_zero():
    assert main.composition(R1, S1)[3] == [0, 0, 0, 0]


# ============================================================
# T2 — Participation Activity 7.4.2 expected output
# ============================================================
R2 = [[0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 0], [1, 0, 0, 0]]
S2 = [[1, 0, 0, 0], [0, 0, 1, 1], [0, 0, 0, 0], [0, 0, 0, 0]]
EXPECTED_2 = [[0, 0, 1, 1], [0, 0, 0, 0], [0, 0, 0, 0], [1, 0, 0, 0]]

@pytest.mark.T2
def test_pa_7_4_2_full_matrix():
    assert main.composition(R2, S2) == EXPECTED_2

@pytest.mark.T2
def test_pa_7_4_2_row_0():
    assert main.composition(R2, S2)[0] == [0, 0, 1, 1]

@pytest.mark.T2
def test_pa_7_4_2_row_2_all_zero():
    """Row 2 of R is all zeros, so the composition row must be all zeros."""
    assert main.composition(R2, S2)[2] == [0, 0, 0, 0]

@pytest.mark.T2
def test_pa_7_4_2_row_3():
    """d -> a (R), then a -> a (S) = d -> a in S∘R."""
    assert main.composition(R2, S2)[3] == [1, 0, 0, 0]


# ============================================================
# T3 — Edge cases on shape and structural properties
# ============================================================
ZERO = [[0]*4 for _ in range(4)]
IDENTITY = [[1, 0, 0, 0], [0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 1]]

@pytest.mark.T3
def test_zero_compose_anything_is_zero():
    """0∘R = R∘0 = 0 for any R."""
    R = [[0, 1, 0, 1], [1, 0, 1, 0], [0, 1, 1, 0], [1, 1, 0, 0]]
    assert main.composition(ZERO, R) == ZERO
    assert main.composition(R, ZERO) == ZERO

@pytest.mark.T3
def test_identity_left_compose_returns_R():
    """I∘R = R: if S=I then for every (i,j) you need R[i][k]=1 AND I[k][j]=1
    ⇔ R[i][j]=1."""
    R = [[0, 1, 0, 1], [1, 0, 1, 0], [0, 1, 1, 0], [1, 1, 0, 0]]
    assert main.composition(R, IDENTITY) == R

@pytest.mark.T3
def test_identity_right_compose_returns_R():
    """R∘I = R."""
    R = [[0, 1, 0, 1], [1, 0, 1, 0], [0, 1, 1, 0], [1, 1, 0, 0]]
    assert main.composition(IDENTITY, R) == R

@pytest.mark.T3
def test_returns_4x4_with_only_0_or_1():
    R = [[0, 1, 0, 1], [1, 0, 1, 0], [0, 1, 1, 0], [1, 1, 0, 0]]
    S = [[1, 0, 0, 1], [0, 1, 1, 0], [1, 0, 0, 0], [0, 1, 0, 0]]
    out = main.composition(R, S)
    assert len(out) == 4
    for row in out:
        assert len(row) == 4
        for v in row:
            assert v in (0, 1)


# ============================================================
# T4 — Specific entry-level checks (existence of intermediate node)
# ============================================================
@pytest.mark.T4
def test_specific_entry_pa1_0_2():
    """In PA 7.4.1, S_R[0][2]=1 because R[0][3]=1 and S[3][2]=1 (intermediate=d)."""
    assert main.composition(R1, S1)[0][2] == 1

@pytest.mark.T4
def test_specific_entry_pa1_1_3():
    """S_R[1][3]=1 because R[1][1]=1 and S[1][3]=1 (intermediate=b)."""
    assert main.composition(R1, S1)[1][3] == 1

@pytest.mark.T4
def test_specific_entry_pa1_no_path():
    """S_R[3][3]: no intermediate works (R[3]=[0,0,1,0], S[2]=[0,0,0,0])."""
    assert main.composition(R1, S1)[3][3] == 0

@pytest.mark.T4
def test_specific_entry_pa2_0_3():
    """PA 7.4.2: S_R[0][3]=1 because R[0][1]=1 and S[1][3]=1."""
    assert main.composition(R2, S2)[0][3] == 1

@pytest.mark.T4
def test_does_not_mutate_inputs():
    """composition must not modify R or S."""
    R = [[0, 0, 0, 1], [0, 1, 1, 0], [0, 0, 0, 1], [0, 0, 1, 0]]
    S = [[0, 0, 0, 0], [1, 0, 0, 1], [0, 0, 0, 0], [0, 0, 1, 0]]
    R_copy = [row[:] for row in R]
    S_copy = [row[:] for row in S]
    _ = main.composition(R, S)
    assert R == R_copy
    assert S == S_copy
