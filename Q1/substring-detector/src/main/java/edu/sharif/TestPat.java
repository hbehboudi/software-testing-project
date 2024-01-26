package edu.sharif;

// Introduction to Software Testing
// Authors: Paul Ammann & Jeff Offutt
// Chapter 2, section 2.3, page 56

public class TestPat {

    public static void main(String[] argv) {
        final int MAX = 100;
        char subject[] = new char[MAX];
        char pattern[] = new char[MAX];
        if (argv.length != 2) {
            System.out.println
                    ("java TestPat String-Subject String-Pattern");
            return;
        }
        subject = argv[0].toCharArray();
        pattern = argv[1].toCharArray();
        TestPat testPat = new TestPat();
        int n = 0;
        if ((n = testPat.pat(subject, pattern)) == -1)
            System.out.println
                    ("Pattern string is not a substring of the subject string");
        else
            System.out.println
                    ("Pattern string begins at the character " + n);
    }

    public TestPat() {
    }

    public int pat(char[] subject, char[] pattern) {
// Post: if pattern is not a substring of subject, return -1
//       else return (zero-based) index where the pattern (first)
//       starts in subject

        final int NOTFOUND = -1;
        int iSub = 0, rtnIndex = NOTFOUND;
        boolean isPat = false;
        int subjectLen = subject.length;
        int patternLen = pattern.length;
        System.out.print(1 + "->");

        System.out.print(2 + "->");
        while (isPat == false && iSub + patternLen - 1 < subjectLen) {
            System.out.print(3 + "->");
            ;
            if (subject[iSub] == pattern[0]) {
                System.out.print(4 + "->");
                rtnIndex = iSub; // Starting at zero
                isPat = true;
                System.out.print(5 + "->");
                for (int iPat = 1; iPat < patternLen; iPat++) {
                    System.out.print(6 + "->");
                    if (subject[iSub + iPat] != pattern[iPat]) {
                        System.out.print(7 + "->");
                        rtnIndex = NOTFOUND;
                        isPat = false;
                        break;  // out of for loop
                    }
                    System.out.print(8 + "->");
                    System.out.print(5 + "->");
                }
            }
            System.out.print(9 + "->");
            iSub++;
            System.out.print(2 + "->");
        }
        System.out.println(10);
        return (rtnIndex);
    }
}
