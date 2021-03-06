package com.nicodangelo.item;

import java.util.ArrayList;

public class Sorty
{
    public static void sortString(ArrayList<String> s, int size)
    {/*
        String[] sort = new String[size];
        for(int k = 0; k < size; k++)
        {
            sort[k] = s.get(k);
        }*/

        long start = System.nanoTime();
        for (int k = s.size() - 1; k >= 1; k--)
        {
            String  currentMax = s.get(0);
            int currentMaxIndex = 0;

            for (int j = 1; j <= k; j++)
            {
                if (currentMax.compareTo(s.get(j)) < 0)
                {
                    currentMax = s.get(j);
                    currentMaxIndex = j;
                }
            }
            if (currentMaxIndex != k)
            {
                s.add(currentMaxIndex, s.get(k));
                s.add(k, currentMax);
            }
        }

        long stop = System.nanoTime();
        System.out.println((stop - start));

/*        s.clear();
        for(int k = 0; k < size; k++)
        {
            s.add(sort[k]);
        }*/
    }
    public static ArrayList<Integer> quickSort(int[] sort, int start, int end)
    {
        long beginning = System.nanoTime();
        if(end - start >= 1)
        {
            int p = sort[start];
            int q = sort[end];
            if(p > q)
            {
                int temp = p;
                p = q;
                q = temp;
            }
            int l = start + 1;
            int g = end -1;
            int k = l;
            while(k <= g)
            {
                if(sort[k]< p)
                {
                    swap(sort, k, l);
                    l++;
                }
                else if(sort[k]>=q)
                {
                    while(sort[g] > q && k <g)
                        g--;

                    swap(sort, k, g);
                    g--;
                    if(sort[k]<p)
                    {
                        swap(sort, k, l);
                        l++;
                    }
                }
                k++;
            }
            l--;
            g++;
            swap(sort,start,l);
            swap(sort,end,g);
            quickSort(sort,start, l -1);
            quickSort(sort,l+1,g-1);
            quickSort(sort,g+1,end);
        }

        long ending = System.nanoTime();
        System.out.println(beginning - ending);
        ArrayList<Integer> s = new ArrayList<Integer>();
        for(int a = 0; a < end; a++)
        {
            s.add(sort[a]);
        }
        return s;
    }
    public static void swap(int array[], int index1, int index2)
    {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }
    public static ArrayList<Integer> selectionSort(int[] sort, int start, int end)
    {
        for (int k = sort.length - 1; k >= 1; k--)
        {
            int  currentMax = sort[0];
            int currentMaxIndex = 0;

            for (int j = 1; j <= k; j++)
            {
                if (currentMax < sort[j])
                {
                    currentMax = sort[j];
                    currentMaxIndex = j;
                }
            }
            if (currentMaxIndex != k)
            {
                sort[currentMaxIndex] = sort[k];
                sort[k] = currentMax;
            }
        }

        ArrayList<Integer> s = new ArrayList<Integer>();
        for(int k = 0; k < end; k++)
        {
            s.add(sort[k]);
        }
        return s;
    }
    public static void printall(ArrayList<String> s)
    {
        int wordCount = 0;
        String combined = "";
        for(int k = 0; k < s.size(); k++)
        {
            combined = combined + " "+ s.get(k);
            wordCount++;
            if(wordCount == 10)
            {
                System.out.println(combined);
                combined = "";
                wordCount = 0;
            }
        }
        System.out.println();
    }

    public static void printall(ArrayList<Integer> s, int a)
    {
        String combined = "";
        int wordCount = 0;
        for(int k = 0; k < s.size(); k++)
        {
            combined = combined + " "+ s.get(k);
            wordCount++;
            if(wordCount == 10)
            {
                System.out.println(combined);
                combined = "";
                wordCount = 0;
            }
        }
        System.out.println();
    }
}
