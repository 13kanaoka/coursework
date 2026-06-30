// I am unable to upload any file type except for Java so I imported my report into a .java file. I hope that is acceptable.
// In Google Docs, it is one full page in Times New Roman size 12pt font.
/*

Matthew Rohde
Joel Rarang
COMP 282

Project 4 - Traveling Salesman

    The Traveling Salesman Problem is all about finding the shortest route that visits every city (or node) once and returns to where you started.
Figuring out the perfect solution can take a lot of computing power, especially with bigger datasets, so oftentimes heuristics is the best option—fast, practical methods that give good-enough answers.
For this project, I used the Nearest Neighbor approach, a simple greedy algorithm that always picks the closest unvisited city next.
It doesn’t always find the absolute best route, but it’s quick and generally gives solid results, even when working with large inputs.
The time complexity of this approach is O(n²), which is reasonable for larger data inputs.

The algorithm works as follows:
1) Start at an arbitrary city (in this case, city 0).
2) Repeatedly travel to the nearest unvisited city.
3) Once all cities have been visited, return to the starting city to complete the tour.

    This implementation is written in Java, contained in the file TravelingSalesman.java.
It takes an adjacency matrix as input, where distanceMatrix[i][j] represents the cost of travel from city i to city j.
The core logic is handled in the nearestNeighbor() method, which keeps track of visited cities, calculates the total tour cost, and returns a complete tour path.
A helper class Result is used to return both the tour (as a list of integers) and the total travel cost. 

	This heuristic algorithm is well-documented in literature and educational resources on the Traveling Salesman problem.
The structure and logic I used to implement this algorithm can be found all over the internet as well as topics discussed in this course.
In these two resources, I learned quite a bit about the Traveling Salesman problem:
https://medium.com/opex-analytics/heuristic-algorithms-for-the-traveling-salesman-problem-6a53d8143584
https://github.com/juliankappler/traveling_salesman
	
    I didn’t fully realize the significance of the Traveling Salesman problem, or as I’ve discovered it commonly being called the TSP.
In 1952, three operations researchers by the names of Danzig, Fulkerson, and Johnson were the first group to really crack this problem, using 49 US cities.
From then on, much more research regarding the topic bloomed.

This project demonstrates the practical application of a simple yet effective heuristic for solving the Traveling Salesman problem.
The algorithm is lightweight, understandable, and scales well for larger datasets, making it suitable for the numeric inputs provided in Project 3 for example.
This problem is an up front example of how data structures and algorithms can be used in real life, and how their individual strengths and weaknesses make for a strong tool in certain fields and practically useless in others.

	It was interesting to see how a relatively simple approach like Nearest Neighbor could produce surprisingly good results with minimal code and solid runtime performance.
That said, the project also made clear the tradeoffs involved—while the algorithm is fast, it can easily get stuck in suboptimal routes, especially if the starting city is poorly chosen.
In a real-world application, combining Nearest Neighbor with techniques like multiple starting points or 2-opt refinements could help improve accuracy without sacrificing too much efficiency.
*/