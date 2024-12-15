package org.example;

import org.example.Exceptions.*;

public class Main {
    public static void main(String[] args) {
        String[][] array = new String[][] {{"3", "4", "5", "3"}, {"2", "4", "5", "2"}, {"1", "4", "5", "1"}, {"0", "4", "5", "0"}};
        String[][] arrayWrongSize = new String[][] {{"3", "4", "5", "3"}, {"2", "4", "5", "2", "3"}, {"3", "5", "6", "2"}};
        String[][] arrayWrongData = new String[][] {{"3", "4", "5", "3"}, {"2", "abracadabra", "5", "2"}, {"1", "4", "5", "1"}, {"0", "4", "5", "0"}};

        System.out.println(FourByFourArray(array));
        System.out.println(FourByFourArray(arrayWrongSize));
        System.out.println(FourByFourArray(arrayWrongData));
    }

    static int FourByFourArray(String[][] myArray) {
        int result = 0;
        try{
            if (myArray.length != 4 || myArray[0].length != 4 || myArray[1].length != 4 || myArray[2].length != 4 || myArray[3].length != 4) {
                throw new MyArraySizeException("Wrong array length");
            }
            for(int i = 0; i < myArray.length; i++){
                for(int j = 0; j < myArray[i].length; j++){
                    try{
                        result += Integer.parseInt(myArray[i][j]);
                    }catch(NumberFormatException e){
                        throw new MyArrayDataException("Wrong array data at index of Array["+ i + "][" + j + "] with '" + myArray[i][j] + "' value");
                    }
                }
            }
        }catch (MyArraySizeException | MyArrayDataException e){
            System.out.println(e.getMessage());
        }

        return result;
    }
}

