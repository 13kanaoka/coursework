"""
CSV17 CH7A04 — Chapter 7 (Relations) §7.5: Graph Powers and Walks

Implement graph_power(G, key, n) recursively. It returns the list of nodes
reachable from `key` in EXACTLY n steps along directed edges of G.

See images/7.5_graph_powers.png for the figure.
See README.md for full algorithm explanation, parameters, and worked examples.
"""

# 'a' = 0, 'b' = 1, 'c' = 2, 'd' = 3
G1 = [
    [0, 0, 0, 1],   # a -> d
    [1, 0, 0, 0],   # b -> a
    [0, 1, 0, 1],   # c -> b, c -> d
    [1, 0, 0, 0],   # d -> a
]


def graph_power(G, key, n):
    """Return the list of nodes reachable from `key` via a walk of EXACTLY length n.

    Args:
        G: adjacency matrix (list of list of 0/1). G[i][j]=1 iff edge i→j.
        key: integer source-node index (0 .. len(G)-1).
        n: non-negative integer walk length.
    Returns:
        list of distinct destination-node indices, in ascending order.
    """
    """
    ######################################################################
    # Complete your code here as a RECURSIVE function.
    # Base case:  if n == 0,  return [key].
    # Recursive step:  for every neighbor w of key (G[key][w] == 1),
    #                  union graph_power(G, w, n-1) into the result.
    # Return a sorted list of distinct vertex indices.
    ######################################################################
    """
    if n == 0:
        return [key]
    seen = set()
    for w in range(len(G)):
        if G[key][w] == 1:                 # w is a direct neighbor of key
            for v in graph_power(G, w, n - 1):
                seen.add(v)                 # union — dedup automatic
    return sorted(seen)                     # ascending order, no duplicates


def main():
    NewGraph = [[0] * len(G1) for _ in range(len(G1))]
    for key in range(len(G1)):
        print('The Origin Key is', key, ' ----> ')
        retval = graph_power(G1, key, 3)
        print('ret val', retval)
        if retval:
            for val in retval:
                NewGraph[key][val] = 1
    print(NewGraph)


if __name__ == '__main__':
    main()
