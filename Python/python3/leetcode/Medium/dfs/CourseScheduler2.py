from collections import defaultdict


class CourseScheduler2:
    WHITE = 1
    GRAY = 2
    BLACK = 3

    def findOrder(self, num_courses, prerequisites):
        adj_list = defaultdict(list)
        for dest, src in prerequisites:
            adj_list[src].append(dest)

        topological_sorted_order = []
        is_possible = True

        colors = {k: CourseScheduler2.WHITE for k in range(num_courses)}

        def dfs(node):
            nonlocal is_possible
            if not is_possible:
                return

            colors[node] = CourseScheduler2.GRAY
            if node in adj_list:
                for neighbor in adj_list[node]:
                    if colors[neighbor] == CourseScheduler2.WHITE:
                        dfs(neighbor)
                    elif colors[neighbor] == CourseScheduler2.GRAY:
                        # An edge to a GRAY vertex represents a cycle
                        is_possible = False

            colors[node] = CourseScheduler2.BLACK
            topological_sorted_order.append(node)

        for c in range(num_courses):
            if colors[c] == CourseScheduler2.WHITE:
                dfs(c)

        return topological_sorted_order[::-1] if is_possible else []


