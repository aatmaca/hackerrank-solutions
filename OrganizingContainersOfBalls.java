package hackerRank;

import java.util.Arrays;
import java.util.Scanner;

public class OrganizingContainersOfBalls {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int q = in.nextInt();
        for(int a0 = 0; a0 < q; a0++){
            int n = in.nextInt();
            int[][] M = new int[n][n];
            for(int M_i=0; M_i < n; M_i++){
                for(int M_j=0; M_j < n; M_j++){
                    M[M_i][M_j] = in.nextInt();
                }
            }
            
            long[] containerSizes= new long[n];
            for(int i=0; i < n; i++){
                for(int j=0; j < n; j++){
                	containerSizes[i] += M[i][j];
                }
            }
            
            long[] typeSizes= new long[n];
            for(int i=0; i < n; i++){
                for(int j=0; j < n; j++){
                	typeSizes[i] += M[j][i];
                }
            }
            
            Arrays.sort(containerSizes);
            Arrays.sort(typeSizes);
            
            boolean impossible = false;
            for(int i=0; i < n; i++){
            	if (containerSizes[i] != typeSizes[i]) {
					impossible = true;
					break;
				}
            }

            if (impossible) {
            	 System.out.println("Impossible");
			} else {
				System.out.println("Possible");
			}
        }
        in.close();
    }
}
