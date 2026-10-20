package hauptPackage.mdl;

public class Model {

    public double convert(double amount, String from, String to) {

        if (from.equals(to))
            return amount;

        if (from.equals("EUR") && to.equals("USD"))
            return amount * 1.10;

        if (from.equals("EUR") && to.equals("CHF"))
            return amount * 0.95;

        if (from.equals("USD") && to.equals("EUR"))
            return amount / 1.10;

        if (from.equals("USD") && to.equals("CHF"))
            return amount * 0.86;

        if (from.equals("CHF") && to.equals("EUR"))
            return amount / 0.95;

        if (from.equals("CHF") && to.equals("USD"))
            return amount * 1.16;
        return 0;
    }
}