class Solution {
    public int reverse(int x) {
        int reverse=0,multiple=1;
        if(x<0){x*=-1;multiple=-1;}
        while(x>0){
            int digit=x%10;
            if(Math.abs(reverse) > (Integer.MAX_VALUE- Math.abs(digit))/10) return 0;
            reverse=reverse*10+digit;
            x/=10;
        }
        return reverse*multiple;
    }
}