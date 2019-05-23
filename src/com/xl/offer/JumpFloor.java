package com.xl.offer;

//同样适用斐波那契数列
public class JumpFloor {

    /**
     * 一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法（先后次序不同算不同的结果）。
     * @param target
     * @return
     */
//    target=1时，有1种跳法，target=2时，有两种跳法，一种是一次跳两级，另一种是一级一级跳
//    设f(target)为跳法的函数，当target=n时，第一跳有2种不同选择，跳一级和跳两级
//    若跳一级,则之后有f(n-1)种跳法，若跳两级，则之后有f(n-2)种跳法，f(n)=f(n-1)+f(n-2),由此又转化成了斐波那契数列，只不过初值不同
    public static int JumpFloor(int target) {
        int[] arr = {1,2};
        if(target<3){
            return arr[target-1];
        }
        int one = 1;
        int two = 2;
        int result = 0;
        for (int i=3;i<=target;i++){
            result = one + two;
            one = two;
            two = result;
        }
        return result;
    }

    public static int JumpFloor2(int target) {
        return (int) Math.pow(2,target-1);
    }

    public static void main(String[] args) {
        System.out.println(JumpFloor2(3));
    }

}
