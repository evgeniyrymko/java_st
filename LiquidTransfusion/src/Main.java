import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {

        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        System.out.println("Введите вместимость первого ведра");
        int capacity1 = Integer.parseInt(reader.readLine());
        System.out.println("Введите вместимость второго ведра");
        int capacity2 = Integer.parseInt(reader.readLine());
        Bucket bucket1 = new Bucket(capacity1);
        Bucket bucket2 = new Bucket(capacity2);
        System.out.println("Введите необходимый объем жидкости");
        int volume = Integer.parseInt(reader.readLine());
        if (!validation(bucket1, bucket2, volume)) {
            System.out.println("Валидация не пройдена, т.к. требуемый объем не кратен НОД вместимостей ведер");
        } else {
            solutionSmallToBig(bucket1, bucket2, volume);
            bucket1.makeEmpty();
            bucket2.makeEmpty();
            solutionBigToSmall(bucket1, bucket2, volume);
        }
    }

    private static void solutionBigToSmall(Bucket bucket1, Bucket bucket2, int volume) {
        System.out.println("Способ 2");
        int count = 0;
        System.out.println("(" + count++ + ") " + bucketsState(bucket1, bucket2));
        while (!checkResult(bucket1, bucket2, volume)) {

            bucket2.makeFilled();
            System.out.println("(" + count++ + ") " + bucketsState(bucket1, bucket2));
            do {
                bucket2.transfuse(bucket1, bucket1.getCapacity() - bucket1.getCurrentVolume());
                System.out.println("(" + count++ + ") " + bucketsState(bucket1, bucket2));
                if (checkResult(bucket1, bucket2, volume)) break;
                bucket1.makeEmpty();
                System.out.println("(" + count++ + ") " + bucketsState(bucket1, bucket2));
            } while (bucket2.getCurrentVolume() >= bucket1.getCapacity() && !checkResult(bucket1, bucket2, volume));
            if (bucket2.getCurrentVolume() > 0 && !checkResult(bucket1, bucket2, volume)) {
                bucket2.transfuse(bucket1, bucket2.getCurrentVolume());
                System.out.println("(" + count++ + ") " + bucketsState(bucket1, bucket2));
            }
        }
        System.out.println("-----");
    }

    public static void solutionSmallToBig(Bucket bucket1, Bucket bucket2, int volume) {
        System.out.println("Способ 1");
        int count = 0;
        System.out.println("(" + count++ + ") " + bucketsState(bucket1, bucket2));
        while (!checkResult(bucket1, bucket2, volume)) {
            while ((bucket2.getCapacity() - bucket2.getCurrentVolume()) >= bucket1.getCapacity() && !checkResult(bucket1, bucket2, volume)) {
                bucket1.makeFilled();
                System.out.println("(" + count++ + ") " + bucketsState(bucket1, bucket2));
                if (bucket1.getCurrentVolume() == volume) break;
                bucket1.transfuse(bucket2, bucket1.getCurrentVolume());
                System.out.println("(" + count++ + ") " + bucketsState(bucket1, bucket2));
            }
            if ((bucket2.getCapacity() - bucket2.getCurrentVolume()) > 0 && !checkResult(bucket1, bucket2, volume)) {
                int delta = bucket2.getCapacity() - bucket2.getCurrentVolume();
                bucket1.makeFilled();
                System.out.println("(" + count++ + ") " + bucketsState(bucket1, bucket2));
                bucket1.transfuse(bucket2, delta);
                System.out.println("(" + count++ + ") " + bucketsState(bucket1, bucket2));
            }
            if (!checkResult(bucket1, bucket2, volume)) {
                bucket2.makeEmpty();
                System.out.println("(" + count++ + ") " + bucketsState(bucket1, bucket2));
                bucket1.transfuse(bucket2, bucket1.getCurrentVolume());
                System.out.println("(" + count++ + ") " + bucketsState(bucket1, bucket2));
            }
        }
        System.out.println("-----");
    }

    public static String bucketsState(Bucket bucket1, Bucket bucket2) {
        return bucket1.getCurrentVolume() + " " + bucket2.getCurrentVolume();
    }

    private static boolean checkResult(Bucket bucket1, Bucket bucket2, int volume) {
        if (bucket1.getCurrentVolume() == volume || bucket2.getCurrentVolume() == volume) {
            return true;
        }
        return false;
    }

    private static boolean validation(Bucket bucket1, Bucket bucket2, int volume) {
        int gcd = getEuclidGCD(bucket1.getCapacity(), bucket2.getCapacity());
        if (volume % gcd == 0) {
            return true;
        }
        return false;
    }

    private static int getEuclidGCD(int minCapacity, int maxCapacity) {
        while (minCapacity > 0) {
            int remainder = maxCapacity % minCapacity;
            maxCapacity = minCapacity;
            minCapacity = remainder;
        }
        return maxCapacity;
    }


}
