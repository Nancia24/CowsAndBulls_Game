// CSC1016S assignment 06
// Exercise 1
// <Name and Surname> Nancia Mwaramba
// <Student Number> MWRNAN002
// <Date> 20 September 2022

// contains a collection of routines for working with integers.
import java.util.ArrayList;

public class NumberUtils{
     
// Constructors
// A private, empty-bodied constructor prevents NumberUtil objects from being created.
private NumberUtils(){

}

// Given a number that is n digits in length, maps the digits to an array length n.
public static int[] toArray(int number){
    int count = 0;
    int use = number;
    while (use>0){
        use /= 10;
        count++;
    }
    int[] array = new int[count]; 
    while (number> 0){
        int lastnum = number %10;       
        array[count-1] = lastnum;
        number /= 10;
        count--;
    }
    return array;
}
// Given two numbers, count the quantity of matching digits - those with the same value and position.
public static int countMatches(int numberA, int numberB){
    int index = 0;
    int[] numAList = toArray(numberA);
    int[] numBList = toArray(numberB);
    ArrayList<Number> count = new ArrayList<Number>();
    for (index= 0; numAList.length > index; index++){
         if (numAList[index]==numBList[index]){ 
            count.add(numAList[index]);
         }
    }
   return count.size(); 
}
// Count the quantity of digits that two numbers have in common, regardless of position.
public static int countIntersect(int numberA, int numberB){
    int i = 0;
    int j = 0;
    int[] numAList = toArray(numberA);
    int[] numBList = toArray(numberB);
    ArrayList<Number> count = new ArrayList<Number>();
    for (i= 0; numAList.length > i; i++){
        for (j= 0; numBList.length > j; j++)
         if (numAList[i]==numBList[j]){ 
            count.add(numAList[j]);
         }
    }
   return count.size(); 
}

}
