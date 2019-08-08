

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Random;

public class FindingThreshold {
	
	public static void main(String[] args) throws Exception {

		new FindingThreshold();
	}

	FindingThreshold () throws Exception {
		
		BufferedReader in = null;
		ArrayList<String> l = new ArrayList<String>();
		try{
		
		String dirPath = "C:\\Users\\User\\Documents\\jedithigh.csv";
		in = new BufferedReader(new FileReader(dirPath));
		
		String c;
		while ((c = in.readLine()) != null) {
           l.add(c);
        }
		}finally {
	         if (in != null) {
		            in.close();
		         }
		      }
		
		int size = l.size();
        ArrayList<Integer> list = new ArrayList<Integer>(size);
        for(int i = 1; i <= size; i++) {
            list.add(i);
        }

        Random rand = new Random();
        while(list.size() > 0) {
            int index = rand.nextInt(list.size());
            list.remove(index);
            System.out.println(l.get(index));
            l.remove(index);
//            System.out.println("Selected: "+ list.remove(index));
        }
	}
}
