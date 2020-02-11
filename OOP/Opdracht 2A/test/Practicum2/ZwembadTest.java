package Practicum2;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


import static org.junit.jupiter.api.Assertions.*;

class ZwembadTest {

    private Zwembad z;
    @BeforeEach // before each test
    public void init(){
        System.out.print("init");
        z = new Zwembad(2.0, 5.5, 1.5);
    }

    @Test
    void testBerekendeInhoud(){

    }
}