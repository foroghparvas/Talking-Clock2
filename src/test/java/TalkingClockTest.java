import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TalkingClockTest {

    @Test
   public void talkingClockTest(){
       TalkingClock talking = new TalkingClock();
        String timesExpected = "It's nine twenty one pm";

        String timesActual = talking.timeToWords("21:21");


        assertEquals(timesExpected,timesActual);




    }


}