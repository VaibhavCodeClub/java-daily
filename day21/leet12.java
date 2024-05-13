// Integer to Roman
/*
Seven different symbols represent Roman numerals with the following values:
Symbol	Value

| I |	1    | 
| V |	5    | 
| X |	10   | 
| L |	50   | 
| C |	100  | 
| D |	500  | 
| M |	1000 |

Roman numerals are formed by appending the conversions of decimal place values from highest to lowest. Converting a decimal place value into a Roman numeral has the following rules:

    If the value does not start with 4 or 9, select the symbol of the maximal value that can be subtracted from the input, append that symbol to the result, subtract its value, and convert the remainder to a Roman numeral.
    If the value starts with 4 or 9 use the subtractive form representing one symbol subtracted from the following symbol, for example, 4 is 1 (I) less than 5 (V): IV and 9 is 1 (I) less than 10 (X): IX. Only the following subtractive forms are used: 4 (IV), 9 (IX), 40 (XL), 90 (XC), 400 (CD) and 900 (CM).
    Only powers of 10 (I, X, C, M) can be appended consecutively at most 3 times to represent multiples of 10. You cannot append 5 (V), 50 (L), or 500 (D) multiple times. If you need to append a symbol 4 times use the subtractive form.

Given an integer, convert it to a Roman numeral.
*/

public class leet12 {
  public static void main(String[] args) {
    System.out.println(intToRoman(3749));
  }

  public static String intToRoman(int num) {
    StringBuilder sb = new StringBuilder();

    if (num >= 1000) {
      int count = num / 1000;
      for (int i = 0; i < count; i++) {
        sb.append("M");
      }
      num %= 1000;
    }

    if (num >= 900) {
      sb.append("CM");
      num %= 900;
    } else if (num >= 500) {
      sb.append("D");
      num %= 500;
    } else if (num >= 400) {
      sb.append("CD");
      num %= 400;
    }
    if (num >= 100) {
      int count = num / 100;
      for (int i = 0; i < count; i++) {
        sb.append("C");
      }
      num %= 100;
    }

    if (num >= 90) {
      sb.append("XC");
      num %= 90;
    } else if (num >= 50) {
      sb.append("L");
      num %= 50;
    } else if (num >= 40) {
      sb.append("XL");
      num %= 40;
    }
    if (num >= 10) {
      int count = num / 10;
      for (int i = 0; i < count; i++) {
        sb.append("X");
      }
      num %= 10;
    }

    if (num >= 9) {
      sb.append("IX");
      num %= 9;
    } else if (num >= 5) {
      sb.append("V");
      num %= 5;
    } else if (num >= 4) {
      sb.append("IV");
      num %= 4;
    }
    if (num >= 1) {
      int count = num;
      for (int i = 0; i < count; i++) {
        sb.append("I");
      }
    }

    return sb.toString();
  }
}
