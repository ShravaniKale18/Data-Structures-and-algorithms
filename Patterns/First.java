package Patterns;

public class First {

    static void printPattern1(int n) {
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void printPattern2(int n) {
        int num = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(num);
            }
            num++;
            System.out.println();
        }
    }

    static void printPattern3(int n) {
        for(int i = n; i >= 0; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    static void printPattern4(int n) {
        for(int i = n; i >= 0; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void printPattern5(int n) {
        for(int i = 1; i <= n ; i++) {
            for(int s = 0; s <= n - i - 1; s++) {
                System.out.print(" ");
            }

            for(int st = 0; st < 2 * i - 1; st++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void printPattern6(int n) {
        for(int i = n; i >= 0 ; i--) {
            for(int s = 0; s <= n - i - 1; s++) {
                System.out.print(" ");
            }

            for(int st = 0; st < 2 * i - 1; st++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void printPattern7(int n) {
        for(int i = 1; i <= n ; i++) {
            for(int s = 0; s <= n - i - 1; s++) {
                System.out.print(" ");
            }

            for(int st = 0; st < 2 * i - 1; st++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for(int i = n; i >= 0 ; i--) {
            for(int s = 0; s <= n - i - 1; s++) {
                System.out.print(" ");
            }

            for(int st = 0; st < 2 * i - 1; st++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void printPattern8(int n) {

        //Upper Half

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
        
        //Lower Half

        for(int i = n - 1; i >= 1; i--) {
            for(int j = 1; j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }
    static void printPattern9(int n) {

        //Count-> (i+j) ==> Even->"1" either Odd-> "0"

        for(int i = 0; i < n; i++) {
            for(int j = 0; j <= i; j++) {
                if((i+j) % 2 == 0) {
                    System.out.print("1");
                }else{
                    System.out.print("0");
                }
            }
            System.out.println();
        }
    }

    static void printPattern10(int n) {
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                System.out.print(j);
            }

            //Spaces
            for (int j = 1; j <= 2*(n-i); j++) {
                System.out.print(" ");
            }

            for (int j = i; j >= 1; j--) {
                System.out.print(j);
            }
            System.out.println();
        }
    }

    static void printPattern11(int n) {
        int num = 1;
        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(num+" ");
                num++;
            }
            System.out.println();
        }
    }

    static void printPattern12(int n) {
        for(int i = 1; i <= n; i++) {
            char ch = 'A';
            for(int j = 1; j <= i; j++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }

    static void printPattern13(int n) {
        for(int i = n; i >= 1; i--) {
            char ch = 'A';
            for(int j = 1; j <= i; j++) {
                System.out.print(ch);
                ch++;
            }
            System.out.println();
        }
    }

    static void printPattern14(int n) {
        char ch = 'A';

        for(int i = 1; i <= n; i++) {
            for(int j = 1; j <= i; j++) {
                System.out.print(ch);
            }
            ch++;
            System.out.println();
        }
    }

    static void printPattern15(int n) {
        for(int i = 1; i <= n; i++) {
            char ch = 'A';

            for (int j = 1; j <= n - i; j++) {
                System.out.print(" ");
            }

            for (int j = 1; j <= i; j++) {
                System.out.print(ch);
                ch++;
            }

            ch -= 2;

            for (int j = i - 1; j >= 1; j--) {
                System.out.print(ch);
                ch--;
            }
            
            System.out.println();
        }
    }

    static void printPattern16(int n) {
        for (int i = 0; i < n; i++) {

            char ch = (char) ('E' - i);

            for (int j = 0; j < n - i; j++) {
                System.out.print(ch);
            }

            System.out.println();
        }
    }

    static void printPattern17(int n) {
        for(int i = n; i > 0; i--) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }

            for(int j = 0; j < n-i; j++) {
                System.out.print("  ");
            }

            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }

        //Lower

        for(int i = 1; i <= n ; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }

            for(int j = 0; j < n-i; j++) {
                System.out.print("  ");
            }

            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

    }


    static void printPattern18(int n) {
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < 2*(n-i); j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            for (int j = 0; j < 2*(n-i); j++) {
                System.out.print(" ");
            }

            for (int j = 0; j < i; j++) {
                System.out.print("*");
            }

            System.out.println();
        }
    }

    static void printPattern19(int n) {
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if(i == 0 || j == 0 || i == n - 1 || j == n - 1) {
                    System.out.print("*");
                }else{
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }

    static void printPattern20(int n) {
        for (int i = 0; i < 2*n-1; i++) {
            for(int j = 0; j < 2*n-1; j++) {
                
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        printPattern20(5);
    }
}
