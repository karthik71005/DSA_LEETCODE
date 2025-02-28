char* mergeAlternately(char* word1, char* word2) {
    int len1 = strlen(word1);
    int len2 = strlen(word2);
    int totalLen = len1 + len2;

    // Allocate memory for the merged string (+1 for null terminator)
    char* merged = (char*)malloc((totalLen + 1) * sizeof(char));
    if (!merged) return NULL;

    int i = 0, j = 0, k = 0;
    
    // Merge letters alternately
    while (i < len1 && j < len2) {
        merged[k++] = word1[i++];
        merged[k++] = word2[j++];
    }

    // Append remaining characters (if any)
    while (i < len1) merged[k++] = word1[i++];
    while (j < len2) merged[k++] = word2[j++];

    merged[k] = '\0'; // Null-terminate the string
    return merged;
}