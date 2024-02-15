# There are n dominoes in a line, and we place each domino vertically upright. In the beginning, we simultaneously push some of the dominoes either to the left or to the right.
#
# After each second, each domino that is falling to the left pushes the adjacent domino on the left. Similarly, the dominoes falling to the right push their adjacent dominoes standing on the right.
#
# When a vertical domino has dominoes falling on it from both sides, it stays still due to the balance of the forces.
#
# For the purposes of this question, we will consider that a falling domino expends no additional force to a falling or already fallen domino.
#
# You are given a string dominoes representing the initial state where:
#
# dominoes[i] = 'L', if the ith domino has been pushed to the left,
# dominoes[i] = 'R', if the ith domino has been pushed to the right, and
# dominoes[i] = '.', if the ith domino has not been pushed.
# Return a string representing the final state.

class Dominos:

    def pushDominoes(self, A: str) -> str:
        A = 'L' + A + 'R'  # for ease of calc.
        ans = ''

        left = 0
        for right in range(1, len(A)):
            if A[right] == '.':
                continue

            if left:
                ans += A[left]
            mid_part_len = right - left - 1

            if A[left] == A[right]:
                ans += A[left] * mid_part_len
            elif A[left] == 'L' and A[right] == 'R':
                ans += '.' * mid_part_len
            else:
                ans += 'R' * (mid_part_len // 2) + '.' * (mid_part_len % 2) + 'L' * (mid_part_len // 2)

            left = right

        return ans
