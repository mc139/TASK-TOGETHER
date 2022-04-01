package zadanie.model.boat;

import lombok.Getter;

@Getter
public enum BoatSize {

    YACHT(200.0),
    STANDARDBOAT(100.0),
    SMALLBOAT(50.0),
    KAYAK(25.0);

    private double size;

    BoatSize(double size) {
        this.size = size;
    }
//    WARSZAWA(30000),
//    KRAKOW(2000),
//    RZESZOW(1000);

//    private int peopleAmount;
//
//    City(int peopleAmount) {
//        this.peopleAmount = peopleAmount;
//    }
//
//    public int getPeopleAmount() {
//        return peopleAmount;
//    }
}
