import java.io.File;
import java.math.BigDecimal;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws Exception {
		//File rootDirectory = new File("C:\\Users\\nitesh\\Documents\\Storage\\Movies");
		File rootDirectory = new File("C:\\Users\\nitesh\\Desktop\\pics");
		for (File file : rootDirectory.listFiles()) {
			System.out.println(file.getName().substring(0, file.getName().length()-4));
			File renamedFile = new File(file.getName().substring(0, file.getName().length()-4));
			file.renameTo(renamedFile);
		}
		//traverseDirectory(rootDirectory);
	}

	private static void traverseDirectory(File rootDirectory) {
		for (File file : rootDirectory.listFiles()) {
			if (file.isDirectory()) {
				if (file.list().length == 0) {
					System.out.println(file.getAbsolutePath() + "\t" + file.getName());					
				} else {
					traverseDirectory(file);
				}
			}
		}
	}
	
	public static void test() {
		/*int[] A = new int[] {2,1,5,-6,9};
		System.out.println(solution1(A));
		
		A = new int[] {2, 4, 3, 5, 6, -2, 4, 7, 8, 9};
		System.out.println(solution1(A));
		
		A = new int[] {100000000, -1000000000,5, 6, -2, 4, 7};
		System.out.println(solution1(A));
		
		A = new int[] {-100000001};
		System.out.println(solution1(A));
		
		A = new int[] {};
		System.out.println(solution1(A));
		
		A = null;
		System.out.println(solution1(A));
		
		A = new int[] {100000001, 100000001, 100000001};
		System.out.println(solution1(A));*/
		
		/*A = new int[] {8,24,3,20,1,17};
		System.out.println(solution(A));
		
		A = new int[] {7,21,3,42,3,7};
		System.out.println(solution(A));
		
		A = new int[] {1, 5, 3, 19, 18, 25};
		System.out.println(solution(A));
		
		A = new int[] {1, 25};
		System.out.println(solution(A));*/
		
		String S = "AABBACABABAACBACBACAABABA";
		System.out.println(solution(S));
		
		S = "ABAAABBBB";
		System.out.println(solution(S));

	}
	public static String solution(String S) {
		boolean[] rulesApplied = {false, false, false, false, false, false};
		int[] rulesApplicable = {-1, -1, -1, -1, -1, -1};
        char[] charArray = S.toCharArray();
        char current = ' ';
        char previous= ' ';
        char next = ' ';
        StringBuilder solution = new StringBuilder();
        for (int i=0; i<S.length()-1;i++) {
        	previous = current;
        	current =  S.charAt(i);
        	next =  S.charAt(i+1);
        	if (current == 'B' && previous == 'A' ) {
        		solution.append('A');
        	} else if (current == 'B' && next == 'A' ) {
        		solution.append('A');
        	} else if (current == 'B' && previous == 'C' ) {
        		solution.append('C');
        	} else if (current == 'B' && next == 'C' ) {
        		solution.append('C');
        	} else {
        		solution.append(current);
        	}
        }
        
		for (int i = 0; i < solution.length()-1; i++) {
			current = solution.charAt(i);
			next = solution.charAt(i + 1);
			if (((current == 'A') && (next == 'C')) || ((current == 'C') && (next == 'A'))) {
				solution.deleteCharAt(i);
			}
		}
        
		/*while (findApplicableRules(S, rulesApplicable)) {        
        
        for (int i=0; i<rulesApplicable.length; i++) {
        	if (rulesApplicable[i] >-1 && !rulesApplied[i]) {
        		if (i==0) {
        			S=S.replace("AB", "AA");
        		}
        		if (i==1) {
        			S=S.replace("BA", "AA");
        		}
        		if (i==2) {
        			S=S.replace("CB", "CC");
        		}
        		if (i==3) {
        			S=S.replace("BC", "CC");
        		}
        		if (i==4) {
        			S=S.replace("AA", "A");
        		}
        		if (i==5) {
        			S=S.replace("CC","C");
        		}
        		
        	}
        }
        }*/
        
		return solution.toString();
    }

	private static boolean findApplicableRules(String S, int[] rulesApplicable) {
		rulesApplicable[0] = S.indexOf("AB");
        rulesApplicable[1] = S.indexOf("BA");
        rulesApplicable[2] = S.indexOf("CB");
        rulesApplicable[3] = S.indexOf("BC");
        rulesApplicable[4] = S.indexOf("AA");
        rulesApplicable[5] = S.indexOf("CC");
        for (int i : rulesApplicable) {
        	if (i>-1)
        		return true;
        }
        return false;
	}

	public static int solution2(int[] A) {
		Arrays.sort(A);
        
        // Initialize difference as infinite
        int diff = Integer.MAX_VALUE;
       
        // Find the min diff by comparing adjacent
        // pairs in sorted array
        for (int i=0; i<A.length-1; i++)
           if (A[i+1] - A[i] < diff)
               diff = A[i+1] - A[i];
       
        // Return min diff
        return diff;
	}
	
	public static int solution1(int[] A) {
		if (A == null || A.length == 0) {
			return 0;
		}
		int evenCount = 0;
		int oddCount = 0;
		for (int num : A) {
			if (num % 2 == 0) {
				evenCount++;
			} else {
				oddCount++;
			}
		}
		BigDecimal pairs = BigDecimal.valueOf(evenCount).multiply(BigDecimal.valueOf(evenCount-1)).divide(BigDecimal.valueOf(2));
		pairs = pairs.add(BigDecimal.valueOf(oddCount).multiply(BigDecimal.valueOf(oddCount-1)).divide(BigDecimal.valueOf(2)));
		int result = pairs.intValue();
		if (result > 1000000000) {
			return -1;
		}
		return result;
	}

}
