
"""
CSV17 CH7A02 — Chapter 7 (Relations) §6.3: In-degree and Out-degree

Implement edgetest, indegree, and outdegree for the directed graph
described by the adjacency matrix R below.
See images/6.3.2_in_out_degree.png for the graph drawing.
"""

# 'a' = 0, 'b' = 1, 'c' = 2, 'd' = 3
Node = ['a', 'b', 'c', 'd']

# Adjacency matrix R: R[i][j] == 1 means a directed edge i -> j
R = [
    [0, 0, 0, 0],   # a -> (none)
    [1, 1, 0, 0],   # b -> a, b -> b (self-loop)
    [0, 1, 0, 0],   # c -> b
    [1, 1, 0, 0],   # d -> a, d -> b
]


def edgetest(node1, node2):
    """
    ##################################################
    # Complete this function
    # Return True if there is a directed edge node1 -> node2, else False.
    # Hint: use R[node1][node2]
    ##################################################
    """
    return R[node1][node2] == 1

def indegree(node):
    """
    ##################################################
    # Complete this function
    # Return the number of incoming edges to `node`.
    # Hint: sum down column `node` in R.
    ##################################################
    """
    count = 0
    for i in range(len(R)):
        count += R[i][node]
    return count

def outdegree(node):
    """
    ##################################################
    # Complete this function
    # Return the number of outgoing edges from `node`.
    # Hint: sum across row `node` in R.
    ##################################################
    """
    count = 0
    for i in range(len(R[node])):
        count += R[node][i]
    return count


def main():
    print('Edge Test 1 b->c', edgetest(1, 2))
    print('Edge Test 2 c->b', edgetest(2, 1))
    print('Edge Test 3 c->c', edgetest(2, 2))
    for i in range(len(R)):
        print('Node', Node[i], 'has', indegree(i), 'incoming edges and', outdegree(i), 'outgoing edges.')


if __name__ == '__main__':
    main()
