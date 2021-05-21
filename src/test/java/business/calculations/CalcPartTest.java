package business.calculations;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CalcPartTest {
    CalcCarport carport = new CalcCarport();

    @Test
    void calcPostAmount() {
        assertEquals(6,CalcPart.calcPostAmount(480,true));

    }

    @Test
    void calcRafters() {
        assertEquals(9,CalcPart.calcRafters(480,55));
    }

    @Test
    void calcRem() {
        assertEquals(2,CalcPart.calcRem(480,600));
    }

    @Test
    void calcRoof() {
        assertEquals(5, CalcPart.calcRoof(480,480,600,100));
    }

    @Test
    void calcSubStarboardsBackAndFront() {
        assertEquals(4,CalcPart.calcSubStarboardsBackAndFront(480,360));
    }

    @Test
    void calcSubStarboardsSides() {
        assertEquals(2,CalcPart.calcSubStarboardsSides(480,540));
    }

    @Test
    void calcOverSternFor() {
        assertEquals(2, CalcPart.calcOverSternFor(480,360));
    }

    @Test
    void calcOverSternSider() {
        assertEquals(2, CalcPart.calcOverSternSider(480,540));
    }

    @Test
    void calcVandBrædtSider() {
        assertEquals(2, CalcPart.calcVandBrædtSider(480,540));
    }

    @Test
    void calcVandBrædtFront() {
        assertEquals(2, CalcPart.calcVandBrædtFront(480,360));
    }

    //@Test
    //void calccCarport(){assertEquals(,6850);}
}