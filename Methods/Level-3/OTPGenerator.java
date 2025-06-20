import java.util.Arrays;
public class OTPGenerator {

    public static void main(String[] args) {
        int[] otps = new int[10];

        for (int i = 0; i < otps.length; i++) {
            otps[i] = generateOTP();
        }

        System.out.println("Generated OTPs: " + Arrays.toString(otps));
        boolean unique = areOTPsUnique(otps);
        System.out.println("Are all OTPs unique? " + (unique ? "Yes" : "No"));
    }

    public static int generateOTP() {
        return (int)(Math.random() * 900000) + 100000; 
    }

    public static boolean areOTPsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}
