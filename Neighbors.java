import java.util.*;
import java.io.*;

public class Neighbors
{
   public static void main(String args[])
   {
      File F = new File("training.txt");
      int num = lines(F);      
      Passenger[] list = new Passenger[num];
      makeList(F, list);

      File f = new File("test.txt");
      int num2 = lines(f);
      Passenger[] unknown = new Passenger[num2];
      makeList(f, unknown);

      int k = 3;

      for(int i = 0; i < unknown.length; i++)
      {
         Distance[] d = new Distance[num];
         sortDistance(d, list, unknown[i]);
         classify(d, list, unknown[i], k);
         System.out.println(unknown[i].getName() + " " + unknown[i].getFate());
      }
   }

   public static int lines(File f)
   {
      int count = 0;
      try(Scanner in = new Scanner(f);)
      {
         while(in.hasNext())
         {
            String s = in.nextLine();
            count++;
         }
         
       }
       catch(FileNotFoundException e)
       {
         System.out.println("file not found");
       }
       return count;
   }
   public static void makeList(File f, Passenger[] p)
   {
      try(Scanner in = new Scanner(f);)
      {
         int count = 0;
         while(in.hasNext())
         {
            String[] s = in.nextLine().split("\\s+");
            p[count] = new Passenger(s);
            count++; 
         }

      }
      catch(FileNotFoundException e)
      {
               System.out.println("file not found");
      }
   }

   public static void sortDistance(Distance[] d, Passenger[] list, Passenger unknown)
   {                     
      //To be completed
       for(int i = 0; i < list.length; i++)
       {
         double fare = (Math.pow((list[i].getFare() -  unknown.getFare()), 2));
         double dClass = (Math.pow((list[i].getPClass() - unknown.getPClass()), 2));
         double gender = (Math.pow((list[i].getGender() - unknown.getGender()), 2));
         
         double result = Math.sqrt(fare + dClass + gender);
         d[i]  = new Distance(i, result);
        } 
         sort(d);
         
        
   }    
   public static void swap(Distance[] d, int i, int tempIndex)
   {
      Distance temp = new Distance(d[i].getIndex(), d[i].getDistance());
      Distance index = new Distance(d[tempIndex].getIndex(), d[tempIndex].getDistance());
      d[i] = index;
      d[tempIndex] = temp; 
   }
   
   public static void classify(Distance[] d, Passenger[] list, Passenger unknown, int k)
   {
      //To be completed
     int countL = 0;
     int countD = 0;
     String str = "";
     for(int i = 0; i < k; i++)
     {
         int index = d[i].getIndex();
         if(list[index].getFate().equals("live"))
            countL++;
         else
            countD++;
     }
      if(countL >= countD)
         str = "live";
      else
         str = "dead";
         
     unknown.setFate(str);

   }

   public static void sort(Distance[] d)
   {
      for (int i = 0; i < d.length - 1; i++)
      {
         double tempMin = d[i].getDistance();
         int tempIndex = i;
      
         for (int j = i + 1; j < d.length; j++)
         {
         	if (d[j].getDistance() < tempMin)
         	{
         	   tempMin = d[j].getDistance();
         	   tempIndex = j;
         	}
         }

         swap(d, i, tempIndex);
      }
   }
}
