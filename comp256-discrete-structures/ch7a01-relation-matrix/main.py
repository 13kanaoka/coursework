"""
CSV17 CH7A01 — Chapter 7 (Relations) §6.1: Matrix Representation for a Relation

Implement permission(person, file) using the access matrix shown in
images/6.1.2_relation_representation.png.

Three people, four files. The relation A on People x Files is:
    pAf  iff  person p has access to file f.

From the figure:
    A = {(Sue,   FileB), (Sue,   FileC), (Sue,   FileD),
         (Harry, FileA), (Harry, FileD)}
Sam has no access to any file.
"""

people = ['Sue', 'Harry', 'Sam']
Files  = ['FileA', 'FileB', 'FileC', 'FileD']

# Permission matrix from Activity 6.1.2 figure.
# rows = people order;  columns = Files order;  1 = access, 0 = no access.
P = [
    [0, 1, 1, 1],   # Sue   -> FileB, FileC, FileD
    [1, 0, 0, 1],   # Harry -> FileA, FileD
    [0, 0, 0, 0],   # Sam   -> (none)
]


def permission(person, file):
    """
    ##################################################
    # Complete this function
    # Return True if `person` has access to `file`, else False.
    # Use the matrix P above; row = people.index(person), col = Files.index(file).
    ##################################################
    """
    row = people.index(person)
    col = Files.index(file)
    return P[row][col] == 1


def main():
    for p in people:
        for f in Files:
            print(p, '->', f, ':', permission(p, f))


if __name__ == '__main__':
    main()
