import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ProteinSynthesisTest {
    @Test
    public void totalTest() {
        String dna1 = "ATGATCTCGTAA";
        String dna2 = "CCCCTGTCATAA";
        String dna3 = "TACAT";
        String dna4 = "ATGCTATGT";
        ProteinSynthesis syn = new ProteinSynthesis();
        MyQueue<Character> rna1 = syn.transcribeDNA(dna1);
        String rna = "";
        for (int i = 0; i < dna1.length(); i++) {
            rna += rna1.dequeue();
        }
        assertTrue(rna.equals("AUGAUCUCGUAA"));

        MyQueue<Character> rna2 = syn.transcribeDNA(dna2);
        rna = "";
        for (int i = 0; i < dna2.length(); i++) {
            rna += rna2.dequeue();
        }
        assertTrue(rna.equals("CCCCUGUCAUAA"));

        assertThrows(IllegalArgumentException.class, () -> {
            MyQueue<Character> rna3 = syn.transcribeDNA(dna3);
        });
        MyQueue<Character> rna4 = syn.transcribeDNA(dna4);
        rna = "";
        for (int i = 0; i < dna4.length(); i++) {
            rna += rna4.dequeue();
        }
        assertTrue(rna.equals("AUGCUAUGU"));

        rna1 = syn.transcribeDNA(dna1);
        rna2 = syn.transcribeDNA(dna2);
        rna4 = syn.transcribeDNA(dna4);

        MyQueue<Character> pro1 = syn.translateRNA(rna1);
        String pro = "";
        int size = pro1.size();
        for (int i = 0; i < size; i++) {
            pro += pro1.dequeue();
        }
        assertTrue(pro.equals("MIS*"));
        MyQueue<Character> pro2 = syn.translateRNA(rna2);
        pro = "";
        size = pro2.size();
        for (int i = 0; i < size; i++) {
            pro += pro2.dequeue();
        }
        assertTrue(pro.isEmpty());
        MyQueue<Character> pro4 = syn.translateRNA(rna4);
        pro = "";
        size = pro4.size();
        for (int i = 0; i < size; i++) {
            pro += pro4.dequeue();
        }
        assertTrue(pro.equals("MLC"));
    }
}