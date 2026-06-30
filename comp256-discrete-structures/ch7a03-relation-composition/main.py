"""
CSV17 CH7A03 — Chapter 7 (Relations) §7.4: Composition of Relations

Implement composition(R, S) which returns the matrix representation of S∘R
("S composed with R" — first apply R, then S) on a 4-element set.

Mathematical definition
-----------------------
For two binary relations R and S on the same set,

    (S∘R)(i, j) = 1   iff   ∃ k such that R(i, k) = 1 AND S(k, j) = 1

In matrix terms: walk row i of R; for every k where R[i][k] = 1, look at row k
of S and OR its bits into row i of the result.

See images/7.4_composition.png for the figure.
See README.md for full algorithm explanation, parameters, and worked examples.
"""

# 'a' = 0, 'b' = 1, 'c' = 2, 'd' = 3
SIZE = 4

def composition(R, S):
    """Return S∘R as a 4x4 matrix of 0/1.

    Args:
        R: 4x4 list-of-lists of 0/1
        S: 4x4 list-of-lists of 0/1
    Returns:
        S_R: 4x4 list-of-lists of 0/1 representing S∘R
    """
    S_R = [[0] * SIZE for _ in range(SIZE)]

    for i in range(SIZE):
        for j in range(SIZE):
            for k in range(SIZE):
                if R[i][k] == 1 and S[k][j] == 1:
                    S_R[i][j] = 1
                    break

    return S_R
    """
    ##################################################
    # Code your program here
    # For every (i, j), set S_R[i][j] = 1 if there exists some k such that
    # R[i][k] == 1 AND S[k][j] == 1.  Use three nested loops; once you
    # find one valid k, you can break out of the k-loop.
    ##################################################
    """
    return S_R


def main():
    # Test 1 — Participation Activity 7.4.1
    R = [[0, 0, 0, 1], [0, 1, 1, 0], [0, 0, 0, 1], [0, 0, 1, 0]]
    S = [[0, 0, 0, 0], [1, 0, 0, 1], [0, 0, 0, 0], [0, 0, 1, 0]]
    print('******** Test 1: 7.4.1 Participation Activity')
    for row in composition(R, S):
        print(row)

    # Test 2 — Participation Activity 7.4.2
    R = [[0, 1, 0, 0], [0, 0, 1, 0], [0, 0, 0, 0], [1, 0, 0, 0]]
    S = [[1, 0, 0, 0], [0, 0, 1, 1], [0, 0, 0, 0], [0, 0, 0, 0]]
    print('******** Test 2: 7.4.2 Participation Activity')
    for row in composition(R, S):
        print(row)


if __name__ == '__main__':
    main()
