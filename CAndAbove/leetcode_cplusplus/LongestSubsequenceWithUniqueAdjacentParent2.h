//
// Created by alex wu on 10/29/23.
//

#ifndef CMAKE_TESTAPP_LONGESTSUBSEQUENCEWITHUNIQUEADJACENTPARENT2_H
#define CMAKE_TESTAPP_LONGESTSUBSEQUENCEWITHUNIQUEADJACENTPARENT2_H


#include <string>

using namespace std;

class LongestSubsequenceWithUniqueAdjacentParent2 {
public:
    vector<string> getWordsInLongestSubsequence(int n, vector<string>& words, vector<int>& groups) ;

private:
    bool check(string &a,string &b);
};



#endif //CMAKE_TESTAPP_LONGESTSUBSEQUENCEWITHUNIQUEADJACENTPARENT2_H
