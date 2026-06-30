import pytest
from main import (
    find_non_injective_pair, find_non_surjective_element,
    my_floor, my_ceil
)

# ── shared test data ──────────────────────────────────────────────────────────

bij   = {1: 'a', 2: 'b', 3: 'c'}
bij_T = {'a', 'b', 'c'}

sur   = {1: 'a', 2: 'b', 3: 'a'}
sur_T = {'a', 'b'}

inj   = {1: 'a', 2: 'b'}
inj_T = {'a', 'b', 'c'}

# ── T1: find_non_injective_pair ──────────────────────────────────────────────

@pytest.mark.T1
def test_non_inj_found():
    pair = find_non_injective_pair(sur)
    assert pair is not None
    x1, x2 = pair
    assert x1 != x2
    assert sur[x1] == sur[x2]

@pytest.mark.T1
def test_non_inj_none():
    assert find_non_injective_pair(bij) is None

@pytest.mark.T1
def test_non_inj_empty():
    assert find_non_injective_pair({}) is None

# ── T2: find_non_surjective_element ──────────────────────────────────────────

@pytest.mark.T2
def test_non_surj_found():
    elem = find_non_surjective_element(inj, inj_T)
    assert elem is not None
    assert elem in inj_T
    assert elem not in set(inj.values())

@pytest.mark.T2
def test_non_surj_none():
    assert find_non_surjective_element(bij, bij_T) is None

@pytest.mark.T2
def test_non_surj_empty_mapping():
    elem = find_non_surjective_element({}, {'a'})
    assert elem == 'a'

# ── T3: my_floor ────────────────────────────────────────────────────────────

@pytest.mark.T3
def test_floor_positive():
    assert my_floor(3.7) == 3

@pytest.mark.T3
def test_floor_negative():
    assert my_floor(-2.3) == -3

@pytest.mark.T3
def test_floor_integer():
    assert my_floor(5.0) == 5

@pytest.mark.T3
def test_floor_zero():
    assert my_floor(0.0) == 0

@pytest.mark.T3
def test_floor_negative_integer():
    assert my_floor(-4.0) == -4

# ── T4: my_ceil ─────────────────────────────────────────────────────────────

@pytest.mark.T4
def test_ceil_positive():
    assert my_ceil(3.2) == 4

@pytest.mark.T4
def test_ceil_negative():
    assert my_ceil(-2.7) == -2

@pytest.mark.T4
def test_ceil_integer():
    assert my_ceil(5.0) == 5

@pytest.mark.T4
def test_ceil_zero():
    assert my_ceil(0.0) == 0

@pytest.mark.T4
def test_ceil_negative_integer():
    assert my_ceil(-3.0) == -3
