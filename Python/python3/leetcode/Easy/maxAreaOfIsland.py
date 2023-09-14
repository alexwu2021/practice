class Solution(object):
    def maxAreaOfIsland_borrowed(self, grid):
        def dfs(i, j):
            if 0 <= i < m and 0 <= j < n and grid[i][j]:
                grid[i][j] = 0
                return 1 + dfs(i - 1, j) + dfs(i, j + 1) + dfs(i + 1, j) + dfs(i, j - 1)
            return 0
        m, n = len(grid), len(grid[0])
        areas = [ dfs(i, j) for i in range(m) for j in range(n) if grid[i][j] ]
        return max(areas) if areas else 0
    
   
    #accepted
    def maxAreaOfIsland(self, grid):
      
        """
        :type grid: List[List[int]]
        :rtype: int
        """
        def dfs(i, j):
            if 0 <= i < m and 0 <= j < n and grid[i][j]: #pay attention to the last term, easy to get lost
                grid[i][j] = 0
                return 1 + dfs(i-1, j) + dfs(i+1, j) + dfs(i, j-1)+ dfs(i, j+1)
            return 0
      
        m, n = len(grid), len(grid[0])
        q = []
        for i in range(m):
            for j in range(n):
                if grid[i][j]:
                    q.append(dfs(i, j))
        return max(q) if q else 0
                  