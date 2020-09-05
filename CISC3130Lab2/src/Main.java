import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
public class Main {
    public static void main(String [] args){
        String [] unSorted = new String[200];
        String line;
        String fileName = "C:\\Users\\Jacks\\OneDrive\\Desktop\\Artists9-5-2020";
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(fileName);
        }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        try {
            Scanner sc = new Scanner(new File("C:\\Users\\Jacks\\OneDrive\\Desktop\\Spotify.csv"));
            String x = sc.nextLine();
            String y = sc.nextLine();
            int count = 0;
            for(int i = 0; sc.hasNextLine(); i++) {                                       //Reads the csv files, but only the column with artists
                        line = sc.nextLine();
                        String[] values = line.split(",");
                        unSorted[i] = values[2].replaceAll("\"", "");
                        count++;
                    }



                    }catch (FileNotFoundException e){
            e.printStackTrace();
        }

        int [] timeShown = findDupe(unSorted);                          //Assigns the array values of findDupe into the array timeshown
        String [] sortedArtists = removeDupe(unSorted);
        for(int i = 0; i<sortedArtists.length; i++){                      //For loop that wrties all the data into a file
            writer.println(sortedArtists[i] + " " +timeShown[i]);
        }
        writer.close();


    }

    public static int [] findDupe(String [] unSorted){ // This method finds the number of times the artists appear in the chart
        int count = 1;                                 // Count is initialized to one because they have to atleast have shown up once to be read in
        int [] x = new int[unSorted.length];           // Here we use a nested for loop to find duplicates. If there is a duplicate count will ++
        for(int i = 0; i < unSorted.length-1; i++){    // Else itll just return count which is one
            for (int j =i+1; j<unSorted.length; j++){
                if(unSorted[i].equalsIgnoreCase(unSorted[j])){
                    x[i] = ++count;
                }
                else{
                    x[i] = count;
                }
            }
            count = 1;
        }
        return x;                                    // returns array x which stores the value of the amount of times the artists shows up
    }

    public static String [] removeDupe(String [] unSorted) { //This method removes dupes.
        int length = unSorted.length;                        //It takes in the unsorted array and removes the duplicates
        String[] temp = new String[length];                  //We make a temp array. First it reads all the names and puts it into the temp array
        int k = 0;                                          //However with the if statement it won't put in duplicative names
        for (int i = 0; i < length-1; i++) {
            if (!unSorted[i].equalsIgnoreCase(unSorted[i + 1])) {
                temp[k++] = unSorted[i];
            }
        }
        temp[k++] = unSorted[length - 1];

        String[] sortedArtist = new String[k];

        for(int i = 0; i < k; i++)
        {
            sortedArtist[i] = temp[i];
        }


        return sortedArtist;
    }
}


