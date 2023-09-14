##This is was asked in Amazon SDE online test from Hacker rank. 
##Initech is a company which has CEO Bill and a hierarchy of employees. Employees can have a list of other employees reporting to them, which can themselves have reports,
##and so on. An employee with at least one report is called a manager. 
##
##Please implement the closestCommonManager method to find the closest manager (i.e. farthest from the CEO) to two employees. You may assume that all employees eventually
##report up to the CEO. 
##
##Tree structure: 
##Bill -> Dom, Samir, Michael 
##Dom -> Bob, Peter, Porter 
##Peter -> Milton, Nina 
##
##Sample Data: 
##CEO Bill has 3 employees reporting to him: {Dom, Samir, Michael} 
##Dom has three reports { Peter, Bob, Porter} 
##Samir has no reports {} 
##Michael has no reports {} 
##Peter has 2 reports {Milton, Nina} 
##Bob has no reports {} 
##Porter has no reports {} 
##Milton has no reports {} 
##Nina has no reports {} 
##
##Sample calls: 
##closestCommonManager(Milton, Nina) = Peter 
##closestCommonManager(Nina, Porter) = Dom 
##closestCommonManager(Nina, Samir) = Bill 
##closestCommonManager(Peter, Nina) = Peter

import unittest
class TreeNode(object):
    
    def __init__(self, name, chldrn = None):
        self.name = name
        self.children = []
        self.addChildren(chldrn)
      
    #the value is good, however, the represenation is no good, all on the same level
    #should I pass the level to adjust it??
    def __repr__(self):
        ret =  'Name: ' + self.name + '\n\t'
        
        for c in self.children:
            ret += '\t' + c.__repr__()
        return ret

    def __contains__(self, identifier):
        return [node for node in self.children if node.name == identifier]

    def addChildren(self, chldrn):
        if chldrn and len(chldrn) > 0:
            for c in chldrn:
                self.children.append(TreeNode(c))

            
class AmazonScreening(unittest.TestCase):
    #the idea I have for now is to
    #find out the path to a
    #find out the path to b
    #find the last CommonTypes pooint in both pathes
    def closestCommonManager(self, a, b):
        pass

    def test_closestCommonManager(self):
        ceo = TreeNode('Bill', ['Samir', 'Michael'])
        dom = TreeNode('Dom', ['Peter', 'Bob', 'Porter'])
        ceo.children.insert(0, dom)
        print('ceo: %s' % (ceo))
        print('ceo'' childrean count:: %s' % (len(ceo.children[0].children)))



if __name__ == "__main__":
    unittest.main()
