#import unittest

def addRow(r, d, v):
    dmo = []
    getHeightAndMore(r, 0, dmo, d)

    if len(dmo) <= 0:
        print ('no way to add row for no d-1 nodes found')
        return

    print('dmo has %d' % len(dmo))
    print('dmo: %s' % ','.join([str(x.val) for x in dmo]))
    for n in dmo:
        left, right = Node(v), Node(v)
        left.left = n.left
        n.left = left
        right.right = n.right
        n.right = right


def getHeightAndMore(r, h, dmo, d):
    h += 1
    if d == h:
        dmo.append(r)
    if r.left != None:
         getHeightAndMore(r.left, h, dmo, d)
    if r.right != None:
        getHeightAndMore(r.right, h, dmo, d)


class Node:
    def __init__(self, val):
        self.left = None
        self.right = None
        self.val = val
    def __expr__(self):
        msg = 'Node({self.val})'.format(self=self)
        return msg

def insertIntoBinaryTreeWithAGivenIntArray(root, intArray):
    n = len(intArray)
    if n <= 0: return
    root = Node(intArray[0])
    if n == 1: return

    nodeArray = [root]
    i = 1
    while i < n:
        temp = Node(intArray[i])
        if i % 2 == 0:
            parentIndex = (i - 2) // 2
            nodeArray[parentIndex].right = temp
        else:
            parentIndex = (i - 1) // 2
            nodeArray[parentIndex].left = temp
        nodeArray.append(temp)
        i += 1

    for n in nodeArray:
        print('content: %s'  % (n))


def binary_insert(root, node):
    if root is None:
        root = node
    else:
        if root.val > node.val:
            if root.left is None:
                root.left = node
            else:
                binary_insert(root.left, node)
        else:
            if root.right is None:
                root.right = node
            else:
                binary_insert(root.right, node)

def in_order_print(root):
    if not root:
        return
    in_order_print(root.left)
    print (root.val)
    in_order_print(root.right)

def pre_order_print(root):
    if not root:
        return
    print ('%s  left:%s right:%s'  % (str(root.val),  str(root.left.val if root.left != None else ''), str(root.right.val if root.right != None else '')))
    pre_order_print(root.left)
    pre_order_print(root.right)

#case 1
t = Node(4)
#binary_insert(t, Node(2))
#binary_insert(t, Node(7))
#binary_insert(t, Node(3))
#binary_insert(t, Node(6))
#binary_insert(t, Node(2))
#binary_insert(t, Node(5))

#insertIntoBinaryTreeWithAGivenIntArray(t, [4, 2, 6, 3, 1, 5])
t.left = Node(2)
t.right = Node(6)
t.left.left = Node(3)
t.left.right = Node(1)
t.right.left = Node(5)
pre_order_print(t)

d = 2
v = 99
addRow(t, d, v)
pre_order_print(t)
#in_order_print(t)
#case 2

