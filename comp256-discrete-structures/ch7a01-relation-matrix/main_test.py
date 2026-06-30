import pytest
import main


# ============================================================
# T1 — Sue's row of the permission matrix
#     Sue has access to FileB, FileC, FileD; NOT to FileA.
# ============================================================
@pytest.mark.T1
def test_sue_no_filea():
    assert main.permission('Sue', 'FileA') is False

@pytest.mark.T1
def test_sue_fileb():
    assert main.permission('Sue', 'FileB') is True

@pytest.mark.T1
def test_sue_filec():
    assert main.permission('Sue', 'FileC') is True

@pytest.mark.T1
def test_sue_filed():
    assert main.permission('Sue', 'FileD') is True


# ============================================================
# T2 — Harry's row
#     Harry has access to FileA and FileD; NOT to FileB, FileC.
# ============================================================
@pytest.mark.T2
def test_harry_filea():
    assert main.permission('Harry', 'FileA') is True

@pytest.mark.T2
def test_harry_no_fileb():
    assert main.permission('Harry', 'FileB') is False

@pytest.mark.T2
def test_harry_no_filec():
    assert main.permission('Harry', 'FileC') is False

@pytest.mark.T2
def test_harry_filed():
    assert main.permission('Harry', 'FileD') is True


# ============================================================
# T3 — Sam's row (no access to ANY file)
# ============================================================
@pytest.mark.T3
def test_sam_no_filea():
    assert main.permission('Sam', 'FileA') is False

@pytest.mark.T3
def test_sam_no_fileb():
    assert main.permission('Sam', 'FileB') is False

@pytest.mark.T3
def test_sam_no_filec():
    assert main.permission('Sam', 'FileC') is False

@pytest.mark.T3
def test_sam_no_filed():
    assert main.permission('Sam', 'FileD') is False


# ============================================================
# T4 — Cross-check against the relation set A from the figure:
#     A = {(Sue,FileB), (Sue,FileC), (Sue,FileD),
#          (Harry,FileA), (Harry,FileD)}
# ============================================================
def _build_relation():
    return [(p, f) for p in main.people for f in main.Files if main.permission(p, f)]

@pytest.mark.T4
def test_relation_pair_count():
    """The relation A has exactly 5 pairs."""
    assert len(_build_relation()) == 5

@pytest.mark.T4
def test_relation_includes_sue_fileb():
    assert ('Sue', 'FileB') in _build_relation()

@pytest.mark.T4
def test_relation_includes_harry_filea():
    assert ('Harry', 'FileA') in _build_relation()

@pytest.mark.T4
def test_relation_excludes_sam_filea():
    """Sam should not appear in any pair."""
    assert ('Sam', 'FileA') not in _build_relation()

@pytest.mark.T4
def test_sam_total_access_count():
    """Sam has access to zero files."""
    assert sum(1 for f in main.Files if main.permission('Sam', f)) == 0
