package cashkaro.com.dashboad.model;

/**
 * Created by yasar on 23/8/17.
 */

public class SchoolList {

    private String schoolName, color;

    public SchoolList() {

    }

    public SchoolList(String schoolName, String color) {
        this.schoolName = schoolName;
        this.color = color;
    }

    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
