import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class OXTest {
    @Test
    public void shouldCreateOXObjectCorrectly(){
        OX oxtable = new OX();

       assertEquals("  0 1 2\n0 - - -\n1 - - -\n2 - - -",oxtable.GetTableString());
       assertEquals("x",oxtable.GetPlayerCurrent());
       assertEquals(0,oxtable.getCounto());
        assertEquals(0,oxtable.getCountx());
        assertEquals(0,oxtable.getCountDraw());

    }

    @Test
    public void put(){
        OX ox = new OX();
        ox.put(0,0);
        assertEquals(   "  0 1 2\n0 x - -\n1 - - -\n2 - - -",ox.GetTableString());
        ox.put(0,1);
        assertEquals(   "  0 1 2\n0 x x -\n1 - - -\n2 - - -",ox.GetTableString());
        ox.put(0,2);
        assertEquals(   "  0 1 2\n0 x x x\n1 - - -\n2 - - -",ox.GetTableString());
        ox.SwitchPlayer();//สลับผู้เล่นไปเป็น O
        ox.put(1,0);
        assertEquals(   "  0 1 2\n0 x x x\n1 o - -\n2 - - -",ox.GetTableString());

        assertEquals( false, ox.put(0,0));//ลงช่องซ้ำ
        assertEquals(false,ox.put(-1,0));//ลงไม่ตรงช่อง
        assertEquals(false,ox.put(0,-1));//ลงไม่ตรงช่อง
        assertEquals(false,ox.put(3,0));//ลงไม่ตรงช่อง
        assertEquals(false,ox.put(0,3));//ลงไม่ตรงช่อง
        assertEquals(false,ox.put(-1,-1));//ลงไม่ตรงช่อง
        assertEquals(false,ox.put(3,3));//ลงไม่ตรงช่อง
    }

    @Test
    public void SwitchPlayer(){
        OX ox = new OX();
        ox.SwitchPlayer();
        assertEquals("o",ox.GetPlayerCurrent());
        ox.SwitchPlayer();
        assertEquals("x",ox.GetPlayerCurrent());
    }

    @Test
    public void CheckWin(){
        OX ox = new OX();
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        assertEquals("  0 1 2\n0 x x x\n1 - - -\n2 - - -",ox.GetTableString());
        assertEquals(true,ox.CheckWin());
        ox.ResetTable();
        ox.put(0,0);
        ox.put(1,0);
        ox.put(2,0);
        assertEquals("  0 1 2\n0 x - -\n1 x - -\n2 x - -",ox.GetTableString());
        assertEquals(true,ox.CheckWin());
        ox.ResetTable();
        ox.put(0,2);
        ox.put(1,2);
        ox.put(2,2);
        assertEquals("  0 1 2\n0 - - x\n1 - - x\n2 - - x",ox.GetTableString());
        assertEquals(true,ox.CheckWin());
        ox.ResetTable();
        ox.put(2,0);
        ox.put(2,1);
        ox.put(2,2);
        assertEquals("  0 1 2\n0 - - -\n1 - - -\n2 x x x",ox.GetTableString());
        assertEquals(true,ox.CheckWin());
        ox.ResetTable();
        ox.put(0,0);
        ox.put(1,1);
        ox.put(2,2);
        assertEquals("  0 1 2\n0 x - -\n1 - x -\n2 - - x",ox.GetTableString());
        assertEquals(true,ox.CheckWin());
        ox.ResetTable();
        ox.put(0,2);
        ox.put(1,1);
        ox.put(2,0);
        assertEquals("  0 1 2\n0 - - x\n1 - x -\n2 x - -",ox.GetTableString());
        assertEquals(true,ox.CheckWin());
        ox.ResetTable();
        ox.put(0,1);
        ox.put(1,1);
        ox.put(2,1);
        assertEquals("  0 1 2\n0 - x -\n1 - x -\n2 - x -",ox.GetTableString());
        assertEquals(true,ox.CheckWin());
        ox.ResetTable();
        ox.put(1,0);
        ox.put(1,1);
        ox.put(1,2);
        assertEquals("  0 1 2\n0 - - -\n1 x x x\n2 - - -",ox.GetTableString());
        assertEquals(true,ox.CheckWin());
        ox.ResetTable();

        assertEquals(false,ox.CheckWin());//ยังไม่มีผู้ชนะ

        ox.put(0,0);
        ox.SwitchPlayer();
        ox.put(0,1);
        ox.SwitchPlayer();
        ox.put(0,2);
        ox.SwitchPlayer();
        ox.put(1,0);
        ox.SwitchPlayer();
        ox.put(1,1);
        ox.SwitchPlayer();
        ox.put(2,0);
        ox.SwitchPlayer();
        ox.put(1,2);
        ox.SwitchPlayer();
        ox.put(2,2);
        ox.SwitchPlayer();
        ox.put(2,1);
        System.out.println(ox.GetTableString());
        assertEquals(true,ox.CheckWin());//เสมอ



    }

    @Test
    public void ResetTable(){
        OX ox = new OX();
        ox.put(0,0);
        assertEquals("  0 1 2\n0 x - -\n1 - - -\n2 - - -",ox.GetTableString());
        ox.ResetTable();
        assertEquals("  0 1 2\n0 - - -\n1 - - -\n2 - - -",ox.GetTableString());
    }

    @Test
    public void PrintScore(){
        OX ox = new OX();
        assertEquals("Score x : 0\nScore o : 0\nDraw : 0",ox.PrintScore());
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        ox.CheckWin();
        ox.ResetTable();
        assertEquals("Score x : 1\nScore o : 0\nDraw : 0",ox.PrintScore());
        ox.SwitchPlayer();
        ox.put(0,0);
        ox.put(0,1);
        ox.put(0,2);
        ox.CheckWin();
        assertEquals("Score x : 1\nScore o : 1\nDraw : 0",ox.PrintScore());
        ox.ResetTable();

        ox.put(0,0);
        ox.SwitchPlayer();
        ox.put(0,1);
        ox.SwitchPlayer();
        ox.put(0,2);
        ox.SwitchPlayer();
        ox.put(1,0);
        ox.SwitchPlayer();
        ox.put(1,1);
        ox.SwitchPlayer();
        ox.put(2,0);
        ox.SwitchPlayer();
        ox.put(1,2);
        ox.SwitchPlayer();
        ox.put(2,2);
        ox.SwitchPlayer();
        ox.put(2,1);
        assertEquals(true,ox.CheckWin());//เสมอ
        assertEquals("Score x : 1\nScore o : 1\nDraw : 1",ox.PrintScore());

    }

}