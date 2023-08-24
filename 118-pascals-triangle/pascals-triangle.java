import java.math.BigInteger;
class Solution {
     public static BigInteger factorial(int number) {
        BigInteger factorial = BigInteger.ONE;

        for (int i = number; i > 0; i--) {
            factorial = factorial.multiply(BigInteger.valueOf(i));
        }

        return factorial;
    }
    public int findcombination(int n,int r){
            BigInteger nfact=factorial(n);
            BigInteger rfact=factorial(r);
            BigInteger ofact=factorial(n-r);
            BigInteger ans=(nfact.divide(rfact)).divide(ofact);
            int ans1=ans.intValue();
            return ans1;
    }
    public List<List<Integer>> generate(int n) {
        List<List<Integer>>ans=new ArrayList<>();
        for (int i=0;i<n;i++){
            List<Integer>l1=new ArrayList<>();
            int[] arr=new int[i+1];
            // System.out.println(findcombination(13,1));
            System.out.println(factorial(13));
            for(int j=0;j<i+1;j++){
                int adder=findcombination(i,j);
                l1.add(adder);
            }
            ans.add(l1);

        }
        return ans;
    }
}