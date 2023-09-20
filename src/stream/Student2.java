package stream;

public class Student2 {
    String name;
    boolean isMale;
    int hak;
    int ban;
    int Score;

    enum Level { HIGH, MID, LOW}

    public Student2(String name, boolean isMale, int hak, int ban, int score) {
        this.name = name;
        this.isMale = isMale;
        this.hak = hak;
        this.ban = ban;
        Score = score;
    }

    public String getName() {
        return name;
    }

    public boolean isMale() {
        return isMale;
    }

    public int getHak() {
        return hak;
    }

    public int getBan() {
        return ban;
    }

    public int getScore() {
        return Score;
    }

    @Override
    public String toString() {
        return "Student2{" +
                "name='" + name + '\'' +
                ", isMale=" + isMale +
                ", hak=" + hak +
                ", ban=" + ban +
                ", Score=" + Score +
                '}';
    }
}
