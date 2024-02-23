# 1628

import operator
from typing import List
from abc import ABC, abstractmethod

# Given the postfix tokens of an arithmetic expression, build and return the binary expression tree that represents this expression.

class Node(ABC):
    @abstractmethod
    def evaluate(self) -> int:
        pass


class LeafNode(Node):
    def __init__(self, val):
        self.val = int(val)

    def evaluate(self):
        return self.val

class InternalNode(Node):
    OPS = {
        '+': operator.add,
        '-': operator.sub,
        '*': operator.imul,
        '/': operator.floordiv
    }

    def __init__(self, val, left=None, right=None):
        self.val = val
        self.left = left
        self.right = right

    def evaluate(self):
        return self.OPS[self.val](self.left.evaluate(), self.right.evaluate())




class TreeBuilder(object):
    def buildTree(self, postfix: List[str]) -> 'Node':
        stack = []
        for s in postfix:
            if s in InternalNode.OPS:
                right, left = stack.pop(), stack.pop()
                stack.append(InternalNode(s, left, right))
            else:
                stack.append(LeafNode(s))
        return stack[-1]


s = ["4","5","2","7","+","-","*"]
actual = TreeBuilder().buildTree(s)
expected = -16
assert(expected == actual)