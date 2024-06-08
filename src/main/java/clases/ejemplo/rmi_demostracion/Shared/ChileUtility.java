package clases.ejemplo.rmi_demostracion.Shared;

public class ChileUtility {
    public static String calculateVerifierDigit(int rut) {
        Integer M = 0, S = 1, T = rut;
        for (; T != 0; T = (int) Math.floor(T /= 10))
            S = (S + T % 10 * (9 - M++ % 6)) % 11;
        return (S > 0) ? String.valueOf(S - 1) : "k";
    }
}
