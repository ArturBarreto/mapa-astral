package type;

public class Tuple<TFirst, TSecond, TThird> {

    private final TFirst first;
    private final TSecond second;

    private final TThird third;

    private Tuple(TFirst first, TSecond second, TThird third) {
        this.first = first;
        this.second = second;
        this.third = third;
    }

    public static <TFirst, TSecond, TThird> Tuple<TFirst, TSecond, TThird> create(TFirst first, TSecond second, TThird third) {
        return new Tuple<>(first, second, third);
    }

    @Override
    public String toString() {
        return "Tuple{" +
                "first=" + first +
                ", second=" + second +
                ", third=" + third +
                        '}';
    }

    public TFirst getFirst() {
        return first;
    }

    public TSecond getSecond() {
        return second;
    }

    public TThird getThird() {
        return third;
    }
}
