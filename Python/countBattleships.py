class Solution:
    def countBattleships(self, board):
        """
        :type board: List[List[str]]
        :rtype: int
        """
        count = 0

        for i in range(len(board)):
            j = 0
            while j < len(board[0]):
                if board[i][j] == 'X' and (i == 0 or board[i-1][j] != 'X') and (j == 0 or board[i][j-1] == '.'):
                    count += 1
                j += 1
                        
        return count
