import static org.junit.jupiter.api.Assertions.*;

class HuffmanTreeTest {

    @org.junit.jupiter.api.Test
    void decode() {
        String s = "This is the greatest string in the whole wide world zxcvbnmasdfghjklqwertyuiop/!?,.";
        String abc = "yeeet";
        HuffmanTree t = new HuffmanTree(s);

        Boolean[] testEncode = t.encode(abc);

        String testDecode = t.decode(testEncode);

        assertEquals(abc, testDecode);
    }

    @org.junit.jupiter.api.Test
    void encode() {
        String s = "This is the greatest string in the whole wide world zxcvbnmasdfghjklqwertyuiop/!?,.";
        String abc = "is this the real life is this just fantasy";
        HuffmanTree t = new HuffmanTree(s);

        Boolean[] testEncode = t.encode(abc);

        String testDecode = t.decode(testEncode);

        assertEquals(abc, testDecode);
    }

    @org.junit.jupiter.api.Test
    void efficientEncode() {
        String s = "This is the greatest string in the whole wide world zxcvbnmasdfghjklqwertyuiop/!?,.";
        String abc = "small endgame spoiler ant man does not crawl up thanos ass";
        HuffmanTree t = new HuffmanTree(s);

        Boolean[] testEncode = t.efficientEncode(abc);

        String testDecode = t.decode(testEncode);

        assertEquals(abc, testDecode);


    }
}