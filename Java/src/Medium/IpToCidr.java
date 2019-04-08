package Medium;

import java.util.ArrayList;
import java.util.List;

public class IpToCidr {

    public List<String> ipToCIDR(String ip, int n) {
        long start = 0;
        for (String s : ip.split("\\.")) start = start * 256 + Integer.parseInt(s);
        List<String> ans = new ArrayList<>();
        while (n > 0) {
            int num = Math.min((int) (start & -start), Integer.highestOneBit(n));
            ans.add(String.format("%s.%s.%s.%s/%s", start >> 24, (start >> 16) % 256, (start >> 8) % 256, start % 256, 32 - Integer.numberOfTrailingZeros(num)));
            start += num;
            n -= num;
        }
        return ans;
    }
}


/*
#include <string>
#include <cstdint>
#include <iostream>

using namespace std;

class Solution {
    public:
    void cidr(const string& start_ip, const string& end_ip, vector<string>& result) {
        uint32_t start = aton(start_ip), end = aton(end_ip);
        while (start <= end) {
            uint32_t val = lsb(start);
            val = std::min(val, end - start + 1);
            int pos = indexOf(val);
            int mask = 32 - pos;
            result.push_back(ntoa(start) + "/" + std::to_string(mask));
            start += 1 << pos;
        }
    }
    private:
    static constexpr int N = 4;
    private:
    uint32_t aton(const string& ip) {
        uint32_t result = 0, val = 0;
        int n = ip.size();
        for (int i = 0; i <= n; ++i) {
            if (i == n || ip[i] == '.') {
                result = (result << 8) + val;
                val = 0;
            } else {
                val = 10 * val + ip[i] - '0';
            }
        }
        return result;
    }

    string ntoa(uint32_t ip) {
        string s;
        for (int i = N - 1; i >= 0; --i) {
            s  = (i != 0 ? "." : "") + std::to_string(ip % 256) + s;
            ip >>= 8;
        }
        return s;
    }

    int indexOf(uint32_t num) {
        int count = 0;
        for (; num != 1; num >>= 1) {
            count++;
        }
        return count;
    }

    uint32_t msb(uint32_t num) {
        uint32_t mask = 1U << 31;
        while (! num & mask) {
            mask >>= 1;
        }
        return mask;
    }

    uint32_t lsb(uint32_t num) {
        return num & (-num);
    }
};

int main() {
        vector<string> result;
        Solution sol;
        sol.cidr("10.5.2.10", "10.5.2.209", result);
        for (auto& c : result) {
        cout << c << " ";
        }
        return 0;
        }
 */