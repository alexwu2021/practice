import sys, csv, NumberOfValidWords, time

class Solution(object):
    def __init__(self):
        self.dataset_directory = r'C:/Users/Alex/PyDev/HackerEarth/predict_projects_success_data_set/'
        self.testDataFileName = 'test.csv'
        self.trainDataFileName = 'train.csv'
class project(object):
    def __init__(self, project_id, name, desc, goal,keywords,disable_communication,country,currency,deadline,state_changed_at,created_at,launched_at):
        self.fileName = fileName
        self.project_id = project_id
        self.name = name
        self.desc = desc
        self.goal = goal
        self.keywords = keywords
        self.disable_communication = disable_communication
        self.country = country
        self.currency = currency
        self.deadline = deadline
        self.state_changed_at = state_changed_at
        self.created_at = created_at
        self.launched_at = launched_at

    def __init__(self, sa):
        i = 0
        self.project_id = sa[i]
        i += 1
        self.name = sa[i]
        i += 1
        self.desc = sa[i]
        i += 1
        print('sa[i].lstrip().rstrip(): {}'.format(sa[i].lstrip().rstrip()))
        self.goal = float(sa[i].lstrip().rstrip())
        i += 1
        self.keywords = sa[i]
        i += 1
        self.disable_communication = bool(sa[i])
        i += 1
        self.country = sa[i]
        i += 1
        self.currency = sa[i]
        i += 1
        self.deadline = sa[i]
        i += 1
        self.state_changed_at = sa[i]
        i += 1
        self.created_at = sa[i]
        i += 1
        self.launched_at = sa[i]

    def __repr__(self):
        return self.project_id + '__' + str(self.goal)
    
class testDataReader(object):
    def __init__(self, fileName):
        self.fileName = fileName
        self.projects = []
    def parseIt(self):
        count = 0
        f = csv.reader(open(self.fileName, newline=''), quotechar='"', delimiter=',', quoting=csv.QUOTE_ALL, skipinitialspace=True)
        for line in f:
            print('now processing line: {}'.format(line))
            count += 1
            if count % 25 == 0:
                print('count: {}'.format(count))
            if count > 50: break
            if count > 1:
                proj = project(line)
                self.projects.append(proj)
        print('totally we have {} lines'.format(len(self.projects)))

        for p in self.projects:
            print(p)
        return True



#lines = '''"AAA", "BBB", "Test, Test", "CCC"
#           "111", "222, 333", "XXX", "YYY, ZZZ"'''.splitlines()
#for l in  csv.reader(lines, quotechar='"', delimiter=',',
#                     quoting=csv.QUOTE_ALL, skipinitialspace=True):
#    print l
#>>> ['AAA', 'BBB', 'Test, Test', 'CCC']
#>>> ['111', '222, 333', 'XXX', 'YYY, ZZZ']


def main():
    print('starting unittest')
    sol = Solution()
    
    tdr = testDataReader(sol.dataset_directory + sol.testDataFileName)
    tdr.parseIt()


if __name__ == '__main__':
    main()
