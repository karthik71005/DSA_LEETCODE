class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        
        HashSet<Integer> seen =  new HashSet<>();
        HashSet<Integer> seen1=  new HashSet<>();
        for(int num:nums1){
            seen.add(num);
        }
        for(int num:nums2)
        {
            if(seen.contains(num)){
                seen1.add(num);
            }
        }

        int [] res=seen1.stream().mapToInt(i -> i).toArray();
        return res;
    }
}