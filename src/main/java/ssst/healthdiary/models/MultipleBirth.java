package ssst.healthdiary.models;

public class MultipleBirth {
    private boolean multipleBirths;
    private int number;

    MultipleBirth(boolean multipleBirths, int number){
        this.multipleBirths=multipleBirths;
        this.number=number;
    }

    public boolean isMultipleBirths() {
        return multipleBirths;
    }

    public void setMultipleBirths(boolean multipleBirths) {
        this.multipleBirths = multipleBirths;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }
}
