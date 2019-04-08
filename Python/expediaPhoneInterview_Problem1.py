import unittest, sys

#nPlaceHolder = -sys.maxsize #this is something we discussed over the phone
#placeHolder = str(nPlaceHolder)
placeHolder = '*' #in fact, we can use any non-numeric print graph

class TreeNode(object):
    def __init__(self, x):
        self.val = x
        self.left = None
        self.right = None
    def __repr__(self):
        """ return the repr recursively
        """
        ret = str(self.val) + ' ' 
        if self.left:
            ret += self.left.__repr__()
        else:
            ret += placeHolder
        ret += ' '
        if self.right:
            ret += self.right.__repr__()
        else:
            ret += placeHolder
        return ret

class TreeManager(unittest.TestCase):
    def writeTreeToFile(self, root, fileName):
        """read the tree and write its content to a file.
        The resulting file content will be used to reconstruct the tree.
        :type root: TreeNode
        :type fileName: a file that has tree info or will have tree info
        :rtype: void
        """
        def dfs(tn):
            if not tn:
                vals.append(placeHolder)
                return
            vals.append(str(tn.val))
            dfs(tn.left)
            dfs(tn.right)
                
        vals = []
        dfs(root)
        with open(fileName, 'w+') as f:
            f.write(' '.join(vals))

    def readFromFile(self, fileName):
        """read from a file which is written by writeTreeToFile
        and reconstruct the tree, and return the root
        :type fileName: a file that has tree info
        :rtype: TreeNode
        """
        def dfs():
            v = next(vals)
            if v == placeHolder:
                return None
            tn = TreeNode(int(v))
            tn.left = dfs()
            tn.right = dfs()
            return tn

        vals = None
        with open(fileName, 'r+') as f:
            vals = iter(f.readlines()[0].split()) #we know only one line
        return dfs()


    def test_writeTreeToFile(self):
        def getFileContent(fname):
            with open(fileName, 'r+') as f:
                return f.readlines()[0]


        fileName = r'C:\users\public\tftest.txt'
        #fileName = r'/home/tftest.txt'
        strFileContents, treeRepresentations = ['', ''], ['', '']
       
        #set up the tree in memory
        n = TreeNode(7)
        n.left = TreeNode(4)
        n.right = TreeNode(21)
        n.left.left = TreeNode(1)
        n.right.left = TreeNode(11)
        n.right.right = TreeNode(33)
        n.right.left.left = TreeNode(9)
        self.writeTreeToFile(n, fileName)

        #first round        
        strFileContents[0] = getFileContent(fileName)
        print('writeTreeToFile done, file content: %s' % strFileContents[0])

        newRoot = self.readFromFile(fileName)
        treeRepresentations[0] = str(newRoot) #force to call __repr__
        print('readFromFile done, tree content: %s' % treeRepresentations[0])

        #print those on screen just for visual inspection: we don't expect them to be exactly the same
        #however, between two rounds, we can do assertion as follows:

        #second round
        self.writeTreeToFile(newRoot, fileName)
        strFileContents[1] = getFileContent(fileName)
        self.assertTrue(strFileContents[0] == strFileContents[1])
        
        newRoot2 = self.readFromFile(fileName)
        treeRepresentations[1] = str(newRoot2)
        self.assertTrue(treeRepresentations[0] == treeRepresentations[1])
        print("done")
        
if __name__ == '__main__':
    unittest.main(exit = False)
