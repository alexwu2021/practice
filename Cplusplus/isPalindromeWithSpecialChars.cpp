class Solution {
public:
    //"A man, a plan, a canal: Panama" is a palindrome.
    //"race a car" is not a palindrome.
    bool isPalindromeWithSpecialChars(string s) {
        int i = 0, j = s.size() - 1;
		while(i < j)
		{
			while(i < j && !isalnum(s[i])) i++;
			while(i < j && !isalnum(s[j])) j--;
			if (toupper(s[i])!=toupper(s[j]))
				return false;
			i++;j--;
		}
		return true;
    }
};