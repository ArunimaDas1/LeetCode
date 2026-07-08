// LC 454. 4Sum II
class FourSumII {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int a : nums1) {
            for (int b : nums2) {
                map.put(a + b, map.getOrDefault(a + b, 0) + 1);
            }
        }
        int count = 0;
        for (int c : nums3) {
            for (int d : nums4) {
                count += map.getOrDefault(-(c + d), 0);
            }
        }
        return count;
    }
}

// LC 424. Longest Repeating Character Replacement
class CharacterReplacement {
    public int characterReplacement(String s, int k) {
        int left = 0, maxFreq = 0, maxLen = 0;
        int[] freq = new int[26];
        for (int right = 0; right < s.length(); right++) {
            char c = s.charAt(right);
            freq[c - 'A']++;
            maxFreq = Math.max(maxFreq, freq[c - 'A']);
            while ((right - left + 1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right - left + 1);
        }
        return maxLen;
    }
}

// LC 383. Ransom Note
class RansomNote {
    public boolean canConstruct(String ransomNote, String magazine) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (char c : ransomNote.toCharArray()) {
            map.put(c, map.getOrDefault(c, 0) + 1);
        }
        for (char c : magazine.toCharArray()) {
            if (map.containsKey(c)) {
                map.put(c, map.get(c) - 1);
            }
        }
        for (int val : map.values()) {
            if (val > 0) return false;
        }
        return true;
    }
}

// LC 350. Intersection of Two Arrays II
class Intersection {
    public int[] intersect(int[] nums1, int[] nums2) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int num : nums1) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        List<Integer> result = new ArrayList<>();
        for (int num : nums2) {
            if (map.getOrDefault(num, 0) > 0) {
                result.add(num);
                map.put(num, map.get(num) - 1);
            }
        }
        int[] ans = new int[result.size()];
        for (int i = 0; i < result.size(); i++) ans[i] = result.get(i);
        return ans;
    }
}