package com.yidu.lr.controller;

public class Test {




    /**
     * 1、爬楼梯算法：已知一个楼梯有n个台阶，每次可以选择迈上一个或者两个台阶，求走完一共有多少种不同的走法。
     *
     *  已知    climbStairs(2)=x  climbStairs(1)=y    求climbStairs(n)=?     climbStairs(n-1)+climbStairs(n-2)=总走法
     *
     *  n=3    climbStairs(3) = climbStairs(2)+climbStairs(1)=x+y;
     *  n=4    climbStairs(4) = climbStairs(3)+climbStairs(2) = (climbStairs(2)+climbStairs(1))+climbStairs(2) = (x+y)+x = 2x+y;
     *  n=5    climbStairs(5) = climbStairs(4)+climbStairs(3) = ((climbStairs(2)+climbStairs(1))+climbStairs(2))+(climbStairs(2)+climbStairs(1)) = ((x+y)+x)+(x+y) = 3x+2y;
     *  n=6    climbStairs(6) = climbStairs(5)+climbStairs(4) = (3x+2y)+(2x+y) = 5x+3y;
     *  n=7    climbStairs(7) = climbStairs(6)+climbStairs(5) = (5x+3y)+(3x+2y) = 8x+5y
     *  n=n    climbStairs(n)=climbStairs(n-1)+climbStairs(n-2);
     * @param n
     * @return
     */
    public static int climbStairs(int n){
        int i=1;
        if(n<=0)
            return 0;
        if(n==1) {
            return i;
        }if(n==2){
            i++;
            return i;
        }else
            return climbStairs(n-1)+climbStairs(n-2);
    };


    private final int TRIED=3;
    private final int PATH=7;

    private int [][] grid={
            {1,1,1,0,0,1,0,1,0,0},
            {0,0,1,1,1,0,0,0,0,0},
            {1,0,1,0,0,0,1,1,1,1},
            {1,1,1,1,1,0,0,0,1,1},
            {0,0,0,0,1,1,1,0,0,0},
            {1,0,1,0,1,0,0,1,0,0},
            {1,0,0,1,1,1,1,1,1,1}		};
    public boolean traverse(int row,int column){
        boolean done =false;
        if(valid(row,column))
        {
            grid[row][column]=TRIED;
            if(row==grid.length-1&&column==grid[0].length-1)
                done=true;
            else
            {
                done=traverse(row+1,column);//down
                if(!done)
                    done=traverse(row,column+1);//right
                if(!done)
                    done=traverse(row-1,column);//up
                if(!done)
                    done=traverse(row,column-1);//left
            }
            if(done)
                grid[row][column]=PATH;
        }
        return done;
    }
    private boolean valid(int row,int column){
        boolean result=false;
        if(row>=0&&row<grid.length&&column>=0&&column<grid[row].length)
            if(grid[row][column]==1)
                result=true;
        return result;
    }
    public String toString(){
        String result="\n";
        for (int row=0;row<grid.length;row++){
            for(int column=0;column<grid[row].length;column++){
                result +=grid[row][column]+" ";
            }
            result+="\n";
        }
        return result;
    }

    public static void main (String []args){
        
        //1、爬楼梯算法：已知一个楼梯有n个台阶，每次可以选择迈上一个或者两个台阶，求走完一共有多少种不同的走法。
        //System.out.println("climbStairs(T) = " + climbStairs(3));

        //2.迷宫走法：二维数组构成一个迷宫，1表示通路，0表示不通，找到一条路径从起始点（traverse函数的参数）到终点（右下角点）。
        //
        //基础情形：row=grid.length-1&&column=grid[0].length-1时done=true；
        Test test=new Test();
        System.out.println(test);
        if(test.traverse(0, 0))
            System.out.println("The maze was successfully travelled!");
        else
            System.out.println("There is no possible path.");
        System.out.println(test);
    }
}
