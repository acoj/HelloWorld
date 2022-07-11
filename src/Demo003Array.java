public class Demo003Array {
    /**
    * @Description: kdjf
    * @Param: [args]
    * @return: void
    * @Date: 12/25/21
    */
    public static void main(String[] args) {
        /*byte[] age1 = new byte[5];
        System.out.println(age1[0]);
        short[] age2 = new short[]{18,19,17,16,20};
        System.out.println(age2);
        int[] age3 = {18,19,17,16,20};
        System.out.println(age3);
        double[] height = new double[5];
        System.out.println(height[0]);
        float[] height1 = new float[5];
        System.out.println(height1[0]);

        System.out.println(age1.length);

        for(int temp : age3){
            System.out.println(temp);
        }

        System.out.println(age1);*/

        Student[] std = new Student[3];
        std[0] = new Student("cxf", 25, true);
        Student std2 = new Student("cxf2", 20, false);
        Student std3 = new Student("cxf3", 22, true);
        System.out.println(std[0]);


    }
}