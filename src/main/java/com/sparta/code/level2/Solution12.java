package com.sparta.code.level2;

class Solution12 {

    public int[][] solution(int[][] arr1, int[][] arr2) {
        return multiplyMatrices(arr1, arr2);
    }

    private int[][] multiplyMatrices(int[][] matrix1, int[][] matrix2) {
        
        int rowsMatrix1 = matrix1.length;
        int colsMatrix1 = matrix1[0].length;
        int colsMatrix2 = matrix2[0].length;
        
        int[][] result = new int[rowsMatrix1][colsMatrix2];

        for (int i = 0; i < rowsMatrix1; i++) {
            for (int j = 0; j < colsMatrix2; j++) {
                result[i][j] = multiplyMatrixCell(matrix1, matrix2, i, j, colsMatrix1);
            }
        }
        
        return result;
        
    }

    private int multiplyMatrixCell(int[][] matrix1, int[][] matrix2, int row, int col, int commonDim) {
        int cellValue = 0;
        
        for (int k = 0; k < commonDim; k++) {
            cellValue += matrix1[row][k] * matrix2[k][col];
        }
        
        return cellValue;
        
    }
    
}
