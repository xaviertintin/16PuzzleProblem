package com.astar;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;
/**
 *
 * @author Grupo 2
 * David Mena
 * Ricardo Teran
 * Xavier Tintin
 */
public class Astars {
    private int a[][]=new int[5][4];
    private int b[][]=new int[5][4];
    private int Expnode[][]=new int[5][4];
    private int l=0;
    private int parent[][]=new int[5][4];
    List<int[][]> l1=new ArrayList();
    List<int[][]> l2=new ArrayList();
    private int row=0;
    private int col=0;
    private int prow=-1;
    private int pcol=-1;
    private int temp=0;
    private int depth=0;
    private int t=0;
    private int pathcost=0;
    private int StatesEnqued=1;

    public void getState(int c[][])throws Exception {
        System.out.println("\n Enter the initial State:");

        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                a[i][j]=c[i][j];
            }
        }
        a[4][1]=depth;

        System.out.println("\n Enter the final State:");
        b[0][0]=1;
        b[0][1]=2;
        b[0][2]=3;
        b[0][3]=4;
        b[1][0]=5;
        b[1][1]=6;
        b[1][2]=7;
        b[1][3]=8;
        b[2][0]=9;
        b[2][1]=10;
        b[2][2]=11;
        b[2][3]=12;
        b[3][0]=13;
        b[3][1]=14;
        b[3][2]=15;
        b[3][3]=0;
    }
    public void display() {
        System.out.println("\n The initial state is:");
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                System.out.print("\t"+a[i][j]);
            }
            System.out.println();
        }

        System.out.println("\n ==============================================================================");

        System.out.println("\n The final state is:");
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                System.out.print("\t"+b[i][j]);
            }
            System.out.println();
        }
        System.out.println("\n ==============================================================================");
    }
    public void displayState(int a[][]) {
        GUI16Puzzle gui = new GUI16Puzzle();
        gui.setVisible(false);
        System.out.println("\n ==============================================================================");
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                System.out.print("\t"+a[i][j]);
                gui.c[i][j]=a[i][j];
            }
            System.out.println("");
        }



        System.out.println(" ==============================================================================\n");
    }
    public int[][] TreeSearch() {
        l1.add(a);
        while(true) {
            if(l1.isEmpty()==false) {
                Expnode=l1.remove(getMin());
                displayState(Expnode);                  // get array every time this function is executed
            }
            else {
                System.out.println("Fail");
            }
            t=0;
            for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                    if(Expnode[i][j]!=b[i][j]) {
                        t=1;
                    }
                }
            }
            if(t!=1) {
                System.out.println("The path cost is: "+Expnode[4][1]);
                System.out.println("The Total Number of states Explored: "+StatesEnqued);
                System.out.println("Success");
                return Expnode;
            }
            else {
                expand(Expnode,Expnode[4][1]+1);
                for(int i=0;i<4;i++) {
                    for(int j=0;j<4;j++) {
                        parent[i][j]=Expnode[i][j];
                    }
                }
            }
        }
    }
    int getMin(){
        int min = l1.get(0)[4][0];
        int index = 0;
        for(int i=1;i<l1.size();i++) {
            if(l1.get(i)[4][0]<min){
                min = l1.get(i)[4][0];
                index =i;
            }
        }
        System.out.print("\nMinimum cost selected: "+min+"\n");
        return index;
    }
    public void expand(int k[][],int depth) {
        findSuccessor(k,depth);
        prow=row;
        pcol=col;
    }
    public void findSuccessor(int orgnode[][],int depth) {
        findspace(orgnode);
        if((row-1>=0 && prow!=row-1)|| (row-1>=0 && prow==-1)) {
            int n[][]=new int[5][4];
            for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                    n[i][j]=orgnode[i][j];
                }
            }
            swap(n,row-1,col,depth);                //For top shift
        }
        if((col+1<=3 && pcol!=col+1) || (col+1<=3 && pcol==-1)) {
            int n[][]=new int[5][4];
            for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                    n[i][j]=orgnode[i][j];
                }
            }
            swap(n,row,col+1,depth);               //for Right shift
        }
        if((row+1<=3 && prow!=row+1) || (row+1)<=3 && prow==-1) {
            int n[][]=new int[5][4];
            for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                    n[i][j]=orgnode[i][j];
                }
            }
            swap(n,row+1,col,depth);                //for bottom shift
        }

        if((col-1>=0 && pcol!=col-1) || (col-1)>=0 && pcol==-1) {
            int n[][]=new int[5][4];
            for(int i=0;i<4;i++) {
                for(int j=0;j<4;j++) {
                    n[i][j]=orgnode[i][j];
                }
            }
            swap(n,row,col-1,depth);                //for left shift
        }
    }
    public void swap(int listnode[][],int j,int k,int depth) {
        int count=0;
        int cost=0;
        int temp=listnode[j][k];
        int s = 1;
        //int depth=0;
        listnode[j][k]=listnode[row][col];
        listnode[row][col]=temp;
        listnode[4][1]=depth;
        for(int i=0;i<4;i++) {
            for(int p=0;p<4;p++) {
                if(listnode[i][p]!=b[i][p]) {
                    count++;
                }
            }
        }
        StatesEnqued++;
        cost=listnode[4][1]+count;
        System.out.print("Costs is: "+cost+" ");
        listnode[4][0]=cost;
        l1.add(listnode);
    }
    public void findspace(int orgnode[][]) {
        for(int i=0;i<4;i++) {
            for(int j=0;j<4;j++) {
                if(orgnode[i][j]==0) {
                    row=i;
                    col=j;
                    break;
                }
            }
        }
    }
}