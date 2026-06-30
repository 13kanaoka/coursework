import pytest
from main import (
    get_domain, get_range, is_well_defined,
    is_injective, is_surjective, is_bijective
)

# ── shared test data ──────────────────────────────────────────────────────────

bij   = {1:'a', 2:'b', 3:'c'}
bij_T = {'a','b','c'}

inj   = {1:'a', 2:'b'}
inj_T = {'a','b','c'}

sur   = {1:'a', 2:'b', 3:'a'}
sur_T = {'a','b'}

nei   = {1:'a', 2:'b', 3:'a'}
nei_T = {'a','b','c','d'}

bad   = {1:'a', 2:'z'}
bad_T = {'a','b','c'}

# ── T1: domain and range ──────────────────────────────────────────────────────

@pytest.mark.T1
def test_domain():
    assert get_domain(bij) == {1, 2, 3}

@pytest.mark.T1
def test_domain_empty():
    assert get_domain({}) == set()

@pytest.mark.T1
def test_range_bijection():
    assert get_range(bij) == {'a', 'b', 'c'}

@pytest.mark.T1
def test_range_injective():
    assert get_range(inj) == {'a', 'b'}

@pytest.mark.T1
def test_range_subset_of_target():
    assert get_range(inj).issubset(inj_T)

# ── T2: well-defined and injective ───────────────────────────────────────────

@pytest.mark.T2
def test_well_defined_true():
    assert is_well_defined(bij, bij_T) is True

@pytest.mark.T2
def test_well_defined_false():
    assert is_well_defined(bad, bad_T) is False

@pytest.mark.T2
def test_well_defined_empty():
    assert is_well_defined({}, {'a','b'}) is True

@pytest.mark.T2
def test_injective_true():
    assert is_injective(bij) is True

@pytest.mark.T2
def test_injective_false():
    assert is_injective(sur) is False

@pytest.mark.T2
def test_injective_false_neither():
    assert is_injective(nei) is False

# ── T3: surjective ──────────────────────────────────────────────────────────

@pytest.mark.T3
def test_surjective_true():
    assert is_surjective(bij, bij_T) is True

@pytest.mark.T3
def test_surjective_true_sur():
    assert is_surjective(sur, sur_T) is True

@pytest.mark.T3
def test_surjective_false():
    assert is_surjective(inj, inj_T) is False

# ── T4: bijective ───────────────────────────────────────────────────────────

@pytest.mark.T4
def test_bijective_true():
    assert is_bijective(bij, bij_T) is True

@pytest.mark.T4
def test_bijective_false_inj_only():
    assert is_bijective(inj, inj_T) is False

@pytest.mark.T4
def test_bijective_false_sur_only():
    assert is_bijective(sur, sur_T) is False
