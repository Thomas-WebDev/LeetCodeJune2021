class IsInterleaveSolution {

    //Revursive solution exceeds timelime -- attempt 2

    public boolean isInterleave(String s1, String s2, String s3) {
     
        // Find lengths of the two strings
        int M = s1.length();
        int N = s2.length();

        // Let us create a 2D table to store
        // solutions of subproblems. C[i][j]
        // will br true if C[0..i+j-1] is an
        // interleaving of A[0..i-1] and B[0..j-1].
        boolean IL[][] = new boolean[M + 1][N + 1];

        // IL is default initialised by false

        // C can be an interleaving of A and B
        // only if the sum of lengths of A and B
        // is equal to length of C
        if ((M + N) != s3.length())
            return false;

        // Process all characters of A and B

        for(int i = 0; i <= M; i++) {
            for(int j = 0; j <= N; j++){

                // Two empty strings have an
                // empty strings as interleaving
                if (i == 0 && j == 0)
                    IL[i][j] = true;

                // A is empty
                else if (i == 0) {
                    if (s2.charAt(j - 1) ==
                        s3.charAt(j - 1))
                        IL[i][j] = IL[i][j - 1];
                 }

                // B is empty
                else if (j == 0) {
                    if (s1.charAt(i - 1) ==
                        s3.charAt(i - 1))
                        IL[i][j] = IL[i - 1][j];
                }

                // Current character of C matches
                // with current character of A,
                // but doesn't match with current
                // character if B
                else if (s1.charAt(i - 1) ==
                         s3.charAt(i + j - 1) &&
                         s2.charAt(j - 1) !=
                         s3.charAt(i + j - 1))
                    IL[i][j] = IL[i - 1][j];

                // Current character of C matches
                // with current character of B, but
                // doesn't match with current
                // character if A
                else if (s1.charAt(i - 1) !=
                         s3.charAt(i + j - 1) &&
                         s2.charAt(j - 1) ==
                         s3.charAt(i + j - 1))
                    IL[i][j] = IL[i][j - 1];

                // Current character of C matches
                // with that of both A and B
                else if (s1.charAt(i - 1) ==
                         s3.charAt(i + j - 1) &&
                         s2.charAt(j - 1) ==
                         s3.charAt(i + j - 1))
                    IL[i][j] = (IL[i - 1][j] ||
                                IL[i][j - 1]);
             }
        }
        return IL[M][N];
    }
}
