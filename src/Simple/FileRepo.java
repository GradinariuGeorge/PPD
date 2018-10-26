package Simple;

import java.io.*;

public class FileRepo {
     public void writeMatrix(String filename, int[][] matrix,int nrRows, int nrCols) {
        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write(nrRows+" "+nrCols);
            bw.newLine();
            for (int i = 0; i < matrix.length; i++) {
                for (int j = 0; j < matrix[i].length; j++) {
                    bw.write(matrix[i][j] + " ");
                }
                bw.newLine();
            }
            bw.flush();
        } catch (IOException e) {
        }
    }

    public void readMatrix(Matrix matrix,String fileName) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(fileName));
        String[] mDimensions = br.readLine().split(" ");
        int m1Rows = Integer.parseInt(mDimensions[0]);
        int m1Cols = Integer.parseInt(mDimensions[1]);
        matrix.setNrRows(m1Rows);
        matrix.setNrCols(m1Cols);
        matrix.setElems(new int[m1Rows][m1Cols]);
        for(int i = 0; i < m1Rows; i++) {
            String[] line = br.readLine().split(" ");
            for(int j = 0; j < m1Cols; j++) {
                matrix.replace(i, j, Integer.parseInt(line[j]));
            }
        }
    }
}
