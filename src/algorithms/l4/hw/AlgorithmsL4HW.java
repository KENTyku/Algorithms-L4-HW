/*
 * Use and copying for commercial purposes
 * only with the author's permission
 */
package algorithms.l4.hw;

/**
 *
 * @author Yuri Tveritin
 */
public class AlgorithmsL4HW {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ex1();
        
    }
    /**
     * метод подсчета количества возможных маршрутов при перемещении из точки A[0][0]  в точку A[m-1][n-1]
     */
    static void ex1(){
        int n=3; //количество строк поля
        int m=3; //количество столбцов поля
        
        //поле по которому перемещаемся        
        int [][] A=new int[m][n];
        
        //карта препятствий
        int [][] B=new int[m][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                B[i][j]=1;
            }
            
        }
        //препятствия на карте
        B[0][1]=0;
        B[0][2]=0;
        B[2][1]=0;
        
        //алгоритм поиска количества маршрутов
        for (int j = 0; j < m; j++) {
            A[0][j]=1*B[0][j];
        }
        for (int i = 1; i < n; i++) {
            A[i][0]=1*B[i][0];
            for (int j = 1; j < m; j++) {
                A[i][j]=(A[i][j-1]+A[i-1][j])*B[i][j];
            }
        }
        
        System.out.println("количество маршрутов="+A[m-1][n-1]);
        
    }
    
}
