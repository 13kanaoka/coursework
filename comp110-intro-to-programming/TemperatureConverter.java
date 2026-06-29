public class TemperatureConverter {
    public static void main(String[] args) {
        double celsius;
        double fahrenheit;
        System.out.printf("Celsius\tFahrenheit\n");
        for (int i = 0; i <= 100; i += 5)
        {
            celsius = i;
            fahrenheit = 9.0 / 5 * celsius + 32.0;
            System.out.printf("%6.2f\t%6.2f\n", celsius, fahrenheit);
        }


    }
}
