package com.xl.sort;

//优先队列
public class MaxPQ<Key extends Comparable<Key>> {

    private Key pq[];
    int N = 0;  //0不用,从1开始作为树根

//    上浮
    public void swim(int k){
//        k是要上浮元素的位置,当k>1时该节点才有父节点,当父节点元素比次节点小时,交换位置,该元素位置变为父节点的位置
        while (k>1&&SortUtils.less(pq[k/2],pq[k])){
            SortUtils.exch(pq,k/2,k);
            k = k/2;
        }
    }

//   下沉
    public void sink(int k){
//        没有左孩子节点时停止
        while (2*k<=N){
//            记录该与哪个孩子节点交换,默认值是左孩子节点
            int j = 2*k;
//            如果左孩子节点比右孩子节点小,则j指向右孩子节点
            if(j<N&&SortUtils.less(pq[j],pq[j+1]))
                j++;
//            如果当前节点不比孩子节点小就停止循环
            if(!SortUtils.less(pq[k],pq[j]))
                break;
//            交换当前节点和更大的孩子节点,然后当前节点变为交换的孩子节点的位置
            SortUtils.exch(pq,k,j);
            k = j;
        }
    }

//    因为0位置不用,所以要+unit1
    public MaxPQ(int size){
        pq = (Key[])new Comparable[size+1];
    }

//    判断优先队列是否为空
    public boolean isEmpty(){
        return N==0;
    }

//    返回优先队列元素个数
    public int size(){
        return N;
    }

//    插入元素
    public void insert(Key key){
//        移到下一个位置,放入元素
        pq[++N] = key;
//        上浮该元素到合适位置
        swim(N);
    }

//    删除最大元素
    public Key delMax(){
//        最大元素就是树根
        Key max = pq[1];
//        交换树根和最后位置的元素,当前位置向前移一位,舍弃最大值树根
        SortUtils.exch(pq,1,N--);
//        避免对象游离,将舍弃的对象置空
        pq[N+1] = null;
//        对当前树根元素下沉到合适位置
        sink(1);
        return max;
    }

    public static void main(String[] args) {
        MaxPQ<Integer> maxPQ = new MaxPQ<>(10);
        maxPQ.insert(5);
        maxPQ.insert(6);
        maxPQ.insert(9);
        maxPQ.insert(1);
        maxPQ.insert(3);
        maxPQ.insert(15);
        SortUtils.print(maxPQ.pq);
        System.out.println(maxPQ.delMax()+" "+maxPQ.delMax()+" "+maxPQ.delMax()+" "
                            +maxPQ.delMax()+" "+maxPQ.delMax()+" "+maxPQ.delMax());
    }

}
