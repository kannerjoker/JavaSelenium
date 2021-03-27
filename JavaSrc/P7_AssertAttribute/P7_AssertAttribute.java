package P7_AssertAttribute;

import org.testng.Assert;

public class P7_AssertAttribute {
    public static void main(String[] args) {
        assertAttribute(Integer.valueOf(1),Integer.valueOf(2));
        int[] arr1 = {1, 2, 3};
        int[] arr2 = {1, 2, 4};
        assertAttribute(arr1,arr2);
    }

    public static void assertAttribute(Object n,Object m){
        try{
            Assert.assertEquals(n,m,"Exceptions");
        }catch(Error e){
            e.printStackTrace();
        }
        System.out.println();
    }

}
