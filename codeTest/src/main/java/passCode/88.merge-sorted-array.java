class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (nums1.length != m + n || m+n > nums1.length)
        {
            return;
        }

        int k = nums1.length - 1;
        m--;
        n--;

        while(m >= 0 && n >=0)
        {
            if (nums1[m] > nums2[n])
            {
                nums1[k--] = nums1[m];
                m--;
            }
            else if (nums1[m] < nums2[n])
            {
                nums1[k--] = nums2[n];
                n--;
            }
            else if (nums1[m] == nums2[n])
            {
                nums1[k--] = nums1[m];
                m--;
                nums1[k--] = nums2[n];
                n--;
            }
        }

        if (n >= 0)
        {
            while(n>=0)
            {
                nums1[k--] = nums2[n];
                n--;
            }
        }
    }
}
