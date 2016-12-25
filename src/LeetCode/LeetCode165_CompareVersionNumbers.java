package LeetCode;

/**
 * Compare Version Numbers
 * <p>
 * Compare two version numbers version1 and version2.
 * If version1 > version2 return 1, if version1 < version2 return -1, otherwise return 0.
 * You may assume that the version strings are non-empty and contain only digits and the . character.
 * The . character does not represent a decimal point and is used to separate number sequences.
 * For instance, 2.5 is not "two and a half" or "half way to version three", it is the fifth second-level revision of the second first-level revision.
 * Here is an example of version numbers ordering:
 * 0.1 < 1.1 < 1.2 < 13.37
 * <p>
 * KeyWords: String, Split
 * Difficulty: Easy
 */
public class LeetCode165_CompareVersionNumbers {
    public int compareVersion(String version1, String version2) {
        //String str = "1234@abc"; String[] a=str.split("@"); --->a[0]="1234",a[1]="abc"
        String ver1[] = version1.split("\\.");
        String ver2[] = version2.split("\\.");
        int length = Math.min(ver1.length, ver2.length);
        for (int i = 0; i < length; i++) {
            if (Integer.parseInt(ver1[i]) - Integer.parseInt(ver2[i]) > 0) {
                return 1;
            } else if (Integer.parseInt(ver1[i]) - Integer.parseInt(ver2[i]) < 0) {
                return -1;
            }
        }
        if (ver1.length > length) {
            for (int i = 0; i < ver1.length - length; i++) {
                if (Integer.parseInt(ver1[length + i]) > 0) {
                    return 1;
                }
            }
        }
        if (ver2.length > length) {
            for (int i = 0; i < ver2.length - length; i++) {
                if (Integer.parseInt(ver2[length + i]) > 0) {
                    return -1;
                }
            }
        }
        return 0;
    }

    //Better Solution
    public int compareVersion2(String version1, String version2) {
        String[] levels1 = version1.split("\\.");
        String[] levels2 = version2.split("\\.");

        int length = Math.max(levels1.length, levels2.length);
        for (int i = 0; i < length; i++) {
            Integer v1 = i < levels1.length ? Integer.parseInt(levels1[i]) : 0;
            Integer v2 = i < levels2.length ? Integer.parseInt(levels2[i]) : 0;
            int compare = v1.compareTo(v2);
            if (compare != 0) {
                return compare;
            }
        }

        return 0;
    }
}
